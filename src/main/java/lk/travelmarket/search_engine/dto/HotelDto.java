package lk.travelmarket.search_engine.dto;

import java.util.List;

public class HotelDto {

    private Long id;
    private String name;
    private String description;
    private List<LandmarkDto> landmarks;

    public HotelDto() {
    }

    public HotelDto(Long id, String name, String description, List<LandmarkDto> landmarks) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.landmarks = landmarks;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<LandmarkDto> getLandmarks() {
        return landmarks;
    }

    public void setLandmarks(List<LandmarkDto> landmarks) {
        this.landmarks = landmarks;
    }
}