package lk.travelmarket.search_engine.service.master;

import lk.travelmarket.search_engine.dto.CityDto;
import lk.travelmarket.search_engine.dto.DistrictDto;
import lk.travelmarket.search_engine.dto.FacilityCategoryDto;
import lk.travelmarket.search_engine.dto.FacilityDto;
import lk.travelmarket.search_engine.network.commons.CCResponse;
import lk.travelmarket.search_engine.network.commons.CCResponsePack;

public interface IMasterService {

    // DISTRICT

    CCResponsePack<DistrictDto> findAllDistricts();

    CCResponse<DistrictDto> findDistrict(Long id);

    CCResponse<DistrictDto> createDistrict(DistrictDto dto);

    CCResponse<DistrictDto> updateDistrict(Long id, DistrictDto dto);

    CCResponse<DistrictDto> deleteDistrict(Long id);


    // CITY

    CCResponsePack<CityDto> findAllCities();

    CCResponse<CityDto> findCity(Long id);

    CCResponse<CityDto> createCity(CityDto dto);

    CCResponse<CityDto> updateCity(Long id, CityDto dto);

    CCResponse<CityDto> deleteCity(Long id);


    // FACILITY CATEGORY

    CCResponsePack<FacilityCategoryDto> findAllFacilityCategories();

    CCResponse<FacilityCategoryDto> findFacilityCategory(Long id);

    CCResponse<FacilityCategoryDto> createFacilityCategory(
            FacilityCategoryDto dto);

    CCResponse<FacilityCategoryDto> updateFacilityCategory(
            Long id,
            FacilityCategoryDto dto);

    CCResponse<FacilityCategoryDto> deleteFacilityCategory(Long id);


    // FACILITY

    CCResponsePack<FacilityDto> findAllFacilities();

    CCResponse<FacilityDto> findFacility(Long id);

    CCResponse<FacilityDto> createFacility(FacilityDto dto);

    CCResponse<FacilityDto> updateFacility(
            Long id,
            FacilityDto dto);

    CCResponse<FacilityDto> deleteFacility(Long id);
}