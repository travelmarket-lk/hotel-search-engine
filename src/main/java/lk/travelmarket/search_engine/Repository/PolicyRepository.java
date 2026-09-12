package lk.travelmarket.search_engine.Repository;


import lk.travelmarket.search_engine.dao.Policy.Policy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PolicyRepository extends JpaRepository<Policy, String> {

}