package lk.travelmarket.search_engine.dao;

import jakarta.persistence.*;
import lk.travelmarket.search_engine.dao.user.User;
import lombok.*;

@Entity
@Table( name = "hotel_owner")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HotelOwner {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column( name = "name" )
    private String name;

    @Column( name = "phone_number")
    private String phoneNumber;

    @Column( name = "nic")
    private String nic;

    @Column( name = "email")
    private String email;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;
}
