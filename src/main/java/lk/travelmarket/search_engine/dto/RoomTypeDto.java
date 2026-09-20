package lk.travelmarket.search_engine.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoomTypeDto {

    private Long id;

    @NotBlank(message = "Room type cannot be blank")
    @Size(min = 2, max = 50, message = "Room type must be between 2 and 50 characters")
    private String type;

    public RoomTypeDto(Long id, String type){

        this.id = id;
        this.type = type;
    }
}
