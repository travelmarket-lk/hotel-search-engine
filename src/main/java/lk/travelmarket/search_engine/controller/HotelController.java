package lk.travelmarket.search_engine.controller;

import lk.travelmarket.search_engine.dao.hotel.Landmark;
import lk.travelmarket.search_engine.dto.HotelDto;
import lk.travelmarket.search_engine.dto.LandmarkDto;
import lk.travelmarket.search_engine.dto.criteria.HotelCreationCriteria;
import lk.travelmarket.search_engine.network.CCResponseWrapper;
import lk.travelmarket.search_engine.network.commons.CCResponsePack;
import lk.travelmarket.search_engine.service.hotel.HotelService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@Validated
public class HotelController implements IHotelController {

    private final HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @Override
    public ResponseEntity<CCResponseWrapper<HotelDto>> getAllHotels() {
        CCResponsePack<HotelDto> response = hotelService.getAllHotels();
        return ResponseEntity.ok(new CCResponseWrapper<>(response));
    }

    @Override
    public ResponseEntity<CCResponseWrapper<HotelDto>> getHotelById(@PathVariable Long id) {
        CCResponsePack<HotelDto> response = hotelService.getHotelById(id);
        return ResponseEntity.ok(new CCResponseWrapper<>(response));
    }

    @Override
    public ResponseEntity<CCResponseWrapper<HotelDto>> createHotel(@RequestBody HotelCreationCriteria criteria) {
        CCResponsePack<HotelDto> response = hotelService.createHotel(criteria);
        return ResponseEntity.ok(new CCResponseWrapper<>(response));
    }

    @Override
    public ResponseEntity<CCResponseWrapper<HotelDto>> updateHotel(@PathVariable Long id, @RequestBody HotelDto hotelDetails) {
        CCResponsePack<HotelDto> response = hotelService.updateHotel(id, hotelDetails);
        return ResponseEntity.ok(new CCResponseWrapper<>(response));
    }

    @Override
    public ResponseEntity<CCResponseWrapper<Boolean>> deleteHotel(@PathVariable Long id) {
        CCResponsePack<Boolean> response = hotelService.deleteHotel(id);
        return ResponseEntity.ok(new CCResponseWrapper<>(response));
    }

    // HOTEL LANDMARKS

    @Override
    public ResponseEntity<CCResponseWrapper<LandmarkDto>> getLandmarksByHotelId(@PathVariable Long id) {
        CCResponsePack<LandmarkDto> response = hotelService.getLandmarksByHotelId(id);
        return ResponseEntity.ok(new CCResponseWrapper<>(response));
    }

    @Override
    public ResponseEntity<CCResponseWrapper<LandmarkDto>> addLandmarkToHotel(@PathVariable Long id, @RequestBody Landmark landmark) {
        CCResponsePack<LandmarkDto> response = hotelService.addLandmarkToHotel(id, landmark);
        return ResponseEntity.ok(new CCResponseWrapper<>(response));
    }

    @Override
    public ResponseEntity<CCResponseWrapper<Boolean>> deleteLandmark(@PathVariable Long landmarkId) {
        CCResponsePack<Boolean> response = hotelService.deleteLandmark(landmarkId);
        return ResponseEntity.ok(new CCResponseWrapper<>(response));
    }
}
