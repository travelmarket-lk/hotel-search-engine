package lk.travelmarket.search_engine.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DistrictDto {

    private Long id;

    @NotBlank(message = "District name is required")
    @Size(
            min = 2,
            max = 100,
            message = "District name must be between 2 and 100 characters"
    )
    private String name;

    public DistrictDto() {
    }

    public DistrictDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

}