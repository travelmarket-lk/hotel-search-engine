package lk.travelmarket.search_engine.dto;

import lk.travelmarket.search_engine.dto.facility.FacilityDto;
import java.util.List;

public class HotelDto {

    private Long id;
    private String name;
    private String description;
    private String locationHighlight;
    private Integer starRating;

    private AddressDto address;

    public HotelDto() {
    }

    public HotelDto(Long id, String name, String description,
                    String locationHighlight, Integer starRating, AddressDto address) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.locationHighlight = locationHighlight;
        this.starRating = starRating;
        this.address = address;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getLocationHighlight() { return locationHighlight; }
    public void setLocationHighlight(String locationHighlight) { this.locationHighlight = locationHighlight; }

    public Integer getStarRating() { return starRating; }
    public void setStarRating(Integer starRating) { this.starRating = starRating; }

    public AddressDto getAddress() { return address; }
    public void setAddress(AddressDto address) { this.address = address; }

}
