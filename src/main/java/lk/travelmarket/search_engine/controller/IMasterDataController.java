package lk.travelmarket.search_engine.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lk.travelmarket.search_engine.dao.RoomCategory;
import lk.travelmarket.search_engine.dto.RoomCategoryDto;
import lk.travelmarket.search_engine.dto.TestDto;
import lk.travelmarket.search_engine.network.CCResponseWrapper;
import lk.travelmarket.search_engine.service.master.IMasterService;
import lk.travelmarket.search_engine.util.EndpointConstants;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(EndpointConstants.V1 + EndpointConstants.MASTER)
@Tag(
        name = "Master",
        description = "APIs for managing Master resources"
)
public interface IMasterDataController {

    @Operation(
            summary = "Create a new Room Category",
            description = "Creates a new Room Category resource and returns the created Test details."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "Test created successfully"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Invalid request"
            )
    })
    @PostMapping
    ResponseEntity<CCResponseWrapper<RoomCategoryDto>> createRoomCategory(
            @RequestBody RoomCategoryDto request
    );

    @Operation(
            summary = "Get all RoomCategory",
            description = "Retrieves all available Room Category resources."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "RoomCategory retrieved successfully"
            )
    })
    @GetMapping
    ResponseEntity<CCResponseWrapper<RoomCategoryDto>> findAllRoomCategories();

    @Operation(
            summary = "Get Room category by ID",
            description = "Retrieves a single Room Category resource using its unique ID."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Room Category retrieved successfully"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Room Category not found"
            )
    })
    @GetMapping("/{id}")
    ResponseEntity<CCResponseWrapper<RoomCategoryDto>> findRoomCategoryById(
            @PathVariable Long id
    );

    @Operation(
            summary = "Update Room Category",
            description = "Updates an existing Room Category resource using its unique ID."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Room Category updated successfully"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Invalid request"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Test not found"
            )
    })
    @PutMapping("/{id}")
    ResponseEntity<CCResponseWrapper<RoomCategoryDto>> updateRoomCategory(
            @PathVariable Long id,
            @RequestBody RoomCategoryDto request
    );

    @Operation(
            summary = "Delete Room Category",
            description = "Deletes an existing Room Category resource using its unique ID."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "204",
                    description = "Room Category deleted successfully"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Test not found"
            )
    })
    @DeleteMapping("/{id}")
    ResponseEntity<CCResponseWrapper<RoomCategoryDto>> deleteRoomCategory(
            @PathVariable Long id
    );
}
