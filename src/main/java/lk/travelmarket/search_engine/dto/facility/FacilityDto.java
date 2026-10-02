package lk.travelmarket.search_engine.dto.facility;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Valid
public class FacilityDto {

    private Long id;
    @NotEmpty
    @Size(min = 1, max = 50)
    private String facilityName;
    @NotEmpty
    @Size(min = 1, max = 50)
    private String facilityCategory;
    private String facilityIcon;
    private Long hotelId;
}