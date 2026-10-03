package lk.travelmarket.search_engine.service.data;

import lk.travelmarket.search_engine.dto.CityDto;
import lk.travelmarket.search_engine.dto.DistrictDto;
import lk.travelmarket.search_engine.network.commons.CCResponsePack;

public interface IDataService {

    CCResponsePack<DistrictDto> findAllDistricts(
            int page,
            int size
    );

    CCResponsePack<CityDto> findAllCities(
            int page,
            int size
    );
}