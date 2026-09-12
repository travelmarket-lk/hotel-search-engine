package lk.travelmarket.search_engine.dao.facility;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "facility_category")
@Getter
@Setter
public class FacilityCategory {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="facility_category", nullable = false)
    private String facilityCategory;

}
