package lk.travelmarket.search_engine.dto;

public class FacilityDto {

    private Long id;
    private String facilityName;
    private Long facilityCategoryId;
    private String facilityIcon;

    public FacilityDto() {
    }

    public FacilityDto(Long id, String facilityName, Long facilityCategoryId, String facilityIcon) {
        this.id = id;
        this.facilityName = facilityName;
        this.facilityCategoryId = facilityCategoryId;
        this.facilityIcon = facilityIcon;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFacilityName() {
        return facilityName;
    }

    public void setFacilityName(String facilityName) {
        this.facilityName = facilityName;
    }

    public Long getFacilityCategoryId() {
        return facilityCategoryId;
    }

    public void setFacilityCategoryId(Long facilityCategoryId) {
        this.facilityCategoryId = facilityCategoryId;
    }

    public String getFacilityIcon() {
        return facilityIcon;
    }

    public void setFacilityIcon(String facilityIcon) {
        this.facilityIcon = facilityIcon;
    }
}