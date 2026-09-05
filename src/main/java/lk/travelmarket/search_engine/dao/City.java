package lk.travelmarket.search_engine.dao;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table( name = "city" )
@Getter
@Setter
public class City {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Long id;

    private String name;

}
