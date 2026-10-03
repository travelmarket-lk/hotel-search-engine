package lk.travelmarket.search_engine.dao.HotelRoom;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Table(name = "room_type")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoomType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Room type cannot be blank")
    @Size(min = 2, max = 50, message = "Room type must be between 2 and 50 characters")
    @Column(name = "type", nullable = false, unique = true)
    private String type;
}
