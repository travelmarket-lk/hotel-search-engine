package lk.travelmarket.search_engine.service.data;

import lk.travelmarket.search_engine.dto.CityDto;
import lk.travelmarket.search_engine.dto.DistrictDto;
import lk.travelmarket.search_engine.network.commons.CCError;
import lk.travelmarket.search_engine.network.commons.CCErrorStatus;
import lk.travelmarket.search_engine.network.commons.CCResponsePack;
import lk.travelmarket.search_engine.network.error.code.ErrorLayer;
import lk.travelmarket.search_engine.network.error.code.ErrorSource;
import lk.travelmarket.search_engine.network.error.code.Status;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import static lk.travelmarket.search_engine.util.Constants.*;

@Service
public class DataService implements IDataService {

    private final DataServiceImpl dataServiceImpl;

    public DataService(DataServiceImpl dataServiceImpl) {
        this.dataServiceImpl = dataServiceImpl;
    }

    @Override
    public CCResponsePack<DistrictDto> findAllDistricts(
            int page,
            int size
    ) {

        try {

            CCError<Page<DistrictDto>> ccError =
                    dataServiceImpl.findAllDistricts(page, size);

            if (ccError.getStatus().equals(CCErrorStatus.ERROR)) {
                return new CCResponsePack<>(
                        Status.ERROR,
                        ccError.getMessage(),
                        null
                );
            }

            return new CCResponsePack<>(
                    ccError.getData().getContent()
            );

        } catch (Exception e) {

            return new CCResponsePack<>(
                    ErrorLayer.HSL_LAYER,
                    ErrorSource.SERVER_ERROR,
                    ERROR_RETRIEVE_DISTRICTS,
                    e
            );
        }
    }

    @Override
    public CCResponsePack<CityDto> findAllCities(
            int page,
            int size
    ) {

        try {

            CCError<Page<CityDto>> ccError =
                    dataServiceImpl.findAllCities(page, size);

            if (ccError.getStatus().equals(CCErrorStatus.ERROR)) {
                return new CCResponsePack<>(
                        Status.ERROR,
                        ccError.getMessage(),
                        null
                );
            }

            return new CCResponsePack<>(
                    ccError.getData().getContent()
            );

        } catch (Exception e) {

            return new CCResponsePack<>(
                    ErrorLayer.HSL_LAYER,
                    ErrorSource.SERVER_ERROR,
                    ERROR_RETRIEVE_CITIES,
                    e
            );
        }
    }
}