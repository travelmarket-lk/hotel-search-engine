package lk.travelmarket.search_engine.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lk.travelmarket.search_engine.dto.BoardBasisDto;
import lk.travelmarket.search_engine.dto.RoomCategoryDto;
import lk.travelmarket.search_engine.dto.RoomTypeDto;
import lk.travelmarket.search_engine.network.CCResponseWrapper;
import lk.travelmarket.search_engine.util.EndpointConstants;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(EndpointConstants.V1 + EndpointConstants.DATA)
public interface IDataController {
    //---------Room Category-----------
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
    ResponseEntity<CCResponseWrapper<RoomCategoryDto>> findAllRoomCategories(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    );

    //---------Board Basis-------------
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
    ResponseEntity<CCResponseWrapper<BoardBasisDto>> findAllBoardBasis(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    );

    //---------Room Type---------------
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
    ResponseEntity<CCResponseWrapper<RoomTypeDto>> findAllRoomType(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    );

}
