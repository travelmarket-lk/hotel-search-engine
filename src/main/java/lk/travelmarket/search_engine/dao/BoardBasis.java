package lk.travelmarket.search_engine.dao;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "board_basis")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardBasis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name",nullable = false,unique = true)
    private String name;

    @Column(name = "description",nullable = false,unique = true)
    private String description;


}
