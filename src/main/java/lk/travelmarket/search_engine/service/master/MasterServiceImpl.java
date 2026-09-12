package lk.travelmarket.search_engine.service.master;

import jakarta.transaction.Transactional;
import lk.travelmarket.search_engine.dao.City;
import lk.travelmarket.search_engine.dao.District;
import lk.travelmarket.search_engine.dto.FacilityCategoryDto;
import lk.travelmarket.search_engine.repository.CityRepository;
import lk.travelmarket.search_engine.repository.DistrictRepository;
import lk.travelmarket.search_engine.dto.CityDto;
import lk.travelmarket.search_engine.dto.DistrictDto;
import lk.travelmarket.search_engine.network.commons.CCError;
import lk.travelmarket.search_engine.network.commons.CCErrorStatus;
import org.springframework.stereotype.Component;
import lk.travelmarket.search_engine.dao.facilities.Facility;
import lk.travelmarket.search_engine.dao.facilities.FacilityCategory;
import lk.travelmarket.search_engine.dto.FacilityDto;
import lk.travelmarket.search_engine.Repository.FacilityRepository;
import lk.travelmarket.search_engine.Repository.FacilityCategoryRepository;


import java.util.List;
import java.util.Optional;

import static lk.travelmarket.search_engine.util.Constants.*;

@Component
@Transactional
public class MasterServiceImpl {

    private final DistrictRepository districtRepository;
    private final CityRepository cityRepository;
    private final FacilityRepository facilityRepository;
    private final FacilityCategoryRepository facilityCategoryRepository;

    public MasterServiceImpl(
            DistrictRepository districtRepository,
            CityRepository cityRepository,
            FacilityRepository facilityRepository,
            FacilityCategoryRepository facilityCategoryRepository) {

        this.districtRepository = districtRepository;
        this.cityRepository = cityRepository;
        this.facilityRepository = facilityRepository;
        this.facilityCategoryRepository = facilityCategoryRepository;
    }


    // DISTRICT

    public CCError<List<DistrictDto>> findAllDistricts() {

        CCError<List<DistrictDto>> ccError =
                new CCError<>(
                        CCErrorStatus.SUCCESS,
                        SUCCESS_RETRIEVE_DISTRICTS
                );

        List<DistrictDto> districtData =
                districtRepository.findAll()
                        .stream()
                        .map(this::toDistrictDto)
                        .toList();

        ccError.setData(districtData);

        return ccError;
    }

    public CCError<DistrictDto> findDistrict(Long id) {

        CCError<DistrictDto> ccError =
                new CCError<>(
                        CCErrorStatus.SUCCESS,
                        SUCCESS_RETRIEVE_DISTRICT
                );

        Optional<District> dao =
                districtRepository.findById(id);

        if (dao.isEmpty()) {

            ccError.setStatus(CCErrorStatus.ERROR);
            ccError.setMessage(ERROR_RETRIEVE_DISTRICT_NOT_FOUND);

            return ccError;
        }

        DistrictDto districtData =
                this.toDistrictDto(dao.get());

        ccError.setData(districtData);

        return ccError;
    }

    public CCError<DistrictDto> createDistrict(
            DistrictDto dto) {

        CCError<DistrictDto> ccError =
                new CCError<>(
                        CCErrorStatus.SUCCESS,
                        SUCCESS_CREATE_DISTRICT
                );

        District dao = new District();

        dao.setName(dto.getName());

        District savedDistrict =
                districtRepository.save(dao);

        DistrictDto districtData =
                this.toDistrictDto(savedDistrict);

        ccError.setData(districtData);

        return ccError;
    }

    public CCError<DistrictDto> updateDistrict(
            Long id,
            DistrictDto dto) {

        CCError<DistrictDto> ccError =
                new CCError<>(
                        CCErrorStatus.SUCCESS,
                        SUCCESS_UPDATE_DISTRICT
                );

        Optional<District> dao =
                districtRepository.findById(id);

        if (dao.isEmpty()) {

            ccError.setStatus(CCErrorStatus.ERROR);
            ccError.setMessage(ERROR_RETRIEVE_DISTRICT_NOT_FOUND);

            return ccError;
        }

        dao.get().setName(dto.getName());

        districtRepository.save(dao.get());

        DistrictDto districtData =
                this.toDistrictDto(dao.get());

        ccError.setData(districtData);

        return ccError;
    }

    public CCError<DistrictDto> deleteDistrict(Long id) {

        CCError<DistrictDto> ccError =
                new CCError<>(
                        CCErrorStatus.SUCCESS,
                        SUCCESS_DELETE_DISTRICT
                );

        Optional<District> dao =
                districtRepository.findById(id);

        if (dao.isEmpty()) {

            ccError.setStatus(CCErrorStatus.ERROR);
            ccError.setMessage(ERROR_RETRIEVE_DISTRICT_NOT_FOUND);

            return ccError;
        }

        districtRepository.delete(dao.get());

        DistrictDto districtData =
                this.toDistrictDto(dao.get());

        ccError.setData(districtData);

        return ccError;
    }


    // CITY

    public CCError<List<CityDto>> findAllCities() {

        CCError<List<CityDto>> ccError =
                new CCError<>(
                        CCErrorStatus.SUCCESS,
                        SUCCESS_RETRIEVE_CITIES
                );

        List<CityDto> cityData =
                cityRepository.findAll()
                        .stream()
                        .map(this::toCityDto)
                        .toList();

        ccError.setData(cityData);

        return ccError;
    }

    public CCError<CityDto> findCity(Long id) {

        CCError<CityDto> ccError =
                new CCError<>(
                        CCErrorStatus.SUCCESS,
                        SUCCESS_RETRIEVE_CITY
                );

        Optional<City> dao =
                cityRepository.findById(id);

        if (dao.isEmpty()) {

            ccError.setStatus(CCErrorStatus.ERROR);
            ccError.setMessage(ERROR_RETRIEVE_CITY_NOT_FOUND);

            return ccError;
        }

        CityDto cityData =
                this.toCityDto(dao.get());

        ccError.setData(cityData);

        return ccError;
    }

    public CCError<CityDto> createCity(
            CityDto dto) {

        CCError<CityDto> ccError =
                new CCError<>(
                        CCErrorStatus.SUCCESS,
                        SUCCESS_CREATE_CITY
                );

        City dao = new City();

        dao.setName(dto.getName());

        City savedCity =
                cityRepository.save(dao);

        CityDto cityData =
                this.toCityDto(savedCity);

        ccError.setData(cityData);

        return ccError;
    }

    public CCError<CityDto> updateCity(
            Long id,
            CityDto dto) {

        CCError<CityDto> ccError =
                new CCError<>(
                        CCErrorStatus.SUCCESS,
                        SUCCESS_UPDATE_CITY
                );

        Optional<City> dao =
                cityRepository.findById(id);

        if (dao.isEmpty()) {

            ccError.setStatus(CCErrorStatus.ERROR);
            ccError.setMessage(ERROR_RETRIEVE_CITY_NOT_FOUND);

            return ccError;
        }

        dao.get().setName(dto.getName());

        cityRepository.save(dao.get());

        CityDto cityData =
                this.toCityDto(dao.get());

        ccError.setData(cityData);

        return ccError;
    }

    public CCError<CityDto> deleteCity(Long id) {

        CCError<CityDto> ccError =
                new CCError<>(
                        CCErrorStatus.SUCCESS,
                        SUCCESS_DELETE_CITY
                );

        Optional<City> dao =
                cityRepository.findById(id);

        if (dao.isEmpty()) {

            ccError.setStatus(CCErrorStatus.ERROR);
            ccError.setMessage(ERROR_RETRIEVE_CITY_NOT_FOUND);

            return ccError;
        }

        cityRepository.delete(dao.get());

        CityDto cityData =
                this.toCityDto(dao.get());

        ccError.setData(cityData);

        return ccError;
    }
    // FACILITY CATEGORY

    public CCError<List<FacilityCategoryDto>> findAllFacilityCategories() {

        CCError<List<FacilityCategoryDto>> ccError =
                new CCError<>(
                        CCErrorStatus.SUCCESS,
                        SUCCESS_RETRIEVE_FACILITY_CATEGORIES
                );

        List<FacilityCategoryDto> facilityCategoryData =
                facilityCategoryRepository.findAll()
                        .stream()
                        .map(this::toFacilityCategoryDto)
                        .toList();

        ccError.setData(facilityCategoryData);

        return ccError;
    }

    public CCError<FacilityCategoryDto> findFacilityCategory(Long id) {

        CCError<FacilityCategoryDto> ccError =
                new CCError<>(
                        CCErrorStatus.SUCCESS,
                        SUCCESS_RETRIEVE_FACILITY_CATEGORY
                );

        Optional<FacilityCategory> dao =
                facilityCategoryRepository.findById(id);

        if (dao.isEmpty()) {

            ccError.setStatus(CCErrorStatus.ERROR);
            ccError.setMessage(ERROR_RETRIEVE_FACILITY_CATEGORY_NOT_FOUND);

            return ccError;
        }

        FacilityCategoryDto facilityCategoryData =
                this.toFacilityCategoryDto(dao.get());

        ccError.setData(facilityCategoryData);

        return ccError;
    }

    public CCError<FacilityCategoryDto> createFacilityCategory(
            FacilityCategoryDto dto) {

        CCError<FacilityCategoryDto> ccError =
                new CCError<>(
                        CCErrorStatus.SUCCESS,
                        SUCCESS_CREATE_FACILITY_CATEGORY
                );

        FacilityCategory dao = new FacilityCategory();

        dao.setName(dto.getFacilityCategory());

        FacilityCategory savedFacilityCategory =
                facilityCategoryRepository.save(dao);

        FacilityCategoryDto facilityCategoryData =
                this.toFacilityCategoryDto(savedFacilityCategory);

        ccError.setData(facilityCategoryData);

        return ccError;
    }

    public CCError<FacilityCategoryDto> updateFacilityCategory(
            Long id,
            FacilityCategoryDto dto) {

        CCError<FacilityCategoryDto> ccError =
                new CCError<>(
                        CCErrorStatus.SUCCESS,
                        SUCCESS_UPDATE_FACILITY_CATEGORY
                );

        Optional<FacilityCategory> dao =
                facilityCategoryRepository.findById(id);

        if (dao.isEmpty()) {

            ccError.setStatus(CCErrorStatus.ERROR);
            ccError.setMessage(ERROR_RETRIEVE_FACILITY_CATEGORY_NOT_FOUND);

            return ccError;
        }

        dao.get().setName(dto.getFacilityCategory());

        facilityCategoryRepository.save(dao.get());

        FacilityCategoryDto facilityCategoryData =
                this.toFacilityCategoryDto(dao.get());

        ccError.setData(facilityCategoryData);

        return ccError;
    }

    public CCError<FacilityCategoryDto> deleteFacilityCategory(Long id) {

        CCError<FacilityCategoryDto> ccError =
                new CCError<>(
                        CCErrorStatus.SUCCESS,
                        SUCCESS_DELETE_FACILITY_CATEGORY
                );

        Optional<FacilityCategory> dao =
                facilityCategoryRepository.findById(id);

        if (dao.isEmpty()) {

            ccError.setStatus(CCErrorStatus.ERROR);
            ccError.setMessage(ERROR_RETRIEVE_FACILITY_CATEGORY_NOT_FOUND);

            return ccError;
        }

        facilityCategoryRepository.delete(dao.get());

        FacilityCategoryDto facilityCategoryData =
                this.toFacilityCategoryDto(dao.get());

        ccError.setData(facilityCategoryData);

        return ccError;
    }
    // FACILITY

    public CCError<List<FacilityDto>> findAllFacilities() {

        CCError<List<FacilityDto>> ccError =
                new CCError<>(
                        CCErrorStatus.SUCCESS,
                        SUCCESS_RETRIEVE_FACILITIES
                );

        List<FacilityDto> facilityData =
                facilityRepository.findAll()
                        .stream()
                        .map(this::toFacilityDto)
                        .toList();

        ccError.setData(facilityData);

        return ccError;
    }

    public CCError<FacilityDto> findFacility(Long id) {

        CCError<FacilityDto> ccError =
                new CCError<>(
                        CCErrorStatus.SUCCESS,
                        SUCCESS_RETRIEVE_FACILITY
                );

        Optional<Facility> dao =
                facilityRepository.findById(id);

        if (dao.isEmpty()) {

            ccError.setStatus(CCErrorStatus.ERROR);
            ccError.setMessage(ERROR_RETRIEVE_FACILITY_NOT_FOUND);

            return ccError;
        }

        FacilityDto facilityData =
                this.toFacilityDto(dao.get());

        ccError.setData(facilityData);

        return ccError;
    }

    public CCError<FacilityDto> createFacility(
            FacilityDto dto) {

        CCError<FacilityDto> ccError =
                new CCError<>(
                        CCErrorStatus.SUCCESS,
                        SUCCESS_CREATE_FACILITY
                );

        Optional<FacilityCategory> category =
                facilityCategoryRepository.findById(
                        dto.getFacilityCategoryId()
                );

        if (category.isEmpty()) {

            ccError.setStatus(CCErrorStatus.ERROR);
            ccError.setMessage(
                    ERROR_RETRIEVE_FACILITY_CATEGORY_NOT_FOUND
            );

            return ccError;
        }

        Facility dao = new Facility();

        dao.setFacilityName(dto.getFacilityName());
        dao.setFacilityCategory(category.get());
        dao.setFacilityIcon(dto.getFacilityIcon());

        Facility savedFacility =
                facilityRepository.save(dao);

        FacilityDto facilityData =
                this.toFacilityDto(savedFacility);

        ccError.setData(facilityData);

        return ccError;
    }

    public CCError<FacilityDto> updateFacility(
            Long id,
            FacilityDto dto) {

        CCError<FacilityDto> ccError =
                new CCError<>(
                        CCErrorStatus.SUCCESS,
                        SUCCESS_UPDATE_FACILITY
                );

        Optional<Facility> dao =
                facilityRepository.findById(id);

        if (dao.isEmpty()) {

            ccError.setStatus(CCErrorStatus.ERROR);
            ccError.setMessage(ERROR_RETRIEVE_FACILITY_NOT_FOUND);

            return ccError;
        }

        Optional<FacilityCategory> category =
                facilityCategoryRepository.findById(
                        dto.getFacilityCategoryId()
                );

        if (category.isEmpty()) {

            ccError.setStatus(CCErrorStatus.ERROR);
            ccError.setMessage(
                    ERROR_RETRIEVE_FACILITY_CATEGORY_NOT_FOUND
            );

            return ccError;
        }

        dao.get().setFacilityName(dto.getFacilityName());
        dao.get().setFacilityCategory(category.get());
        dao.get().setFacilityIcon(dto.getFacilityIcon());

        facilityRepository.save(dao.get());

        FacilityDto facilityData =
                this.toFacilityDto(dao.get());

        ccError.setData(facilityData);

        return ccError;
    }

    public CCError<FacilityDto> deleteFacility(Long id) {

        CCError<FacilityDto> ccError =
                new CCError<>(
                        CCErrorStatus.SUCCESS,
                        SUCCESS_DELETE_FACILITY
                );

        Optional<Facility> dao =
                facilityRepository.findById(id);

        if (dao.isEmpty()) {

            ccError.setStatus(CCErrorStatus.ERROR);
            ccError.setMessage(ERROR_RETRIEVE_FACILITY_NOT_FOUND);

            return ccError;
        }

        facilityRepository.delete(dao.get());

        FacilityDto facilityData =
                this.toFacilityDto(dao.get());

        ccError.setData(facilityData);

        return ccError;
    }


    // ==================== MAPPERS ====================

    private DistrictDto toDistrictDto(District district) {

        return new DistrictDto(
                district.getId(),
                district.getName()
        );
    }

    private CityDto toCityDto(City city) {

        return new CityDto(
                city.getId(),
                city.getName()
        );
    }

    private FacilityCategoryDto toFacilityCategoryDto(
            FacilityCategory facilityCategory) {

        return new FacilityCategoryDto(
                facilityCategory.getId(),
                facilityCategory.getName()
        );
    }

    private FacilityDto toFacilityDto(Facility facility) {

        return new FacilityDto(
                facility.getId(),
                facility.getFacilityName(),
                facility.getFacilityCategory().getId(),
                facility.getFacilityIcon()
        );
    }
}