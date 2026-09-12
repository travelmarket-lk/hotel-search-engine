package lk.travelmarket.search_engine.controller;

import lk.travelmarket.search_engine.dto.BoardBasisDto;
import lk.travelmarket.search_engine.dto.hotel.HotelTypeDto;
import lk.travelmarket.search_engine.dto.facility.FacilityDto;
import lk.travelmarket.search_engine.dto.facility.FacilityCategoryDto;
import lk.travelmarket.search_engine.dao.HotelRoom.BedType;
import lk.travelmarket.search_engine.dto.CityDto;
import lk.travelmarket.search_engine.dto.DistrictDto;
import lk.travelmarket.search_engine.dto.RoomCategoryDto;
import lk.travelmarket.search_engine.network.CCResponseWrapper;
import lk.travelmarket.search_engine.network.util.NetworkUtils;
import lk.travelmarket.search_engine.service.master.IMasterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MasterDataController implements IMasterDataController {

    private final IMasterService masterService;

    public MasterDataController(IMasterService masterService) {
        this.masterService = masterService;
    }

    // DISTRICT

    @Override
    public ResponseEntity<CCResponseWrapper<DistrictDto>> createDistrict(
            DistrictDto request) {

        return NetworkUtils.wrap(
                masterService.createDistrict(request)
        );
    }

    @Override
    public ResponseEntity<CCResponseWrapper<DistrictDto>> getAllDistricts() {

        return NetworkUtils.wrap(
                masterService.findAllDistricts()
        );
    }

    @Override
    public ResponseEntity<CCResponseWrapper<DistrictDto>> getDistrictById(
            Long id) {

        return NetworkUtils.wrap(
                masterService.findDistrict(id)
        );
    }

    @Override
    public ResponseEntity<CCResponseWrapper<DistrictDto>> updateDistrict(
            Long id,
            DistrictDto request) {

        return NetworkUtils.wrap(
                masterService.updateDistrict(id, request)
        );
    }

    @Override
    public ResponseEntity<CCResponseWrapper<DistrictDto>> deleteDistrict(
            Long id) {

        return NetworkUtils.wrap(
                masterService.deleteDistrict(id)
        );
    }


    // CITY

    @Override
    public ResponseEntity<CCResponseWrapper<CityDto>> createCity(
            CityDto request) {

        return NetworkUtils.wrap(
                masterService.createCity(request)
        );
    }

    @Override
    public ResponseEntity<CCResponseWrapper<CityDto>> getAllCities() {

        return NetworkUtils.wrap(
                masterService.findAllCities()
        );
    }

    @Override
    public ResponseEntity<CCResponseWrapper<CityDto>> getCityById(
            Long id) {

        return NetworkUtils.wrap(
                masterService.findCity(id)
        );
    }

    @Override
    public ResponseEntity<CCResponseWrapper<CityDto>> updateCity(
            Long id,
            CityDto request) {

        return NetworkUtils.wrap(
                masterService.updateCity(id, request)
        );
    }

    @Override
    public ResponseEntity<CCResponseWrapper<CityDto>> deleteCity(
            Long id) {

        return NetworkUtils.wrap(
                masterService.deleteCity(id)
        );
    }

    // BED TYPES

    @Override
    public ResponseEntity<CCResponseWrapper<BedType>> getAllBedTypes() {
        return NetworkUtils.wrap(masterService.findAllBedTypes());
    }

    @Override
    public ResponseEntity<CCResponseWrapper<BedType>> addBedType(BedType bedType) {
        return NetworkUtils.wrap(masterService.addBedType(bedType));
    }

    @Override
    public ResponseEntity<CCResponseWrapper<Void>> deleteBedType(Long id) {
        return NetworkUtils.wrap(masterService.deleteBedType(id));
    }

    @Override
    public ResponseEntity<CCResponseWrapper<BedType>> getBedTypeById(Long id) {
        return NetworkUtils.wrap(masterService.findBedTypeById(id));
    }

    @Override
    public ResponseEntity<CCResponseWrapper<BedType>> updateBedType(Long id, BedType bedType) {
        return NetworkUtils.wrap(masterService.updateBedType(id, bedType));
    }

    // ROOMS

    @Override
    public ResponseEntity<CCResponseWrapper<RoomCategoryDto>> createRoomCategory(RoomCategoryDto request) {
        return NetworkUtils.wrap(masterService.createRoomCategory(request));
    }

    @Override
    public ResponseEntity<CCResponseWrapper<RoomCategoryDto>> findAllRoomCategories() {
        return NetworkUtils.wrap(masterService.findAllRoomCategories());
    }

    @Override
    public ResponseEntity<CCResponseWrapper<RoomCategoryDto>> findRoomCategoryById(Long id) {
        return NetworkUtils.wrap(masterService.findRoomCategoryById(id));
    }

    @Override
    public ResponseEntity<CCResponseWrapper<RoomCategoryDto>> updateRoomCategory(Long id, RoomCategoryDto request) {
        return NetworkUtils.wrap(masterService.updateRoomCategory(id, request));
    }

    @Override
    public ResponseEntity<CCResponseWrapper<RoomCategoryDto>> deleteRoomCategory(Long id) {
        return NetworkUtils.wrap(masterService.deleteRoomCategory(id));
    }

    // ---------------------------- HotelType ----------------------------
    @Override
    public ResponseEntity<CCResponseWrapper<HotelTypeDto>> findAllHotelTypes() {
        return NetworkUtils.wrap(masterService.findAllHotelTypes());
    }

    @Override
    public ResponseEntity<CCResponseWrapper<HotelTypeDto>> findHotelTypeById(Long id) {
        return NetworkUtils.wrap(masterService.findHotelTypeById( id ));
    }

    @Override
    public ResponseEntity<CCResponseWrapper<HotelTypeDto>> saveHotelType(HotelTypeDto hotelTypeDto) {
        return NetworkUtils.wrap(masterService.saveHotelType(hotelTypeDto));
    }

    @Override
    public ResponseEntity<CCResponseWrapper<HotelTypeDto>> updateHotelType(Long id, HotelTypeDto hotelTypeDto) {
        return NetworkUtils.wrap(masterService.updateHotelType(id, hotelTypeDto));
    }

    @Override
    public ResponseEntity<CCResponseWrapper<HotelTypeDto>> deleteHotelType(Long id) {
        return NetworkUtils.wrap(masterService.deleteHotelType(id));
    }

    // ---------------------------- Facility ----------------------------
    @Override
    public ResponseEntity<CCResponseWrapper<FacilityDto>> findAllFacilities() {
        return NetworkUtils.wrap(masterService.findAllFacilities());
    }

    @Override
    public ResponseEntity<CCResponseWrapper<FacilityDto>> findFacilityById(Long id) {
        return NetworkUtils.wrap(masterService.findFacilityById( id ));
    }

    @Override
    public ResponseEntity<CCResponseWrapper<FacilityDto>> saveFacility(FacilityDto facilityDto) {
        return NetworkUtils.wrap(masterService.saveFacility(facilityDto));
    }

    @Override
    public ResponseEntity<CCResponseWrapper<FacilityDto>> updateFacility(Long id, FacilityDto facilityDto) {
        return NetworkUtils.wrap(masterService.updateFacility(id, facilityDto));
    }

    @Override
    public ResponseEntity<CCResponseWrapper<FacilityDto>> deleteFacility(Long id) {
        return NetworkUtils.wrap(masterService.deleteFacility( id ));
    }

    // ------------------------- FacilityCategory -------------------------
    @Override
    public ResponseEntity<CCResponseWrapper<FacilityCategoryDto>> findAllFacilityCategories() {
        return NetworkUtils.wrap(masterService.findAllFacilityCategories());
    }

    @Override
    public ResponseEntity<CCResponseWrapper<FacilityCategoryDto>> findFacilityCategoryById(Long id) {
        return NetworkUtils.wrap(masterService.findFacilityCategoryById( id ));
    }

    @Override
    public ResponseEntity<CCResponseWrapper<FacilityCategoryDto>> saveFacilityCategory(FacilityCategoryDto facilityCategoryDto) {
        return NetworkUtils.wrap(masterService.saveFacilityCategory(facilityCategoryDto));
    }

    @Override
    public ResponseEntity<CCResponseWrapper<FacilityCategoryDto>> updateFacilityCategory(Long id, FacilityCategoryDto facilityCategoryDto) {
        return NetworkUtils.wrap(masterService.updateFacilityCategory(id, facilityCategoryDto));
    }

    @Override
    public ResponseEntity<CCResponseWrapper<FacilityCategoryDto>> deleteFacilityCategory(Long id) {
        return NetworkUtils.wrap(masterService.deleteFacilityCategory( id ));
    }

    @Override
    public ResponseEntity<CCResponseWrapper<BoardBasisDto>> createBoardBasis(BoardBasisDto request) {
        return NetworkUtils.wrap(masterService.createBoardBasis(request));
    }

    @Override
    public ResponseEntity<CCResponseWrapper<BoardBasisDto>> findAllBoardBasis() {
        return NetworkUtils.wrap(masterService.findAllBoardBasis());
    }

    @Override
    public ResponseEntity<CCResponseWrapper<BoardBasisDto>> findBoardBasisById(Long id) {
        return NetworkUtils.wrap(masterService.findBoardBasisById(id));
    }

    @Override
    public ResponseEntity<CCResponseWrapper<BoardBasisDto>> updateBoardBasis(Long id, BoardBasisDto request) {
        return NetworkUtils.wrap(masterService.updateBoardBasis(id,request));
    }

    @Override
    public ResponseEntity<CCResponseWrapper<BoardBasisDto>> deleteBoardBasis(Long id) {
        return NetworkUtils.wrap(masterService.deleteBoardBasis(id));
    }

    // FACILITY CATEGORY

    @Override
    public ResponseEntity<CCResponseWrapper<FacilityCategoryDto>> createFacilityCategory(
            FacilityCategoryDto request) {

        return NetworkUtils.wrap(
                masterService.createFacilityCategory(request)
        );
    }

    @Override
    public ResponseEntity<CCResponseWrapper<FacilityCategoryDto>> getAllFacilityCategories() {

        return NetworkUtils.wrap(
                masterService.findAllFacilityCategories()
        );
    }

    @Override
    public ResponseEntity<CCResponseWrapper<FacilityCategoryDto>> getFacilityCategoryById(
            Long id) {

        return NetworkUtils.wrap(
                masterService.findFacilityCategory(id)
        );
    }

    @Override
    public ResponseEntity<CCResponseWrapper<FacilityCategoryDto>> updateFacilityCategory(
            Long id,
            FacilityCategoryDto request) {

        return NetworkUtils.wrap(
                masterService.updateFacilityCategory(id, request)
        );
    }

    @Override
    public ResponseEntity<CCResponseWrapper<FacilityCategoryDto>> deleteFacilityCategory(
            Long id) {

        return NetworkUtils.wrap(
                masterService.deleteFacilityCategory(id)
        );
    }


    // FACILITY

    @Override
    public ResponseEntity<CCResponseWrapper<FacilityDto>> createFacility(
            FacilityDto request) {

        return NetworkUtils.wrap(
                masterService.createFacility(request)
        );
    }

    @Override
    public ResponseEntity<CCResponseWrapper<FacilityDto>> getAllFacilities() {

        return NetworkUtils.wrap(
                masterService.findAllFacilities()
        );
    }

    @Override
    public ResponseEntity<CCResponseWrapper<FacilityDto>> getFacilityById(
            Long id) {

        return NetworkUtils.wrap(
                masterService.findFacility(id)
        );
    }

    @Override
    public ResponseEntity<CCResponseWrapper<FacilityDto>> updateFacility(
            Long id,
            FacilityDto request) {

        return NetworkUtils.wrap(
                masterService.updateFacility(id, request)
        );
    }

    @Override
    public ResponseEntity<CCResponseWrapper<FacilityDto>> deleteFacility(
            Long id) {

        return NetworkUtils.wrap(
                masterService.deleteFacility(id)
        );
    }
}