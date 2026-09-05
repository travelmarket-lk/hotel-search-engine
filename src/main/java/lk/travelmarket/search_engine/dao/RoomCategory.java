package lk.travelmarket.search_engine.dao;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "room_category")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoomCategory {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name",nullable = false,unique = true)
    private String name;
}
