package lk.travelmarket.search_engine.service.master;

import lk.travelmarket.search_engine.dto.FacilityCategoryDto;
import lk.travelmarket.search_engine.dto.CityDto;
import lk.travelmarket.search_engine.dto.DistrictDto;
import lk.travelmarket.search_engine.network.commons.CCError;
import lk.travelmarket.search_engine.network.commons.CCErrorStatus;
import lk.travelmarket.search_engine.network.commons.CCResponse;
import lk.travelmarket.search_engine.network.commons.CCResponsePack;
import lk.travelmarket.search_engine.network.error.code.ErrorLayer;
import lk.travelmarket.search_engine.network.error.code.ErrorSource;
import lk.travelmarket.search_engine.network.error.code.Status;
import lk.travelmarket.search_engine.dto.FacilityDto;
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
// FACILITY CATEGORY

    @Override
    public CCResponsePack<FacilityCategoryDto> findAllFacilityCategories() {

        try {

            CCError<List<FacilityCategoryDto>> ccError =
                    masterServiceImpl.findAllFacilityCategories();

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
                    ERROR_RETRIEVE_FACILITY_CATEGORIES,
                    e
            );
        }
    }


    @Override
    public CCResponse<FacilityCategoryDto> findFacilityCategory(Long id) {

        try {

            CCError<FacilityCategoryDto> ccError =
                    masterServiceImpl.findFacilityCategory(id);

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
                    ERROR_RETRIEVE_FACILITY_CATEGORY,
                    e
            );
        }
    }

    @Override
    public CCResponse<FacilityCategoryDto> createFacilityCategory(
            FacilityCategoryDto dto) {

        try {

            CCError<FacilityCategoryDto> ccError =
                    masterServiceImpl.createFacilityCategory(dto);

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
                    ERROR_CREATE_FACILITY_CATEGORY,
                    e
            );
        }
    }

    @Override
    public CCResponse<FacilityCategoryDto> updateFacilityCategory(
            Long id,
            FacilityCategoryDto dto) {

        try {

            CCError<FacilityCategoryDto> ccError =
                    masterServiceImpl.updateFacilityCategory(id, dto);

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
                    ERROR_UPDATE_FACILITY_CATEGORY,
                    e
            );
        }
    }

    @Override
    public CCResponse<FacilityCategoryDto> deleteFacilityCategory(Long id) {

        try {

            CCError<FacilityCategoryDto> ccError =
                    masterServiceImpl.deleteFacilityCategory(id);

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
                    ERROR_DELETE_FACILITY_CATEGORY,
                    e
            );
        }
    }

// FACILITY

    @Override
    public CCResponsePack<FacilityDto> findAllFacilities() {

        try {

            CCError<List<FacilityDto>> ccError =
                    masterServiceImpl.findAllFacilities();

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
                    ERROR_RETRIEVE_FACILITIES,
                    e
            );
        }
    }


    @Override
    public CCResponse<FacilityDto> findFacility(Long id) {

        try {

            CCError<FacilityDto> ccError =
                    masterServiceImpl.findFacility(id);

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
                    ERROR_RETRIEVE_FACILITY,
                    e
            );
        }
    }


    @Override
    public CCResponse<FacilityDto> createFacility(FacilityDto dto) {

        try {

            CCError<FacilityDto> ccError =
                    masterServiceImpl.createFacility(dto);

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
                    ERROR_CREATE_FACILITY,
                    e
            );
        }
    }


    @Override
    public CCResponse<FacilityDto> updateFacility(
            Long id,
            FacilityDto dto) {

        try {

            CCError<FacilityDto> ccError =
                    masterServiceImpl.updateFacility(id, dto);

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
                    ERROR_UPDATE_FACILITY,
                    e
            );
        }
    }


    @Override
    public CCResponse<FacilityDto> deleteFacility(Long id) {

        try {

            CCError<FacilityDto> ccError =
                    masterServiceImpl.deleteFacility(id);

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
                    ERROR_DELETE_FACILITY,
                    e
            );
        }
    }
}