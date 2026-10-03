package lk.travelmarket.search_engine.service.data;

import lk.travelmarket.search_engine.dao.HotelRoom.BedType;
import lk.travelmarket.search_engine.network.commons.CCError;
import lk.travelmarket.search_engine.network.commons.CCErrorStatus;
import lk.travelmarket.search_engine.repository.BedTypeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import static lk.travelmarket.search_engine.util.Constants.*;

@Service
public class DataServiceImpl {

    private final BedTypeRepository bedTypeRepository;

    public DataServiceImpl(
            BedTypeRepository bedTypeRepository
    ) {
        this.bedTypeRepository = bedTypeRepository;
    }

    // Bed Types
    public CCError<Page<BedType>> findAllBedTypes(
            int page,
            int size
    ) {

        CCError<Page<BedType>> ccError =
                new CCError<>(
                        CCErrorStatus.SUCCESS,
                        SUCCESS_RETRIEVE_BED_TYPES
                );

        Pageable pageable = PageRequest.of(page, size);

        Page<BedType> bedTypeData = bedTypeRepository.findAll(pageable);

        ccError.setData(bedTypeData);

        return ccError;
    }
}