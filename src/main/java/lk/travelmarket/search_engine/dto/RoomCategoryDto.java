package lk.travelmarket.search_engine.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoomCategoryDto {

    private Long id;
    private String name;

    public RoomCategoryDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
