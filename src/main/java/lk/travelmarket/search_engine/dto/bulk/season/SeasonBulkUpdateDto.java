package lk.travelmarket.search_engine.dto.bulk.season;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import lk.travelmarket.search_engine.dto.SeasonDto;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Schema(
        name = "SeasonBulkUpdate",
        description = "Bulk season create, update and delete request"
)
public class SeasonBulkUpdateDto {

    @Valid
    @Schema(description = "Seasons to be created")
    private List<SeasonDto> created = new ArrayList<>();

    @Valid
    @Schema(description = "Seasons to be updated")
    private List<SeasonDto> updated = new ArrayList<>();

    @Schema(
            description = "Season IDs to be deleted",
            example = "[10, 11, 12]"
    )
    private List<Long> deleted = new ArrayList<>();
}
