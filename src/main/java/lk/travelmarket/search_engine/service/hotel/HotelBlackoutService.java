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
public class HotelBlackoutService implements IHotelBlackoutService {

    private final HotelBlackoutServiceImpl hotelBlackoutServiceImpl;

    public HotelBlackoutService(HotelBlackoutServiceImpl hotelBlackoutServiceImpl) {
        this.hotelBlackoutServiceImpl = hotelBlackoutServiceImpl;
    }

    @Override
    public CCResponsePack<BlackoutsDto> findAll() {
        try {
            CCError<List<BlackoutsDto>> ccError = hotelBlackoutServiceImpl.findAll();
            if (ccError.getStatus().equals(CCErrorStatus.ERROR)) {
                return new CCResponsePack<>(Status.ERROR, ccError.getMessage(), null);
            }
            return new CCResponsePack<>(ccError.getData());
        } catch (Exception e) {
            return new CCResponsePack<>(ErrorLayer.HSL_LAYER, ErrorSource.SERVER_ERROR, ERROR_RETRIEVE_HOTEL_BLACKOUTS, e);
        }
    }

    @Override
    public CCResponsePack<BlackoutsDto> findByHotelId(Long hotelId) {
        try {
            CCError<List<BlackoutsDto>> ccError = hotelBlackoutServiceImpl.findByHotelId(hotelId);
            if (ccError.getStatus().equals(CCErrorStatus.ERROR)) {
                return new CCResponsePack<>(Status.ERROR, ccError.getMessage(), null);
            }
            return new CCResponsePack<>(ccError.getData());
        } catch (Exception e) {
            return new CCResponsePack<>(ErrorLayer.HSL_LAYER, ErrorSource.SERVER_ERROR, ERROR_RETRIEVE_HOTEL_BLACKOUTS, e);
        }
    }

    @Override
    public CCResponse<BlackoutsDto> findHotelBlackout(Long id) {
        try {
            CCError<BlackoutsDto> ccError = hotelBlackoutServiceImpl.findHotelBlackout(id);
            if (ccError.getStatus().equals(CCErrorStatus.ERROR)) {
                return new CCResponse<>(Status.ERROR, ccError.getMessage(), null);
            }
            return new CCResponse<>(ccError.getData());
        } catch (Exception e) {
            return new CCResponse<>(ErrorLayer.HSL_LAYER, ErrorSource.SERVER_ERROR, ERROR_RETRIEVE_HOTEL_BLACKOUT, e);
        }
    }

    @Override
    public CCResponse<BlackoutsDto> createHotelBlackout(BlackoutsDto dto) {
        try {
            CCError<BlackoutsDto> ccError = hotelBlackoutServiceImpl.createHotelBlackout(dto);
            if (ccError.getStatus().equals(CCErrorStatus.ERROR)) {
                return new CCResponse<>(Status.ERROR, ccError.getMessage(), null);
            }
            return new CCResponse<>(ccError.getData());
        } catch (Exception e) {
            return new CCResponse<>(ErrorLayer.HSL_LAYER, ErrorSource.SERVER_ERROR, ERROR_CREATE_HOTEL_BLACKOUT, e);
        }
    }

    @Override
    public CCResponse<BlackoutsDto> updateHotelBlackout(Long id, BlackoutsDto dto) {
        try {
            CCError<BlackoutsDto> ccError = hotelBlackoutServiceImpl.updateHotelBlackout(id, dto);
            if (ccError.getStatus().equals(CCErrorStatus.ERROR)) {
                return new CCResponse<>(Status.ERROR, ccError.getMessage(), null);
            }
            return new CCResponse<>(ccError.getData());
        } catch (Exception e) {
            return new CCResponse<>(ErrorLayer.HSL_LAYER, ErrorSource.SERVER_ERROR, ERROR_UPDATE_HOTEL_BLACKOUT, e);
        }
    }

    @Override
    public CCResponse<BlackoutsDto> deleteHotelBlackout(Long id) {
        try {
            CCError<BlackoutsDto> ccError = hotelBlackoutServiceImpl.deleteHotelBlackout(id);
            if (ccError.getStatus().equals(CCErrorStatus.ERROR)) {
                return new CCResponse<>(Status.ERROR, ccError.getMessage(), null);
            }
            return new CCResponse<>(ccError.getData());
        } catch (Exception e) {
            return new CCResponse<>(ErrorLayer.HSL_LAYER, ErrorSource.SERVER_ERROR, ERROR_DELETE_HOTEL_BLACKOUT, e);
        }
    }

}