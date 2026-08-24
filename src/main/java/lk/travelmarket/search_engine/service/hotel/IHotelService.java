package lk.travelmarket.search_engine.service.hotel;
import lk.travelmarket.search_engine.dao.hotel.Hotel;
import lk.travelmarket.search_engine.dto.HotelDto;
import lk.travelmarket.search_engine.network.commons.CCResponsePack;

public interface IHotelService {
    CCResponsePack<HotelDto> getAllHotels();
    CCResponsePack<HotelDto> getHotelById(Long id);
    CCResponsePack<HotelDto> createHotel(Hotel hotel);
    CCResponsePack<HotelDto> updateHotel(Long id, Hotel hotelDetails);
    CCResponsePack<Boolean> deleteHotel(Long id);
}
