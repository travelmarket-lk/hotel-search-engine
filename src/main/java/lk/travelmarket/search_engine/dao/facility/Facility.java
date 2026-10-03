package lk.travelmarket.search_engine.dao.facility;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

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

