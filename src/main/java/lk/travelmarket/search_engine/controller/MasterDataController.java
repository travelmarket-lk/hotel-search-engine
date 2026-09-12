package lk.travelmarket.search_engine.controller;

import lk.travelmarket.search_engine.dto.CityDto;
import lk.travelmarket.search_engine.dto.DistrictDto;
import lk.travelmarket.search_engine.dto.FacilityCategoryDto;
import lk.travelmarket.search_engine.dto.FacilityDto;
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