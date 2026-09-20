package lk.travelmarket.search_engine.controller;

import lk.travelmarket.search_engine.dto.BoardBasisDto;
import lk.travelmarket.search_engine.dto.RoomCategoryDto;
import lk.travelmarket.search_engine.dto.RoomTypeDto;
import lk.travelmarket.search_engine.network.CCResponseWrapper;
import lk.travelmarket.search_engine.network.util.NetworkUtils;
import lk.travelmarket.search_engine.service.master.IMasterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataController implements IDataController {

    private final IMasterService masterService;

    public DataController(IMasterService masterService) {
        this.masterService = masterService;
    }

    //---------Room Category-----------
    @Override
    public ResponseEntity<CCResponseWrapper<RoomCategoryDto>> findAllRoomCategories(int page, int size) {
        return NetworkUtils.wrap(masterService.findAllRoomCategories());
    }


    //---------Board Basis-------------
    @Override
    public ResponseEntity<CCResponseWrapper<BoardBasisDto>> findAllBoardBasis(int page, int size) {
        return NetworkUtils.wrap(masterService.findAllBoardBasis());
    }

    //---------Room Type---------------
    @Override
    public ResponseEntity<CCResponseWrapper<RoomTypeDto>> findAllRoomType(int page, int size) {
        return NetworkUtils.wrap(masterService.findAllRoomType());
    }
}
