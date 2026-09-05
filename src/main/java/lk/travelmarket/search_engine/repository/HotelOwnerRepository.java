package lk.travelmarket.search_engine.repository;

import lk.travelmarket.search_engine.dao.HotelOwner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelOwnerRepository extends JpaRepository<HotelOwner, Long> {

    boolean existsByEmail(String email);
    boolean existsByNic(String nic);

}
