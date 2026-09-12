package lk.travelmarket.search_engine.dto;

public class FacilityCategoryDto {

    private Long id;
    private String facilityCategory;

    public FacilityCategoryDto() {
    }

    public FacilityCategoryDto(Long id, String facilityCategory) {
        this.id = id;
        this.facilityCategory = facilityCategory;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFacilityCategory() {
        return facilityCategory;
    }

    public void setFacilityCategory(String facilityCategory) {
        this.facilityCategory = facilityCategory;
    }
}