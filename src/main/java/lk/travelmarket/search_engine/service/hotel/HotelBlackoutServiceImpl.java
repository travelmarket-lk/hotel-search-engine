package lk.travelmarket.search_engine.service.hotel;

import jakarta.transaction.Transactional;
import lk.travelmarket.search_engine.dao.Blackouts;
import lk.travelmarket.search_engine.dto.BlackoutsDto;
import lk.travelmarket.search_engine.network.commons.CCError;
import lk.travelmarket.search_engine.network.commons.CCErrorStatus;
import lk.travelmarket.search_engine.repository.HotelBlackoutRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

import static lk.travelmarket.search_engine.util.Constants.*;

@Component
@Transactional
public class HotelBlackoutServiceImpl {

    private final HotelBlackoutRepository hotelBlackoutRepository;

    public HotelBlackoutServiceImpl(HotelBlackoutRepository hotelBlackoutRepository) {
        this.hotelBlackoutRepository = hotelBlackoutRepository;
    }

    public CCError<List<BlackoutsDto>> findAll() {
        CCError<List<BlackoutsDto>> ccError = new CCError<>(CCErrorStatus.SUCCESS, SUCCESS_RETRIEVE_HOTEL_BLACKOUTS);
        List<BlackoutsDto> data = this.hotelBlackoutRepository.findByRoomIdIsNull().stream()
                .map(this::toDto)
                .toList();
        ccError.setData(data);
        return ccError;
    }

    public CCError<List<BlackoutsDto>> findByHotelId(Long hotelId) {
        CCError<List<BlackoutsDto>> ccError = new CCError<>(CCErrorStatus.SUCCESS, SUCCESS_RETRIEVE_HOTEL_BLACKOUTS);
        List<BlackoutsDto> data = this.hotelBlackoutRepository.findByHotelIdAndRoomIdIsNull(hotelId).stream()
                .map(this::toDto)
                .toList();
        ccError.setData(data);
        return ccError;
    }

    public CCError<BlackoutsDto> findHotelBlackout(Long id) {
        CCError<BlackoutsDto> ccError = new CCError<>(CCErrorStatus.SUCCESS, SUCCESS_RETRIEVE_HOTEL_BLACKOUT);

        Optional<Blackouts> dao = this.hotelBlackoutRepository.findById(id);

        if (dao.isEmpty() || dao.get().getRoomId() != null) {
            ccError.setStatus(CCErrorStatus.ERROR);
            ccError.setMessage(ERROR_HOTEL_BLACKOUT_NOT_FOUND + id);
            return ccError;
        }

        BlackoutsDto data = this.toDto(dao.get());
        ccError.setData(data);
        return ccError;
    }

    public CCError<BlackoutsDto> createHotelBlackout(BlackoutsDto dto) {
        CCError<BlackoutsDto> ccError = new CCError<>(CCErrorStatus.SUCCESS, SUCCESS_CREATE_HOTEL_BLACKOUT);

        Blackouts dao = new Blackouts();
        dao.setHotelId(dto.getHotelId());
        dao.setRoomId(null);
        dao.setReason(dto.getReason());
        dao.setStartDate(dto.getStartDate());
        dao.setEndDate(dto.getEndDate());

        Blackouts saved = hotelBlackoutRepository.save(dao);

        BlackoutsDto data = this.toDto(saved);
        ccError.setData(data);
        return ccError;
    }

    public CCError<BlackoutsDto> updateHotelBlackout(Long id, BlackoutsDto dto) {
        CCError<BlackoutsDto> ccError = new CCError<>(CCErrorStatus.SUCCESS, SUCCESS_UPDATE_HOTEL_BLACKOUT);

        Optional<Blackouts> dao = this.hotelBlackoutRepository.findById(id);

        if (dao.isEmpty() || dao.get().getRoomId() != null) {
            ccError.setStatus(CCErrorStatus.ERROR);
            ccError.setMessage(ERROR_HOTEL_BLACKOUT_NOT_FOUND + id);
            return ccError;
        }

        Blackouts entity = dao.get();
        entity.setHotelId(dto.getHotelId());
        entity.setRoomId(null);
        entity.setReason(dto.getReason());
        entity.setStartDate(dto.getStartDate());
        entity.setEndDate(dto.getEndDate());

        this.hotelBlackoutRepository.save(entity);

        BlackoutsDto data = this.toDto(entity);
        ccError.setData(data);
        return ccError;
    }

    public CCError<BlackoutsDto> deleteHotelBlackout(Long id) {
        CCError<BlackoutsDto> ccError = new CCError<>(CCErrorStatus.SUCCESS, SUCCESS_DELETE_HOTEL_BLACKOUT);

        Optional<Blackouts> dao = this.hotelBlackoutRepository.findById(id);

        if (dao.isEmpty() || dao.get().getRoomId() != null) {
            ccError.setStatus(CCErrorStatus.ERROR);
            ccError.setMessage(ERROR_HOTEL_BLACKOUT_NOT_FOUND + id);
            return ccError;
        }

        this.hotelBlackoutRepository.delete(dao.get());

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