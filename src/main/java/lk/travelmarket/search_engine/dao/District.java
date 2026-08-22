package lk.travelmarket.search_engine.dao;


import jakarta.persistence.*;

@Entity
@Table( name = "district")
public class District {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Long id;

    private String name;


}
