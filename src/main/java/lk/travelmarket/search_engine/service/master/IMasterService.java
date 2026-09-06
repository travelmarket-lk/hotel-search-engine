package lk.travelmarket.search_engine.service.master;

import lk.travelmarket.search_engine.dao.HotelRoom.BedType;
import lk.travelmarket.search_engine.dto.CityDto;
import lk.travelmarket.search_engine.dto.DistrictDto;
import lk.travelmarket.search_engine.dto.RoomCategoryDto;
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

    // BED TYPES

    CCResponsePack<BedType> findAllBedTypes();

    CCResponse<BedType> addBedType(BedType bedType);

    CCResponse<Void> deleteBedType(Long id);

    CCResponse<BedType> findBedTypeById(Long id);

    CCResponse<BedType> updateBedType(Long id, BedType bedType);

    CCResponsePack<RoomCategoryDto> findAllRoomCategories();

    // ROOM

    CCResponse <RoomCategoryDto>createRoomCategory(RoomCategoryDto request);

    CCResponse <RoomCategoryDto>findRoomCategoryById(Long id);

    CCResponse <RoomCategoryDto>updateRoomCategory(Long id, RoomCategoryDto request);

    CCResponse <RoomCategoryDto>deleteRoomCategory(Long id);
}