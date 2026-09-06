package lk.travelmarket.search_engine.service.hotel;

import jakarta.transaction.Transactional;
import lk.travelmarket.search_engine.dao.Blackouts;
import lk.travelmarket.search_engine.dto.BlackoutsDto;
import lk.travelmarket.search_engine.network.commons.CCError;
import lk.travelmarket.search_engine.network.commons.CCErrorStatus;
import lk.travelmarket.search_engine.repository.RoomBlackoutRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

import static lk.travelmarket.search_engine.util.Constants.*;

@Component
@Transactional
public class RoomBlackoutServiceImpl {

    private final RoomBlackoutRepository roomBlackoutRepository;

    public RoomBlackoutServiceImpl(RoomBlackoutRepository roomBlackoutRepository) {
        this.roomBlackoutRepository = roomBlackoutRepository;
    }

    public CCError<List<BlackoutsDto>> findAll() {
        CCError<List<BlackoutsDto>> ccError = new CCError<>(CCErrorStatus.SUCCESS, SUCCESS_RETRIEVE_ROOM_BLACKOUTS);
        List<BlackoutsDto> data = this.roomBlackoutRepository.findByRoomIdIsNotNull().stream()
                .map(this::toDto)
                .toList();
        ccError.setData(data);
        return ccError;
    }

    public CCError<List<BlackoutsDto>> findByRoomId(Long roomId) {
        CCError<List<BlackoutsDto>> ccError = new CCError<>(CCErrorStatus.SUCCESS, SUCCESS_RETRIEVE_ROOM_BLACKOUTS);
        List<BlackoutsDto> data = this.roomBlackoutRepository.findByRoomId(roomId).stream()
                .map(this::toDto)
                .toList();
        ccError.setData(data);
        return ccError;
    }

    public CCError<List<BlackoutsDto>> findByHotelId(Long hotelId) {
        CCError<List<BlackoutsDto>> ccError = new CCError<>(CCErrorStatus.SUCCESS, SUCCESS_RETRIEVE_ROOM_BLACKOUTS);
        List<BlackoutsDto> data = this.roomBlackoutRepository.findByHotelIdAndRoomIdIsNotNull(hotelId).stream()
                .map(this::toDto)
                .toList();
        ccError.setData(data);
        return ccError;
    }

    public CCError<BlackoutsDto> findRoomBlackout(Long id) {
        CCError<BlackoutsDto> ccError = new CCError<>(CCErrorStatus.SUCCESS, SUCCESS_RETRIEVE_ROOM_BLACKOUT);

        Optional<Blackouts> dao = this.roomBlackoutRepository.findById(id);

        if (dao.isEmpty() || dao.get().getRoomId() == null) {
            ccError.setStatus(CCErrorStatus.ERROR);
            ccError.setMessage(ERROR_ROOM_BLACKOUT_NOT_FOUND + id);
            return ccError;
        }

        BlackoutsDto data = this.toDto(dao.get());
        ccError.setData(data);
        return ccError;
    }

    public CCError<BlackoutsDto> createRoomBlackout(BlackoutsDto dto) {
        CCError<BlackoutsDto> ccError = new CCError<>(CCErrorStatus.SUCCESS, SUCCESS_CREATE_ROOM_BLACKOUT);

        if (dto.getRoomId() == null) {
            ccError.setStatus(CCErrorStatus.ERROR);
            ccError.setMessage(ERROR_ROOM_ID_REQUIRED);
            return ccError;
        }

        Blackouts dao = new Blackouts();
        dao.setHotelId(dto.getHotelId());
        dao.setRoomId(dto.getRoomId());
        dao.setReason(dto.getReason());
        dao.setStartDate(dto.getStartDate());
        dao.setEndDate(dto.getEndDate());

        Blackouts saved = roomBlackoutRepository.save(dao);

        BlackoutsDto data = this.toDto(saved);
        ccError.setData(data);
        return ccError;
    }

    public CCError<BlackoutsDto> updateRoomBlackout(Long id, BlackoutsDto dto) {
        CCError<BlackoutsDto> ccError = new CCError<>(CCErrorStatus.SUCCESS, SUCCESS_UPDATE_ROOM_BLACKOUT);

        Optional<Blackouts> dao = this.roomBlackoutRepository.findById(id);

        if (dao.isEmpty() || dao.get().getRoomId() == null) {
            ccError.setStatus(CCErrorStatus.ERROR);
            ccError.setMessage(ERROR_ROOM_BLACKOUT_NOT_FOUND + id);
            return ccError;
        }

        if (dto.getRoomId() == null) {
            ccError.setStatus(CCErrorStatus.ERROR);
            ccError.setMessage(ERROR_ROOM_ID_REQUIRED);
            return ccError;
        }

        Blackouts entity = dao.get();
        entity.setHotelId(dto.getHotelId());
        entity.setRoomId(dto.getRoomId());
        entity.setReason(dto.getReason());
        entity.setStartDate(dto.getStartDate());
        entity.setEndDate(dto.getEndDate());

        this.roomBlackoutRepository.save(entity);

        BlackoutsDto data = this.toDto(entity);
        ccError.setData(data);
        return ccError;
    }

    public CCError<BlackoutsDto> deleteRoomBlackout(Long id) {
        CCError<BlackoutsDto> ccError = new CCError<>(CCErrorStatus.SUCCESS, SUCCESS_DELETE_ROOM_BLACKOUT);

        Optional<Blackouts> dao = this.roomBlackoutRepository.findById(id);

        if (dao.isEmpty() || dao.get().getRoomId() == null) {
            ccError.setStatus(CCErrorStatus.ERROR);
            ccError.setMessage(ERROR_ROOM_BLACKOUT_NOT_FOUND + id);
            return ccError;
        }

        this.roomBlackoutRepository.delete(dao.get());

        BlackoutsDto data = this.toDto(dao.get());
        ccError.setData(data);
        return ccError;
    }

    private BlackoutsDto toDto(Blackouts entity) {
        return new BlackoutsDto(
                entity.getId(),
                entity.getHotelId(),
                entity.getRoomId(),
                entity.getReason(),
                entity.getStartDate(),
                entity.getEndDate()
        );
    }

}