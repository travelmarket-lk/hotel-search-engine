package lk.travelmarket.search_engine.service.data;

import lk.travelmarket.search_engine.dao.HotelRoom.BedType;
import lk.travelmarket.search_engine.network.commons.CCResponsePack;

public interface IDataService {

    // Bed Types
    CCResponsePack<BedType> findAllBedTypes(
            int page,
            int size
    );
}