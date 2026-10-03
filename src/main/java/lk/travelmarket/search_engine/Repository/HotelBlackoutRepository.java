package lk.travelmarket.search_engine.repository;

import lk.travelmarket.search_engine.dao.Blackouts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelBlackoutRepository extends JpaRepository<Blackouts, Long> {

    List<Blackouts> findByRoomIdIsNull();
    List<Blackouts> findByHotelIdAndRoomIdIsNull(Long hotelId);

}