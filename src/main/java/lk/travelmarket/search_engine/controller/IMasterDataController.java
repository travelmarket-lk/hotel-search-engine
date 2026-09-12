package lk.travelmarket.search_engine.controller;

import lk.travelmarket.search_engine.dto.FacilityCategoryDto;
import lk.travelmarket.search_engine.dto.FacilityDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lk.travelmarket.search_engine.dto.CityDto;
import lk.travelmarket.search_engine.dto.DistrictDto;
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

    // FACILITY CATEGORY

    @Operation(
            summary = "Create a new Facility Category",
            description = "Creates a new Facility Category and returns the created Facility Category details."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "Facility Category created successfully"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Invalid request"
            )
    })
    @PostMapping("/facility-categories")
    ResponseEntity<CCResponseWrapper<FacilityCategoryDto>> createFacilityCategory(
            @RequestBody FacilityCategoryDto request
    );

    @Operation(
            summary = "Get all Facility Categories",
            description = "Retrieves all available Facility Categories."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Facility Categories retrieved successfully"
            )
    })
    @GetMapping("/facility-categories")
    ResponseEntity<CCResponseWrapper<FacilityCategoryDto>> getAllFacilityCategories();

    @Operation(
            summary = "Get Facility Category by ID",
            description = "Retrieves a single Facility Category using its unique ID."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Facility Category retrieved successfully"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Facility Category not found"
            )
    })
    @GetMapping("/facility-categories/{id}")
    ResponseEntity<CCResponseWrapper<FacilityCategoryDto>> getFacilityCategoryById(
            @PathVariable Long id
    );

    @Operation(
            summary = "Update Facility Category",
            description = "Updates an existing Facility Category using its unique ID."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Facility Category updated successfully"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Invalid request"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Facility Category not found"
            )
    })
    @PutMapping("/facility-categories/{id}")
    ResponseEntity<CCResponseWrapper<FacilityCategoryDto>> updateFacilityCategory(
            @PathVariable Long id,
            @RequestBody FacilityCategoryDto request
    );

    @Operation(
            summary = "Delete Facility Category",
            description = "Deletes an existing Facility Category using its unique ID."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "204",
                    description = "Facility Category deleted successfully"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Facility Category not found"
            )
    })
    @DeleteMapping("/facility-categories/{id}")
    ResponseEntity<CCResponseWrapper<FacilityCategoryDto>> deleteFacilityCategory(
            @PathVariable Long id
    );

    // FACILITY

    @Operation(
            summary = "Create a new Facility",
            description = "Creates a new Facility and returns the created Facility details."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "Facility created successfully"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Invalid request"
            )
    })
    @PostMapping("/facilities")
    ResponseEntity<CCResponseWrapper<FacilityDto>> createFacility(
            @RequestBody FacilityDto request
    );

    @Operation(
            summary = "Get all Facilities",
            description = "Retrieves all available Facilities."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Facilities retrieved successfully"
            )
    })
    @GetMapping("/facilities")
    ResponseEntity<CCResponseWrapper<FacilityDto>> getAllFacilities();

    @Operation(
            summary = "Get Facility by ID",
            description = "Retrieves a single Facility using its unique ID."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Facility retrieved successfully"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Facility not found"
            )
    })
    @GetMapping("/facilities/{id}")
    ResponseEntity<CCResponseWrapper<FacilityDto>> getFacilityById(
            @PathVariable Long id
    );

    @Operation(
            summary = "Update Facility",
            description = "Updates an existing Facility using its unique ID."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Facility updated successfully"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Invalid request"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Facility not found"
            )
    })
    @PutMapping("/facilities/{id}")
    ResponseEntity<CCResponseWrapper<FacilityDto>> updateFacility(
            @PathVariable Long id,
            @RequestBody FacilityDto request
    );

    @Operation(
            summary = "Delete Facility",
            description = "Deletes an existing Facility using its unique ID."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "204",
                    description = "Facility deleted successfully"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Facility not found"
            )
    })
    @DeleteMapping("/facilities/{id}")
    ResponseEntity<CCResponseWrapper<FacilityDto>> deleteFacility(
            @PathVariable Long id
    );
}