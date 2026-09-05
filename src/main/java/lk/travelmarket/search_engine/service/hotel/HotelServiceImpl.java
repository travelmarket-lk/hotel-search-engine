package lk.travelmarket.search_engine.service.hotel;

import lk.travelmarket.search_engine.dao.hotel.Hotel;
import lk.travelmarket.search_engine.dto.HotelDto;

import lk.travelmarket.search_engine.dto.criteria.HotelCreationCriteria;
import lk.travelmarket.search_engine.network.commons.CCError;
import lk.travelmarket.search_engine.network.commons.CCErrorStatus;

import lk.travelmarket.search_engine.repository.HotelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static lk.travelmarket.search_engine.util.Constants.*;

@Service
@RequiredArgsConstructor
public class HotelServiceImpl {

    private final HotelRepository hotelRepository;


    public CCError<List<HotelDto>> findAll() {
        CCError<List<HotelDto>> ccError = new CCError<>(CCErrorStatus.SUCCESS, SUCCESS_RETRIEVE_TESTS);
        List<HotelDto> hotels = hotelRepository.findAll().stream()
                .map(this::toDto)
                .toList();
        ccError.setData(hotels);
        return ccError;
    }

    public CCError<HotelDto> findById(Long id) {
        Optional<Hotel> hotelOpt = hotelRepository.findById(id);
        CCError<HotelDto> ccError;
        if (hotelOpt.isPresent()) {
            ccError = new CCError<>(CCErrorStatus.SUCCESS, SUCCESS_RETRIEVE_HOTEL);
            ccError.setData(toDto(hotelOpt.get()));
        } else {
            ccError = new CCError<>(CCErrorStatus.ERROR, ERROR_RETRIEVE_HOTEL);
            ccError.setData(null);
        }
        return ccError;
    }

    public CCError<HotelDto> create(HotelCreationCriteria criteria) {
        Hotel hotel = new Hotel();
        hotel.setName(criteria.getName());
        hotel.setDescription(criteria.getDescription());

        Hotel saved = hotelRepository.save(hotel);
        CCError<HotelDto> ccError = new CCError<>(CCErrorStatus.SUCCESS, SUCCESS_CREATE_HOTEL);
        ccError.setData(toDto(saved));
        return ccError;
    }

    public CCError<HotelDto> update(Long id, Hotel hotelDetails) {
        Optional<Hotel> hotelOpt = hotelRepository.findById(id);
        CCError<HotelDto> ccError;

        if (hotelOpt.isPresent()) {
            Hotel hotel = hotelOpt.get();
            hotel.setName(hotelDetails.getName());
            hotel.setDescription(hotelDetails.getDescription());

            Hotel updated = hotelRepository.save(hotel);
            ccError = new CCError<>(CCErrorStatus.SUCCESS, SUCCESS_UPDATE_HOTEL);
            ccError.setData(toDto(updated));
        } else {
            ccError = new CCError<>(CCErrorStatus.ERROR, ERROR_UPDATE_HOTEL);
            ccError.setData(null);
        }

        return ccError;
    }

    public CCError<Boolean> delete(Long id) {
        Optional<Hotel> hotelOpt = hotelRepository.findById(id);
        if (hotelOpt.isPresent()) {
            hotelRepository.delete(hotelOpt.get());
            CCError<Boolean> ccError = new CCError<>(CCErrorStatus.SUCCESS, SUCCESS_DELETE_HOTEL);
            ccError.setData(true);
            return ccError;
        }
        CCError<Boolean> ccError = new CCError<>(CCErrorStatus.ERROR, ERROR_DELETE_HOTEL);
        ccError.setData(false);
        return ccError;
    }

    private HotelDto toDto(Hotel hotel) {
        return new HotelDto(hotel.getId(), hotel.getName(), hotel.getDescription());
    }
}
