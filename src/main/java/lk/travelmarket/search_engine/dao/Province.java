package lk.travelmarket.search_engine.dao;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table( name = "province")
public class Province {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Long id;

    private String name;

}
