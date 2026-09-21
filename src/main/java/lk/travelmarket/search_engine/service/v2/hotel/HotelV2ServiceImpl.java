package lk.travelmarket.search_engine.service.v2.hotel;

import lk.travelmarket.search_engine.dao.HotelRoom.Season;
import lk.travelmarket.search_engine.dao.hotel.Hotel;
import lk.travelmarket.search_engine.dto.SeasonDto;
import lk.travelmarket.search_engine.dto.bulk.season.SeasonBulkUpdateDto;
import lk.travelmarket.search_engine.network.commons.CCError;
import lk.travelmarket.search_engine.network.commons.CCErrorStatus;
import lk.travelmarket.search_engine.repository.HotelRepository;
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

    public HotelV2ServiceImpl(
            HotelRepository hotelRepository,
            SeasonRepository seasonRepository) {
        this.hotelRepository = hotelRepository;
        this.seasonRepository = seasonRepository;
    }


    public CCError<List<SeasonDto>> retrieveSeasons( Long hotelId) {

        CCError<List<SeasonDto>> ccError =
                new CCError<>(
                        CCErrorStatus.SUCCESS,
                        SUCCESS_RETRIEVE_SEASONS
                );

        Optional<Hotel> hotelDao = this.hotelRepository.findById( hotelId );

        if( hotelDao.isEmpty() )
        {
            ccError.setStatus( CCErrorStatus.ERROR );
            ccError.setMessage( ERROR_HOTEL_V2_NOT_FOUND );
            return ccError;
        }

        List<SeasonDto> seasonData =
                this.seasonRepository.findAllByHotelId( hotelId )
                        .stream()
                        .map(this::mapToSeasonDto)
                        .toList();

        ccError.setData(seasonData);

        return ccError;
    }

    public CCError<SeasonBulkUpdateDto> bulkUpdateSeasons(Long hotelId, SeasonBulkUpdateDto request ) {
        CCError<SeasonBulkUpdateDto> ccError = new CCError<>(CCErrorStatus.SUCCESS, SUCCESS_RETRIEVE_TEST);

        Optional<Hotel> hotelDao = this.hotelRepository.findById( hotelId );

        if( hotelDao.isEmpty() )
        {
            ccError.setStatus( CCErrorStatus.ERROR );
            ccError.setMessage( ERROR_HOTEL_V2_NOT_FOUND );
            return ccError;
        }

        Hotel hotel = hotelDao.get();

        List<SeasonDto> created =
                request.getCreated() != null
                        ? request.getCreated()
                        : List.of();

        List<SeasonDto> updated =
                request.getUpdated() != null
                        ? request.getUpdated()
                        : List.of();

        List<Long> deleted =
                request.getDeleted() != null
                        ? request.getDeleted()
                        : List.of();

        /*
         * 2. Validate CREATE list
         */
        boolean createdHasId = created.stream()
                .anyMatch(season -> season.getId() != null);

        if (createdHasId) {
            ccError.setStatus(CCErrorStatus.ERROR);
            ccError.setMessage(
                    "Created seasons must not contain an id"
            );
            return ccError;
        }

        /*
         * 3. Validate UPDATE list
         */
        boolean updateMissingId = updated.stream()
                .anyMatch(season -> season.getId() == null);

        if (updateMissingId) {
            ccError.setStatus(CCErrorStatus.ERROR);
            ccError.setMessage(
                    "Updated seasons must contain an id"
            );
            return ccError;
        }

        List<Long> updateIds = updated.stream()
                .map(SeasonDto::getId)
                .toList();

        /*
         * 4. Make sure same season is not
         *    updated and deleted together
         */
        Set<Long> deletedSet =
                new HashSet<>(deleted);

        List<Long> conflictingIds = updateIds.stream()
                .filter(deletedSet::contains)
                .toList();

        if (!conflictingIds.isEmpty()) {
            ccError.setStatus(CCErrorStatus.ERROR);
            ccError.setMessage(
                    "Seasons cannot be updated and deleted " +
                            "in the same request: " + conflictingIds
            );
            return ccError;
        }

        /*
         * 5. Load all seasons involved in
         *    UPDATE and DELETE at once
         */
        Set<Long> requestedExistingIds =
                new HashSet<>();

        requestedExistingIds.addAll(updateIds);
        requestedExistingIds.addAll(deleted);

        List<Season> existingSeasons =
                seasonRepository.findAllById(
                        requestedExistingIds
                );

        Map<Long, Season> existingSeasonMap =
                existingSeasons.stream()
                        .collect(
                                Collectors.toMap(
                                        Season::getId,
                                        Function.identity()
                                )
                        );

        /*
         * 6. Check missing seasons
         */
        List<Long> missingIds =
                requestedExistingIds.stream()
                        .filter(id ->
                                !existingSeasonMap.containsKey(id)
                        )
                        .toList();

        if (!missingIds.isEmpty()) {
            ccError.setStatus(CCErrorStatus.ERROR);
            ccError.setMessage(
                    "Seasons not found: " + missingIds
            );
            return ccError;
        }

        /*
         * 7. Validate hotel ownership
         *
         * A season belonging to hotel 20
         * must not be modified through hotel 10.
         */
        List<Long> invalidHotelSeasonIds =
                existingSeasons.stream()
                        .filter(season ->
                                season.getHotel() == null ||
                                        !season.getHotel()
                                                .getId()
                                                .equals(hotelId)
                        )
                        .map(Season::getId)
                        .toList();

        if (!invalidHotelSeasonIds.isEmpty()) {
            ccError.setStatus(CCErrorStatus.ERROR);
            ccError.setMessage(
                    "Seasons do not belong to hotel "
                            + hotelId
                            + ": "
                            + invalidHotelSeasonIds
            );
            return ccError;
        }

        /*
         * Everything has now been validated.
         *
         * Start modifying database.
         */

        /*
         * 8. CREATE
         */
        List<Season> seasonsToCreate =
                created.stream()
                        .map(dto -> {

                            Season season = new Season();

                            season.setSeasonName(
                                    dto.getSeasonName()
                            );

                            season.setStartDate(
                                    dto.getStartDate()
                            );

                            season.setEndDate(
                                    dto.getEndDate()
                            );

                            season.setHotel(hotel);

                            return season;
                        })
                        .toList();

        List<Season> createdSeasons =
                seasonRepository.saveAll(
                        seasonsToCreate
                );

        /*
         * 9. UPDATE
         */
        List<Season> seasonsToUpdate =
                updated.stream()
                        .map(dto -> {

                            Season season =
                                    existingSeasonMap.get(
                                            dto.getId()
                                    );

                            season.setSeasonName(
                                    dto.getSeasonName()
                            );

                            season.setStartDate(
                                    dto.getStartDate()
                            );

                            season.setEndDate(
                                    dto.getEndDate()
                            );

                            return season;
                        })
                        .toList();

        List<Season> updatedSeasons =
                seasonRepository.saveAll(
                        seasonsToUpdate
                );

        /*
         * 10. DELETE
         */
        if (!deleted.isEmpty()) {
            seasonRepository.deleteAllByIdInBatch(
                    deleted
            );
        }

        /*
         * 11. Build response
         */
        SeasonBulkUpdateDto response =
                new SeasonBulkUpdateDto();

        response.setCreated(
                createdSeasons.stream()
                        .map(this::mapToSeasonDto)
                        .toList()
        );

        response.setUpdated(
                updatedSeasons.stream()
                        .map(this::mapToSeasonDto)
                        .toList()
        );

        response.setDeleted(deleted);

        ccError.setData(response);


        ccError.setData(request);
        return ccError;
    }

    private SeasonDto mapToSeasonDto(
            Season season) {

        return new SeasonDto(
                season.getId(),
                season.getSeasonName(),
                season.getStartDate(),
                season.getEndDate()
        );
    }
}
