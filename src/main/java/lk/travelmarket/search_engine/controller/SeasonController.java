package lk.travelmarket.search_engine.controller;

import lk.travelmarket.search_engine.dto.SeasonDto;
import lk.travelmarket.search_engine.network.CCResponseWrapper;
import lk.travelmarket.search_engine.network.util.NetworkUtils;
import lk.travelmarket.search_engine.service.season.ISeasonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SeasonController implements ISeasonController {

    private final ISeasonService seasonService;

    public SeasonController(ISeasonService seasonService) {
        this.seasonService = seasonService;
    }

    @Override
    public ResponseEntity<CCResponseWrapper<SeasonDto>> create(
            SeasonDto request) {

        return NetworkUtils.wrap(
                seasonService.createSeason(request)
        );
    }

    @Override
    public ResponseEntity<CCResponseWrapper<SeasonDto>> getAll() {

        return NetworkUtils.wrap(
                seasonService.findAll()
        );
    }

    @Override
    public ResponseEntity<CCResponseWrapper<SeasonDto>> getById(
            Long id) {

        return NetworkUtils.wrap(
                seasonService.findSeason(id)
        );
    }

    @Override
    public ResponseEntity<CCResponseWrapper<SeasonDto>> update(
            Long id,
            SeasonDto request) {

        return NetworkUtils.wrap(
                seasonService.updateSeason(id, request)
        );
    }

    @Override
    public ResponseEntity<CCResponseWrapper<SeasonDto>> delete(
            Long id) {

        return NetworkUtils.wrap(
                seasonService.deleteSeason(id)
        );
    }
}