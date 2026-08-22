package lk.travelmarket.search_engine.dao.HotelRoom;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Table(name = "room")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "room_count", nullable = false)
    private Integer roomCount;

    @Column(name = "room_name")
    private String roomName;

    @Column(columnDefinition = "TEXT" )
    private String description;

    @Column(name = "min_pax_count", nullable = false)
    private Integer minPaxCount;

    @Column(name = "max_pax_count", nullable = false)
    private Integer maxPaxCount;

//    @Column(name = "room_type_id")
//    private Long roomTypeId;

    @Column(name = "hotel_id", nullable = false)
    private Long hotelId;

    @OneToMany
    @JoinColumn(name = "bed_type_id")
    private BedType bed_type;

}