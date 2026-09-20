package lk.travelmarket.search_engine.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoomCategoryDto {

    private Long id;

    @NotBlank(message = "Room category name cannot be blank")
    @Size(min = 2, max = 50, message = "Room category name must be between 2 and 50 characters")
    private String name;

    public RoomCategoryDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
