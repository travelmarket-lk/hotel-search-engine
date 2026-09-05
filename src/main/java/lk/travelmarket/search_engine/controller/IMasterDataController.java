package lk.travelmarket.search_engine.controller;

import lk.travelmarket.search_engine.dao.HotelRoom.BedType;
import lk.travelmarket.search_engine.network.CCResponseWrapper;
import lk.travelmarket.search_engine.util.EndpointConstants;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(EndpointConstants.V1)
public interface IMasterDataController {

    @GetMapping(EndpointConstants.BED_TYPES)
    public ResponseEntity<CCResponseWrapper<BedType>> getAllBedTypes();

    @PostMapping(EndpointConstants.BED_TYPES)
    public ResponseEntity<CCResponseWrapper<BedType>> addBedType(@RequestBody BedType bedType);

    @DeleteMapping(EndpointConstants.BED_TYPES_ID)
    public ResponseEntity<CCResponseWrapper<Void>> deleteBedType(@PathVariable Long id);

    @GetMapping(EndpointConstants.BED_TYPES_ID)
    public ResponseEntity<CCResponseWrapper<BedType>> getBedTypeById(@PathVariable("id") Long id);

    @PutMapping(EndpointConstants.BED_TYPES_ID)
    public ResponseEntity<CCResponseWrapper<BedType>> updateBedType(@PathVariable("id") Long id, @RequestBody BedType bedType);
}