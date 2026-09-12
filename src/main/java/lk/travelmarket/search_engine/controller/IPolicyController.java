package lk.travelmarket.search_engine.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lk.travelmarket.search_engine.dto.PolicyDto;
import lk.travelmarket.search_engine.network.CCResponseWrapper;
import lk.travelmarket.search_engine.util.EndpointConstants;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(EndpointConstants.V1 + EndpointConstants.POLICY)
@Tag(
        name = "Policy",
        description = "APIs for managing Policy resources"
)
public interface IPolicyController {

    @Operation(
            summary = "Create a new Policy",
            description = "Creates a new Policy resource and returns the created Policy details."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "Policy created successfully"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Invalid request"
            )
    })
    @PostMapping
    ResponseEntity<CCResponseWrapper<PolicyDto>> create(
            @RequestBody PolicyDto request
    );

    @Operation(
            summary = "Get all policies",
            description = "Retrieves all available policy resources."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "policies retrieved successfully"
            )
    })
    @GetMapping
    ResponseEntity<CCResponseWrapper<PolicyDto>> getAll();

    @Operation(
            summary = "Get policy by ID",
            description = "Retrieves a single policy resource using its unique ID."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "policy retrieved successfully"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "policy not found"
            )
    })
    @GetMapping("/{id}")
    ResponseEntity<CCResponseWrapper<PolicyDto>> getById(
            @PathVariable Long id
    );

    @Operation(
            summary = "Update policy",
            description = "Updates an existing policy resource using its unique ID."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "policy updated successfully"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Invalid request"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "policy not found"
            )
    })
    @PutMapping("/{id}")
    ResponseEntity<CCResponseWrapper<PolicyDto>> update(
            @PathVariable Long id,
            @RequestBody PolicyDto request
    );

    @Operation(
            summary = "Delete policy",
            description = "Deletes an existing policy resource using its unique ID."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "204",
                    description = "policy deleted successfully"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "policy not found"
            )
    })
    @DeleteMapping("/{id}")
    ResponseEntity<CCResponseWrapper<PolicyDto>> delete(
            @PathVariable Long id
    );

}
