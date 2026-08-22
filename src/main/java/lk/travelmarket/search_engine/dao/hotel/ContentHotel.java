package lk.travelmarket.search_engine.dao.hotel;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "content-hotel")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ContentHotel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "content",columnDefinition = "TEXT")
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hotel_id", nullable = false)
    private Hotel hotel;



}
