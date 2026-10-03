package lk.travelmarket.search_engine.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lk.travelmarket.search_engine.dto.RoomDto;
import lk.travelmarket.search_engine.network.CCResponseWrapper;
import lk.travelmarket.search_engine.util.EndpointConstants;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
@RequestMapping(EndpointConstants.V1 + EndpointConstants.ROOMS)
@Tag(
        name = "Room",
        description = "APIs for managing Room resources"
)
public interface IRoomController {

    @Operation(
            summary = "Create a new Room",
            description = "Creates a new Room resource and returns the created Room details."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "Room created successfully"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Invalid request"
            )
    })
    @PostMapping
    ResponseEntity<CCResponseWrapper<RoomDto>> create(
            @Valid @RequestBody RoomDto request
    );

    @Operation(
            summary = "Get all Rooms",
            description = "Retrieves all available Room resources."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Rooms retrieved successfully"
    )
    @GetMapping
    ResponseEntity<CCResponseWrapper<RoomDto>> getAll();

    @Operation(
            summary = "Get Room by ID",
            description = "Retrieves a Room resource using its unique ID."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Room retrieved successfully"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Room not found"
            )
    })
    @GetMapping("/{id}")
    ResponseEntity<CCResponseWrapper<RoomDto>> getById(
            @Positive(message = "Room ID must be greater than 0")
            @PathVariable Long id
    );

    @Operation(
            summary = "Update Room",
            description = "Updates an existing Room resource using its unique ID."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Room updated successfully"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Invalid request"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Room not found"
            )
    })
    @PutMapping("/{id}")
    ResponseEntity<CCResponseWrapper<RoomDto>> update(
            @Positive(message = "Room ID must be greater than 0")
            @PathVariable Long id,
            @Valid @RequestBody RoomDto request
    );

    @Operation(
            summary = "Delete Room",
            description = "Deletes an existing Room resource using its unique ID."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "204",
                    description = "Room deleted successfully"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Room not found"
            )
    })
    @DeleteMapping("/{id}")
    ResponseEntity<CCResponseWrapper<RoomDto>> delete(
            @Positive(message = "Room ID must be greater than 0")
            @PathVariable Long id
    );
}