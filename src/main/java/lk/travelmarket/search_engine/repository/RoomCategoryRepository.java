package lk.travelmarket.search_engine.repository;
import lk.travelmarket.search_engine.dao.RoomCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoomCategoryRepository extends JpaRepository<RoomCategory, Long> {
    Optional<RoomCategory> findByName(String name);
}
