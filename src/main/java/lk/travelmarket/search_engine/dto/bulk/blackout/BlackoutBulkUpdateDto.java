package lk.travelmarket.search_engine.dto.bulk.blackout;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import lk.travelmarket.search_engine.dto.BlackoutsDto;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Schema(
        name = "BlackoutBulkUpdate",
        description = "Bulk blackout create, update and delete request"
)
public class BlackoutBulkUpdateDto {

    @Valid
    @Schema(description = "Blackouts to be created")
    private List<BlackoutsDto> created = new ArrayList<>();

    @Valid
    @Schema(description = "Blackouts to be updated")
    private List<BlackoutsDto> updated = new ArrayList<>();

    @Schema(
            description = "Blackout IDs to be deleted",
            example = "[10, 11, 12]"
    )
    private List<Long> deleted = new ArrayList<>();
}