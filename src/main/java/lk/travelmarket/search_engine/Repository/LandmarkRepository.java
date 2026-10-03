package lk.travelmarket.search_engine.repository;

import lk.travelmarket.search_engine.dao.hotel.Landmark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LandmarkRepository extends JpaRepository<Landmark, Long> {

    List<Landmark> findByHotelId(Long hotelId);
}