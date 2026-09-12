package lk.travelmarket.search_engine.dto.facility;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FacilityDto {

    private Long id;
    private String title;
    private FacilityCategoryDto category;
    private String icon;
}