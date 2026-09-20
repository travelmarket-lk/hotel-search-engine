package lk.travelmarket.search_engine.service.master;

import lk.travelmarket.search_engine.dao.HotelRoom.BedType;
import lk.travelmarket.search_engine.dto.*;
import lk.travelmarket.search_engine.dto.hotel.HotelTypeDto;
import lk.travelmarket.search_engine.dto.facility.FacilityDto;
import lk.travelmarket.search_engine.dto.facility.FacilityCategoryDto;
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

    CCResponsePack<HotelTypeDto> findAllHotelTypes();

    CCResponse<HotelTypeDto> findHotelTypeById(Long id);

    CCResponse<HotelTypeDto> saveHotelType(HotelTypeDto hotelTypeDto);

    CCResponse<HotelTypeDto> updateHotelType(Long id, HotelTypeDto hotelTypeDto);

    CCResponse<HotelTypeDto> deleteHotelType(Long id);

    // ---------------------------- Facility ----------------------------


    CCResponsePack<FacilityDto> findAllFacilities();

    CCResponse<FacilityDto> findFacilityById(Long id);

    CCResponse<FacilityDto> saveFacility(FacilityDto facilityDto);

    CCResponse<FacilityDto> updateFacility(Long id, FacilityDto facilityDto);

    CCResponse<FacilityDto> deleteFacility(Long id);

    // ------------------------- FacilityCategory -------------------------


    CCResponsePack<FacilityCategoryDto> findAllFacilityCategories();

    CCResponse<FacilityCategoryDto> findFacilityCategoryById(Long id);

    CCResponse<FacilityCategoryDto> saveFacilityCategory(FacilityCategoryDto facilityCategoryDto);

    CCResponse<FacilityCategoryDto> updateFacilityCategory(Long id, FacilityCategoryDto facilityCategoryDto);

    CCResponse<FacilityCategoryDto> deleteFacilityCategory(Long id);

    CCResponse<BoardBasisDto> createBoardBasis(BoardBasisDto boardBasisDto);

    CCResponsePack<BoardBasisDto> findAllBoardBasis();

    CCResponse<BoardBasisDto> findBoardBasisById(Long id);

    CCResponse<BoardBasisDto> updateBoardBasis(Long id, BoardBasisDto boardBasisDto);

    CCResponse<BoardBasisDto> deleteBoardBasis(Long id);


    CCResponse<RoomTypeDto> createRoomType(RoomTypeDto roomTypeDto);

    CCResponsePack<RoomTypeDto> findAllRoomType();

    CCResponse<RoomTypeDto> findRoomTypeById(Long id);

    CCResponse<RoomTypeDto> updateRoomType(Long id, RoomTypeDto roomTypeDto);

    CCResponse<RoomTypeDto> deleteRoomType(Long id);
}