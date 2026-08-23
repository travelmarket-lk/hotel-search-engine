package lk.travelmarket.search_engine.dao;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "blackouts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Blackouts {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "hotel_id", nullable = false)
    private Long hotelId;

    @Column(name = "room_id")
    private Long roomId;

    @Column(name = "reason")
    private String reason;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

}
