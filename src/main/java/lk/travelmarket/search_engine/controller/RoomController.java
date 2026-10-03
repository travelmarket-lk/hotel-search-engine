package lk.travelmarket.search_engine.controller;

import lk.travelmarket.search_engine.dto.RoomDto;
import lk.travelmarket.search_engine.network.CCResponseWrapper;
import lk.travelmarket.search_engine.network.util.NetworkUtils;
import lk.travelmarket.search_engine.service.room.IRoomService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoomController implements IRoomController {

    private final IRoomService roomService;

    public RoomController(IRoomService roomService) {
        this.roomService = roomService;
    }

    @Override
    public ResponseEntity<CCResponseWrapper<RoomDto>> create(RoomDto request) {
        return NetworkUtils.wrap(roomService.createRoom(request));
    }

    @Override
    public ResponseEntity<CCResponseWrapper<RoomDto>> getAll() {
        return NetworkUtils.wrap(roomService.findAll());
    }

    @Override
    public ResponseEntity<CCResponseWrapper<RoomDto>> getById(Long id) {
        return NetworkUtils.wrap(roomService.findRoom(id));
    }

    @Override
    public ResponseEntity<CCResponseWrapper<RoomDto>> update(
            Long id,
            RoomDto request
    ) {
        return NetworkUtils.wrap(roomService.updateRoom(id, request));
    }

    @Override
    public ResponseEntity<CCResponseWrapper<RoomDto>> delete(Long id) {
        return NetworkUtils.wrap(roomService.deleteRoom(id));
    }
}