package lk.travelmarket.search_engine.dao.HotelRoom;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Getter
@Setter
@Table(name = "bed_type")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BedType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Bed type is required")
    @Size(max = 100, message = "Bed type must not exceed 100 characters")
    @Column(name = "type", nullable = false)
    private String type;

}