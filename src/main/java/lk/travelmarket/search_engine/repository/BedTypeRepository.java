package lk.travelmarket.search_engine.repository;

import lk.travelmarket.search_engine.dao.HotelRoom.BedType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BedTypeRepository extends JpaRepository<BedType, Long> {

}
