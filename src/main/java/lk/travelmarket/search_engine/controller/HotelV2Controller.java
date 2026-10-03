package lk.travelmarket.search_engine.controller;

import lk.travelmarket.search_engine.dto.SeasonDto;
import lk.travelmarket.search_engine.dto.bulk.season.SeasonBulkUpdateDto;
import lk.travelmarket.search_engine.network.CCResponseWrapper;
import lk.travelmarket.search_engine.network.util.NetworkUtils;
import lk.travelmarket.search_engine.service.v2.hotel.HotelV2Service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HotelV2Controller implements IHotelV2Controller {

    private final HotelV2Service hotelService;

    public HotelV2Controller(HotelV2Service hotelService) {
        this.hotelService = hotelService;
    }

    @Override
    public ResponseEntity<CCResponseWrapper<SeasonDto>> retrieveHotelSeasons(Long hotelId) {
        return NetworkUtils.wrap(hotelService.retrieveSeasons( hotelId ));
    }

    @Override
    public ResponseEntity<CCResponseWrapper<SeasonBulkUpdateDto>> bulkSeasonsUpdate(Long hotelId, SeasonBulkUpdateDto request) {
        return NetworkUtils.wrap(hotelService.bulkUpdateSeasons( hotelId, request ));
    }
}
