package lk.travelmarket.search_engine.dao.discount;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "discount")
@Getter
@Setter
public class Discount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "hotel_id", nullable = false)
    private Long hotelId;

    @Column(name = "room_id")
    private Long roomId;

    @Column(name = "discount", nullable = false, length = 100)
    private String discountName;


    @Column(name="discount_code", nullable = false, length = 100)
    private String discountCode;



}