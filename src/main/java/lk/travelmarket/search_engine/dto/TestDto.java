package lk.travelmarket.search_engine.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Schema(
        name = "Test",
        description = "Test resource"
)
public class TestDto {

    @Schema(
            description = "Unique identifier",
            example = "1",
            accessMode = Schema.AccessMode.READ_ONLY
    )
    private Long id;

    @Schema(
            description = "Name of the test",
            example = "Hotel Test"
    )
    @NotBlank
    private String name;

    @Schema(
            description = "Description of the test",
            example = "Test description"
    )
    private String description;

    public TestDto() {
    }

    public TestDto(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
}
