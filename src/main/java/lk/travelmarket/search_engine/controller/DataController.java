package lk.travelmarket.search_engine.controller;

import lk.travelmarket.search_engine.dao.HotelRoom.BedType;
import lk.travelmarket.search_engine.dto.LandmarkDto;
import lk.travelmarket.search_engine.network.CCResponseWrapper;
import lk.travelmarket.search_engine.network.util.NetworkUtils;
import lk.travelmarket.search_engine.service.data.IDataService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataController implements IDataController {

    private final IDataService dataService;

    public DataController(IDataService dataService) {
        this.dataService = dataService;
    }

    // Bed Types
    @Override
    public ResponseEntity<CCResponseWrapper<Page<BedType>>> getAllBedTypes(
            int page,
            int size
    ) {
        return NetworkUtils.wrap(
                dataService.findAllBedTypes(page, size)
        );
    }
}