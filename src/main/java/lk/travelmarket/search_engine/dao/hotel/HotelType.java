package lk.travelmarket.search_engine.dao.hotel;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "hotel_type")
@Getter
@Setter
public class HotelType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "hotel_type", nullable = false, unique = true)
    private String hotelType;
}