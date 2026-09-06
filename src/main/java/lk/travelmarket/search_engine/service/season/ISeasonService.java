package lk.travelmarket.search_engine.service.season;

import lk.travelmarket.search_engine.dto.SeasonDto;
import lk.travelmarket.search_engine.network.commons.CCResponse;
import lk.travelmarket.search_engine.network.commons.CCResponsePack;

public interface ISeasonService {

    CCResponsePack<SeasonDto> findAll();

    CCResponse<SeasonDto> findSeason(Long id);

    CCResponse<SeasonDto> createSeason(SeasonDto dto);

    CCResponse<SeasonDto> updateSeason(Long id, SeasonDto dto);

    CCResponse<SeasonDto> deleteSeason(Long id);
}