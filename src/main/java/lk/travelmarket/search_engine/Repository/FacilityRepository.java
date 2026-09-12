package lk.travelmarket.search_engine.Repository;

import lk.travelmarket.search_engine.dao.facilities.Facility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacilityRepository
        extends JpaRepository<Facility, Long> {
}