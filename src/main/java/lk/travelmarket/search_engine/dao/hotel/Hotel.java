package lk.travelmarket.search_engine.dao.hotel;
import jakarta.persistence.*;
import lombok.*;
import org.w3c.dom.Text;

import java.util.List;

@Entity
@Table(name = "hotel")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "description",length = 1000 ,columnDefinition = "TEXT")
    private String description;

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ContentHotel> hotelContents;



}
