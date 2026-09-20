package lk.travelmarket.search_engine.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoomTypeDto {

    private Long id;
    private String type;

    public RoomTypeDto(Long id, String type){

        this.id = id;
        this.type = type;
    }
}
