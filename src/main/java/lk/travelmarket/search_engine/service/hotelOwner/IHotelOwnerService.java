package lk.travelmarket.search_engine.service.hotelOwner;

import lk.travelmarket.search_engine.dto.HotelOwnerDto;
import lk.travelmarket.search_engine.network.commons.CCResponse;

public interface IHotelOwnerService {

    CCResponse<HotelOwnerDto> registerOwner(HotelOwnerDto dto);
}