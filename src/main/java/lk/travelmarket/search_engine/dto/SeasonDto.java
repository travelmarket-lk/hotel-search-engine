package lk.travelmarket.search_engine.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@Schema(
        name = "Season",
        description = "Season resource"
)
public class SeasonDto {

    @Schema(
            description = "Unique identifier",
            example = "1",
            accessMode = Schema.AccessMode.READ_ONLY
    )
    private Long id;

    @Schema(
            description = "Name of the season",
            example = "Summer Season"
    )
    @NotBlank
    private String seasonName;

    @Schema(
            description = "Season start date",
            example = "2026-04-01"
    )
    @NotNull
    private LocalDate startDate;

    @Schema(
            description = "Season end date",
            example = "2026-09-30"
    )
    @NotNull
    private LocalDate endDate;

    public SeasonDto() {
    }

    public SeasonDto(
            Long id,
            String seasonName,
            LocalDate startDate,
            LocalDate endDate) {

        this.id = id;
        this.seasonName = seasonName;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}