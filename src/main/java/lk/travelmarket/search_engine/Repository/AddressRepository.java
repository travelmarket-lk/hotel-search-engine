package lk.travelmarket.search_engine.repository;

import lk.travelmarket.search_engine.dao.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
