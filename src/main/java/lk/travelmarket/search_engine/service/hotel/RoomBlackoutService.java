package lk.travelmarket.search_engine.service.hotel;

import lk.travelmarket.search_engine.dto.BlackoutsDto;
import lk.travelmarket.search_engine.network.commons.CCError;
import lk.travelmarket.search_engine.network.commons.CCErrorStatus;
import lk.travelmarket.search_engine.network.commons.CCResponse;
import lk.travelmarket.search_engine.network.commons.CCResponsePack;
import lk.travelmarket.search_engine.network.error.code.ErrorLayer;
import lk.travelmarket.search_engine.network.error.code.ErrorSource;
import lk.travelmarket.search_engine.network.error.code.Status;
import org.springframework.stereotype.Service;

import java.util.List;

import static lk.travelmarket.search_engine.util.Constants.*;

@Service
public class RoomBlackoutService implements IRoomBlackoutService {

    private final RoomBlackoutServiceImpl roomBlackoutServiceImpl;

    public RoomBlackoutService(RoomBlackoutServiceImpl roomBlackoutServiceImpl) {
        this.roomBlackoutServiceImpl = roomBlackoutServiceImpl;
    }

    @Override
    public CCResponsePack<BlackoutsDto> findAll() {
        try {
            CCError<List<BlackoutsDto>> ccError = roomBlackoutServiceImpl.findAll();
            if (ccError.getStatus().equals(CCErrorStatus.ERROR)) {
                return new CCResponsePack<>(Status.ERROR, ccError.getMessage(), null);
            }
            return new CCResponsePack<>(ccError.getData());
        } catch (Exception e) {
            return new CCResponsePack<>(ErrorLayer.HSL_LAYER, ErrorSource.SERVER_ERROR, ERROR_RETRIEVE_ROOM_BLACKOUTS, e);
        }
    }

    @Override
    public CCResponsePack<BlackoutsDto> findByRoomId(Long roomId) {
        try {
            CCError<List<BlackoutsDto>> ccError = roomBlackoutServiceImpl.findByRoomId(roomId);
            if (ccError.getStatus().equals(CCErrorStatus.ERROR)) {
                return new CCResponsePack<>(Status.ERROR, ccError.getMessage(), null);
            }
            return new CCResponsePack<>(ccError.getData());
        } catch (Exception e) {
            return new CCResponsePack<>(ErrorLayer.HSL_LAYER, ErrorSource.SERVER_ERROR, ERROR_RETRIEVE_ROOM_BLACKOUTS, e);
        }
    }

    @Override
    public CCResponsePack<BlackoutsDto> findByHotelId(Long hotelId) {
        try {
            CCError<List<BlackoutsDto>> ccError = roomBlackoutServiceImpl.findByHotelId(hotelId);
            if (ccError.getStatus().equals(CCErrorStatus.ERROR)) {
                return new CCResponsePack<>(Status.ERROR, ccError.getMessage(), null);
            }
            return new CCResponsePack<>(ccError.getData());
        } catch (Exception e) {
            return new CCResponsePack<>(ErrorLayer.HSL_LAYER, ErrorSource.SERVER_ERROR, ERROR_RETRIEVE_ROOM_BLACKOUTS, e);
        }
    }

    @Override
    public CCResponse<BlackoutsDto> findRoomBlackout(Long id) {
        try {
            CCError<BlackoutsDto> ccError = roomBlackoutServiceImpl.findRoomBlackout(id);
            if (ccError.getStatus().equals(CCErrorStatus.ERROR)) {
                return new CCResponse<>(Status.ERROR, ccError.getMessage(), null);
            }
            return new CCResponse<>(ccError.getData());
        } catch (Exception e) {
            return new CCResponse<>(ErrorLayer.HSL_LAYER, ErrorSource.SERVER_ERROR, ERROR_RETRIEVE_ROOM_BLACKOUT, e);
        }
    }

    @Override
    public CCResponse<BlackoutsDto> createRoomBlackout(BlackoutsDto dto) {
        try {
            CCError<BlackoutsDto> ccError = roomBlackoutServiceImpl.createRoomBlackout(dto);
            if (ccError.getStatus().equals(CCErrorStatus.ERROR)) {
                return new CCResponse<>(Status.ERROR, ccError.getMessage(), null);
            }
            return new CCResponse<>(ccError.getData());
        } catch (Exception e) {
            return new CCResponse<>(ErrorLayer.HSL_LAYER, ErrorSource.SERVER_ERROR, ERROR_CREATE_ROOM_BLACKOUT, e);
        }
    }

    @Override
    public CCResponse<BlackoutsDto> updateRoomBlackout(Long id, BlackoutsDto dto) {
        try {
            CCError<BlackoutsDto> ccError = roomBlackoutServiceImpl.updateRoomBlackout(id, dto);
            if (ccError.getStatus().equals(CCErrorStatus.ERROR)) {
                return new CCResponse<>(Status.ERROR, ccError.getMessage(), null);
            }
            return new CCResponse<>(ccError.getData());
        } catch (Exception e) {
            return new CCResponse<>(ErrorLayer.HSL_LAYER, ErrorSource.SERVER_ERROR, ERROR_UPDATE_ROOM_BLACKOUT, e);
        }
    }

    @Override
    public CCResponse<BlackoutsDto> deleteRoomBlackout(Long id) {
        try {
            CCError<BlackoutsDto> ccError = roomBlackoutServiceImpl.deleteRoomBlackout(id);
            if (ccError.getStatus().equals(CCErrorStatus.ERROR)) {
                return new CCResponse<>(Status.ERROR, ccError.getMessage(), null);
            }
            return new CCResponse<>(ccError.getData());
        } catch (Exception e) {
            return new CCResponse<>(ErrorLayer.HSL_LAYER, ErrorSource.SERVER_ERROR, ERROR_DELETE_ROOM_BLACKOUT, e);
        }
    }

}
