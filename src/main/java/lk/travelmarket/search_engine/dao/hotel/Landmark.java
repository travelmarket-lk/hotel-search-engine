package lk.travelmarket.search_engine.dao.hotel;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "landmarks")
@Entity
@Builder
public class Landmark {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "landmark_name")
    private String landmarkName;

    @Column(name = "landmark_distance")
    private Double landmarkDist;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;
}