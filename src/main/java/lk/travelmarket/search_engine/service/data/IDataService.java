package lk.travelmarket.search_engine.service.data;

import lk.travelmarket.search_engine.dto.*;
import lk.travelmarket.search_engine.network.commons.CCResponsePack;
import lk.travelmarket.search_engine.dto.BoardBasisDto;
import lk.travelmarket.search_engine.dto.RoomCategoryDto;
import lk.travelmarket.search_engine.dto.RoomTypeDto;

public interface IDataService {

    CCResponsePack<DistrictDto> findAllDistricts(
            int page,
            int size
    );

    CCResponsePack<CityDto> findAllCities(
            int page,
            int size
    );

    CCResponsePack<RoomCategoryDto> findAllRoomCategories(
            int page,
            int size
    );

    //-------------Board Basis---------------
    CCResponsePack<BoardBasisDto> findAllBoardBasis(
            int page,
            int size
    );

    //--------------Room Type-----------------
    CCResponsePack<RoomTypeDto> findAllRoomType(
            int page,
            int size
    );
}