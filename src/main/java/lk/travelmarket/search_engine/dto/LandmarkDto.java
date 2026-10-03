package lk.travelmarket.search_engine.dto;

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