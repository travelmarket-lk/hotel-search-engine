package lk.travelmarket.search_engine.dao.HotelRoom;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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

    @Column(name = "type")
    private String type;

}
