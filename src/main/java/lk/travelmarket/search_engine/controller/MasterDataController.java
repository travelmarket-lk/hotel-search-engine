package lk.travelmarket.search_engine.controller;

import lk.travelmarket.search_engine.dto.RoomCategoryDto;
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

    @Override
    public ResponseEntity<CCResponseWrapper<RoomCategoryDto>> createRoomCategory(RoomCategoryDto request) {
        return NetworkUtils.wrap(masterService.createRoomCategory(request));
    }

    @Override
    public ResponseEntity<CCResponseWrapper<RoomCategoryDto>> findAllRoomCategories() {
        return NetworkUtils.wrap(masterService.findAllRoomCategories());
    }

    @Override
    public ResponseEntity<CCResponseWrapper<RoomCategoryDto>> findRoomCategoryById(Long id) {
        return NetworkUtils.wrap(masterService.findRoomCategoryById(id));
    }

    @Override
    public ResponseEntity<CCResponseWrapper<RoomCategoryDto>> updateRoomCategory(Long id, RoomCategoryDto request) {
        return NetworkUtils.wrap(masterService.updateRoomCategory(id, request));
    }

    @Override
    public ResponseEntity<CCResponseWrapper<RoomCategoryDto>> deleteRoomCategory(Long id) {
        return NetworkUtils.wrap(masterService.deleteRoomCategory(id));
    }
}
