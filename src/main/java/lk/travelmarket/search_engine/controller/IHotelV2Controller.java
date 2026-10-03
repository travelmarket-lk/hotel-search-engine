package lk.travelmarket.search_engine.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lk.travelmarket.search_engine.dto.SeasonDto;
import lk.travelmarket.search_engine.dto.bulk.season.SeasonBulkUpdateDto;
import lk.travelmarket.search_engine.network.CCResponseWrapper;
import lk.travelmarket.search_engine.util.EndpointConstants;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(EndpointConstants.V2 + EndpointConstants.HOTELS)
public interface IHotelV2Controller {


    @Operation(
            summary = "Get all hotel seasons",
            description = "Retrieve all available hotel season resources."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Hotel seasons retrieved successfully"
            )
    })
    @GetMapping("/{hotelId}/seasons")
    ResponseEntity<CCResponseWrapper<SeasonDto>> retrieveHotelSeasons(@PathVariable Long hotelId);

    @PatchMapping("/{hotelId}/seasons")
    ResponseEntity<CCResponseWrapper<SeasonBulkUpdateDto>> bulkSeasonsUpdate(
            @PathVariable Long hotelId,
            @Valid @RequestBody SeasonBulkUpdateDto request
    );
}
