package lk.travelmarket.search_engine.service.data;

import lk.travelmarket.search_engine.dao.HotelRoom.BedType;
import lk.travelmarket.search_engine.dto.BlackoutsDto;
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

    // Bed Types

    @Override
    public CCResponsePack<BedType> findAllBedTypes(
            int page,
            int size
    ) {

        try {

            CCError<Page<BedType>> ccError =
                    dataServiceImpl.findAllBedTypes(page, size);

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
                    ERROR_RETRIEVE_BED_TYPES,
                    e
            );
        }
    }
}