package lk.travelmarket.search_engine.dao.HotelRoom;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Table(name = "room_rate")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class RoomRate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "room_type_id")
    private Long roomTypeId;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "pax_count")
    private Integer paxCount;

    @Column(name = "room_id", nullable = false)
    private Long roomId;

    @Column(name = "season_id", nullable = false)
    private Long seasonId;

    @Column(name = "refundable")
    private Boolean refundable;

    @Column(name = "hotel_id")
    private Long hotelId;

}