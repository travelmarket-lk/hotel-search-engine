package lk.travelmarket.search_engine.dao.HotelRoom;

import jakarta.persistence.*;
import lk.travelmarket.search_engine.dao.hotel.Hotel;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Table(name = "season")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Season {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "season_name")
    private String seasonName;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
            name = "hotel_id",
            nullable = false
    )
    private Hotel hotel;

}
