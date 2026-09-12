package lk.travelmarket.search_engine.service.hotel;

import lk.travelmarket.search_engine.dto.BlackoutsDto;
import lk.travelmarket.search_engine.network.commons.CCResponse;
import lk.travelmarket.search_engine.network.commons.CCResponsePack;

public interface IHotelBlackoutService {

    CCResponsePack<BlackoutsDto> findAll();
    CCResponsePack<BlackoutsDto> findByHotelId(Long hotelId);
    CCResponse<BlackoutsDto> findHotelBlackout(Long id);
    CCResponse<BlackoutsDto> createHotelBlackout(BlackoutsDto dto);
    CCResponse<BlackoutsDto> updateHotelBlackout(Long id, BlackoutsDto dto);
    CCResponse<BlackoutsDto> deleteHotelBlackout(Long id);

}