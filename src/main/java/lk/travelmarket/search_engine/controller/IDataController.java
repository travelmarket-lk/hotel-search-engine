package lk.travelmarket.search_engine.controller;

import io.swagger.v3.oas.annotations.Operation;
import lk.travelmarket.search_engine.dao.HotelRoom.BedType;
import lk.travelmarket.search_engine.dto.LandmarkDto;
import lk.travelmarket.search_engine.network.CCResponseWrapper;
import lk.travelmarket.search_engine.util.EndpointConstants;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(EndpointConstants.V1 + EndpointConstants.DATA)
public interface IDataController {

    // Bed Types
    @Operation(
            summary = "Get all Bed Types",
            description = "Retrieves Bed Types with pagination."
    )
    @GetMapping("/bed-types")
    ResponseEntity<CCResponseWrapper<Page<BedType>>> getAllBedTypes(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    );
}