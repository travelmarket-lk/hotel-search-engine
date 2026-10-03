package lk.travelmarket.search_engine.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
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

    @Schema(
            description = "Number of rooms available",
            example = "10"
    )
    @NotNull(message = "Room count is required")
    @Positive(message = "Room count must be greater than 0")
    private Integer roomCount;

    @Schema(
            description = "Room name",
            example = "Deluxe Double Room"
    )
    @NotBlank(message = "Room name is required")
    @Size(
            min = 2,
            max = 100,
            message = "Room name must be between 2 and 100 characters"
    )
    private String roomName;

    @Schema(
            description = "Room description",
            example = "Spacious deluxe room with sea view"
    )
    @Size(
            max = 1000,
            message = "Room description cannot exceed 1000 characters"
    )
    private String description;

    @Schema(
            description = "Minimum pax count",
            example = "1"
    )
    @NotNull(message = "Minimum pax count is required")
    @Positive(message = "Minimum pax count must be greater than 0")
    private Integer minPaxCount;

    @Schema(
            description = "Maximum pax count",
            example = "3"
    )
    @NotNull(message = "Maximum pax count is required")
    @Positive(message = "Maximum pax count must be greater than 0")
    private Integer maxPaxCount;

    @Schema(
            description = "Room size",
            example = "35"
    )
    @NotNull(message = "Room size is required")
    @Positive(message = "Room size must be greater than 0")
    private Integer roomSize;

    @Schema(
            description = "Room view type",
            example = "Sea View"
    )
    @NotBlank(message = "View type is required")
    @Size(
            max = 100,
            message = "View type cannot exceed 100 characters"
    )
    private String viewType;

    @Schema(
            description = "Hotel ID",
            example = "1"
    )
    @NotNull(message = "Hotel ID is required")
    @Positive(message = "Hotel ID must be greater than 0")
    private Long hotelId;

    @Schema(
            description = "Bed type IDs assigned to the room",
            example = "[1, 2]"
    )
    @NotEmpty(message = "At least one bed type is required")
    private Set<
            @NotNull(message = "Bed type ID cannot be null")
            @Positive(message = "Bed type ID must be greater than 0")
                    Long> bedTypeIds;

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

    @AssertTrue(
            message = "Maximum pax count must be greater than or equal to minimum pax count"
    )
    @Schema(hidden = true)
    public boolean isPaxRangeValid() {

        if (minPaxCount == null || maxPaxCount == null) {
            return true;
        }

        return maxPaxCount >= minPaxCount;
    }
}