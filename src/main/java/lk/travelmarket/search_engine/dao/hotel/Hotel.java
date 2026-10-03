package lk.travelmarket.search_engine.dao.hotel;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lk.travelmarket.search_engine.dao.Address;
import lk.travelmarket.search_engine.dao.HotelOwner;
import lk.travelmarket.search_engine.dao.HotelRoom.Room;
import lk.travelmarket.search_engine.dao.discount.Discount;
import lk.travelmarket.search_engine.dao.facility.Facility;
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

    @NotBlank(message = "Hotel name is required")
    @Size(max = 255, message = "Hotel name must not exceed 255 characters")
    @Column(name = "name", nullable = false)
    private String name;

    @NotBlank(message = "Description is required")
    @Size(max = 1000, message = "Description must not exceed 1000 characters")
    @Column(name = "description", length = 1000, columnDefinition = "TEXT")
    private String description;

    @Size(max = 500, message = "Location highlight must not exceed 500 characters")
    @Column(name = "location-highlight", length = 500)
    private String locationHighlight;

    @Min(value = 1, message = "Star rating must be at least 1")
    @Max(value = 5, message = "Star rating must not exceed 5")
    @Column(name = "star-rating", length = 5)
    private Integer starRating;

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ContentHotel> hotelContents;

    @Valid
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id")
    private Address address;

    @Valid
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hotel_owner_id")
    private HotelOwner hotelOwner;

    @Valid
    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Room> rooms;

    @Valid
    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<HotelFacility> facilities;
}
