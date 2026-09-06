package lk.travelmarket.search_engine.service.season;

import jakarta.transaction.Transactional;
import lk.travelmarket.search_engine.dao.HotelRoom.Season;
import lk.travelmarket.search_engine.dto.SeasonDto;
import lk.travelmarket.search_engine.network.commons.CCError;
import lk.travelmarket.search_engine.network.commons.CCErrorStatus;
import lk.travelmarket.search_engine.repository.SeasonRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

import static lk.travelmarket.search_engine.util.Constants.*;

@Component
@Transactional
public class SeasonServiceImpl {

    private final SeasonRepository seasonRepository;

    public SeasonServiceImpl(SeasonRepository seasonRepository) {
        this.seasonRepository = seasonRepository;
    }

    public CCError<List<SeasonDto>> findAll() {

        CCError<List<SeasonDto>> ccError =
                new CCError<>(
                        CCErrorStatus.SUCCESS,
                        SUCCESS_RETRIEVE_SEASONS
                );

        List<SeasonDto> seasonData =
                this.seasonRepository.findAll()
                        .stream()
                        .map(this::toDto)
                        .toList();

        ccError.setData(seasonData);

        return ccError;
    }

    public CCError<SeasonDto> findSeason(Long id) {

        CCError<SeasonDto> ccError =
                new CCError<>(
                        CCErrorStatus.SUCCESS,
                        SUCCESS_RETRIEVE_SEASON
                );

        Optional<Season> dao =
                this.seasonRepository.findById(id);

        if (dao.isEmpty()) {

            ccError.setStatus(CCErrorStatus.ERROR);
            ccError.setMessage(
                    ERROR_RETRIEVE_SEASON_NOT_FOUND
            );

            return ccError;
        }

        SeasonDto seasonData =
                this.toDto(dao.get());

        ccError.setData(seasonData);

        return ccError;
    }

    public CCError<SeasonDto> createSeason(
            SeasonDto dto) {

        CCError<SeasonDto> ccError =
                new CCError<>(
                        CCErrorStatus.SUCCESS,
                        SUCCESS_CREATE_SEASON
                );

        Season dao = new Season();

        dao.setSeasonName(dto.getSeasonName());
        dao.setStartDate(dto.getStartDate());
        dao.setEndDate(dto.getEndDate());

        Season savedSeason =
                seasonRepository.save(dao);

        SeasonDto seasonData =
                this.toDto(savedSeason);

        ccError.setData(seasonData);

        return ccError;
    }

    public CCError<SeasonDto> updateSeason(
            Long id,
            SeasonDto dto) {

        CCError<SeasonDto> ccError =
                new CCError<>(
                        CCErrorStatus.SUCCESS,
                        SUCCESS_UPDATE_SEASON
                );

        Optional<Season> dao =
                this.seasonRepository.findById(id);

        if (dao.isEmpty()) {

            ccError.setStatus(CCErrorStatus.ERROR);
            ccError.setMessage(
                    ERROR_RETRIEVE_SEASON_NOT_FOUND
            );

            return ccError;
        }

        dao.get().setSeasonName(dto.getSeasonName());
        dao.get().setStartDate(dto.getStartDate());
        dao.get().setEndDate(dto.getEndDate());

        this.seasonRepository.save(dao.get());

        SeasonDto seasonData =
                this.toDto(dao.get());

        ccError.setData(seasonData);

        return ccError;
    }

    public CCError<SeasonDto> deleteSeason(Long id) {

        CCError<SeasonDto> ccError =
                new CCError<>(
                        CCErrorStatus.SUCCESS,
                        SUCCESS_DELETE_SEASON
                );

        Optional<Season> dao =
                this.seasonRepository.findById(id);

        if (dao.isEmpty()) {

            ccError.setStatus(CCErrorStatus.ERROR);
            ccError.setMessage(
                    ERROR_RETRIEVE_SEASON_NOT_FOUND
            );

            return ccError;
        }

        this.seasonRepository.delete(dao.get());

        SeasonDto seasonData =
                this.toDto(dao.get());

        ccError.setData(seasonData);

        return ccError;
    }

    private SeasonDto toDto(Season season) {

        return new SeasonDto(
                season.getId(),
                season.getSeasonName(),
                season.getStartDate(),
                season.getEndDate()
        );
    }
}