package lk.travelmarket.search_engine.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@Schema(name = "Room", description = "Room resource")
public class RoomDto {

    @Schema(
            description = "Unique identifier",
            example = "1",
            accessMode = Schema.AccessMode.READ_ONLY
    )
    private Long id;

    @Schema(description = "Number of rooms", example = "10")
    @NotNull
    private Integer roomCount;

    @Schema(description = "Room name", example = "Deluxe Double Room")
    @NotBlank
    private String roomName;

    @Schema(
            description = "Room description",
            example = "Spacious deluxe room with sea view"
    )
    private String description;

    @Schema(description = "Minimum pax count", example = "1")
    @NotNull
    private Integer minPaxCount;

    @Schema(description = "Maximum pax count", example = "3")
    @NotNull
    private Integer maxPaxCount;

    @Schema(description = "Room size", example = "35")
    @NotNull
    private Integer roomSize;

    @Schema(description = "Room view type", example = "Sea View")
    @NotBlank
    private String viewType;

    @Schema(description = "Hotel ID", example = "1")
    @NotNull
    private Long hotelId;

    @Schema(
            description = "Bed type IDs assigned to the room",
            example = "[1, 2]"
    )
    private Set<Long> bedTypeIds;

    public RoomDto() {
    }

    public RoomDto(
            Long id,
            Integer roomCount,
            String roomName,
            String description,
            Integer minPaxCount,
            Integer maxPaxCount,
            Integer roomSize,
            String viewType,
            Long hotelId,
            Set<Long> bedTypeIds
    ) {
        this.id = id;
        this.roomCount = roomCount;
        this.roomName = roomName;
        this.description = description;
        this.minPaxCount = minPaxCount;
        this.maxPaxCount = maxPaxCount;
        this.roomSize = roomSize;
        this.viewType = viewType;
        this.hotelId = hotelId;
        this.bedTypeIds = bedTypeIds;
    }
}