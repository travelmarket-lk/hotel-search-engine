package lk.travelmarket.search_engine.service.hotel;

import lk.travelmarket.search_engine.dao.hotel.Hotel;
import lk.travelmarket.search_engine.dto.HotelDto;
import lk.travelmarket.search_engine.network.commons.CCError;
import lk.travelmarket.search_engine.network.commons.CCErrorStatus;
import lk.travelmarket.search_engine.network.commons.CCResponsePack;
import lk.travelmarket.search_engine.network.error.code.ErrorLayer;
import lk.travelmarket.search_engine.network.error.code.ErrorSource;
import lk.travelmarket.search_engine.network.error.code.Status;
import org.springframework.stereotype.Service;

import java.util.List;

import static lk.travelmarket.search_engine.util.Constants.*;

@Service
public class HotelService implements IHotelService {

    private final HotelServiceImpl hotelServiceImpl;

    public HotelService(HotelServiceImpl hotelServiceImpl) {
        this.hotelServiceImpl = hotelServiceImpl;
    }

    @Override
    public CCResponsePack<HotelDto> getAllHotels() {
        try {
            CCError<List<HotelDto>> ccError = hotelServiceImpl.findAll();
            if (ccError.getStatus().equals(CCErrorStatus.ERROR)) {
                return new CCResponsePack<>(Status.ERROR, ccError.getMessage(), null);
            }
            return new CCResponsePack<>(ccError.getData());
        } catch (Exception e) {
            return new CCResponsePack<>(ErrorLayer.HSL_LAYER, ErrorSource.SERVER_ERROR, ERROR_RETRIEVE_TESTS, e);
        }
    }

    @Override
    public CCResponsePack<HotelDto> getHotelById(Long id) {
        try {
            CCError<HotelDto> ccError = hotelServiceImpl.findById(id);
            if (ccError.getStatus().equals(CCErrorStatus.ERROR)) {
                return new CCResponsePack<>(Status.ERROR, ccError.getMessage(), null);
            }
            return new CCResponsePack<>(List.of(ccError.getData()));
        } catch (Exception e) {
            return new CCResponsePack<>(ErrorLayer.HSL_LAYER, ErrorSource.SERVER_ERROR, ERROR_RETRIEVE_HOTEL, e);
        }
    }

    @Override
    public CCResponsePack<HotelDto> createHotel(Hotel hotel) {
        try {
            CCError<HotelDto> ccError = hotelServiceImpl.create(hotel);
            if (ccError.getStatus().equals(CCErrorStatus.ERROR)) {
                return new CCResponsePack<>(Status.ERROR, ccError.getMessage(), null);
            }
            return new CCResponsePack<>(List.of(ccError.getData()));
        } catch (Exception e) {
            return new CCResponsePack<>(ErrorLayer.HSL_LAYER, ErrorSource.SERVER_ERROR, ERROR_CREATE_HOTEL, e);
        }
    }

    @Override
    public CCResponsePack<HotelDto> updateHotel(Long id, Hotel hotelDetails) {
        try {
            CCError<HotelDto> ccError = hotelServiceImpl.update(id, hotelDetails);
            if (ccError.getStatus().equals(CCErrorStatus.ERROR)) {
                return new CCResponsePack<>(Status.ERROR, ccError.getMessage(), null);
            }
            return new CCResponsePack<>(List.of(ccError.getData()));
        } catch (Exception e) {
            return new CCResponsePack<>(ErrorLayer.HSL_LAYER, ErrorSource.SERVER_ERROR, ERROR_UPDATE_HOTEL, e);
        }
    }

    @Override
    public CCResponsePack<Boolean> deleteHotel(Long id) {
        try {
            CCError<Boolean> ccError = hotelServiceImpl.delete(id);
            if (ccError.getStatus().equals(CCErrorStatus.ERROR)) {
                return new CCResponsePack<>(Status.ERROR, ccError.getMessage(), null);
            }
            return new CCResponsePack<>(List.of(ccError.getData()));
        } catch (Exception e) {
            return new CCResponsePack<>(ErrorLayer.HSL_LAYER, ErrorSource.SERVER_ERROR, ERROR_DELETE_HOTEL, e);
        }
    }
}