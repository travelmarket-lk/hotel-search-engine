package lk.travelmarket.search_engine.service.master;

import lk.travelmarket.search_engine.dto.RoomCategoryDto;
import lk.travelmarket.search_engine.dto.TestDto;
import lk.travelmarket.search_engine.network.commons.CCError;
import lk.travelmarket.search_engine.network.commons.CCErrorStatus;
import lk.travelmarket.search_engine.network.commons.CCResponse;
import lk.travelmarket.search_engine.network.commons.CCResponsePack;
import lk.travelmarket.search_engine.network.error.code.ErrorLayer;
import lk.travelmarket.search_engine.network.error.code.ErrorSource;
import lk.travelmarket.search_engine.network.error.code.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static lk.travelmarket.search_engine.util.Constants.*;

@Service
public class MasterService implements IMasterService {

    @Autowired
    private MasterServiceImpl masterServiceImpl;

    public MasterService(MasterServiceImpl masterServiceImpl) {
        this.masterServiceImpl = masterServiceImpl;
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
