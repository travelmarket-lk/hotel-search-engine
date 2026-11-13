package lk.travelmarket.search_engine.service.v2.hotel;

import lk.travelmarket.search_engine.dto.BlackoutsDto;
import lk.travelmarket.search_engine.dto.SeasonDto;
import lk.travelmarket.search_engine.dto.bulk.season.BlackoutBulkUpdateDto;
import lk.travelmarket.search_engine.dto.bulk.season.SeasonBulkUpdateDto;
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
public class HotelV2Service implements IHotelV2Service {

    private final HotelV2ServiceImpl hotelServiceImpl;

    public HotelV2Service(HotelV2ServiceImpl hotelServiceImpl) {
        this.hotelServiceImpl = hotelServiceImpl;
    }

    @Override
    public CCResponsePack<SeasonDto> retrieveSeasons(Long hotelId) {
        try {

            CCError<List<SeasonDto>> ccError = hotelServiceImpl.retrieveSeasons( hotelId );

            if (ccError.getStatus().equals(CCErrorStatus.ERROR)) {

                return new CCResponsePack<>(
                        Status.ERROR,
                        ccError.getMessage(),
                        null
                );
            }

            return new CCResponsePack<>(
                    ccError.getData()
            );

        } catch (Exception e) {

            return new CCResponsePack<>(
                    ErrorLayer.HSL_LAYER,
                    ErrorSource.SERVER_ERROR,
                    ERROR_RETRIEVE_SEASONS,
                    e
            );
        }
    }

    @Override
    public CCResponse<SeasonBulkUpdateDto> bulkUpdateSeasons(Long hotelId, SeasonBulkUpdateDto request) {
        try {
            CCError<SeasonBulkUpdateDto> ccError = hotelServiceImpl.bulkUpdateSeasons( hotelId, request );
            if( ccError.getStatus().equals( CCErrorStatus.ERROR))
            {
                return new CCResponse<>( Status.ERROR, ccError.getMessage(), null );
            }
            return new CCResponse<>( ccError.getData() );
        } catch ( Exception e ) {
            return new CCResponse<>( ErrorLayer.HSL_LAYER, ErrorSource.SERVER_ERROR, ERROR_HOTEL_SEASONS_BULK_UPDATE, e );
        }
    }

    @Override
    public CCResponsePack<BlackoutsDto> retrieveBlackouts(Long hotelId) {
        try {

            CCError<List<BlackoutsDto>> ccError = hotelServiceImpl.retrieveBlackouts( hotelId );

            if (ccError.getStatus().equals(CCErrorStatus.ERROR)) {

                return new CCResponsePack<>(
                        Status.ERROR,
                        ccError.getMessage(),
                        null
                );
            }

            return new CCResponsePack<>(
                    ccError.getData()
            );

        } catch (Exception e) {

            return new CCResponsePack<>(
                    ErrorLayer.HSL_LAYER,
                    ErrorSource.SERVER_ERROR,
                    ERROR_RETRIEVE_BLACKOUTS,
                    e
            );
        }
    }

    @Override
    public CCResponse<BlackoutBulkUpdateDto> bulkUpdateBlackouts(Long hotelId, BlackoutBulkUpdateDto request) {
        try {
            CCError<BlackoutBulkUpdateDto> ccError = hotelServiceImpl.bulkUpdateBlackouts (hotelId, request);
            if ( ccError.getStatus().equals( CCErrorStatus.ERROR)) {
                return new CCResponse<>( Status.ERROR, ccError.getMessage(), null );
            }
            return new CCResponse<>( ccError.getData() );
        } catch ( Exception e) {
            return new CCResponse<>(ErrorLayer.HSL_LAYER, ErrorSource.SERVER_ERROR, ERROR_HOTEL_BLACKOUTS_BULK_UPDATE, e );
        }
    }
}
