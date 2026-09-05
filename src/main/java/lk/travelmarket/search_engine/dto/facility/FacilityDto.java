package lk.travelmarket.search_engine.dto.facility;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FacilityDto {

    private Long id;
    private String facilityName;
    private Long facilityCategory;
    private Long facilityIcon;
    private Long hotelId;  // ← ADD THIS
}