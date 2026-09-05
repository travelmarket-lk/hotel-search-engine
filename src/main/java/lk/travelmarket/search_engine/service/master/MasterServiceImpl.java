package lk.travelmarket.search_engine.service.master;

import jakarta.transaction.Transactional;
import lk.travelmarket.search_engine.dao.HotelRoom.BedType;
import lk.travelmarket.search_engine.dao.City;
import lk.travelmarket.search_engine.dao.District;
import lk.travelmarket.search_engine.repository.BedTypeRepository;
import lk.travelmarket.search_engine.repository.CityRepository;
import lk.travelmarket.search_engine.repository.DistrictRepository;
import lk.travelmarket.search_engine.dto.CityDto;
import lk.travelmarket.search_engine.dto.DistrictDto;
import lk.travelmarket.search_engine.network.commons.CCError;
import lk.travelmarket.search_engine.network.commons.CCErrorStatus;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

import static lk.travelmarket.search_engine.util.Constants.*;

@Component
@Transactional
public class MasterServiceImpl {

    private final DistrictRepository districtRepository;
    private final CityRepository cityRepository;
    private final BedTypeRepository bedTypeRepository;

    public MasterServiceImpl(
            DistrictRepository districtRepository,
            CityRepository cityRepository) {

        this.districtRepository = districtRepository;
        this.cityRepository = cityRepository;
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

    // BED TYPES
    public CCError<List<BedType>> findAllBedTypes() {
        CCError<List<BedType>> ccError = new CCError<>(CCErrorStatus.SUCCESS, SUCCESS_RETRIEVE_BED_TYPES);
        List<BedType> bedTypes = this.bedTypeRepository.findAll();
        ccError.setData(bedTypes);
        return ccError;
    }

    public CCError<BedType> addBedType(BedType bedType) {
        CCError<BedType> ccError = new CCError<>(CCErrorStatus.SUCCESS, SUCCESS_ADD_BED_TYPES);
        BedType savedBedType = this.bedTypeRepository.save(bedType);
        ccError.setData(savedBedType);
        return ccError;
    }


    public CCError<Void> deleteBedType(Long id) {
        if (!this.bedTypeRepository.existsById(id)) {
            return new CCError<>(CCErrorStatus.ERROR, ERROR_BED_ID_NOT_FOUND + id);
        }
        this.bedTypeRepository.deleteById(id);
        return new CCError<>(CCErrorStatus.SUCCESS, SUCCESS_DELETE_BED_TYPES);
    }

    public CCError<BedType> findBedTypeById(Long id) {
        Optional<BedType> optionalBedType = this.bedTypeRepository.findById(id);
        if (optionalBedType.isEmpty()) {
            return new CCError<>(CCErrorStatus.ERROR, ERROR_RETRIEVE_BED_TYPES + id);
        }
        CCError<BedType> ccError = new CCError<>(CCErrorStatus.SUCCESS, SUCCESS_RETRIEVE_BED_TYPES);
        ccError.setData(optionalBedType.get());
        return ccError;
    }

    public CCError<BedType> updateBedType(Long id, BedType bedType) {
        if (!this.bedTypeRepository.existsById(id)) {
            return new CCError<>(CCErrorStatus.ERROR, ERROR_BED_ID_NOT_FOUND + id);
        }
        bedType.setId(id);
        BedType updatedBedType = this.bedTypeRepository.save(bedType);
        return new CCError<>(CCErrorStatus.SUCCESS, SUCCESS_UPDATE_BED_TYPES);
    }
}