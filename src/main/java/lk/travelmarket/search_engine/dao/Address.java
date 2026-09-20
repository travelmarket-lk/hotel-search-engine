package lk.travelmarket.search_engine.dao;
import jakarta.persistence.*;
import lk.travelmarket.search_engine.dao.hotel.Hotel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table( name = "address")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Long id;

    @Column( name = "address_line_1")
    private String addressLine1;

    @Column( name = "address_line_2")
    private String addressLine2;

    @OneToOne( cascade = CascadeType.ALL)
    @JoinColumn( name = "city_id")
    private City city;

    @OneToOne( cascade = CascadeType.ALL)
    @JoinColumn( name = "district_id")
    private City district;

    @OneToOne( cascade = CascadeType.ALL)
    @JoinColumn( name = "province_id")
    private Province province;

    @OneToMany( mappedBy = "address" , cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Contact> contacts;

    @OneToOne(mappedBy = "address", fetch = FetchType.LAZY)
    private Hotel hotel;


}
