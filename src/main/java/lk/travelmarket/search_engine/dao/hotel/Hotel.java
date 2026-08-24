package lk.travelmarket.search_engine.dao.hotel;
import jakarta.persistence.*;
import lk.travelmarket.search_engine.dao.Blackouts;
import lk.travelmarket.search_engine.dao.HotelOwner;
import lk.travelmarket.search_engine.dao.HotelRoom.Room;
import lk.travelmarket.search_engine.dao.discount.Discount;
import lk.travelmarket.search_engine.dao.facilities.Facility;
import lombok.*;
import org.w3c.dom.Text;

import java.security.Policy;
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

//    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<Policy> policies;
//
//    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<Facility> facilities;
//
//    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<Room> rooms;
//
//    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<Discount> discounts;
//
//    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<Blackouts> blackouts;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "hotel_owner_id")
//    private HotelOwner hotelOwner;


}
