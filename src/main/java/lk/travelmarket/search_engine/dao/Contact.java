package lk.travelmarket.search_engine.dao;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table( name = "contact")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Contact {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Long id;

    private String value;

    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn( name = "address_id")
    private Address address;
}
