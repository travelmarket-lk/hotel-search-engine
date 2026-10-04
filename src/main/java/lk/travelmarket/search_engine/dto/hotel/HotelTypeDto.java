package lk.travelmarket.search_engine.dto.hotel;


import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Valid
public class HotelTypeDto {

    private Long id;
    @NotEmpty(message = "Hotel Type Cannot Be Empty")
    @Size(min = 1, max = 50)
    private String hotelType;}
