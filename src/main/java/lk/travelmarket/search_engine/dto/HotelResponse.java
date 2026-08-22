package lk.travelmarket.search_engine.dto;

import lk.travelmarket.search_engine.dao.hotel.Hotel;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HotelResponse {

    private Long id;
    private String name;
    private String description;

    public static HotelResponse form(Hotel hotel){
        return HotelResponse.builder()
                .id(hotel.getId())
                .name(hotel.getName())
                .name(hotel.getDescription())
                .build();

    }

}
