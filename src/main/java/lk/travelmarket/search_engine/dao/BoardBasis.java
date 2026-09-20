package lk.travelmarket.search_engine.dao;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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

    @NotBlank(message = "Name is required")
    @Size(max = 100, message = "Name must be less than 100 characters")
    @Column(name = "name",nullable = false,unique = true)
    private String name;

    @NotBlank(message = "Description is required")
    @Size(max = 255, message = "Description must be less than 255 characters")
    @Column(name = "description",nullable = false,unique = true)
    private String description;


}
