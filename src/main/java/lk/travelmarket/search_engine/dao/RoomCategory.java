package lk.travelmarket.search_engine.dao;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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

    @NotBlank(message = "Room category name cannot be blank")
    @Size(min = 2, max = 50, message = "Room category name must be between 2 and 50 characters")
    @Column(name = "name",nullable = false,unique = true)
    private String name;
}
