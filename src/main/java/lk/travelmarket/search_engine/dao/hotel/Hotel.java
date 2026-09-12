package lk.travelmarket.search_engine.dao.hotel;
import jakarta.persistence.*;
import lk.travelmarket.search_engine.dao.Address;
import lk.travelmarket.search_engine.dao.HotelOwner;
import lk.travelmarket.search_engine.dao.HotelRoom.Room;
import lk.travelmarket.search_engine.dao.facility.Facility;
import lombok.*;


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

    @Column(name = "location-highlight" , length = 500)
    private String locationHighlight;

    @Column(name = "star-rating" , length = 5)
    private Integer starRating;

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ContentHotel> hotelContents;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id")
    private Address address;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hotel_owner_id")
    private HotelOwner hotelOwner;

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Room> rooms;

//    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<Policy> policies;

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Facility> facilities;

//    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<Discount> discounts;
//
//    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<Blackouts> blackouts;
//



}
