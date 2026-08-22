package lk.travelmarket.search_engine.controller;

import lk.travelmarket.search_engine.dao.HotelOwner;
import lk.travelmarket.search_engine.repository.HotelOwnerRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class HotelOwnerController implements IHotelOwnerController{

    private final HotelOwnerRepository hotelOwnerRepository;

    public HotelOwnerController(HotelOwnerRepository hotelOwnerRepository) {
        this.hotelOwnerRepository = hotelOwnerRepository;
    }

    @Override
    public ResponseEntity<HotelOwner> registerOwner(@RequestBody HotelOwner hotelOwner) {
        HotelOwner savedOwner = hotelOwnerRepository.save(hotelOwner);
        return ResponseEntity.ok(savedOwner);
    }
}
