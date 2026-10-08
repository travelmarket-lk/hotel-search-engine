package lk.travelmarket.search_engine.repository.landmark;

import lk.travelmarket.search_engine.dao.landmark.LandMarkCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LandMarkCategoryRepository extends JpaRepository<LandMarkCategory, Long> {

    boolean existsByCategory(String category);

    boolean existsByCategoryAndIdNot(String category , long id);



}
