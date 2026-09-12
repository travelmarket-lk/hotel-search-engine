package lk.travelmarket.search_engine.dao.facility;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "facility_category_id", nullable = false)
    private FacilityCategory facilityCategory;

    @Column(name = "facility_icon")
    private String facilityIcon;
}