package lk.travelmarket.search_engine.service.v2.hotel;

import lk.travelmarket.search_engine.dao.Blackouts;
import lk.travelmarket.search_engine.dao.HotelRoom.Season;
import lk.travelmarket.search_engine.dao.hotel.Hotel;
import lk.travelmarket.search_engine.dto.BlackoutsDto;
import lk.travelmarket.search_engine.dto.SeasonDto;
import lk.travelmarket.search_engine.dto.bulk.blackout.BlackoutBulkUpdateDto;
import lk.travelmarket.search_engine.dto.bulk.season.SeasonBulkUpdateDto;
import lk.travelmarket.search_engine.network.commons.CCError;
import lk.travelmarket.search_engine.network.commons.CCErrorStatus;
import lk.travelmarket.search_engine.repository.HotelBlackoutRepository;
import lk.travelmarket.search_engine.repository.HotelRepository;
import lk.travelmarket.search_engine.repository.RoomBlackoutRepository;
import lk.travelmarket.search_engine.repository.SeasonRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static lk.travelmarket.search_engine.util.Constants.*;

@Component
@Transactional
public class HotelV2ServiceImpl {

    private final HotelRepository hotelRepository;
    private final SeasonRepository seasonRepository;
    private final HotelBlackoutRepository hotelBlackoutRepository;
    private final RoomBlackoutRepository roomBlackoutRepository;

    public HotelV2ServiceImpl(
            HotelRepository hotelRepository,
            SeasonRepository seasonRepository,
            HotelBlackoutRepository hotelBlackoutRepository,
            RoomBlackoutRepository roomBlackoutRepository) {
        this.hotelRepository = hotelRepository;
        this.seasonRepository = seasonRepository;
        this.hotelBlackoutRepository = hotelBlackoutRepository;
        this.roomBlackoutRepository = roomBlackoutRepository;
    }

    public CCError<List<SeasonDto>> retrieveSeasons(Long hotelId) {
        CCError<List<SeasonDto>> ccError = new CCError<>(CCErrorStatus.SUCCESS, SUCCESS_RETRIEVE_SEASONS);
        Optional<Hotel> hotelDao = this.hotelRepository.findById(hotelId);

        if(hotelDao.isEmpty()) {
            ccError.setStatus(CCErrorStatus.ERROR);
            ccError.setMessage(ERROR_HOTEL_V2_NOT_FOUND);
            return ccError;
        }

        List<SeasonDto> seasonData = this.seasonRepository.findAllByHotelId(hotelId)
                .stream()
                .map(this::mapToSeasonDto)
                .toList();

        ccError.setData(seasonData);
        return ccError;
    }

    public CCError<SeasonBulkUpdateDto> bulkUpdateSeasons(Long hotelId, SeasonBulkUpdateDto request) {
        CCError<SeasonBulkUpdateDto> ccError = new CCError<>(CCErrorStatus.SUCCESS, SUCCESS_RETRIEVE_TEST);
        Optional<Hotel> hotelDao = this.hotelRepository.findById(hotelId);

        if(hotelDao.isEmpty()) {
            ccError.setStatus(CCErrorStatus.ERROR);
            ccError.setMessage(ERROR_HOTEL_V2_NOT_FOUND);
            return ccError;
        }

        Hotel hotel = hotelDao.get();
        List<SeasonDto> created = request.getCreated() != null ? request.getCreated() : List.of();
        List<SeasonDto> updated = request.getUpdated() != null ? request.getUpdated() : List.of();
        List<Long> deleted = request.getDeleted() != null ? request.getDeleted() : List.of();

        boolean createdHasId = created.stream().anyMatch(season -> season.getId() != null);
        if (createdHasId) {
            ccError.setStatus(CCErrorStatus.ERROR);
            ccError.setMessage("Created seasons must not contain an id");
            return ccError;
        }

        boolean updateMissingId = updated.stream().anyMatch(season -> season.getId() == null);
        if (updateMissingId) {
            ccError.setStatus(CCErrorStatus.ERROR);
            ccError.setMessage("Updated seasons must contain an id");
            return ccError;
        }

        List<Long> updateIds = updated.stream().map(SeasonDto::getId).toList();
        Set<Long> deletedSet = new HashSet<>(deleted);
        List<Long> conflictingIds = updateIds.stream().filter(deletedSet::contains).toList();

        if (!conflictingIds.isEmpty()) {
            ccError.setStatus(CCErrorStatus.ERROR);
            ccError.setMessage("Seasons cannot be updated and deleted in the same request: " + conflictingIds);
            return ccError;
        }

        Set<Long> requestedExistingIds = new HashSet<>();
        requestedExistingIds.addAll(updateIds);
        requestedExistingIds.addAll(deleted);

        List<Season> existingSeasons = seasonRepository.findAllById(requestedExistingIds);
        Map<Long, Season> existingSeasonMap = existingSeasons.stream().collect(Collectors.toMap(Season::getId, Function.identity()));

        List<Long> missingIds = requestedExistingIds.stream().filter(id -> !existingSeasonMap.containsKey(id)).toList();
        if (!missingIds.isEmpty()) {
            ccError.setStatus(CCErrorStatus.ERROR);
            ccError.setMessage("Seasons not found: " + missingIds);
            return ccError;
        }

        List<Long> invalidHotelSeasonIds = existingSeasons.stream()
                .filter(season -> season.getHotel() == null || !season.getHotel().getId().equals(hotelId))
                .map(Season::getId)
                .toList();

        if (!invalidHotelSeasonIds.isEmpty()) {
            ccError.setStatus(CCErrorStatus.ERROR);
            ccError.setMessage("Seasons do not belong to hotel " + hotelId + ": " + invalidHotelSeasonIds);
            return ccError;
        }

        List<Season> seasonsToCreate = created.stream()
                .map(dto -> {
                    Season season = new Season();
                    season.setSeasonName(dto.getSeasonName());
                    season.setStartDate(dto.getStartDate());
                    season.setEndDate(dto.getEndDate());
                    season.setHotel(hotel);
                    return season;
                }).toList();
        List<Season> createdSeasons = seasonRepository.saveAll(seasonsToCreate);

        List<Season> seasonsToUpdate = updated.stream()
                .map(dto -> {
                    Season season = existingSeasonMap.get(dto.getId());
                    season.setSeasonName(dto.getSeasonName());
                    season.setStartDate(dto.getStartDate());
                    season.setEndDate(dto.getEndDate());
                    return season;
                }).toList();
        List<Season> updatedSeasons = seasonRepository.saveAll(seasonsToUpdate);

        if (!deleted.isEmpty()) {
            seasonRepository.deleteAllByIdInBatch(deleted);
        }

        SeasonBulkUpdateDto response = new SeasonBulkUpdateDto();
        response.setCreated(createdSeasons.stream().map(this::mapToSeasonDto).toList());
        response.setUpdated(updatedSeasons.stream().map(this::mapToSeasonDto).toList());
        response.setDeleted(deleted);

        ccError.setData(response);
        return ccError;
    }

    public CCError<List<BlackoutsDto>> retrieveBlackouts(Long hotelId) {
        CCError<List<BlackoutsDto>> ccError = new CCError<>(CCErrorStatus.SUCCESS, SUCCESS_RETRIEVE_BLACKOUTS);
        Optional<Hotel> hotelDao = this.hotelRepository.findById(hotelId);

        if (hotelDao.isEmpty()) {
            ccError.setStatus(CCErrorStatus.ERROR);
            ccError.setMessage(ERROR_HOTEL_V2_NOT_FOUND);
            return ccError;
        }

        List<BlackoutsDto> blackoutData = this.hotelBlackoutRepository
                .findByHotelIdAndRoomIdIsNull(hotelId)
                .stream()
                .map(this::mapToBlackoutsDto)
                .toList();

        ccError.setData(blackoutData);
        return ccError;
    }

    public CCError<BlackoutBulkUpdateDto> bulkUpdateBlackouts(Long hotelId, BlackoutBulkUpdateDto request) {
        CCError<BlackoutBulkUpdateDto> ccError = new CCError<>(CCErrorStatus.SUCCESS, SUCCESS_BULK_UPDATE_HOTEL_BLACKOUTS);
        Optional<Hotel> hotelDao = this.hotelRepository.findById(hotelId);

        if (hotelDao.isEmpty()) {
            ccError.setStatus(CCErrorStatus.ERROR);
            ccError.setMessage(ERROR_HOTEL_V2_NOT_FOUND);
            return ccError;
        }

        List<BlackoutsDto> created = request.getCreated() != null ? request.getCreated() : List.of();
        List<BlackoutsDto> updated = request.getUpdated() != null ? request.getUpdated() : List.of();
        List<Long> deleted = request.getDeleted() != null ? request.getDeleted() : List.of();

        boolean createdHasId = created.stream().anyMatch(blackout -> blackout.getId() != null);
        if (createdHasId) {
            ccError.setStatus(CCErrorStatus.ERROR);
            ccError.setMessage("Created blackouts must not contain an id");
            return ccError;
        }

        boolean updateMissingId = updated.stream().anyMatch(blackout -> blackout.getId() == null);
        if (updateMissingId) {
            ccError.setStatus(CCErrorStatus.ERROR);
            ccError.setMessage("Updated blackouts must contain an id");
            return ccError;
        }

        List<Long> updateIds = updated.stream().map(BlackoutsDto::getId).toList();
        Set<Long> deletedSet = new HashSet<>(deleted);
        List<Long> conflictingIds = updateIds.stream().filter(deletedSet::contains).toList();

        if (!conflictingIds.isEmpty()) {
            ccError.setStatus(CCErrorStatus.ERROR);
            ccError.setMessage("Blackouts cannot be updated and deleted in the same request: " + conflictingIds);
            return ccError;
        }

        Set<Long> requestedExistingIds = new HashSet<>();
        requestedExistingIds.addAll(updateIds);
        requestedExistingIds.addAll(deleted);

        List<Blackouts> existingBlackouts = requestedExistingIds.isEmpty() ? List.of() : hotelBlackoutRepository.findAllById(requestedExistingIds);
        Map<Long, Blackouts> existingBlackoutMap = existingBlackouts.stream().collect(Collectors.toMap(Blackouts::getId, Function.identity()));

        List<Long> missingIds = requestedExistingIds.stream().filter(id -> !existingBlackoutMap.containsKey(id)).toList();
        if (!missingIds.isEmpty()) {
            ccError.setStatus(CCErrorStatus.ERROR);
            ccError.setMessage("Blackouts not found: " + missingIds);
            return ccError;
        }

        List<Long> invalidHotelBlackoutIds = existingBlackouts.stream()
                .filter(blackout -> !Objects.equals(blackout.getHotelId(), hotelId) || blackout.getRoomId() != null)
                .map(Blackouts::getId)
                .toList();

        if (!invalidHotelBlackoutIds.isEmpty()) {
            ccError.setStatus(CCErrorStatus.ERROR);
            ccError.setMessage("Blackouts do not belong to hotel " + hotelId + ": " + invalidHotelBlackoutIds);
            return ccError;
        }

        List<Blackouts> blackoutsToCreate = created.stream()
                .map(dto -> Blackouts.builder()
                        .hotelId(hotelId)
                        .roomId(null)
                        .reason(dto.getReason())
                        .startDate(dto.getStartDate())
                        .endDate(dto.getEndDate())
                        .build()
                ).toList();
        List<Blackouts> createdBlackouts = hotelBlackoutRepository.saveAll(blackoutsToCreate);

        List<Blackouts> blackoutsToUpdate = updated.stream()
                .map(dto -> {
                    Blackouts blackout = existingBlackoutMap.get(dto.getId());
                    blackout.setReason(dto.getReason());
                    blackout.setStartDate(dto.getStartDate());
                    blackout.setEndDate(dto.getEndDate());
                    return blackout;
                }).toList();
        List<Blackouts> updatedBlackouts = hotelBlackoutRepository.saveAll(blackoutsToUpdate);

        if (!deleted.isEmpty()) {
            hotelBlackoutRepository.deleteAllByIdInBatch(deleted);
        }

        BlackoutBulkUpdateDto response = new BlackoutBulkUpdateDto();
        response.setCreated(createdBlackouts.stream().map(this::mapToBlackoutsDto).toList());
        response.setUpdated(updatedBlackouts.stream().map(this::mapToBlackoutsDto).toList());
        response.setDeleted(deleted);

        ccError.setData(response);
        return ccError;
    }

    public CCError<List<BlackoutsDto>> retrieveRoomBlackouts(Long hotelId, Long roomId) {
        CCError<List<BlackoutsDto>> ccError = new CCError<>(CCErrorStatus.SUCCESS, SUCCESS_RETRIEVE_BLACKOUTS);
        Optional<Hotel> hotelDao = this.hotelRepository.findById(hotelId);

        if (hotelDao.isEmpty()) {
            ccError.setStatus(CCErrorStatus.ERROR);
            ccError.setMessage(ERROR_HOTEL_V2_NOT_FOUND);
            return ccError;
        }

        List<BlackoutsDto> blackoutData = this.roomBlackoutRepository
                .findByHotelIdAndRoomId(hotelId, roomId)
                .stream()
                .map(this::mapToBlackoutsDto)
                .toList();

        ccError.setData(blackoutData);
        return ccError;
    }

    public CCError<BlackoutBulkUpdateDto> bulkUpdateRoomBlackouts(Long hotelId, Long roomId, BlackoutBulkUpdateDto request) {
        CCError<BlackoutBulkUpdateDto> ccError = new CCError<>(CCErrorStatus.SUCCESS, SUCCESS_BULK_UPDATE_ROOM_BLACKOUTS);
        Optional<Hotel> hotelDao = this.hotelRepository.findById(hotelId);

        if (hotelDao.isEmpty()) {
            ccError.setStatus(CCErrorStatus.ERROR);
            ccError.setMessage(ERROR_HOTEL_V2_NOT_FOUND);
            return ccError;
        }

        List<BlackoutsDto> created = request.getCreated() != null ? request.getCreated() : List.of();
        List<BlackoutsDto> updated = request.getUpdated() != null ? request.getUpdated() : List.of();
        List<Long> deleted = request.getDeleted() != null ? request.getDeleted() : List.of();

        boolean createdHasId = created.stream().anyMatch(blackout -> blackout.getId() != null);
        if (createdHasId) {
            ccError.setStatus(CCErrorStatus.ERROR);
            ccError.setMessage("Created blackouts must not contain an id");
            return ccError;
        }

        boolean updateMissingId = updated.stream().anyMatch(blackout -> blackout.getId() == null);
        if (updateMissingId) {
            ccError.setStatus(CCErrorStatus.ERROR);
            ccError.setMessage("Updated blackouts must contain an id");
            return ccError;
        }

        List<Long> updateIds = updated.stream().map(BlackoutsDto::getId).toList();
        Set<Long> deletedSet = new HashSet<>(deleted);
        List<Long> conflictingIds = updateIds.stream().filter(deletedSet::contains).toList();

        if (!conflictingIds.isEmpty()) {
            ccError.setStatus(CCErrorStatus.ERROR);
            ccError.setMessage("Blackouts cannot be updated and deleted in the same request: " + conflictingIds);
            return ccError;
        }

        Set<Long> requestedExistingIds = new HashSet<>();
        requestedExistingIds.addAll(updateIds);
        requestedExistingIds.addAll(deleted);

        List<Blackouts> existingBlackouts = requestedExistingIds.isEmpty() ? List.of() : roomBlackoutRepository.findAllById(requestedExistingIds);
        Map<Long, Blackouts> existingBlackoutMap = existingBlackouts.stream().collect(Collectors.toMap(Blackouts::getId, Function.identity()));

        List<Long> missingIds = requestedExistingIds.stream().filter(id -> !existingBlackoutMap.containsKey(id)).toList();
        if (!missingIds.isEmpty()) {
            ccError.setStatus(CCErrorStatus.ERROR);
            ccError.setMessage("Blackouts not found: " + missingIds);
            return ccError;
        }

        List<Long> invalidRoomBlackoutIds = existingBlackouts.stream()
                .filter(blackout -> !Objects.equals(blackout.getHotelId(), hotelId) || !Objects.equals(blackout.getRoomId(), roomId))
                .map(Blackouts::getId)
                .toList();

        if (!invalidRoomBlackoutIds.isEmpty()) {
            ccError.setStatus(CCErrorStatus.ERROR);
            ccError.setMessage("Blackouts do not belong to hotel " + hotelId + " and room " + roomId + ": " + invalidRoomBlackoutIds);
            return ccError;
        }

        List<Blackouts> blackoutsToCreate = created.stream()
                .map(dto -> Blackouts.builder()
                        .hotelId(hotelId)
                        .roomId(roomId)
                        .reason(dto.getReason())
                        .startDate(dto.getStartDate())
                        .endDate(dto.getEndDate())
                        .build()
                ).toList();
        List<Blackouts> createdBlackouts = roomBlackoutRepository.saveAll(blackoutsToCreate);

        List<Blackouts> blackoutsToUpdate = updated.stream()
                .map(dto -> {
                    Blackouts blackout = existingBlackoutMap.get(dto.getId());
                    blackout.setReason(dto.getReason());
                    blackout.setStartDate(dto.getStartDate());
                    blackout.setEndDate(dto.getEndDate());
                    return blackout;
                }).toList();
        List<Blackouts> updatedBlackouts = roomBlackoutRepository.saveAll(blackoutsToUpdate);

        if (!deleted.isEmpty()) {
            roomBlackoutRepository.deleteAllByIdInBatch(deleted);
        }

        BlackoutBulkUpdateDto response = new BlackoutBulkUpdateDto();
        response.setCreated(createdBlackouts.stream().map(this::mapToBlackoutsDto).toList());
        response.setUpdated(updatedBlackouts.stream().map(this::mapToBlackoutsDto).toList());
        response.setDeleted(deleted);

        ccError.setData(response);
        return ccError;
    }

    private SeasonDto mapToSeasonDto(Season season) {
        return new SeasonDto(
                season.getId(),
                season.getSeasonName(),
                season.getStartDate(),
                season.getEndDate()
        );
    }

    private BlackoutsDto mapToBlackoutsDto(Blackouts blackout) {
        return new BlackoutsDto(
                blackout.getId(),
                blackout.getHotelId(),
                blackout.getRoomId(),
                blackout.getReason(),
                blackout.getStartDate(),
                blackout.getEndDate()
        );
    }
}