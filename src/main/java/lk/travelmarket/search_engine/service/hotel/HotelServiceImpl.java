package lk.travelmarket.search_engine.service.hotel;
import lk.travelmarket.search_engine.dao.hotel.Hotel;
import lk.travelmarket.search_engine.dto.HotelResponse;
import lk.travelmarket.search_engine.repository.HotelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HotelServiceImpl implements IHotelService {

    private final HotelRepository hotelRepository;

    @Override
    public List<HotelResponse> getAllHotels() {
        return hotelRepository.findAll()
                .stream()
                .map(HotelResponse::form)
                .collect(Collectors.toList());
    }

    @Override
    public HotelResponse getHotelById(Long id) {
        return hotelRepository.findById(id)
                .map(HotelResponse::form)
                .orElse(null);
    }

    @Override
    public HotelResponse createHotel(Hotel hotel) {
        Hotel saved = hotelRepository.save(hotel);
        return HotelResponse.form(saved);
    }

    @Override
    public HotelResponse updateHotel(Long id, Hotel hotelDetails) {
        return hotelRepository.findById(id).map(hotel -> {
            hotel.setName(hotelDetails.getName());
            hotel.setDescription(hotelDetails.getDescription());
            Hotel updated = hotelRepository.save(hotel);
            return HotelResponse.form(updated);
        }).orElse(null);
    }

    @Override
    public boolean deleteHotel(Long id) {
        return hotelRepository.findById(id).map(hotel -> {
            hotelRepository.delete(hotel);
            return true;
        }).orElse(false);
    }


}
