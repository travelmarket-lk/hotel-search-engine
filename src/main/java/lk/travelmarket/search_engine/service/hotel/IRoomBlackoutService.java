package lk.travelmarket.search_engine.service.hotel;

import lk.travelmarket.search_engine.dto.BlackoutsDto;
import lk.travelmarket.search_engine.network.commons.CCResponse;
import lk.travelmarket.search_engine.network.commons.CCResponsePack;

public interface IRoomBlackoutService {

    CCResponsePack<BlackoutsDto> findAll();
    CCResponsePack<BlackoutsDto> findByRoomId(Long roomId);
    CCResponsePack<BlackoutsDto> findByHotelId(Long hotelId);
    CCResponse<BlackoutsDto> findRoomBlackout(Long id);
    CCResponse<BlackoutsDto> createRoomBlackout(BlackoutsDto dto);
    CCResponse<BlackoutsDto> updateRoomBlackout(Long id, BlackoutsDto dto);
    CCResponse<BlackoutsDto> deleteRoomBlackout(Long id);

}