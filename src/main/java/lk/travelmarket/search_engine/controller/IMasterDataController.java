package lk.travelmarket.search_engine.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lk.travelmarket.search_engine.dao.HotelRoom.BedType;
import lk.travelmarket.search_engine.dto.CityDto;
import lk.travelmarket.search_engine.dto.DistrictDto;
import lk.travelmarket.search_engine.dto.RoomCategoryDto;
import lk.travelmarket.search_engine.network.CCResponseWrapper;
import lk.travelmarket.search_engine.util.EndpointConstants;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(EndpointConstants.V1 + EndpointConstants.MASTER)
@Tag(
        name = "Master Data",
        description = "APIs for managing District and City master data"
)
public interface IMasterDataController {

    // DISTRICT

    @Operation(
            summary = "Create a new District",
            description = "Creates a new District and returns the created District details."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "District created successfully"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Invalid request"
            )
    })
    @PostMapping("/districts")
    ResponseEntity<CCResponseWrapper<DistrictDto>> createDistrict(
            @RequestBody DistrictDto request
    );

    @Operation(
            summary = "Get all Districts",
            description = "Retrieves all available Districts."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Districts retrieved successfully"
            )
    })
    @GetMapping("/districts")
    ResponseEntity<CCResponseWrapper<DistrictDto>> getAllDistricts();

    @Operation(
            summary = "Get District by ID",
            description = "Retrieves a single District using its unique ID."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "District retrieved successfully"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "District not found"
            )
    })
    @GetMapping("/districts/{id}")
    ResponseEntity<CCResponseWrapper<DistrictDto>> getDistrictById(
            @PathVariable Long id
    );

    @Operation(
            summary = "Update District",
            description = "Updates an existing District using its unique ID."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "District updated successfully"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Invalid request"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "District not found"
            )
    })
    @PutMapping("/districts/{id}")
    ResponseEntity<CCResponseWrapper<DistrictDto>> updateDistrict(
            @PathVariable Long id,
            @RequestBody DistrictDto request
    );

    @Operation(
            summary = "Delete District",
            description = "Deletes an existing District using its unique ID."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "204",
                    description = "District deleted successfully"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "District not found"
            )
    })
    @DeleteMapping("/districts/{id}")
    ResponseEntity<CCResponseWrapper<DistrictDto>> deleteDistrict(
            @PathVariable Long id
    );


    // CITY

    @Operation(
            summary = "Create a new City",
            description = "Creates a new City and returns the created City details."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "City created successfully"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Invalid request"
            )
    })
    @PostMapping("/cities")
    ResponseEntity<CCResponseWrapper<CityDto>> createCity(
            @RequestBody CityDto request
    );

    @Operation(
            summary = "Get all Cities",
            description = "Retrieves all available Cities."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Cities retrieved successfully"
            )
    })
    @GetMapping("/cities")
    ResponseEntity<CCResponseWrapper<CityDto>> getAllCities();

    @Operation(
            summary = "Get City by ID",
            description = "Retrieves a single City using its unique ID."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "City retrieved successfully"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "City not found"
            )
    })
    @GetMapping("/cities/{id}")
    ResponseEntity<CCResponseWrapper<CityDto>> getCityById(
            @PathVariable Long id
    );

    @Operation(
            summary = "Update City",
            description = "Updates an existing City using its unique ID."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "City updated successfully"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Invalid request"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "City not found"
            )
    })
    @PutMapping("/cities/{id}")
    ResponseEntity<CCResponseWrapper<CityDto>> updateCity(
            @PathVariable Long id,
            @RequestBody CityDto request
    );

    @Operation(
            summary = "Delete City",
            description = "Deletes an existing City using its unique ID."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "204",
                    description = "City deleted successfully"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "City not found"
            )
    })

    @DeleteMapping("/cities/{id}")
    ResponseEntity<CCResponseWrapper<CityDto>> deleteCity(
            @PathVariable Long id
    );

    //  BED TYPES

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

    // ROOMS

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