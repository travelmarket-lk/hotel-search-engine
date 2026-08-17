package lk.travelmarket.search_engine.dao;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Table( name = "address")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Long id;

    private String addressLine1;

    private String addressLine2;

    @OneToOne( cascade = CascadeType.ALL)
    @JoinColumn( name = "city_id")
    private City city;

    @OneToOne( cascade = CascadeType.ALL)
    @JoinColumn( name = "district_id")
    private City district;

}
