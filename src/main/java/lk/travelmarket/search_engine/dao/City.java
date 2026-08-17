package lk.travelmarket.search_engine.dao;


import jakarta.persistence.*;

@Entity
@Table( name = "city" )
public class City {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToOne( cascade = CascadeType.ALL)
    private Address address;
}
