package lk.travelmarket.search_engine.service.v2.hotel;


import lk.travelmarket.search_engine.dto.BlackoutsDto;
import lk.travelmarket.search_engine.dto.SeasonDto;
import lk.travelmarket.search_engine.dto.bulk.season.BlackoutBulkUpdateDto;
import lk.travelmarket.search_engine.dto.bulk.season.SeasonBulkUpdateDto;
import lk.travelmarket.search_engine.network.commons.CCResponse;
import lk.travelmarket.search_engine.network.commons.CCResponsePack;

public interface IHotelV2Service {


    CCResponsePack<SeasonDto> retrieveSeasons(Long hotelId);

    CCResponse<SeasonBulkUpdateDto> bulkUpdateSeasons(
            Long hotelId,
            SeasonBulkUpdateDto request);

    CCResponsePack<BlackoutsDto> retrieveBlackouts(Long hotelId);

    CCResponse<BlackoutBulkUpdateDto> bulkUpdateBlackouts(
            Long hotelId,
            BlackoutBulkUpdateDto request
    );
}
