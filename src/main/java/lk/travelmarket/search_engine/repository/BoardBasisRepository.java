package lk.travelmarket.search_engine.repository;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lk.travelmarket.search_engine.dao.BoardBasis;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardBasisRepository extends JpaRepository<BoardBasis, Long> {
    boolean existsByNameAndIdNot( String name, Long id);

    boolean existsByName(String name);
}
