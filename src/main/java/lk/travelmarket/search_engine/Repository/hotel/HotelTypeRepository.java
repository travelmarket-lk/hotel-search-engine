package lk.travelmarket.search_engine.repository.hotel;

import lk.travelmarket.search_engine.dao.hotel.HotelType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelTypeRepository extends JpaRepository<HotelType, Long> {

}
