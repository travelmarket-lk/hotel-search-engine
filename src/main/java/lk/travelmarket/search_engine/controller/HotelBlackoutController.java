package lk.travelmarket.search_engine.controller;

import lk.travelmarket.search_engine.dto.BlackoutsDto;
import lk.travelmarket.search_engine.network.CCResponseWrapper;
import lk.travelmarket.search_engine.network.util.NetworkUtils;
import lk.travelmarket.search_engine.service.hotel.IHotelBlackoutService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HotelBlackoutController implements IHotelBlackoutController {

    private final IHotelBlackoutService hotelBlackoutService;

    public HotelBlackoutController(IHotelBlackoutService hotelBlackoutService) {
        this.hotelBlackoutService = hotelBlackoutService;
    }

    @Override
    public ResponseEntity<CCResponseWrapper<BlackoutsDto>> create(BlackoutsDto request) {
        return NetworkUtils.wrap(hotelBlackoutService.createHotelBlackout(request));
    }

    @Override
    public ResponseEntity<CCResponseWrapper<BlackoutsDto>> getAll() {
        return NetworkUtils.wrap(hotelBlackoutService.findAll());
    }

    @Override
    public ResponseEntity<CCResponseWrapper<BlackoutsDto>> getByHotelId(Long hotelId) {
        return NetworkUtils.wrap(hotelBlackoutService.findByHotelId(hotelId));
    }

    @Override
    public ResponseEntity<CCResponseWrapper<BlackoutsDto>> getById(Long id) {
        return NetworkUtils.wrap(hotelBlackoutService.findHotelBlackout(id));
    }

    @Override
    public ResponseEntity<CCResponseWrapper<BlackoutsDto>> update(Long id, BlackoutsDto request) {
        return NetworkUtils.wrap(hotelBlackoutService.updateHotelBlackout(id, request));
    }

    @Override
    public ResponseEntity<CCResponseWrapper<BlackoutsDto>> delete(Long id) {
        return NetworkUtils.wrap(hotelBlackoutService.deleteHotelBlackout(id));
    }

}