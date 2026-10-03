package lk.travelmarket.search_engine.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardBasisDto {

    private Long id;

    @NotBlank(message = "Description is required")
    @Size(max = 255, message = "Description must be less than 255 characters")
    private  String name;

    @NotBlank(message = "Description is required")
    @Size(max = 255, message = "Description must be less than 255 characters")
    private String description;


    public BoardBasisDto(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;

    }
}
