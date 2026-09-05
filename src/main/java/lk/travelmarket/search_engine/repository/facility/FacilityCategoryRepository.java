package lk.travelmarket.search_engine.repository.facility;

import lk.travelmarket.search_engine.dao.facility.FacilityCategory;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface FacilityCategoryRepository
        extends CrudRepository<FacilityCategory, Long> {

    Optional<FacilityCategory> findByFacilityCategory(
            String facilityCategory
    );

    List<FacilityCategory> findByFacilityCategoryContainingIgnoreCase(
            String facilityCategory
    );
}