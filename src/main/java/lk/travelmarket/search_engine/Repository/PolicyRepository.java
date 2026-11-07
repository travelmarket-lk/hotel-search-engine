package lk.travelmarket.search_engine.Repository;


import lk.travelmarket.search_engine.dao.Policy.Policy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

@Repository
public interface PolicyRepository extends JpaRepository<Policy, Long> {

    Optional<Policy> findByHotelIdAndHotelId(Long hotelId, Long id);
}


