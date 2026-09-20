package lk.travelmarket.search_engine.controller;

import jakarta.validation.Valid;
import lk.travelmarket.search_engine.dao.hotel.Hotel;
import lk.travelmarket.search_engine.dao.hotel.Landmark;
import lk.travelmarket.search_engine.dto.HotelDto;
import lk.travelmarket.search_engine.dto.LandmarkDto;
import lk.travelmarket.search_engine.dto.criteria.HotelCreationCriteria;
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
    ResponseEntity<CCResponseWrapper<HotelDto>> getHotelById(
            @PathVariable Long id);

    @PostMapping(EndpointConstants.HOTEL)
    ResponseEntity<CCResponseWrapper<HotelDto>> createHotel(
            @Valid @RequestBody HotelCreationCriteria criteria);

    @PutMapping(EndpointConstants.HOTEL_BY_ID)
    ResponseEntity<CCResponseWrapper<HotelDto>> updateHotel(
            @PathVariable Long id,
            @Valid @RequestBody HotelDto hotel);

    @DeleteMapping(EndpointConstants.HOTEL_BY_ID)
    ResponseEntity<CCResponseWrapper<Boolean>> deleteHotel(
            @PathVariable Long id);

    // HOTEL LANDMARKS

    @GetMapping(EndpointConstants.HOTEL_LANDMARKS)
    ResponseEntity<CCResponseWrapper<LandmarkDto>> getLandmarksByHotelId(@PathVariable Long id);

    @PostMapping(EndpointConstants.HOTEL_LANDMARKS)
    ResponseEntity<CCResponseWrapper<LandmarkDto>> addLandmarkToHotel(@PathVariable Long id, @RequestBody Landmark landmark);

    @DeleteMapping(EndpointConstants.LANDMARK_BY_ID)
    ResponseEntity<CCResponseWrapper<Boolean>> deleteLandmark(@PathVariable Long landmarkId);
}