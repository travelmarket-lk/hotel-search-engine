package lk.travelmarket.search_engine.repository;

import lk.travelmarket.search_engine.dao.HotelRoom.Season;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SeasonRepository extends JpaRepository<Season, Long> {

    @Query(
            value = """
                SELECT *
                FROM season
                WHERE hotel_id = :hotelId
                """,
            nativeQuery = true
    )
    List<Season> findAllByHotelId(
            @Param("hotelId") Long hotelId
    );

    boolean existsBySeasonNameIgnoreCase(String seasonName);
    boolean existsBySeasonNameIgnoreCaseAndIdNot(String seasonName, Long id);
}