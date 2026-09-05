package lk.travelmarket.search_engine.controller;

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
}