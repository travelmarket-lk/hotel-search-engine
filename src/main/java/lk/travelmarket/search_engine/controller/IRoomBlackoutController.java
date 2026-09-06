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
@RequestMapping(EndpointConstants.V1 + EndpointConstants.ROOM_BLACKOUTS)
@Tag(name = "Room Blackouts", description = "APIs for managing Room Blackouts resources")
public interface IRoomBlackoutController {

    @Operation(summary = "Create a new Room Blackout")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Room Blackout created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid request")
    })
    @PostMapping
    ResponseEntity<CCResponseWrapper<BlackoutsDto>> create(@RequestBody BlackoutsDto request);

    @Operation(summary = "Get all Room Blackouts")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Room Blackouts retrieved successfully")
    })
    @GetMapping
    ResponseEntity<CCResponseWrapper<BlackoutsDto>> getAll();

    @Operation(summary = "Get Room Blackouts by Room ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Room Blackouts retrieved successfully")
    })
    @GetMapping("/room/{roomId}")
    ResponseEntity<CCResponseWrapper<BlackoutsDto>> getByRoomId(@PathVariable Long roomId);

    @Operation(summary = "Get Room Blackouts by Hotel ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Room Blackouts retrieved successfully")
    })
    @GetMapping("/hotel/{hotelId}")
    ResponseEntity<CCResponseWrapper<BlackoutsDto>> getByHotelId(@PathVariable Long hotelId);

    @Operation(summary = "Get Room Blackout by ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Room Blackout retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "Room Blackout not found")
    })
    @GetMapping("/{id}")
    ResponseEntity<CCResponseWrapper<BlackoutsDto>> getById(@PathVariable Long id);

    @Operation(summary = "Update Room Blackout")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Room Blackout updated successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid request"),
            @ApiResponse(responseCode = "404", description = "Room Blackout not found")
    })
    @PutMapping("/{id}")
    ResponseEntity<CCResponseWrapper<BlackoutsDto>> update(@PathVariable Long id, @RequestBody BlackoutsDto request);

    @Operation(summary = "Delete Room Blackout")
    @ApiResponses({
            @ApiResponse(responseCode = "204", description = "Room Blackout deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Room Blackout not found")
    })
    @DeleteMapping("/{id}")
    ResponseEntity<CCResponseWrapper<BlackoutsDto>> delete(@PathVariable Long id);

}
