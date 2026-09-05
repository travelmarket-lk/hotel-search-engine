package lk.travelmarket.search_engine.service.master;

import lk.travelmarket.search_engine.dao.HotelRoom.BedType;
import lk.travelmarket.search_engine.dto.CityDto;
import lk.travelmarket.search_engine.dto.DistrictDto;
import lk.travelmarket.search_engine.dto.RoomCategoryDto;
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
}