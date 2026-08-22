package lk.travelmarket.search_engine.service.hotel;
import lk.travelmarket.search_engine.dao.hotel.Hotel;
import lk.travelmarket.search_engine.dto.HotelResponse;
import java.util.List;

public interface IHotelService {
    List<HotelResponse> getAllHotels();
    HotelResponse getHotelById(Long id);
    HotelResponse createHotel(Hotel hotel);
    HotelResponse updateHotel(Long id, Hotel hotelDetails);
    boolean deleteHotel(Long id);
}
