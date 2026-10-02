package lk.travelmarket.search_engine.repository.facility;

import lk.travelmarket.search_engine.dao.facility.FacilityCategory;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FacilityCategoryRepository
        extends JpaRepository<FacilityCategory, Long> {

    boolean existsByFacilityCategory(String LandMarkCategory);

    boolean existsByCategoryAndIdNot(String LandMarkCategory, Long id);
}