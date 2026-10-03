package lk.travelmarket.search_engine.controller;

import lk.travelmarket.search_engine.dto.CityDto;
import lk.travelmarket.search_engine.dto.DistrictDto;
import lk.travelmarket.search_engine.dto.RoomDto;
import lk.travelmarket.search_engine.dto.SeasonDto;
import lk.travelmarket.search_engine.network.CCResponseWrapper;
import lk.travelmarket.search_engine.network.util.NetworkUtils;
import lk.travelmarket.search_engine.service.data.IDataService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import lk.travelmarket.search_engine.dto.BoardBasisDto;
import lk.travelmarket.search_engine.dto.RoomCategoryDto;
import lk.travelmarket.search_engine.dto.RoomTypeDto;
import lk.travelmarket.search_engine.network.CCResponseWrapper;
import lk.travelmarket.search_engine.network.util.NetworkUtils;
import lk.travelmarket.search_engine.service.master.IMasterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DataController implements IDataController {

    private final IDataService dataService;



    public DataController(IDataService dataService ) {
        this.dataService = dataService;

    }

    @Override
    public ResponseEntity<CCResponseWrapper<Page<DistrictDto>>> getAllDistricts(
            int page,
            int size
    ) {
        return NetworkUtils.wrap(
                dataService.findAllDistricts(page, size)
        );
    }



    //---------Room Category-----------
    @Override
    public ResponseEntity<CCResponseWrapper<RoomCategoryDto>> findAllRoomCategories(int page, int size) {
        return NetworkUtils.wrap(dataService.findAllRoomCategories( page, size));
    }


    //---------Board Basis-------------
    @Override
    public ResponseEntity<CCResponseWrapper<BoardBasisDto>> findAllBoardBasis(int page, int size) {
        return NetworkUtils.wrap(dataService.findAllBoardBasis( page, size) );
    }

    //---------Room Type---------------
    @Override
    public ResponseEntity<CCResponseWrapper<RoomTypeDto>> findAllRoomType(int page, int size) {
        return NetworkUtils.wrap(dataService.findAllRoomType( page, size));
    }

    @Override
    public ResponseEntity<CCResponseWrapper<Page<CityDto>>> getAllCities(
            int page,
            int size
    ) {
        return NetworkUtils.wrap(
                dataService.findAllCities(page, size)
        );
    }
}