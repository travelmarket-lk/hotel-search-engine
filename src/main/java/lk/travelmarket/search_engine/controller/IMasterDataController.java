package lk.travelmarket.search_engine.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lk.travelmarket.search_engine.dao.HotelRoom.BedType;
import lk.travelmarket.search_engine.dto.*;
import lk.travelmarket.search_engine.dao.RoomCategory;
import lk.travelmarket.search_engine.dto.hotel.HotelTypeDto;
import lk.travelmarket.search_engine.dto.facility.FacilityDto;
import lk.travelmarket.search_engine.dto.facility.FacilityCategoryDto;
import lk.travelmarket.search_engine.network.CCResponseWrapper;
import lk.travelmarket.search_engine.util.EndpointConstants;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
            @Valid @RequestBody DistrictDto request
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
            @Positive(message = "District ID must be greater than 0")
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
            @Positive(message = "District ID must be greater than 0")
            @PathVariable Long id,
            @Valid @RequestBody DistrictDto request
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
            @Positive(message = "District ID must be greater than 0")
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
            @Valid @RequestBody CityDto request
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
            @Positive(message = "City ID must be greater than 0")
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
            @Positive(message = "City ID must be greater than 0")
            @Valid @RequestBody CityDto request
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
            @Positive(message = "City ID must be greater than 0")
            @PathVariable Long id
    );

// BED TYPES

    @GetMapping(EndpointConstants.BED_TYPES)
    public ResponseEntity<CCResponseWrapper<BedType>> getAllBedTypes();

    @PostMapping(EndpointConstants.BED_TYPES)
    public ResponseEntity<CCResponseWrapper<BedType>> addBedType(@Valid @RequestBody BedType bedType);

    @DeleteMapping(EndpointConstants.BED_TYPES_ID)
    public ResponseEntity<CCResponseWrapper<Void>> deleteBedType(@PathVariable Long id);

    @GetMapping(EndpointConstants.BED_TYPES_ID)
    public ResponseEntity<CCResponseWrapper<BedType>> getBedTypeById(@PathVariable("id") Long id);

    @PutMapping(EndpointConstants.BED_TYPES_ID)
    public ResponseEntity<CCResponseWrapper<BedType>> updateBedType(@PathVariable("id") Long id, @Valid @RequestBody BedType bedType);
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
    @PostMapping("/room-category")
    ResponseEntity<CCResponseWrapper<RoomCategoryDto>> createRoomCategory(
            @Valid
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
    @GetMapping("/room-category")
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
    @GetMapping("/room-category/{id}")
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
    @PutMapping("/room-category/{id}")
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
    @DeleteMapping("/room-category/{id}")
    ResponseEntity<CCResponseWrapper<RoomCategoryDto>> deleteRoomCategory(
            @PathVariable Long id
    );

    // ---------------------------- HotelType ----------------------------
    @GetMapping(HOTEL_TYPES)
    ResponseEntity<CCResponseWrapper<HotelTypeDto>> findAllHotelTypes();

    @GetMapping(HOTEL_TYPE_BY_ID)
    ResponseEntity<CCResponseWrapper<HotelTypeDto>> findHotelTypeById(@PathVariable Long id);

    @PostMapping(HOTEL_TYPES)
    ResponseEntity<CCResponseWrapper<HotelTypeDto>> saveHotelType(@RequestBody HotelTypeDto hotelTypeDto);

    @PutMapping(HOTEL_TYPE_BY_ID)
    ResponseEntity<CCResponseWrapper<HotelTypeDto>> updateHotelType(@PathVariable Long id, @RequestBody HotelTypeDto hotelTypeDto);

    @DeleteMapping(HOTEL_TYPE_BY_ID)
    ResponseEntity<CCResponseWrapper<HotelTypeDto>> deleteHotelType(@PathVariable Long id);

    // ---------------------------- Facility ----------------------------
    @GetMapping(FACILITIES)
    ResponseEntity<CCResponseWrapper<FacilityDto>> findAllFacilities();

    @GetMapping(FACILITY_BY_ID)
    ResponseEntity<CCResponseWrapper<FacilityDto>> findFacilityById(@PathVariable Long id);

    @PostMapping(FACILITIES)
    ResponseEntity<CCResponseWrapper<FacilityDto>> saveFacility(@RequestBody FacilityDto facilityDto);

    @PutMapping(FACILITY_BY_ID)
    ResponseEntity<CCResponseWrapper<FacilityDto>> updateFacility(@PathVariable Long id, @RequestBody FacilityDto facilityDto);

    @DeleteMapping(FACILITY_BY_ID)
    ResponseEntity<CCResponseWrapper<FacilityDto>> deleteFacility(@PathVariable Long id);

    // ------------------------- FacilityCategory -------------------------
    @GetMapping(FACILITY_CATEGORIES)
    ResponseEntity<CCResponseWrapper<FacilityCategoryDto>> findAllFacilityCategories();

    @GetMapping(FACILITY_CATEGORY_BY_ID)
    ResponseEntity<CCResponseWrapper<FacilityCategoryDto>> findFacilityCategoryById(@PathVariable Long id);

    @PostMapping(FACILITY_CATEGORIES)
    ResponseEntity<CCResponseWrapper<FacilityCategoryDto>> saveFacilityCategory(@RequestBody FacilityCategoryDto facilityCategoryDto);

    @PutMapping(FACILITY_CATEGORY_BY_ID)
    ResponseEntity<CCResponseWrapper<FacilityCategoryDto>> updateFacilityCategory(@PathVariable Long id, @RequestBody FacilityCategoryDto facilityCategoryDto);

    @DeleteMapping(FACILITY_CATEGORY_BY_ID)
    ResponseEntity<CCResponseWrapper<FacilityCategoryDto>> deleteFacilityCategory(@PathVariable Long id);



    @Operation(
            summary = "Create a new Board Basis",
            description = "Creates a new Board basis resource and returns the created Test details."
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
    @PostMapping("/board-basis")
    ResponseEntity<CCResponseWrapper<BoardBasisDto>> createBoardBasis(
            @Valid
            @RequestBody BoardBasisDto request
    );

    @Operation(
            summary = "Get all Board Basis",
            description = "Retrieves all available Board Basis resources."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Board basis retrieved successfully"
            )
    })
    @GetMapping("/board-basis")
    ResponseEntity<CCResponseWrapper<BoardBasisDto>> findAllBoardBasis();

    @Operation(
            summary = "Get Board Basis by ID",
            description = "Retrieves a single Board basis resource using its unique ID."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Board basis retrieved successfully"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Board Basis not found"
            )
    })
    @GetMapping("/board-basis/{id}")
    ResponseEntity<CCResponseWrapper<BoardBasisDto>> findBoardBasisById(
            @PathVariable Long id
    );

    @Operation(
            summary = "Update Bord basis",
            description = "Updates an existing Board Basis resource using its unique ID."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Board Basis updated successfully"
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
    @PutMapping("/board-basis/{id}")
    ResponseEntity<CCResponseWrapper<BoardBasisDto>> updateBoardBasis(
            @PathVariable Long id,
            @RequestBody BoardBasisDto request
    );

    @Operation(
            summary = "Delete Board Basis",
            description = "Deletes an existing Board Basis resource using its unique ID."
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
    @DeleteMapping("/board-basis/{id}")
    ResponseEntity<CCResponseWrapper<BoardBasisDto>> deleteBoardBasis(
            @PathVariable Long id
    );


    @Operation(
            summary = "Create a new Room Type",
            description = "Creates a new Room Type resource and returns the created Test details."
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
    @PostMapping("/room-type")
    ResponseEntity<CCResponseWrapper<RoomTypeDto>> createRoomType(
            @Valid
            @RequestBody RoomTypeDto request
    );

    @Operation(
            summary = "Get all Room Type",
            description = "Retrieves all available Room Type resources."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Room Type retrieved successfully"
            )
    })
    @GetMapping("/room-type")
    ResponseEntity<CCResponseWrapper<RoomTypeDto>> findAllRoomType();

    @Operation(
            summary = "Get Room Type by ID",
            description = "Retrieves a single Room Type resource using its unique ID."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Room Type retrieved successfully"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Board Basis not found"
            )
    })
    @GetMapping("/room-type/{id}")
    ResponseEntity<CCResponseWrapper<RoomTypeDto>> findRoomTypeById(
            @PathVariable Long id
    );

    @Operation(
            summary = "Update Room Type",
            description = "Updates an existing Room Type resource using its unique ID."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Room Type updated successfully"
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
    @PutMapping("/room-type/{id}")
    ResponseEntity<CCResponseWrapper<RoomTypeDto>> updateRoomType(
            @PathVariable Long id,
            @RequestBody RoomTypeDto request
    );

    @Operation(
            summary = "Delete Room Type",
            description = "Deletes an existing Room Type resource using its unique ID."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "204",
                    description = "Room Type deleted successfully"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Test not found"
            )
    })
    @DeleteMapping("/room-type/{id}")
    ResponseEntity<CCResponseWrapper<RoomTypeDto>> deleteRoomType(
            @PathVariable Long id
    );

}