package lk.travelmarket.search_engine.dao.hotel;

import jakarta.persistence.*;
import lk.travelmarket.search_engine.dao.facility.Facility;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(
        name = "hotel_facility",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_hotel_facility",
                        columnNames = {"hotel_id", "facility_id"}
                )
        }
)
@Getter
@Setter
public class HotelFacility {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hotel_id", nullable = false)
    private Hotel hotel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "facility_id", nullable = false)
    private Facility facility;


}
