package lk.travelmarket.search_engine.dao.facilities;

import jakarta.persistence.*;
import lk.travelmarket.search_engine.dao.hotel.Hotel;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "facility")
@Getter
@Setter
public class Facility {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "facility_name", nullable = false)
    private String facilityName;

    @Column(name = "facility_category", nullable = false)
    private Long facilityCategory;

    @Column(name = "facility_icon")
    private Long facilityIcon;
}