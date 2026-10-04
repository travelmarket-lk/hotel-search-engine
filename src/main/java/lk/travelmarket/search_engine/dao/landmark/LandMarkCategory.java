package lk.travelmarket.search_engine.dao.landmark;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name="landmark_category")
@Getter
@Setter
public class LandMarkCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "landmark_category", nullable = false, unique = true)
    private String category;

}
