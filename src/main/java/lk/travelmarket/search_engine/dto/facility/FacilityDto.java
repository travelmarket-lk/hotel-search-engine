package lk.travelmarket.search_engine.dto.facility;
import lk.travelmarket.search_engine.dao.hotel.Hotel;
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

    public FacilityDto() {
    }

    public FacilityDto(Long id, String facilityName, Long facilityCategory,
                       Long facilityIcon, Long hotelId) {
        this.id = id;
        this.facilityName = facilityName;
        this.facilityCategory = facilityCategory;
        this.facilityIcon = facilityIcon;
        this.hotelId = hotelId;
    }

}