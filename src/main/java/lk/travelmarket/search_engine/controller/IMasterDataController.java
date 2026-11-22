package lk.travelmarket.search_engine.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lk.travelmarket.search_engine.dao.HotelRoom.BedType;
import lk.travelmarket.search_engine.dto.CityDto;
import lk.travelmarket.search_engine.dto.DistrictDto;
import lk.travelmarket.search_engine.dto.RoomCategoryDto;
import lk.travelmarket.search_engine.dto.hotel.HotelTypeDto;
import lk.travelmarket.search_engine.dto.facility.FacilityDto;
import lk.travelmarket.search_engine.dto.facility.FacilityCategoryDto;
import lk.travelmarket.search_engine.dto.landmark.LandMarkCategoryDto;
import lk.travelmarket.search_engine.network.CCResponseWrapper;
import lk.travelmarket.search_engine.util.EndpointConstants;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static lk.travelmarket.search_engine.util.Constants.*;
import static lk.travelmarket.search_engine.util.EndpointConstants.*;

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

    // ---------------------------- HotelType ----------------------------

    @Operation(
            summary = "Get all Hotel Types",
            description = "Retrieves all available Hotel Types.")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Hotel Types retrieved successfully")
    })
    @GetMapping(HOTEL_TYPES)
    ResponseEntity<CCResponseWrapper<HotelTypeDto>> findAllHotelTypes();

    @Operation(
            summary = "Get Hotel Type by ID",
            description = "Retrieves a single Hotel Type using its ID.")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Hotel Type retrieved successfully"),
            @ApiResponse(
                    responseCode = "404",
                    description = "Hotel Type not found")
    })
    @GetMapping(HOTEL_TYPE_BY_ID)
    ResponseEntity<CCResponseWrapper<HotelTypeDto>> findHotelTypeById(
            @PathVariable @Positive Long id);

    @Operation(
            summary = "Create a new Hotel Type", description = "Creates a Hotel Type and returns its details.")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "Hotel Type created successfully"),
            @ApiResponse(
                    responseCode = "400",
                    description = "Invalid request or duplicate")
    })
    @PostMapping(HOTEL_TYPES)
    ResponseEntity<CCResponseWrapper<HotelTypeDto>> createHotelType(
            @Valid @RequestBody HotelTypeDto hotelTypeDto);

    @Operation(
            summary = "Update Hotel Type",
            description = "Updates an existing Hotel Type using its ID.")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Hotel Type updated successfully"),
            @ApiResponse(
                    responseCode = "400",
                    description = "Invalid request or duplicate"),
            @ApiResponse(
                    responseCode = "404",
                    description = "Hotel Type not found")
    })
    @PutMapping(HOTEL_TYPE_BY_ID)
    ResponseEntity<CCResponseWrapper<HotelTypeDto>> updateHotelType(
            @PathVariable @Positive Long id,
            @Valid @RequestBody HotelTypeDto hotelTypeDto);

    @Operation(
            summary = "Delete Hotel Type",
            description = "Deletes a Hotel Type using its ID.")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Hotel Type deleted successfully"),
            @ApiResponse(
                    responseCode = "404",
                    description = "Hotel Type not found")
    })
    @DeleteMapping(HOTEL_TYPE_BY_ID)
    ResponseEntity<CCResponseWrapper<HotelTypeDto>> deleteHotelType(
            @PathVariable @Positive Long id);


    // ---------------------------- Facility ----------------------------

    @Operation(
            summary = "Get all Facilities",
            description = "Retrieves all available Facilities.")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Facilities retrieved successfully")
    })
    @GetMapping(FACILITIES)
    ResponseEntity<CCResponseWrapper<FacilityDto>> findAllFacilities();

    @Operation(
            summary = "Get Facility by ID",
            description = "Retrieves a single Facility using its ID.")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Facility retrieved successfully"),
            @ApiResponse(
                    responseCode = "404",
                    description = "Facility not found")
    })
    @GetMapping(FACILITY_BY_ID)
    ResponseEntity<CCResponseWrapper<FacilityDto>> findFacilityById(
            @PathVariable @Positive Long id);

    @Operation(
            summary = "Create a new Facility",
            description = "Creates a Facility and returns its details.")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "Facility created successfully"),
            @ApiResponse(
                    responseCode = "400",
                    description = "Invalid request or duplicate")
    })
    @PostMapping(FACILITIES)
    ResponseEntity<CCResponseWrapper<FacilityDto>> createFacility(
            @Valid @RequestBody FacilityDto facilityDto);

    @Operation(
            summary = "Update Facility",
            description = "Updates an existing Facility using its ID.")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Facility updated successfully"),
            @ApiResponse(
                    responseCode = "400",
                    description = "Invalid request or duplicate"),
            @ApiResponse(
                    responseCode = "404",
                    description = "Facility not found")
    })
    @PutMapping(FACILITY_BY_ID)
    ResponseEntity<CCResponseWrapper<FacilityDto>> updateFacility(
            @PathVariable @Positive Long id,
            @Valid @RequestBody FacilityDto facilityDto);

    @Operation(summary = "Delete Facility",
            description = "Deletes a Facility using its ID.")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Facility deleted successfully"),
            @ApiResponse(
                    responseCode = "404",
                    description = "Facility not found")
    })
    @DeleteMapping(FACILITY_BY_ID)
    ResponseEntity<CCResponseWrapper<FacilityDto>> deleteFacility(
            @PathVariable @Positive Long id);


    // ------------------------- FacilityCategory -------------------------

    @Operation(
            summary = "Get all Facility Categories",
            description = "Retrieves all available Facility Categories.")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Facility Categories retrieved successfully")
    })
    @GetMapping(FACILITY_CATEGORIES)
    ResponseEntity<CCResponseWrapper<FacilityCategoryDto>> findAllFacilityCategories();

    @Operation(
            summary = "Get Facility Category by ID", description = "Retrieves a single Facility Category using its ID.")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Facility Category retrieved successfully"),
            @ApiResponse(
                    responseCode = "404",
                    description = "Facility Category not found")
    })
    @GetMapping(FACILITY_CATEGORY_BY_ID)
    ResponseEntity<CCResponseWrapper<FacilityCategoryDto>> findFacilityCategoryById(
            @PathVariable @Positive Long id);

    @Operation(
            summary = "Create a new Facility Category",
            description = "Creates a Facility Category and returns its details.")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "Facility Category created successfully"),
            @ApiResponse(
                    responseCode = "400",
                    description = "Invalid request or duplicate")
    })
    @PostMapping(FACILITY_CATEGORIES)
    ResponseEntity<CCResponseWrapper<FacilityCategoryDto>> createFacilityCategory(
            @Valid @RequestBody FacilityCategoryDto facilityCategoryDto);

    @Operation(
            summary = "Update Facility Category",
            description = "Updates an existing Facility Category using its ID.")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Facility Category updated successfully"),
            @ApiResponse(
                    responseCode = "400",
                    description = "Invalid request or duplicate"),
            @ApiResponse(
                    responseCode = "404",
                    description = "Facility Category not found")
    })
    @PutMapping(FACILITY_CATEGORY_BY_ID)
    ResponseEntity<CCResponseWrapper<FacilityCategoryDto>> updateFacilityCategory(
            @PathVariable @Positive Long id,
            @Valid @RequestBody FacilityCategoryDto facilityCategoryDto);

    @Operation(
            summary = "Delete Facility Category",
            description = "Deletes a Facility Category using its ID.")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Facility Category deleted successfully"),
            @ApiResponse(
                    responseCode = "404",
                    description = "Facility Category not found")
    })
    @DeleteMapping(FACILITY_CATEGORY_BY_ID)
    ResponseEntity<CCResponseWrapper<FacilityCategoryDto>> deleteFacilityCategory(
            @PathVariable @Positive Long id);


    // ------------------------- Landmark Category -------------------------

    @Operation(
            summary = "Get all Landmark Categories", description = "Retrieves all available Landmark Categories.")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Landmark Categories retrieved successfully")
    })
    @GetMapping(LANDMARK_CATEGORIES)
    ResponseEntity<CCResponseWrapper<LandMarkCategoryDto>> findAllLandmarkCategories();

    @Operation(
            summary = "Get Landmark Category by ID",
            description = "Retrieves a single Landmark Category using its ID.")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Landmark Category retrieved successfully"),
            @ApiResponse(
                    responseCode = "404",
                    description = "Landmark Category not found")
    })
    @GetMapping(LANDMARK_CATEGORY_BY_ID)
    ResponseEntity<CCResponseWrapper<LandMarkCategoryDto>> findLandmarkCategoryById(
            @PathVariable @Positive Long id);

    @Operation(
            summary = "Create a new Landmark Category",
            description = "Creates a Landmark Category and returns its details.")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "Landmark Category created successfully"),
            @ApiResponse(
                    responseCode = "400",
                    description = "Invalid request or duplicate")
    })
    @PostMapping(LANDMARK_CATEGORIES)
    ResponseEntity<CCResponseWrapper<LandMarkCategoryDto>> createLandmarkCategory(
            @Valid @RequestBody LandMarkCategoryDto landMarkCategoryDto);

    @Operation(
            summary = "Update Landmark Category",
            description = "Updates an existing Landmark Category using its ID.")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Landmark Category updated successfully"),
            @ApiResponse(
                    responseCode = "400",
                    description = "Invalid request or duplicate"),
            @ApiResponse(
                    responseCode = "404",
                    description = "Landmark Category not found")
    })
    @PutMapping(LANDMARK_CATEGORY_BY_ID)
    ResponseEntity<CCResponseWrapper<LandMarkCategoryDto>> updateLandmarkCategory(
            @PathVariable @Positive Long id,
            @Valid @RequestBody LandMarkCategoryDto landMarkCategoryDto);

    @Operation(
            summary = "Delete Landmark Category", description = "Deletes a Landmark Category using its ID.")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Landmark Category deleted successfully"),
            @ApiResponse(
                    responseCode = "404",
                    description = "Landmark Category not found")
    })
    @DeleteMapping(LANDMARK_CATEGORY_BY_ID)
    ResponseEntity<CCResponseWrapper<LandMarkCategoryDto>> deleteLandmarkCategory(
            @PathVariable @Positive Long id);

}



