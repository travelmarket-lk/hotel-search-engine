package lk.travelmarket.search_engine.controller;

import lk.travelmarket.search_engine.dto.BlackoutsDto;
import lk.travelmarket.search_engine.network.CCResponseWrapper;
import lk.travelmarket.search_engine.network.util.NetworkUtils;
import lk.travelmarket.search_engine.service.hotel.IRoomBlackoutService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoomBlackoutController implements lk.travelmarket.search_engine.controller.IRoomBlackoutController {

    private final IRoomBlackoutService roomBlackoutService;

    public RoomBlackoutController(IRoomBlackoutService roomBlackoutService) {
        this.roomBlackoutService = roomBlackoutService;
    }

    @Override
    public ResponseEntity<CCResponseWrapper<BlackoutsDto>> create(BlackoutsDto request) {
        return NetworkUtils.wrap(roomBlackoutService.createRoomBlackout(request));
    }

    @Override
    public ResponseEntity<CCResponseWrapper<BlackoutsDto>> getAll() {
        return NetworkUtils.wrap(roomBlackoutService.findAll());
    }

    @Override
    public ResponseEntity<CCResponseWrapper<BlackoutsDto>> getByRoomId(Long roomId) {
        return NetworkUtils.wrap(roomBlackoutService.findByRoomId(roomId));
    }

    @Override
    public ResponseEntity<CCResponseWrapper<BlackoutsDto>> getByHotelId(Long hotelId) {
        return NetworkUtils.wrap(roomBlackoutService.findByHotelId(hotelId));
    }

    @Override
    public ResponseEntity<CCResponseWrapper<BlackoutsDto>> getById(Long id) {
        return NetworkUtils.wrap(roomBlackoutService.findRoomBlackout(id));
    }

    @Override
    public ResponseEntity<CCResponseWrapper<BlackoutsDto>> update(Long id, BlackoutsDto request) {
        return NetworkUtils.wrap(roomBlackoutService.updateRoomBlackout(id, request));
    }

    @Override
    public ResponseEntity<CCResponseWrapper<BlackoutsDto>> delete(Long id) {
        return NetworkUtils.wrap(roomBlackoutService.deleteRoomBlackout(id));
    }

}
