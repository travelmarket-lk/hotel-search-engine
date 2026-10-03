package lk.travelmarket.search_engine.service.master;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lk.travelmarket.search_engine.dao.BoardBasis;
import lk.travelmarket.search_engine.dao.HotelRoom.BedType;
import lk.travelmarket.search_engine.dao.City;
import lk.travelmarket.search_engine.dao.District;
import lk.travelmarket.search_engine.dao.HotelRoom.RoomContent;
import lk.travelmarket.search_engine.dao.HotelRoom.RoomType;
import lk.travelmarket.search_engine.dao.RoomCategory;
import lk.travelmarket.search_engine.dao.hotel.HotelType;
import lk.travelmarket.search_engine.dao.landmark.LandMarkCategory;
import lk.travelmarket.search_engine.dto.*;
import lk.travelmarket.search_engine.dto.facility.FacilityCategoryDto;
import lk.travelmarket.search_engine.dto.facility.FacilityDto;
import lk.travelmarket.search_engine.dto.hotel.HotelTypeDto;
import lk.travelmarket.search_engine.dto.landmark.LandMarkCategoryDto;
import lk.travelmarket.search_engine.repository.*;
import lk.travelmarket.search_engine.network.commons.CCError;
import lk.travelmarket.search_engine.network.commons.CCErrorStatus;
import lk.travelmarket.search_engine.repository.hotel.HotelTypeRepository;
import lk.travelmarket.search_engine.dao.facility.Facility;
import lk.travelmarket.search_engine.repository.facility.FacilityRepository;
import lk.travelmarket.search_engine.dao.facility.FacilityCategory;
import lk.travelmarket.search_engine.repository.facility.FacilityCategoryRepository;
import lk.travelmarket.search_engine.repository.landmark.LandMarkCategoryRepository;
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
    private final RoomCategoryRepository categoryRepository;
    private final HotelTypeRepository hotelTypeRepository;
    private final FacilityRepository facilityRepository;
    private final FacilityCategoryRepository facilityCategoryRepository;
    private final LandMarkCategoryRepository landMarkCategoryRepository;
    private final BoardBasisRepository boardBasisRepository;
    private final RoomTypeRepository roomTypeRepository;

    public MasterServiceImpl(
            BedTypeRepository bedTypeRepository,
            RoomCategoryRepository categoryRepository,
            DistrictRepository districtRepository,
            CityRepository cityRepository,
            HotelTypeRepository hotelTypeRepository,
            FacilityRepository facilityRepository,
            FacilityCategoryRepository facilityCategoryRepository,
            LandMarkCategoryRepository landMarkCategoryRepository
    ) {

        this.districtRepository = districtRepository;
        this.cityRepository = cityRepository;
        this.categoryRepository = categoryRepository;
        this.bedTypeRepository = bedTypeRepository;
        this.hotelTypeRepository = hotelTypeRepository;
        this.facilityRepository = facilityRepository;
        this.facilityCategoryRepository = facilityCategoryRepository;
        this.landMarkCategoryRepository = landMarkCategoryRepository;
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

        String name = dto.getName().trim();

        if (districtRepository.existsByNameIgnoreCase(name)) {

            ccError.setStatus(CCErrorStatus.ERROR);
            ccError.setMessage("District already exists");

            return ccError;
        }

        District dao = new District();
        dao.setName(name);

        District savedDistrict = districtRepository.save(dao);

        ccError.setData(toDistrictDto(savedDistrict));

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

        String name = dto.getName().trim();

        if (districtRepository.existsByNameIgnoreCaseAndIdNot(name, id)) {

            ccError.setStatus(CCErrorStatus.ERROR);
            ccError.setMessage("District already exists");

            return ccError;
        }

        District district = dao.get();
        district.setName(name);

        District savedDistrict = districtRepository.save(district);

        ccError.setData(toDistrictDto(savedDistrict));

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

        String name = dto.getName().trim();

        if (cityRepository.existsByNameIgnoreCase(name)) {

            ccError.setStatus(CCErrorStatus.ERROR);
            ccError.setMessage("City already exists");

            return ccError;
        }

        City dao = new City();
        dao.setName(name);

        City savedCity = cityRepository.save(dao);

        ccError.setData(toCityDto(savedCity));

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

        String name = dto.getName().trim();

        if (cityRepository.existsByNameIgnoreCaseAndIdNot(name, id)) {

            ccError.setStatus(CCErrorStatus.ERROR);
            ccError.setMessage("City already exists");

            return ccError;
        }

        City city = dao.get();
        city.setName(name);

        City savedCity = cityRepository.save(city);

        ccError.setData(toCityDto(savedCity));

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

        CCError<BedType> ccError = new CCError<>(CCErrorStatus.SUCCESS, SUCCESS_UPDATE_BED_TYPES);
        ccError.setData(updatedBedType);
        return ccError;
    }

    // ROOMS

    public CCError<List<RoomCategoryDto>> findAllRoomCategories() {
        CCError<List<RoomCategoryDto>> ccError = new CCError<>(CCErrorStatus.SUCCESS, SUCCESS_RETRIEVE_ROOM_CATEGORIES);
        List<RoomCategoryDto> roomCategoryData = this.categoryRepository.findAll().stream()
                .map(this::toRoomCategoryDto)
                .toList();
        ccError.setData(roomCategoryData);
        return ccError;
    }

    private RoomCategoryDto toRoomCategoryDto(RoomCategory roomCategory) {
        return new RoomCategoryDto(roomCategory.getId(), roomCategory.getName());
    }

    public CCError<RoomCategoryDto> findRoomCategoryById( Long id ) {
        CCError<RoomCategoryDto> ccError = new CCError<>(CCErrorStatus.SUCCESS, SUCCESS_RETRIEVE_ROOM_CATEGORIES);

        Optional<RoomCategory> dao = this.categoryRepository.findById( id );

        if( dao.isEmpty() )
        {
            ccError.setStatus( CCErrorStatus.ERROR );
            ccError.setMessage( ERROR_RETRIEVE_ROOM_CATEGORIES_NOT_FOUND );
            return ccError;
        }

        RoomCategoryDto roomCategoryDto = this.toRoomCategoryDto( dao.get() );
        ccError.setData(roomCategoryDto);
        return ccError;
    }

    public CCError<RoomCategoryDto> createRoomCategory(RoomCategoryDto dto) {
        CCError<RoomCategoryDto> ccError = new CCError<>(CCErrorStatus.SUCCESS, SUCCESS_CREATE_ROOM_CATEGORY);

        if (dto.getName() == null || dto.getName().isBlank()) {
            ccError.setStatus(CCErrorStatus.ERROR);
            ccError.setMessage("Room category name cannot be blank");
            return ccError;
        }
        if (dto.getName().length() < 2 || dto.getName().length() > 50) {
            ccError.setStatus(CCErrorStatus.ERROR);
            ccError.setMessage("Room category name must be between 2 and 50 characters");
            return ccError;
        }
        if (categoryRepository.findByName(dto.getName()).isPresent()) {
            ccError.setStatus(CCErrorStatus.ERROR);
            ccError.setMessage("Room category with this name already exists");
            return ccError;
        }

        RoomCategory dao = new RoomCategory();
        dao.setName(dto.getName());

        RoomCategory savedRoomCategory = categoryRepository.save(dao);
        ccError.setData(toRoomCategoryDto(savedRoomCategory));
        return ccError;
    }

    public CCError<RoomCategoryDto> updateRoomCategory(Long id, RoomCategoryDto dto) {
        CCError<RoomCategoryDto> ccError = new CCError<>(CCErrorStatus.SUCCESS, SUCCESS_UPDATE_ROOM_CATEGORY);

        Optional<RoomCategory> dao = this.categoryRepository.findById(id);

        if (dao.isEmpty()) {
            ccError.setStatus(CCErrorStatus.ERROR);
            ccError.setMessage(ERROR_RETRIEVE_ROOM_CATEGORIES_NOT_FOUND);
            return ccError;
        }

        if (dto.getName() == null || dto.getName().isBlank()) {
            ccError.setStatus(CCErrorStatus.ERROR);
            ccError.setMessage("Room category name cannot be blank");
            return ccError;
        }
        if (dto.getName().length() < 2 || dto.getName().length() > 50) {
            ccError.setStatus(CCErrorStatus.ERROR);
            ccError.setMessage("Room category name must be between 2 and 50 characters");
            return ccError;
        }
        if (categoryRepository.findByName(dto.getName())
                .filter(existing -> !existing.getId().equals(id))
                .isPresent()) {
            ccError.setStatus(CCErrorStatus.ERROR);
            ccError.setMessage("Another room category with this name already exists");
            return ccError;
        }

        RoomCategory existing = dao.get();
        existing.setName(dto.getName());

        RoomCategory updated = categoryRepository.save(existing);
        ccError.setData(toRoomCategoryDto(updated));
        return ccError;
    }

    public CCError<RoomCategoryDto> deleteRoomCategory( Long id ) {
        CCError<RoomCategoryDto> ccError = new CCError<>(CCErrorStatus.SUCCESS, SUCCESS_DELETE_ROOM_CATEGORY);

        Optional<RoomCategory> dao = this.categoryRepository.findById( id );

        if( dao.isEmpty() )
        {
            ccError.setStatus( CCErrorStatus.ERROR );
            ccError.setMessage( ERROR_RETRIEVE_ROOM_CATEGORIES_NOT_FOUND );
            return ccError;
        }

        this.categoryRepository.delete( dao.get() );

        RoomCategoryDto roomCategoryDto = this.toRoomCategoryDto( dao.get() );
        ccError.setData(roomCategoryDto);
        return ccError;
    }

    // ---------------------------- HotelType ----------------------------



    public CCError<List<HotelTypeDto>> findAllHotelTypes() {

        CCError<List<HotelTypeDto>> ccError = new CCError<>(CCErrorStatus.SUCCESS, SUCCESS_RETRIEVE_HOTEL_TYPES);

        List<HotelTypeDto> data = new java.util.ArrayList<>();

        this.hotelTypeRepository.findAll().forEach(hotelType -> {
            data.add(toDto(hotelType));
        });

        ccError.setData(data);
        return ccError;
    }

    public CCError<HotelTypeDto> findHotelTypeById(Long id) {

        Optional<HotelType> hotelTypeOpt = this.hotelTypeRepository.findById(id);

        if (hotelTypeOpt.isEmpty()) {
            return new CCError<>(CCErrorStatus.ERROR, ERROR_HOTEL_TYPE_NOT_FOUND);
        }

        CCError<HotelTypeDto> ccError = new CCError<>(CCErrorStatus.SUCCESS, SUCCESS_RETRIEVE_HOTEL_TYPE);
        ccError.setData(toDto(hotelTypeOpt.get()));
        return ccError;
    }

    public CCError<HotelTypeDto> saveHotelType(HotelTypeDto hotelTypeDto) {

        if (hotelTypeRepository.existsByHotelType(
                hotelTypeDto.getHotelType())) {

            return new CCError<>(
                    CCErrorStatus.ERROR,
                    "Hotel type already exists"
            );
        }
        HotelType hotelType = toEntity(hotelTypeDto);
        HotelType saved = this.hotelTypeRepository.save(hotelType);

        CCError<HotelTypeDto> ccError = new CCError<>(CCErrorStatus.SUCCESS, SUCCESS_SAVE_HOTEL_TYPE);
        ccError.setData(toDto(saved));
        return ccError;
    }

    public CCError<HotelTypeDto> updateHotelType(Long id, HotelTypeDto hotelTypeDto) {

        Optional<HotelType> hotelTypeOpt = this.hotelTypeRepository.findById(id);

        if (hotelTypeRepository.existsByCategoryAndIdNot(
                hotelTypeDto.getHotelType(),
                id)) {

            return new CCError<>(
                    CCErrorStatus.ERROR,
                    DUPLICATE_HOTEL_TYPE
            );
        }

        if (hotelTypeOpt.isEmpty()) {
            return new CCError<>(CCErrorStatus.ERROR, ERROR_HOTEL_TYPE_NOT_FOUND);
        }

        HotelType hotelType = hotelTypeOpt.get();
        hotelType.setHotelType(hotelTypeDto.getHotelType());

        HotelType updated = this.hotelTypeRepository.save(hotelType);

        CCError<HotelTypeDto> ccError = new CCError<>(CCErrorStatus.SUCCESS, SUCCESS_UPDATE_HOTEL_TYPE);
        ccError.setData(toDto(updated));
        return ccError;
    }

    public CCError<HotelTypeDto> deleteHotelType(Long id) {

        Optional<HotelType> hotelTypeOpt = this.hotelTypeRepository.findById(id);

        if (hotelTypeOpt.isEmpty()) {
            return new CCError<>(CCErrorStatus.ERROR, ERROR_HOTEL_TYPE_NOT_FOUND);
        }

        this.hotelTypeRepository.deleteById(id);

        CCError<HotelTypeDto> ccError = new CCError<>(CCErrorStatus.SUCCESS, SUCCESS_DELETE_HOTEL_TYPE);
        ccError.setData(toDto(hotelTypeOpt.get()));
        return ccError;
    }

    // ---------------------------- Facility ----------------------------
    public CCError<List<FacilityDto>> findAllFacilities() {

        CCError<List<FacilityDto>> ccError = new CCError<>(CCErrorStatus.SUCCESS, SUCCESS_RETRIEVE_FACILITIES);

        List<FacilityDto> data = this.facilityRepository.findAll()
                .stream()
                .map(this::toDto)
                .toList();

        ccError.setData(data);
        return ccError;
    }

    public CCError<FacilityDto> findFacilityById(Long id) {

        Optional<Facility> facilityOpt = this.facilityRepository.findById(id);

        if (facilityOpt.isEmpty()) {
            return new CCError<>(CCErrorStatus.ERROR, ERROR_FACILITY_NOT_FOUND);
        }

        CCError<FacilityDto> ccError = new CCError<>(CCErrorStatus.SUCCESS, SUCCESS_RETRIEVE_FACILITY);
        ccError.setData(toDto(facilityOpt.get()));
        return ccError;
    }

    public CCError<FacilityDto> saveFacility(FacilityDto facilityDto) {

        if (facilityRepository.existsByFacility(
                facilityDto.getFacilityName())) {

            return new CCError<>(
                    CCErrorStatus.ERROR,
                    DUPLICATE_FACILITY
            );
        }

        Facility facility = toEntity(facilityDto);
        Facility saved = this.facilityRepository.save(facility);

        CCError<FacilityDto> ccError = new CCError<>(CCErrorStatus.SUCCESS, SUCCESS_SAVE_FACILITY);
        ccError.setData(toDto(saved));
        return ccError;
    }

    public CCError<FacilityDto> updateFacility(Long id, FacilityDto facilityDto) {

        Optional<Facility> facilityOpt = this.facilityRepository.findById(id);
        Optional<FacilityCategory> facilityCategory = this.facilityCategoryRepository.findById( facilityDto.getCategory().getId() );


        if (facilityRepository.existsByFacilityAndIdNot(
                facilityDto.getFacilityName(),
                id)) {

            return new CCError<>(
                    CCErrorStatus.ERROR,
                    DUPLICATE_FACILITY
            );
        }

        if (facilityOpt.isEmpty()) {
            return new CCError<>(CCErrorStatus.ERROR, ERROR_FACILITY_NOT_FOUND);
        }




        Facility facility = facilityOpt.get();
        facility.setTitle(facilityDto.getTitle());
        facility.setCategory( facilityCategory.get() );
        facility.setIcon(facilityDto.getIcon());

        Facility updated = this.facilityRepository.save(facility);

        CCError<FacilityDto> ccError = new CCError<>(CCErrorStatus.SUCCESS, SUCCESS_UPDATE_FACILITY);
        ccError.setData(toDto(updated));
        return ccError;
    }

    public CCError<FacilityDto> deleteFacility(Long id) {

        Optional<Facility> facilityOpt = this.facilityRepository.findById(id);

        if (facilityOpt.isEmpty()) {
            return new CCError<>(CCErrorStatus.ERROR, ERROR_FACILITY_NOT_FOUND);
        }

        this.facilityRepository.deleteById(id);

        CCError<FacilityDto> ccError = new CCError<>(CCErrorStatus.SUCCESS, SUCCESS_DELETE_FACILITY);
        ccError.setData(toDto(facilityOpt.get()));
        return ccError;
    }

    // ------------------------- FacilityCategory -------------------------
    public CCError<List<FacilityCategoryDto>> findAllFacilityCategories() {

        CCError<List<FacilityCategoryDto>> ccError = new CCError<>(CCErrorStatus.SUCCESS, SUCCESS_RETRIEVE_FACILITY_CATEGORIES);

        List<FacilityCategoryDto> data = new java.util.ArrayList<>();

        this.facilityCategoryRepository.findAll().forEach(category -> {
            data.add(toDto(category));
        });
        ccError.setData(data);
        return ccError;
    }

    public CCError<FacilityCategoryDto> findFacilityCategoryById(Long id) {

        Optional<FacilityCategory> categoryOpt = this.facilityCategoryRepository.findById(id);

        if (categoryOpt.isEmpty()) {
            return new CCError<>(CCErrorStatus.ERROR, ERROR_FACILITY_CATEGORY_NOT_FOUND);
        }

        CCError<FacilityCategoryDto> ccError = new CCError<>(CCErrorStatus.SUCCESS, SUCCESS_RETRIEVE_FACILITY_CATEGORY);
        ccError.setData(toDto(categoryOpt.get()));
        return ccError;
    }

    public CCError<FacilityCategoryDto> saveFacilityCategory(FacilityCategoryDto facilityCategoryDto) {

        if (facilityCategoryRepository.existsByFacilityCategory(
                facilityCategoryDto.getFacilityCategory())) {

            return new CCError<>(
                    CCErrorStatus.ERROR,
                   DUPLICATE_FACILITY_CATEGORY
            );
        }

        FacilityCategory category = toEntity(facilityCategoryDto);
        FacilityCategory saved = this.facilityCategoryRepository.save(category);

        CCError<FacilityCategoryDto> ccError = new CCError<>(CCErrorStatus.SUCCESS, SUCCESS_SAVE_FACILITY_CATEGORY);
        ccError.setData(toDto(saved));
        return ccError;
    }

    public CCError<FacilityCategoryDto> updateFacilityCategory(Long id, FacilityCategoryDto facilityCategoryDto) {

        Optional<FacilityCategory> categoryOpt = this.facilityCategoryRepository.findById(id);

        if (categoryOpt.isEmpty()) {
            return new CCError<>(CCErrorStatus.ERROR, ERROR_FACILITY_CATEGORY_NOT_FOUND);
        }

        if (facilityCategoryRepository.existsByCategoryAndIdNot(
                facilityCategoryDto.getFacilityCategory(),
                id)) {

            return new CCError<>(
                    CCErrorStatus.ERROR,
                    DUPLICATE_FACILITY_CATEGORY
            );
        }

        FacilityCategory category = categoryOpt.get();
        category.setName(facilityCategoryDto.getName());

        FacilityCategory updated = this.facilityCategoryRepository.save(category);

        CCError<FacilityCategoryDto> ccError = new CCError<>(CCErrorStatus.SUCCESS, SUCCESS_UPDATE_FACILITY_CATEGORY);
        ccError.setData(toDto(updated));
        return ccError;
    }

    public CCError<FacilityCategoryDto> deleteFacilityCategory(Long id) {

        Optional<FacilityCategory> categoryOpt = this.facilityCategoryRepository.findById(id);

        if (categoryOpt.isEmpty()) {
            return new CCError<>(CCErrorStatus.ERROR, ERROR_FACILITY_CATEGORY_NOT_FOUND);
        }

        this.facilityCategoryRepository.deleteById(id);

        CCError<FacilityCategoryDto> ccError = new CCError<>(CCErrorStatus.SUCCESS, SUCCESS_DELETE_FACILITY_CATEGORY);
        ccError.setData(toDto(categoryOpt.get()));
        return ccError;
    }

    // --------------------------- LandMark Category ---------------------------


    public CCError<List<LandMarkCategoryDto>> findAllLandmarkCategories() {

        CCError<List<LandMarkCategoryDto>> ccError =
                new CCError<>(
                        CCErrorStatus.SUCCESS,
                        SUCCESS_RETRIEVE_LANDMARK_CATEGORIES
                );

        List<LandMarkCategoryDto> landmarkData =
                landMarkCategoryRepository.findAll()
                        .stream()
                        .map(this::toDto)
                        .toList();

        ccError.setData(landmarkData);

        return ccError;
    }

    public CCError<LandMarkCategoryDto> findLandmarkCategoryById(Long id) {

        CCError<LandMarkCategoryDto> ccError =
                new CCError<>(
                        CCErrorStatus.SUCCESS,
                        SUCCESS_RETRIEVE_LANDMARK_CATEGORY
                );

        Optional<LandMarkCategory> dao =
                landMarkCategoryRepository.findById(id);

        if (dao.isEmpty()) {

            ccError.setStatus(CCErrorStatus.ERROR);
            ccError.setMessage(ERROR_LANDMARK_CATEGORY_NOT_FOUND);

            return ccError;
        }

        ccError.setData(this.toDto(dao.get()));

        return ccError;
    }

    public CCError<LandMarkCategoryDto> createLandmarkCategory(LandMarkCategoryDto landMarkCategoryDto) {

        CCError<LandMarkCategoryDto> ccError =
                new CCError<>(
                        CCErrorStatus.SUCCESS,
                        SUCCESS_CREATE_LANDMARK_CATEGORY
                );

        if (landMarkCategoryRepository.findByCategory(
                landMarkCategoryDto.getCategory()
        )) {
            ccError.setStatus(CCErrorStatus.ERROR);

            ccError.setMessage(DUPLICATE_CREATE_LANDMARK_CATEGORY);
            return ccError;
        }

        LandMarkCategory dao = new LandMarkCategory();

        dao.setCategory(landMarkCategoryDto.getCategory());

        LandMarkCategory saved = this.landMarkCategoryRepository.save(dao);

        ccError.setData(this.toDto(saved));

        return ccError;
    }

    public CCError<LandMarkCategoryDto> deleteLandmarkCategory(Long id) {
        CCError<LandMarkCategoryDto> ccError =
                new CCError<>(
                        CCErrorStatus.SUCCESS,
                        SUCCESS_DELETE_LANDMARK_CATEGORY
                );

        Optional<LandMarkCategory> dao =
                landMarkCategoryRepository.findById(id);

        if (dao.isEmpty()) {
            ccError.setStatus(CCErrorStatus.ERROR);
            ccError.setMessage(ERROR_LANDMARK_CATEGORY_NOT_FOUND);
            return ccError;
        }

        landMarkCategoryRepository.delete(dao.get());

        ccError.setData(this.toDto(dao.get()));

        return ccError;
    }

    public CCError<LandMarkCategoryDto> updateLandmarkCategory(Long id, LandMarkCategoryDto landMarkCategoryDto) {
        CCError<LandMarkCategoryDto> ccError =
                new CCError<>(
                        CCErrorStatus.SUCCESS,
                        SUCCESS_UPDATE_LANDMARK_CATEGORY
                );

        Optional<LandMarkCategory> dao =
                landMarkCategoryRepository.findById(id);

        if (dao.isEmpty()) {
            ccError.setStatus(CCErrorStatus.ERROR);
            ccError.setMessage(ERROR_LANDMARK_CATEGORY_NOT_FOUND);
            return ccError;
        }

        if (landMarkCategoryRepository.existsByCategoryAndIdNot(
                landMarkCategoryDto.getCategory()

        ))



        dao.get().setCategory(landMarkCategoryDto.getCategory());

        landMarkCategoryRepository.save(dao.get());

        ccError.setData(this.toDto(dao.get()));

        return ccError;
    }






    private HotelTypeDto toDto(HotelType hotelType) {
        HotelTypeDto dto = new HotelTypeDto();
        dto.setId(hotelType.getId());
        dto.setHotelType(hotelType.getHotelType());
        return dto;
    }

    private HotelType toEntity(HotelTypeDto dto) {
        HotelType hotelType = new HotelType();
        hotelType.setId(dto.getId());
        hotelType.setHotelType(dto.getHotelType());
        return hotelType;
    }

    private FacilityDto toDto(Facility facility) {
        FacilityDto dto = new FacilityDto();
        dto.setId(facility.getId());
        dto.setTitle(facility.getTitle());
        dto.setCategory( toDto( facility.getCategory() ));
        dto.setIcon(facility.getIcon());
        return dto;
    }

    private Facility toEntity(FacilityDto dto) {
        Facility facility = new Facility();
        facility.setId(dto.getId());
        facility.setTitle(dto.getTitle());
        facility.setCategory( toEntity( dto.getCategory() ));
        facility.setIcon(dto.getIcon());
        return facility;
    }

    private FacilityCategoryDto toDto(FacilityCategory category) {
        FacilityCategoryDto dto = new FacilityCategoryDto();
        dto.setId(category.getId());
        dto.setName(category.getName());
        return dto;
    }

    private FacilityCategory toEntity(FacilityCategoryDto dto) {
        FacilityCategory category = new FacilityCategory();
        category.setId(dto.getId());
        category.setName(dto.getName());
        return category;
    }

    private LandMarkCategoryDto toDto(LandMarkCategory category) {
        LandMarkCategoryDto dto = new LandMarkCategoryDto();
        dto.setId(category.getId());
        dto.setCategory(category.getCategory());
        return dto;
    }

    private LandMarkCategory toDao(LandMarkCategoryDto dto) {
        LandMarkCategory category = new LandMarkCategory();
        category.setId(dto.getId());
        category.setCategory(dto.getCategory());
        return category;
    }





}