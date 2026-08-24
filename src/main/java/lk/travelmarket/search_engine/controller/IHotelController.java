package lk.travelmarket.search_engine.controller;

import lk.travelmarket.search_engine.dao.hotel.Hotel;
import lk.travelmarket.search_engine.dto.HotelDto;
import lk.travelmarket.search_engine.network.CCResponseWrapper;
import lk.travelmarket.search_engine.util.EndpointConstants;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(EndpointConstants.V1)
public interface IHotelController {

    @GetMapping(EndpointConstants.HOTEL)
    ResponseEntity<CCResponseWrapper<HotelDto>> getAllHotels();

    @GetMapping(EndpointConstants.HOTEL_BY_ID)
    ResponseEntity<CCResponseWrapper<HotelDto>> getHotelById(@PathVariable Long id);

    @PostMapping(EndpointConstants.HOTEL)
    ResponseEntity<CCResponseWrapper<HotelDto>> createHotel(@RequestBody Hotel hotel);

    @PutMapping(EndpointConstants.HOTEL_BY_ID)
    ResponseEntity<CCResponseWrapper<HotelDto>> updateHotel(@PathVariable Long id, @RequestBody Hotel hotelDetails);

    @DeleteMapping(EndpointConstants.HOTEL_BY_ID)
    ResponseEntity<CCResponseWrapper<Boolean>> deleteHotel(@PathVariable Long id);
}