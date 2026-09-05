package lk.travelmarket.search_engine.controller;

import lk.travelmarket.search_engine.dao.HotelRoom.BedType;
import lk.travelmarket.search_engine.network.CCResponseWrapper;
import lk.travelmarket.search_engine.network.util.NetworkUtils;
import lk.travelmarket.search_engine.service.master.IMasterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MasterDataController implements IMasterDataController {

    private final IMasterService masterService;

    public MasterDataController(IMasterService masterService) {
        this.masterService = masterService;
    }

    @Override
    public ResponseEntity<CCResponseWrapper<BedType>> getAllBedTypes() {
        return NetworkUtils.wrap(masterService.findAllBedTypes());
    }

    @Override
    public ResponseEntity<CCResponseWrapper<BedType>> addBedType(BedType bedType) {
        return NetworkUtils.wrap(masterService.addBedType(bedType));
    }

    @Override
    public ResponseEntity<CCResponseWrapper<Void>> deleteBedType(Long id) {
        return NetworkUtils.wrap(masterService.deleteBedType(id));
    }

    @Override
    public ResponseEntity<CCResponseWrapper<BedType>> getBedTypeById(Long id) {
        return NetworkUtils.wrap(masterService.findBedTypeById(id));
    }

    @Override
    public ResponseEntity<CCResponseWrapper<BedType>> updateBedType(Long id, BedType bedType) {
        return NetworkUtils.wrap(masterService.updateBedType(id, bedType));
    }

}
