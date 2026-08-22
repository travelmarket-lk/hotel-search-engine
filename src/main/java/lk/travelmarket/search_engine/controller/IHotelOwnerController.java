package lk.travelmarket.search_engine.controller;

import lk.travelmarket.search_engine.dao.HotelOwner;
import lk.travelmarket.search_engine.util.EndpointConstants;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(EndpointConstants.V1)
public interface IHotelOwnerController {

    @PostMapping("/hotel-owners/register")
    public ResponseEntity<HotelOwner> registerOwner(@RequestBody HotelOwner hotelOwner);
}
