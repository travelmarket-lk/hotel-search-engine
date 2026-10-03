package lk.travelmarket.search_engine.repository;

import lk.travelmarket.search_engine.dao.hotel.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {
}