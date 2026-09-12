package lk.travelmarket.search_engine.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardBasisDto {

    private Long id;
    private  String name;
    private String description;


    public BoardBasisDto(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;

    }
}
