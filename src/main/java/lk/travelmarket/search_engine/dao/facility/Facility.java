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

    @Column(name = "name", nullable = false)
    private String facilityName;

    @Column(name = "category", nullable = false)
    private String facilityCategory;

    @Column(name = "icon")
    private String facilityIcon;
}

