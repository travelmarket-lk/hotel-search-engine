package lk.travelmarket.search_engine.repository;

import lk.travelmarket.search_engine.dao.HotelRoom.Season;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeasonRepository extends JpaRepository<Season, Long> {
}