package lk.travelmarket.search_engine.repository;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lk.travelmarket.search_engine.dao.HotelRoom.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomTypeRepository extends JpaRepository<RoomType, Long> {
    boolean existsByType( String type);
}
