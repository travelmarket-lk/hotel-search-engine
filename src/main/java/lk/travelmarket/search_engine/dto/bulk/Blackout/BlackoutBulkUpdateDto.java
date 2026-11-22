package lk.travelmarket.search_engine.dto.bulk.Blackout;


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
        name = "Blackout Bulk Update",
        description = "Bulk Blackout create, update and delete request"
)
public class BlackoutBulkUpdateDto {

    @Valid
    @Schema(description = "Blackouts to be created")
    private  List<BlackoutsDto> created = new ArrayList<>();

    @Valid
    @Schema(description = "Blackouts to be updated")
    private  List<BlackoutsDto> updated = new ArrayList<>();

    @Schema(
            description = "Blackout Ids for Deleted",
            example = "[9,10,11]"
    )
    private  List<Long> deleted = new ArrayList<>();

}

