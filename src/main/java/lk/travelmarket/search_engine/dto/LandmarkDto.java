package lk.travelmarket.search_engine.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;


public class LandmarkDto {

    private Long id;
    private String landmarkName;
    private Double landmarkDist;
    private Long hotelId;

    public LandmarkDto() {
    }

    public LandmarkDto(Long id, String landmarkName, Double landmarkDist, Long hotelId) {
        this.id = id;
        this.landmarkName = landmarkName;
        this.landmarkDist = landmarkDist;
        this.hotelId = hotelId;
    }

    public LandmarkDto(Long id, @NotBlank(message = "Landmark name is required and cannot be blank") @Size(max = 255, message = "Landmark name must not exceed 255 characters") String landmarkName, @NotNull(message = "Landmark distance is required") @PositiveOrZero(message = "Landmark distance must be greater than or equal to 0") Double landmarkDist) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLandmarkName() {
        return landmarkName;
    }

    public void setLandmarkName(String landmarkName) {
        this.landmarkName = landmarkName;
    }

    public Double getLandmarkDist() {
        return landmarkDist;
    }

    public void setLandmarkDist(Double landmarkDist) {
        this.landmarkDist = landmarkDist;
    }

    public Long getHotelId() {
        return hotelId;
    }

    public void setHotelId(Long hotelId) {
        this.hotelId = hotelId;
    }

}