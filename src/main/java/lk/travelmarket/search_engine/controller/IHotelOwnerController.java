package lk.travelmarket.search_engine.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lk.travelmarket.search_engine.dto.HotelOwnerDto;
import lk.travelmarket.search_engine.network.CCResponseWrapper;
import lk.travelmarket.search_engine.util.EndpointConstants;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(EndpointConstants.V1)
@Tag(
        name = "Hotel Owner",
        description = "APIs for managing Hotel Owner resources"
)
public interface IHotelOwnerController {

    @Operation(
            summary = "Register a Hotel Owner",
            description = "Creates a new Hotel Owner and returns the registered owner details."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "Hotel Owner registered successfully"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Invalid request"
            )
    })
    @PostMapping("/hotel-owners/register")
    ResponseEntity<CCResponseWrapper<HotelOwnerDto>> registerOwner(
            @Valid @RequestBody HotelOwnerDto request
    );
}