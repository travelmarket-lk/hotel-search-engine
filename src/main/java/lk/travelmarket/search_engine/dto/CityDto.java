package lk.travelmarket.search_engine.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CityDto {

    private Long id;

    @NotBlank(message = "City name is required")
    @Size(
            min = 2,
            max = 100,
            message = "City name must be between 2 and 100 characters"
    )
    private String name;

    public CityDto() {
    }

    public CityDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

}