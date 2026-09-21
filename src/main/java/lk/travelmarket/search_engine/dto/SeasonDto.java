package lk.travelmarket.search_engine.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
    @NotBlank(message = "Season name is required")
    @Size(
            min = 2,
            max = 100,
            message = "Season name must be between 2 and 100 characters"
    )
    private String seasonName;

    @Schema(
            description = "Season start date",
            example = "2026-04-01"
    )
    @NotNull(message = "Start date is required")
    private LocalDate startDate;

    @Schema(
            description = "Season end date",
            example = "2026-09-30"
    )
    @NotNull(message = "End date is required")
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

    @AssertTrue(
            message = "End date must be equal to or after start date"
    )
    @Schema(hidden = true)
    public boolean isDateRangeValid() {

        if (startDate == null || endDate == null) {
            return true;
        }

        return !endDate.isBefore(startDate);
    }
}