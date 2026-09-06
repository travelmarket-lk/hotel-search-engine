package lk.travelmarket.search_engine.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lk.travelmarket.search_engine.dto.SeasonDto;
import lk.travelmarket.search_engine.network.CCResponseWrapper;
import lk.travelmarket.search_engine.util.EndpointConstants;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(EndpointConstants.V1 + EndpointConstants.SEASONS)
@Tag(
        name = "Season",
        description = "APIs for managing Season resources"
)
public interface ISeasonController {

    @Operation(
            summary = "Create a new Season",
            description = "Creates a new Season resource and returns the created Season details."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "Season created successfully"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Invalid request"
            )
    })
    @PostMapping
    ResponseEntity<CCResponseWrapper<SeasonDto>> create(
            @Valid @RequestBody SeasonDto request
    );

    @Operation(
            summary = "Get all Seasons",
            description = "Retrieves all available Season resources."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Seasons retrieved successfully"
            )
    })
    @GetMapping
    ResponseEntity<CCResponseWrapper<SeasonDto>> getAll();

    @Operation(
            summary = "Get Season by ID",
            description = "Retrieves a single Season resource using its unique ID."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Season retrieved successfully"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Season not found"
            )
    })
    @GetMapping("/{id}")
    ResponseEntity<CCResponseWrapper<SeasonDto>> getById(
            @PathVariable Long id
    );

    @Operation(
            summary = "Update Season",
            description = "Updates an existing Season resource using its unique ID."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Season updated successfully"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Invalid request"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Season not found"
            )
    })
    @PutMapping("/{id}")
    ResponseEntity<CCResponseWrapper<SeasonDto>> update(
            @PathVariable Long id,
            @Valid @RequestBody SeasonDto request
    );

    @Operation(
            summary = "Delete Season",
            description = "Deletes an existing Season resource using its unique ID."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "204",
                    description = "Season deleted successfully"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Season not found"
            )
    })
    @DeleteMapping("/{id}")
    ResponseEntity<CCResponseWrapper<SeasonDto>> delete(
            @PathVariable Long id
    );
}