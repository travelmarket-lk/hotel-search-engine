package lk.travelmarket.search_engine.service.master;

import lk.travelmarket.search_engine.dao.HotelRoom.BedType;
import lk.travelmarket.search_engine.dto.CityDto;
import lk.travelmarket.search_engine.dto.DistrictDto;
import lk.travelmarket.search_engine.dto.BoardBasisDto;
import lk.travelmarket.search_engine.dto.RoomCategoryDto;
import lk.travelmarket.search_engine.dto.hotel.HotelTypeDto;
import lk.travelmarket.search_engine.dto.facility.FacilityDto;
import lk.travelmarket.search_engine.dto.facility.FacilityCategoryDto;
import lk.travelmarket.search_engine.network.commons.CCError;
import lk.travelmarket.search_engine.network.commons.CCErrorStatus;
import lk.travelmarket.search_engine.network.commons.CCResponse;
import lk.travelmarket.search_engine.network.commons.CCResponsePack;
import lk.travelmarket.search_engine.network.error.code.ErrorLayer;
import lk.travelmarket.search_engine.network.error.code.ErrorSource;
import lk.travelmarket.search_engine.network.error.code.Status;
import org.springframework.stereotype.Service;

import java.util.List;

import static lk.travelmarket.search_engine.util.Constants.*;

@Service
public class MasterService implements IMasterService {

    private final MasterServiceImpl masterServiceImpl;

    public MasterService(MasterServiceImpl masterServiceImpl) {
        this.masterServiceImpl = masterServiceImpl;
    }

    // DISTRICT

    @Override
    public CCResponsePack<DistrictDto> findAllDistricts() {

        try {

            CCError<List<DistrictDto>> ccError =
                    masterServiceImpl.findAllDistricts();

            if (ccError.getStatus().equals(CCErrorStatus.ERROR)) {

                return new CCResponsePack<>(
                        Status.ERROR,
                        ccError.getMessage(),
                        null
                );
            }

            return new CCResponsePack<>(ccError.getData());

        } catch (Exception e) {

            return new CCResponsePack<>(
                    ErrorLayer.HSL_LAYER,
                    ErrorSource.SERVER_ERROR,
                    ERROR_RETRIEVE_DISTRICTS,
                    e
            );
        }
    }

    @Override
    public CCResponse<DistrictDto> findDistrict(Long id) {

        try {

            CCError<DistrictDto> ccError =
                    masterServiceImpl.findDistrict(id);

            if (ccError.getStatus().equals(CCErrorStatus.ERROR)) {

                return new CCResponse<>(
                        Status.ERROR,
                        ccError.getMessage(),
                        null
                );
            }

            return new CCResponse<>(ccError.getData());

        } catch (Exception e) {

            return new CCResponse<>(
                    ErrorLayer.HSL_LAYER,
                    ErrorSource.SERVER_ERROR,
                    ERROR_RETRIEVE_DISTRICT,
                    e
            );
        }
    }

    @Override
    public CCResponse<DistrictDto> createDistrict(DistrictDto dto) {

        try {

            CCError<DistrictDto> ccError =
                    masterServiceImpl.createDistrict(dto);

            if (ccError.getStatus().equals(CCErrorStatus.ERROR)) {

                return new CCResponse<>(
                        Status.ERROR,
                        ccError.getMessage(),
                        null
                );
            }

            return new CCResponse<>(ccError.getData());

        } catch (Exception e) {

            return new CCResponse<>(
                    ErrorLayer.HSL_LAYER,
                    ErrorSource.SERVER_ERROR,
                    ERROR_CREATE_DISTRICT,
                    e
            );
        }
    }

    @Override
    public CCResponse<DistrictDto> updateDistrict(
            Long id,
            DistrictDto dto) {

        try {

            CCError<DistrictDto> ccError =
                    masterServiceImpl.updateDistrict(id, dto);

            if (ccError.getStatus().equals(CCErrorStatus.ERROR)) {

                return new CCResponse<>(
                        Status.ERROR,
                        ccError.getMessage(),
                        null
                );
            }

            return new CCResponse<>(ccError.getData());

        } catch (Exception e) {

            return new CCResponse<>(
                    ErrorLayer.HSL_LAYER,
                    ErrorSource.SERVER_ERROR,
                    ERROR_UPDATE_DISTRICT,
                    e
            );
        }
    }

    @Override
    public CCResponse<DistrictDto> deleteDistrict(Long id) {

        try {

            CCError<DistrictDto> ccError =
                    masterServiceImpl.deleteDistrict(id);

            if (ccError.getStatus().equals(CCErrorStatus.ERROR)) {

                return new CCResponse<>(
                        Status.ERROR,
                        ccError.getMessage(),
                        null
                );
            }

            return new CCResponse<>(ccError.getData());

        } catch (Exception e) {

            return new CCResponse<>(
                    ErrorLayer.HSL_LAYER,
                    ErrorSource.SERVER_ERROR,
                    ERROR_DELETE_DISTRICT,
                    e
            );
        }
    }


    // CITY

    @Override
    public CCResponsePack<CityDto> findAllCities() {

        try {

            CCError<List<CityDto>> ccError =
                    masterServiceImpl.findAllCities();

            if (ccError.getStatus().equals(CCErrorStatus.ERROR)) {

                return new CCResponsePack<>(
                        Status.ERROR,
                        ccError.getMessage(),
                        null
                );
            }

            return new CCResponsePack<>(ccError.getData());

        } catch (Exception e) {

            return new CCResponsePack<>(
                    ErrorLayer.HSL_LAYER,
                    ErrorSource.SERVER_ERROR,
                    ERROR_RETRIEVE_CITIES,
                    e
            );
        }
    }

    @Override
    public CCResponse<CityDto> findCity(Long id) {

        try {

            CCError<CityDto> ccError =
                    masterServiceImpl.findCity(id);

            if (ccError.getStatus().equals(CCErrorStatus.ERROR)) {

                return new CCResponse<>(
                        Status.ERROR,
                        ccError.getMessage(),
                        null
                );
            }

            return new CCResponse<>(ccError.getData());

        } catch (Exception e) {

            return new CCResponse<>(
                    ErrorLayer.HSL_LAYER,
                    ErrorSource.SERVER_ERROR,
                    ERROR_RETRIEVE_CITY,
                    e
            );
        }
    }

    @Override
    public CCResponse<CityDto> createCity(CityDto dto) {

        try {

            CCError<CityDto> ccError =
                    masterServiceImpl.createCity(dto);

            if (ccError.getStatus().equals(CCErrorStatus.ERROR)) {

                return new CCResponse<>(
                        Status.ERROR,
                        ccError.getMessage(),
                        null
                );
            }

            return new CCResponse<>(ccError.getData());

        } catch (Exception e) {

            return new CCResponse<>(
                    ErrorLayer.HSL_LAYER,
                    ErrorSource.SERVER_ERROR,
                    ERROR_CREATE_CITY,
                    e
            );
        }
    }

    @Override
    public CCResponse<CityDto> updateCity(
            Long id,
            CityDto dto) {

        try {

            CCError<CityDto> ccError =
                    masterServiceImpl.updateCity(id, dto);

            if (ccError.getStatus().equals(CCErrorStatus.ERROR)) {

                return new CCResponse<>(
                        Status.ERROR,
                        ccError.getMessage(),
                        null
                );
            }

            return new CCResponse<>(ccError.getData());

        } catch (Exception e) {

            return new CCResponse<>(
                    ErrorLayer.HSL_LAYER,
                    ErrorSource.SERVER_ERROR,
                    ERROR_UPDATE_CITY,
                    e
            );
        }
    }

    @Override
    public CCResponse<CityDto> deleteCity(Long id) {

        try {

            CCError<CityDto> ccError =
                    masterServiceImpl.deleteCity(id);

            if (ccError.getStatus().equals(CCErrorStatus.ERROR)) {

                return new CCResponse<>(
                        Status.ERROR,
                        ccError.getMessage(),
                        null
                );
            }

            return new CCResponse<>(ccError.getData());

        } catch (Exception e) {

            return new CCResponse<>(
                    ErrorLayer.HSL_LAYER,
                    ErrorSource.SERVER_ERROR,
                    ERROR_DELETE_CITY,
                    e
            );
        }
    }

    // BED TYPES

    @Override
    public CCResponsePack<BedType> findAllBedTypes() {
        try {
            CCError<List<BedType>> ccError = masterServiceImpl.findAllBedTypes();
            if (ccError.getStatus().equals(CCErrorStatus.ERROR)) {
                return new CCResponsePack<>(Status.ERROR, ccError.getMessage(), null);
            }
            return new CCResponsePack<>(ccError.getData());
        } catch (Exception e) {
            return new CCResponsePack<>(ErrorLayer.HSL_LAYER, ErrorSource.SERVER_ERROR, ERROR_RETRIEVE_BED_TYPES, e);
        }
    }

    @Override
    public CCResponse<BedType> addBedType(BedType bedType) {
        try {
            CCError<BedType> ccError = masterServiceImpl.addBedType(bedType);
            if (ccError.getStatus().equals(CCErrorStatus.ERROR)) {
                return new CCResponse<>(Status.ERROR, ccError.getMessage(), null);
            }
            return new CCResponse<>(ccError.getData());
        } catch (Exception e) {
            return new CCResponse<>(ErrorLayer.HSL_LAYER, ErrorSource.SERVER_ERROR, ERROR_ADD_BED_TYPE, e);
        }
    }

    @Override
    public CCResponse<Void> deleteBedType(Long id) {
        try {
            CCError<Void> ccError = masterServiceImpl.deleteBedType(id);
            if (ccError.getStatus().equals(CCErrorStatus.ERROR)) {
                return new CCResponse<>(Status.ERROR, ccError.getMessage(), null);
            }
            return new CCResponse<>(null);
        } catch (Exception e) {
            return new CCResponse<>(ErrorLayer.HSL_LAYER, ErrorSource.SERVER_ERROR, ERROR_DELETE_BED_TYPE, e);
        }
    }

    @Override
    public CCResponse<BedType> findBedTypeById(Long id) {
        try {
            CCError<BedType> ccError = masterServiceImpl.findBedTypeById(id);
            if (ccError.getStatus().equals(CCErrorStatus.ERROR)) {
                return new CCResponse<>(Status.ERROR, ccError.getMessage(), null);
            }
            return new CCResponse<>(ccError.getData());
        } catch (Exception e) {
            return new CCResponse<>(ErrorLayer.HSL_LAYER, ErrorSource.SERVER_ERROR, ERROR_RETRIEVE_BED_TYPES, e);
        }
    }

    @Override
    public CCResponse<BedType> updateBedType(Long id, BedType bedType) {
        try {
            CCError<BedType> ccError = masterServiceImpl.updateBedType(id, bedType);
            if (ccError.getStatus().equals(CCErrorStatus.ERROR)) {
                return new CCResponse<>(Status.ERROR, ccError.getMessage(), null);
            }
            return new CCResponse<>(ccError.getData());
        } catch (Exception e) {
            return new CCResponse<>(ErrorLayer.HSL_LAYER, ErrorSource.SERVER_ERROR, ERROR_UPDATE_BED_TYPE, e);
        }
    }


    @Override
    public CCResponse<RoomCategoryDto> createRoomCategory(RoomCategoryDto dto) {
        try {
            CCError<RoomCategoryDto> ccError = masterServiceImpl.createRoomCategory(dto);
            if (ccError.getStatus().equals(CCErrorStatus.ERROR)) {
                return new CCResponse<>(Status.ERROR, ccError.getMessage(), null);
            }
            return new CCResponse<>(ccError.getData());
        } catch (Exception e) {
            return new CCResponse<>(ErrorLayer.HSL_LAYER, ErrorSource.SERVER_ERROR, ERROR_CREATE_ROOM_CATEGORY, e);
        }
    }

    @Override
    public CCResponsePack<RoomCategoryDto> findAllRoomCategories() {
        try {
            CCError<List<RoomCategoryDto>> ccError = masterServiceImpl.findAllRoomCategories();
            if (ccError.getStatus().equals(CCErrorStatus.ERROR)) {
                return new CCResponsePack<>(Status.ERROR, ccError.getMessage(), null);
            }
            return new CCResponsePack<>(ccError.getData());
        } catch (Exception e) {
            return new CCResponsePack<>(ErrorLayer.HSL_LAYER, ErrorSource.SERVER_ERROR, ERROR_RETRIEVE_ROOM_CATEGORIES, e);
        }
    }

    @Override
    public CCResponse<RoomCategoryDto> findRoomCategoryById(Long id) {
        try {
            CCError<RoomCategoryDto> ccError = masterServiceImpl.findRoomCategoryById(id);
            if (ccError.getStatus().equals(CCErrorStatus.ERROR)) {
                return new CCResponse<>(Status.ERROR, ccError.getMessage(), null);
            }
            return new CCResponse<>(ccError.getData());
        } catch (Exception e) {
            return new CCResponse<>(ErrorLayer.HSL_LAYER, ErrorSource.SERVER_ERROR, ERROR_RETRIEVE_ROOM_CATEGORIES, e);
        }
    }

    @Override
    public CCResponse<RoomCategoryDto> updateRoomCategory(Long id, RoomCategoryDto roomCategoryDto) {
        try {
            CCError<RoomCategoryDto> ccError = masterServiceImpl.updateRoomCategory(id, roomCategoryDto);
            if (ccError.getStatus().equals(CCErrorStatus.ERROR)) {
                return new CCResponse<>(Status.ERROR, ccError.getMessage(), null);
            }
            return new CCResponse<>(ccError.getData());
        } catch (Exception e) {
            return new CCResponse<>(ErrorLayer.HSL_LAYER, ErrorSource.SERVER_ERROR, ERROR_UPDATE_ROOM_CATEGORY, e);
        }
    }

    @Override
    public CCResponse<RoomCategoryDto> deleteRoomCategory(Long id) {
        try {
            CCError<RoomCategoryDto> ccError = masterServiceImpl.deleteRoomCategory(id);
            if (ccError.getStatus().equals(CCErrorStatus.ERROR)) {
                return new CCResponse<>(Status.ERROR, ccError.getMessage(), null);
            }
            return new CCResponse<>(ccError.getData());
        } catch (Exception e) {
            return new CCResponse<>(ErrorLayer.HSL_LAYER, ErrorSource.SERVER_ERROR, ERROR_DELETE_ROOM_CATEGORY, e);
        }
    }

    @Override
    public CCResponse<BoardBasisDto> createBoardBasis(BoardBasisDto boardBasisDto) {
        try {
            CCError<BoardBasisDto> ccError = masterServiceImpl.createBoardBasis(boardBasisDto);
            if (ccError.getStatus().equals(CCErrorStatus.ERROR)) {
                return new CCResponse<>(Status.ERROR, ccError.getMessage(), null);
            }
            return new CCResponse<>(ccError.getData());
        } catch (Exception e) {
            return new CCResponse<>(ErrorLayer.HSL_LAYER, ErrorSource.SERVER_ERROR, ERROR_CREATE_BOARD_BASIS, e);
        }
    }

    @Override
    public CCResponsePack<BoardBasisDto> findAllBoardBasis() {
        try {
            CCError<List<BoardBasisDto>> ccError = masterServiceImpl.findAllBoardBasis();
            if (ccError.getStatus().equals(CCErrorStatus.ERROR)) {
                return new CCResponsePack<>(Status.ERROR, ccError.getMessage(), null);
            }
            return new CCResponsePack<>(ccError.getData());
        } catch (Exception e) {
            return new CCResponsePack<>(ErrorLayer.HSL_LAYER, ErrorSource.SERVER_ERROR, ERROR_RETRIEVE_BOARD_BASIS, e);
        }
    }

    @Override
    public CCResponse<BoardBasisDto> findBoardBasisById(Long id) {
        try {
            CCError<BoardBasisDto> ccError = masterServiceImpl.findBoardBasisById(id);
            if (ccError.getStatus().equals(CCErrorStatus.ERROR)) {
                return new CCResponse<>(Status.ERROR, ccError.getMessage(), null);
            }
            return new CCResponse<>(ccError.getData());
        } catch (Exception e) {
            return new CCResponse<>(ErrorLayer.HSL_LAYER, ErrorSource.SERVER_ERROR, ERROR_RETRIEVE_BOARD_BASIS, e);
        }
    }

    @Override
    public CCResponse<BoardBasisDto> updateBoardBasis(Long id, BoardBasisDto boardBasisDto) {
        try {
            CCError<BoardBasisDto> ccError = masterServiceImpl.updateBoardBasis(id, boardBasisDto);
            if (ccError.getStatus().equals(CCErrorStatus.ERROR)) {
                return new CCResponse<>(Status.ERROR, ccError.getMessage(), null);
            }
            return new CCResponse<>(ccError.getData());
        } catch (Exception e) {
            return new CCResponse<>(ErrorLayer.HSL_LAYER, ErrorSource.SERVER_ERROR, ERROR_UPDATE_BOARD_BASIS, e);
        }
    }

    @Override
    public CCResponse<BoardBasisDto> deleteBoardBasis(Long id) {
        try {
            CCError<BoardBasisDto> ccError = masterServiceImpl.deleteBoardBasis(id);
            if (ccError.getStatus().equals(CCErrorStatus.ERROR)) {
                return new CCResponse<>(Status.ERROR, ccError.getMessage(), null);
            }
            return new CCResponse<>(ccError.getData());
        } catch (Exception e) {
            return new CCResponse<>(ErrorLayer.HSL_LAYER, ErrorSource.SERVER_ERROR, ERROR_DELETE_BOARD_BASIS, e);
        }
    }

    // ---------------------------- HotelType ----------------------------
    @Override
    public CCResponsePack<HotelTypeDto> findAllHotelTypes() {
        try {
            CCError<List<HotelTypeDto>> ccError = masterServiceImpl.findAllHotelTypes();

            if (ccError.getStatus().equals(CCErrorStatus.ERROR)) {
                return new CCResponsePack<>(Status.ERROR, ccError.getMessage(), null);
            }
            return new CCResponsePack<>(ccError.getData());

        } catch (Exception e) {
            return new CCResponsePack<>(ErrorLayer.HSL_LAYER, ErrorSource.SERVER_ERROR, ERROR_RETRIEVE_HOTEL_TYPES, e);
        }
    }

    @Override
    public CCResponse<HotelTypeDto> findHotelTypeById(Long id) {
        try {
            CCError<HotelTypeDto> ccError = masterServiceImpl.findHotelTypeById(id);

            if (ccError.getStatus().equals(CCErrorStatus.ERROR)) {
                return new CCResponse<>(Status.ERROR, ccError.getMessage(), null);
            }
            return new CCResponse<>(ccError.getData());

        } catch (Exception e) {
            return new CCResponse<>(ErrorLayer.HSL_LAYER, ErrorSource.SERVER_ERROR, ERROR_RETRIEVE_HOTEL_TYPE, e);
        }
    }

    @Override
    public CCResponse<HotelTypeDto> saveHotelType(HotelTypeDto hotelTypeDto) {
        try {
            CCError<HotelTypeDto> ccError = masterServiceImpl.saveHotelType(hotelTypeDto);

            if (ccError.getStatus().equals(CCErrorStatus.ERROR)) {
                return new CCResponse<>(Status.ERROR, ccError.getMessage(), null);
            }
            return new CCResponse<>(ccError.getData());

        } catch (Exception e) {
            return new CCResponse<>(ErrorLayer.HSL_LAYER, ErrorSource.SERVER_ERROR, ERROR_SAVE_HOTEL_TYPE, e);
        }
    }

    @Override
    public CCResponse<HotelTypeDto> updateHotelType(Long id, HotelTypeDto hotelTypeDto) {
        try {
            CCError<HotelTypeDto> ccError = masterServiceImpl.updateHotelType(id, hotelTypeDto);

            if (ccError.getStatus().equals(CCErrorStatus.ERROR)) {
                return new CCResponse<>(Status.ERROR, ccError.getMessage(), null);
            }
            return new CCResponse<>(ccError.getData());

        } catch (Exception e) {
            return new CCResponse<>(ErrorLayer.HSL_LAYER, ErrorSource.SERVER_ERROR, ERROR_UPDATE_HOTEL_TYPE, e);
        }
    }

    @Override
    public CCResponse<HotelTypeDto> deleteHotelType(Long id) {
        try {
            CCError<HotelTypeDto> ccError = masterServiceImpl.deleteHotelType(id);

            if (ccError.getStatus().equals(CCErrorStatus.ERROR)) {
                return new CCResponse<>(Status.ERROR, ccError.getMessage(), null);
            }
            return new CCResponse<>(ccError.getData());

        } catch (Exception e) {
            return new CCResponse<>(ErrorLayer.HSL_LAYER, ErrorSource.SERVER_ERROR, ERROR_DELETE_HOTEL_TYPE, e);
        }
    }

    // ---------------------------- Facility ----------------------------
    @Override
    public CCResponsePack<FacilityDto> findAllFacilities() {
        try {
            CCError<List<FacilityDto>> ccError = masterServiceImpl.findAllFacilities();

            if (ccError.getStatus().equals(CCErrorStatus.ERROR)) {
                return new CCResponsePack<>(Status.ERROR, ccError.getMessage(), null);
            }
            return new CCResponsePack<>(ccError.getData());

        } catch (Exception e) {
            return new CCResponsePack<>(ErrorLayer.HSL_LAYER, ErrorSource.SERVER_ERROR, ERROR_RETRIEVE_FACILITIES, e);
        }
    }

    @Override
    public CCResponse<FacilityDto> findFacilityById(Long id) {
        try {
            CCError<FacilityDto> ccError = masterServiceImpl.findFacilityById(id);

            if (ccError.getStatus().equals(CCErrorStatus.ERROR)) {
                return new CCResponse<>(Status.ERROR, ccError.getMessage(), null);
            }
            return new CCResponse<>(ccError.getData());

        } catch (Exception e) {
            return new CCResponse<>(ErrorLayer.HSL_LAYER, ErrorSource.SERVER_ERROR, ERROR_RETRIEVE_FACILITY, e);
        }
    }

    @Override
    public CCResponse<FacilityDto> saveFacility(FacilityDto facilityDto) {
        try {
            CCError<FacilityDto> ccError = masterServiceImpl.saveFacility(facilityDto);

            if (ccError.getStatus().equals(CCErrorStatus.ERROR)) {
                return new CCResponse<>(Status.ERROR, ccError.getMessage(), null);
            }
            return new CCResponse<>(ccError.getData());

        } catch (Exception e) {
            return new CCResponse<>(ErrorLayer.HSL_LAYER, ErrorSource.SERVER_ERROR, ERROR_SAVE_FACILITY, e);
        }
    }

    @Override
    public CCResponse<FacilityDto> updateFacility(Long id, FacilityDto facilityDto) {
        try {
            CCError<FacilityDto> ccError = masterServiceImpl.updateFacility(id, facilityDto);

            if (ccError.getStatus().equals(CCErrorStatus.ERROR)) {
                return new CCResponse<>(Status.ERROR, ccError.getMessage(), null);
            }
            return new CCResponse<>(ccError.getData());

        } catch (Exception e) {
            return new CCResponse<>(ErrorLayer.HSL_LAYER, ErrorSource.SERVER_ERROR, ERROR_UPDATE_FACILITY, e);
        }
    }

    @Override
    public CCResponse<FacilityDto> deleteFacility(Long id) {
        try {
            CCError<FacilityDto> ccError = masterServiceImpl.deleteFacility(id);

            if (ccError.getStatus().equals(CCErrorStatus.ERROR)) {
                return new CCResponse<>(Status.ERROR, ccError.getMessage(), null);
            }
            return new CCResponse<>(ccError.getData());

        } catch (Exception e) {
            return new CCResponse<>(ErrorLayer.HSL_LAYER, ErrorSource.SERVER_ERROR, ERROR_DELETE_FACILITY, e);
        }
    }

    // ------------------------- FacilityCategory -------------------------
    @Override
    public CCResponsePack<FacilityCategoryDto> findAllFacilityCategories() {
        try {
            CCError<List<FacilityCategoryDto>> ccError = masterServiceImpl.findAllFacilityCategories();

            if (ccError.getStatus().equals(CCErrorStatus.ERROR)) {
                return new CCResponsePack<>(Status.ERROR, ccError.getMessage(), null);
            }
            return new CCResponsePack<>(ccError.getData());

        } catch (Exception e) {
            return new CCResponsePack<>(ErrorLayer.HSL_LAYER, ErrorSource.SERVER_ERROR, ERROR_RETRIEVE_FACILITY_CATEGORIES, e);
        }
    }

    @Override
    public CCResponse<FacilityCategoryDto> findFacilityCategoryById(Long id) {
        try {
            CCError<FacilityCategoryDto> ccError = masterServiceImpl.findFacilityCategoryById(id);

            if (ccError.getStatus().equals(CCErrorStatus.ERROR)) {
                return new CCResponse<>(Status.ERROR, ccError.getMessage(), null);
            }
            return new CCResponse<>(ccError.getData());

        } catch (Exception e) {
            return new CCResponse<>(ErrorLayer.HSL_LAYER, ErrorSource.SERVER_ERROR, ERROR_RETRIEVE_FACILITY_CATEGORY, e);
        }
    }

    @Override
    public CCResponse<FacilityCategoryDto> saveFacilityCategory(FacilityCategoryDto facilityCategoryDto) {
        try {
            CCError<FacilityCategoryDto> ccError = masterServiceImpl.saveFacilityCategory(facilityCategoryDto);

            if (ccError.getStatus().equals(CCErrorStatus.ERROR)) {
                return new CCResponse<>(Status.ERROR, ccError.getMessage(), null);
            }
            return new CCResponse<>(ccError.getData());

        } catch (Exception e) {
            return new CCResponse<>(ErrorLayer.HSL_LAYER, ErrorSource.SERVER_ERROR, ERROR_SAVE_FACILITY_CATEGORY, e);
        }
    }

    @Override
    public CCResponse<FacilityCategoryDto> updateFacilityCategory(Long id, FacilityCategoryDto facilityCategoryDto) {
        try {
            CCError<FacilityCategoryDto> ccError = masterServiceImpl.updateFacilityCategory(id, facilityCategoryDto);

            if (ccError.getStatus().equals(CCErrorStatus.ERROR)) {
                return new CCResponse<>(Status.ERROR, ccError.getMessage(), null);
            }
            return new CCResponse<>(ccError.getData());

        } catch (Exception e) {
            return new CCResponse<>(ErrorLayer.HSL_LAYER, ErrorSource.SERVER_ERROR, ERROR_UPDATE_FACILITY_CATEGORY, e);
        }
    }

    @Override
    public CCResponse<FacilityCategoryDto> deleteFacilityCategory(Long id) {
        try {
            CCError<FacilityCategoryDto> ccError = masterServiceImpl.deleteFacilityCategory(id);

            if (ccError.getStatus().equals(CCErrorStatus.ERROR)) {
                return new CCResponse<>(Status.ERROR, ccError.getMessage(), null);
            }
            return new CCResponse<>(ccError.getData());

        } catch (Exception e) {
            return new CCResponse<>(ErrorLayer.HSL_LAYER, ErrorSource.SERVER_ERROR, ERROR_DELETE_FACILITY_CATEGORY, e);
        }
    }
}