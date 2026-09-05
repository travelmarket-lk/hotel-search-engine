package lk.travelmarket.search_engine.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lk.travelmarket.search_engine.dto.TestDto;
import lk.travelmarket.search_engine.network.CCResponseWrapper;
import lk.travelmarket.search_engine.util.EndpointConstants;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(EndpointConstants.V1 + EndpointConstants.TEST)
@Tag(
        name = "Test",
        description = "APIs for managing Test resources"
)
public interface ITestController {

    @Operation(
            summary = "Create a new Test",
            description = "Creates a new Test resource and returns the created Test details."
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
    ResponseEntity<CCResponseWrapper<TestDto>> create(
            @RequestBody TestDto request
    );

    @Operation(
            summary = "Get all Tests",
            description = "Retrieves all available Test resources."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Tests retrieved successfully"
            )
    })
    @GetMapping
    ResponseEntity<CCResponseWrapper<TestDto>> getAll();

    @Operation(
            summary = "Get Test by ID",
            description = "Retrieves a single Test resource using its unique ID."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Test retrieved successfully"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Test not found"
            )
    })
    @GetMapping("/{id}")
    ResponseEntity<CCResponseWrapper<TestDto>> getById(
            @PathVariable Long id
    );

    @Operation(
            summary = "Update Test",
            description = "Updates an existing Test resource using its unique ID."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Test updated successfully"
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
    ResponseEntity<CCResponseWrapper<TestDto>> update(
            @PathVariable Long id,
            @RequestBody TestDto request
    );

    @Operation(
            summary = "Delete Test",
            description = "Deletes an existing Test resource using its unique ID."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "204",
                    description = "Test deleted successfully"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Test not found"
            )
    })
    @DeleteMapping("/{id}")
    ResponseEntity<CCResponseWrapper<TestDto>> delete(
            @PathVariable Long id
    );

}
