package lk.travelmarket.search_engine.dao.hotel;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
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
    @Column(name = "id")
    private Long id;

    @NotBlank(message = "Landmark name is required and cannot be blank")
    @Size(max = 255, message = "Landmark name must not exceed 255 characters")
    @Column(name = "landmark_name", nullable = false)
    private String landmarkName;

    @NotNull(message = "Landmark distance is required")
    @PositiveOrZero(message = "Landmark distance must be greater than or equal to 0")
    @Column(name = "landmark_distance")
    private Double landmarkDist;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hotel_id")
    private Hotel hotel;

}