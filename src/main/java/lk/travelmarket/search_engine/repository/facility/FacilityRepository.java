package lk.travelmarket.search_engine.repository.facility;

import lk.travelmarket.search_engine.dao.facility.Facility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacilityRepository extends JpaRepository<Facility, Long> {
}