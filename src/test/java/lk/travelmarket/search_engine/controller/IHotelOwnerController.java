package lk.travelmarket.search_engine.controller;

import lk.travelmarket.search_engine.dto.HotelOwnerDto;
import lk.travelmarket.search_engine.network.CCResponseWrapper;
import lk.travelmarket.search_engine.util.EndpointConstants;
import org.junit.jupiter.api.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(
        EndpointConstants.V1 + EndpointConstants.HOTEL_OWNER
)
@Tag(
        name = "Hotel Owner",
        description = "APIs for managing Hotel Owners"
)
public interface IHotelOwnerController {

    @PostMapping
    ResponseEntity<CCResponseWrapper<HotelOwnerDto>> create(
            @RequestBody HotelOwnerDto request
    );

    @GetMapping
    ResponseEntity<CCResponseWrapper<HotelOwnerDto>> getAll();

    @GetMapping("/{id}")
    ResponseEntity<CCResponseWrapper<HotelOwnerDto>> getById(
            @PathVariable Long id
    );

    @PutMapping("/{id}")
    ResponseEntity<CCResponseWrapper<HotelOwnerDto>> update(
            @PathVariable Long id,
            @RequestBody HotelOwnerDto request
    );

    @DeleteMapping("/{id}")
    ResponseEntity<CCResponseWrapper<HotelOwnerDto>> delete(
            @PathVariable Long id
    );
}
