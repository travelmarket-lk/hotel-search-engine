package lk.travelmarket.search_engine.controller;

import lk.travelmarket.search_engine.dto.HotelOwnerDto;
import lk.travelmarket.search_engine.network.CCResponseWrapper;
import lk.travelmarket.search_engine.network.util.NetworkUtils;
import lk.travelmarket.search_engine.service.hotelOwner.IHotelOwnerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HotelOwnerController implements IHotelOwnerController {

    private final IHotelOwnerService hotelOwnerService;

    public HotelOwnerController(IHotelOwnerService hotelOwnerService) {
        this.hotelOwnerService = hotelOwnerService;
    }

    @Override
    public ResponseEntity<CCResponseWrapper<HotelOwnerDto>> registerOwner(
            HotelOwnerDto request) {

        return NetworkUtils.wrap(
                hotelOwnerService.registerOwner(request)
        );
    }
}