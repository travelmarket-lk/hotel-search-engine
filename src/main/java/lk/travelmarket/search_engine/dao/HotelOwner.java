package lk.travelmarket.search_engine.dao;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table( name = "hotel_owner")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HotelOwner {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String phoneNumber;

    private String nic;

    private String email;
}
