package lk.travelmarket.search_engine.dao.facilities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "facility")
@Getter
@Setter
public class facility {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "facility_name", nullable = false)
    private String facilityName;

    @Column(name = "hotel_id", nullable = false)
    private Long hotelId;

    @Column(name = "room_id")
    private Long roomId;
}