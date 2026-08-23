package lk.travelmarket.search_engine.service.hotelOwner;

import lk.travelmarket.search_engine.dto.HotelOwnerDto;
import lk.travelmarket.search_engine.network.commons.CCError;
import lk.travelmarket.search_engine.network.commons.CCErrorStatus;
import lk.travelmarket.search_engine.network.commons.CCResponse;
import lk.travelmarket.search_engine.network.error.code.ErrorLayer;
import lk.travelmarket.search_engine.network.error.code.ErrorSource;
import lk.travelmarket.search_engine.network.error.code.Status;
import org.springframework.stereotype.Service;

import static lk.travelmarket.search_engine.util.Constants.ERROR_REGISTER_HOTEL_OWNER;

@Service
public class HotelOwnerService implements IHotelOwnerService {

    private final HotelOwnerServiceImpl hotelOwnerServiceImpl;

    public HotelOwnerService(
            HotelOwnerServiceImpl hotelOwnerServiceImpl) {

        this.hotelOwnerServiceImpl = hotelOwnerServiceImpl;
    }

    @Override
    public CCResponse<HotelOwnerDto> registerOwner(
            HotelOwnerDto dto) {

        try {

            CCError<HotelOwnerDto> ccError =
                    hotelOwnerServiceImpl.registerOwner(dto);

            if (ccError.getStatus().equals(CCErrorStatus.ERROR)) {

                return new CCResponse<>(
                        Status.ERROR,
                        ccError.getMessage(),
                        null
                );
            }

            return new CCResponse<>(ccError.getData());

        } catch (Exception e) {

            return new CCResponse<>(
                    ErrorLayer.HSL_LAYER,
                    ErrorSource.SERVER_ERROR,
                    ERROR_REGISTER_HOTEL_OWNER,
                    e
            );
        }
    }
}