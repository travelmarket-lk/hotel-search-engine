package lk.travelmarket.search_engine.service.data;

import lk.travelmarket.search_engine.dto.BoardBasisDto;
import lk.travelmarket.search_engine.dto.RoomCategoryDto;
import lk.travelmarket.search_engine.dto.RoomTypeDto;
import lk.travelmarket.search_engine.network.commons.CCError;
import lk.travelmarket.search_engine.network.commons.CCErrorStatus;
import lk.travelmarket.search_engine.network.commons.CCResponsePack;
import lk.travelmarket.search_engine.network.error.code.ErrorLayer;
import lk.travelmarket.search_engine.network.error.code.ErrorSource;
import lk.travelmarket.search_engine.network.error.code.Status;
import lk.travelmarket.search_engine.service.master.MasterServiceImpl;
import org.springframework.data.domain.Page;

import java.util.List;

import static lk.travelmarket.search_engine.util.Constants.*;


public class DataService implements IDataService{

    private final DataServiceImpl dataServiceImpl;

    public DataService(DataServiceImpl dataServiceImpl) {
        this.dataServiceImpl = dataServiceImpl;
    }

    //------------Room Category-------------
    @Override
    public CCResponsePack<RoomCategoryDto> findAllRoomCategories(int page, int size) {
        try {
            CCError<Page<RoomCategoryDto>> ccError = dataServiceImpl.findAllRoomCategories(page,size);
            if (ccError.getStatus().equals(CCErrorStatus.ERROR)) {
                return new CCResponsePack<>(Status.ERROR, ccError.getMessage(), null);
            }
            return new CCResponsePack<>(ccError.getData().getContent());
        } catch (Exception e) {
            return new CCResponsePack<>(ErrorLayer.HSL_LAYER, ErrorSource.SERVER_ERROR, ERROR_RETRIEVE_ROOM_CATEGORIES, e);
        }
    }

    //-------------Board Basis---------------
    @Override
    public CCResponsePack<BoardBasisDto> findAllBoardBasis(int page, int size) {
        try {
            CCError<Page<BoardBasisDto>> ccError = dataServiceImpl.findAllBoardBasis(page,size);
            if (ccError.getStatus().equals(CCErrorStatus.ERROR)) {
                return new CCResponsePack<>(Status.ERROR, ccError.getMessage(), null);
            }
            return new CCResponsePack<>(ccError.getData().getContent());
        } catch (Exception e) {
            return new CCResponsePack<>(ErrorLayer.HSL_LAYER, ErrorSource.SERVER_ERROR, ERROR_RETRIEVE_BOARD_BASIS, e);
        }
    }

    //--------------Room Type-----------------
    @Override
    public CCResponsePack<RoomTypeDto> findAllRoomType(int page,int size) {
        try {
            CCError<Page<RoomTypeDto>> ccError = dataServiceImpl.findAllRoomType(page, size);
            if (ccError.getStatus().equals(CCErrorStatus.ERROR)) {
                return new CCResponsePack<>(Status.ERROR, ccError.getMessage(), null);
            }
            return new CCResponsePack<>(ccError.getData().getContent());
        } catch (Exception e) {
            return new CCResponsePack<>(ErrorLayer.HSL_LAYER, ErrorSource.SERVER_ERROR, ERROR_RETRIEVE_ROOM_TYPE, e);
        }
    }
}
