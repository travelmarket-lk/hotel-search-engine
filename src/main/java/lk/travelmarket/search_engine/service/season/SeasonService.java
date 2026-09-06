package lk.travelmarket.search_engine.service.season;

import lk.travelmarket.search_engine.dto.SeasonDto;
import lk.travelmarket.search_engine.network.commons.CCError;
import lk.travelmarket.search_engine.network.commons.CCErrorStatus;
import lk.travelmarket.search_engine.network.commons.CCResponse;
import lk.travelmarket.search_engine.network.commons.CCResponsePack;
import lk.travelmarket.search_engine.network.error.code.ErrorLayer;
import lk.travelmarket.search_engine.network.error.code.ErrorSource;
import lk.travelmarket.search_engine.network.error.code.Status;
import org.springframework.stereotype.Service;

import java.util.List;

import static lk.travelmarket.search_engine.util.Constants.*;

@Service
public class SeasonService implements ISeasonService {

    private final SeasonServiceImpl seasonServiceImpl;

    public SeasonService(SeasonServiceImpl seasonServiceImpl) {
        this.seasonServiceImpl = seasonServiceImpl;
    }

    @Override
    public CCResponsePack<SeasonDto> findAll() {

        try {

            CCError<List<SeasonDto>> ccError =
                    seasonServiceImpl.findAll();

            if (ccError.getStatus().equals(CCErrorStatus.ERROR)) {

                return new CCResponsePack<>(
                        Status.ERROR,
                        ccError.getMessage(),
                        null
                );
            }

            return new CCResponsePack<>(
                    ccError.getData()
            );

        } catch (Exception e) {

            return new CCResponsePack<>(
                    ErrorLayer.HSL_LAYER,
                    ErrorSource.SERVER_ERROR,
                    ERROR_RETRIEVE_SEASONS,
                    e
            );
        }
    }

    @Override
    public CCResponse<SeasonDto> findSeason(Long id) {

        try {

            CCError<SeasonDto> ccError =
                    seasonServiceImpl.findSeason(id);

            if (ccError.getStatus().equals(CCErrorStatus.ERROR)) {

                return new CCResponse<>(
                        Status.ERROR,
                        ccError.getMessage(),
                        null
                );
            }

            return new CCResponse<>(
                    ccError.getData()
            );

        } catch (Exception e) {

            return new CCResponse<>(
                    ErrorLayer.HSL_LAYER,
                    ErrorSource.SERVER_ERROR,
                    ERROR_RETRIEVE_SEASON,
                    e
            );
        }
    }

    @Override
    public CCResponse<SeasonDto> createSeason(SeasonDto dto) {

        try {

            CCError<SeasonDto> ccError =
                    seasonServiceImpl.createSeason(dto);

            if (ccError.getStatus().equals(CCErrorStatus.ERROR)) {

                return new CCResponse<>(
                        Status.ERROR,
                        ccError.getMessage(),
                        null
                );
            }

            return new CCResponse<>(
                    ccError.getData()
            );

        } catch (Exception e) {

            return new CCResponse<>(
                    ErrorLayer.HSL_LAYER,
                    ErrorSource.SERVER_ERROR,
                    ERROR_CREATE_SEASON,
                    e
            );
        }
    }

    @Override
    public CCResponse<SeasonDto> updateSeason(
            Long id,
            SeasonDto dto) {

        try {

            CCError<SeasonDto> ccError =
                    seasonServiceImpl.updateSeason(id, dto);

            if (ccError.getStatus().equals(CCErrorStatus.ERROR)) {

                return new CCResponse<>(
                        Status.ERROR,
                        ccError.getMessage(),
                        null
                );
            }

            return new CCResponse<>(
                    ccError.getData()
            );

        } catch (Exception e) {

            return new CCResponse<>(
                    ErrorLayer.HSL_LAYER,
                    ErrorSource.SERVER_ERROR,
                    ERROR_UPDATE_SEASON,
                    e
            );
        }
    }

    @Override
    public CCResponse<SeasonDto> deleteSeason(Long id) {

        try {

            CCError<SeasonDto> ccError =
                    seasonServiceImpl.deleteSeason(id);

            if (ccError.getStatus().equals(CCErrorStatus.ERROR)) {

                return new CCResponse<>(
                        Status.ERROR,
                        ccError.getMessage(),
                        null
                );
            }

            return new CCResponse<>(
                    ccError.getData()
            );

        } catch (Exception e) {

            return new CCResponse<>(
                    ErrorLayer.HSL_LAYER,
                    ErrorSource.SERVER_ERROR,
                    ERROR_DELETE_SEASON,
                    e
            );
        }
    }
}