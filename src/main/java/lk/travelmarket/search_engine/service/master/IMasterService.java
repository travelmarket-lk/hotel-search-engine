package lk.travelmarket.search_engine.service.master;

import lk.travelmarket.search_engine.dao.HotelRoom.BedType;
import lk.travelmarket.search_engine.network.commons.CCResponse;
import lk.travelmarket.search_engine.network.commons.CCResponsePack;

public interface IMasterService {

// BED TYPES
    CCResponsePack<BedType> findAllBedTypes();

    CCResponse<BedType> addBedType(BedType bedType);

    CCResponse<Void> deleteBedType(Long id);

    CCResponse<BedType> findBedTypeById(Long id);

    CCResponse<BedType> updateBedType(Long id, BedType bedType);
}