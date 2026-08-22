package lk.travelmarket.search_engine.controller;
import lk.travelmarket.search_engine.dto.HotelResponse;
import lk.travelmarket.search_engine.service.hotel.IHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/hotel")
public class HotelController {

    @Autowired
    private IHotelService hotelService;

    @GetMapping
    public List<HotelResponse> getAllHotels(){
        return hotelService.getAllHotels();
    }

}
