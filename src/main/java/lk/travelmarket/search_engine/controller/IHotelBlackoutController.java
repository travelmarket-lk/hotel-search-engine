package lk.travelmarket.search_engine.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lk.travelmarket.search_engine.dto.BlackoutsDto;
import lk.travelmarket.search_engine.network.CCResponseWrapper;
import lk.travelmarket.search_engine.util.EndpointConstants;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(EndpointConstants.V1 + EndpointConstants.HOTEL_BLACKOUTS)
@Tag(name = "Hotel Blackouts", description = "APIs for managing Hotel Blackouts resources")
public interface IHotelBlackoutController {

    @Operation(summary = "Create a new Hotel Blackout")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Hotel Blackout created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid request")
    })
    @PostMapping
    ResponseEntity<CCResponseWrapper<BlackoutsDto>> create(@RequestBody BlackoutsDto request);

    @Operation(summary = "Get all Hotel Blackouts")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Hotel Blackouts retrieved successfully")
    })
    @GetMapping
    ResponseEntity<CCResponseWrapper<BlackoutsDto>> getAll();

    @Operation(summary = "Get Hotel Blackouts by Hotel ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Hotel Blackouts retrieved successfully")
    })
    @GetMapping("/hotel/{hotelId}")
    ResponseEntity<CCResponseWrapper<BlackoutsDto>> getByHotelId(@PathVariable Long hotelId);

    @Operation(summary = "Get Hotel Blackout by ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Hotel Blackout retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "Hotel Blackout not found")
    })
    @GetMapping("/{id}")
    ResponseEntity<CCResponseWrapper<BlackoutsDto>> getById(@PathVariable Long id);

    @Operation(summary = "Update Hotel Blackout")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Hotel Blackout updated successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid request"),
            @ApiResponse(responseCode = "404", description = "Hotel Blackout not found")
    })
    @PutMapping("/{id}")
    ResponseEntity<CCResponseWrapper<BlackoutsDto>> update(@PathVariable Long id, @RequestBody BlackoutsDto request);

    @Operation(summary = "Delete Hotel Blackout")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Hotel Blackout deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Hotel Blackout not found")
    })
    @DeleteMapping("/{id}")
    ResponseEntity<CCResponseWrapper<BlackoutsDto>> delete(@PathVariable Long id);

}