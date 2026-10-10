package lk.travelmarket.search_engine.dto.landmark;


import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Valid
public class LandMarkCategoryDto {
    private Long id;
    @NotEmpty(message = "Category cannot be Empty")
    @Size(min = 1, max = 50)
    private String category;
}
