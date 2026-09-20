package lk.travelmarket.search_engine.service.hotel;

import lk.travelmarket.search_engine.dao.Address;
import lk.travelmarket.search_engine.dao.hotel.Hotel;
import lk.travelmarket.search_engine.dao.hotel.Landmark;
import lk.travelmarket.search_engine.dto.AddressDto;
import lk.travelmarket.search_engine.dto.HotelDto;
import lk.travelmarket.search_engine.dto.LandmarkDto;
import lk.travelmarket.search_engine.dto.criteria.HotelCreationCriteria;
import lk.travelmarket.search_engine.network.commons.CCError;
import lk.travelmarket.search_engine.network.commons.CCErrorStatus;

import lk.travelmarket.search_engine.repository.HotelRepository;
import lk.travelmarket.search_engine.repository.LandmarkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static lk.travelmarket.search_engine.util.Constants.*;

@Service
@RequiredArgsConstructor
public class HotelServiceImpl {

    private final HotelRepository hotelRepository;
    private final LandmarkRepository landmarkRepository;


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
        hotel.setStarRating(criteria.getStarRating());
        hotel.setLocationHighlight(criteria.getLocationHighlight());

        // Convert AddressDto → Address entity
        if (criteria.getAddress() != null) {
            Address address = new Address();
            address.setAddressLine1(criteria.getAddress().getAddressLine1());
            address.setAddressLine2(criteria.getAddress().getAddressLine2());
            hotel.setAddress(address);
        }

        Hotel saved = hotelRepository.save(hotel);
        CCError<HotelDto> ccError = new CCError<>(CCErrorStatus.SUCCESS, SUCCESS_CREATE_HOTEL);
        ccError.setData(toDto(saved));
        return ccError;
    }


    public CCError<HotelDto> update(Long id, HotelDto hotelDetails) {
        Optional<Hotel> hotelOpt = hotelRepository.findById(id);
        CCError<HotelDto> ccError;

        if (hotelOpt.isPresent()) {
            Hotel hotel = hotelOpt.get();
            hotel.setName(hotelDetails.getName());
            hotel.setDescription(hotelDetails.getDescription());
            hotel.setStarRating(hotelDetails.getStarRating());
            hotel.setLocationHighlight(hotelDetails.getLocationHighlight());
            hotel.getAddress().setAddressLine1( hotelDetails.getAddress().getAddressLine1() );
            hotel.getAddress().setAddressLine2( hotelDetails.getAddress().getAddressLine2() );
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


    // HOTEL LANDMARKS

    public CCError<List<LandmarkDto>> findLandmarksByHotelId(Long hotelId) {
        if (!hotelRepository.existsById(hotelId)) {
            CCError<List<LandmarkDto>> ccError = new CCError<>(CCErrorStatus.ERROR, ERROR_RETRIEVE_HOTEL_NOT_FOUND);
            ccError.setData(null);
            return ccError;
        }

        List<LandmarkDto> landmarks = landmarkRepository.findByHotelId(hotelId).stream()
                .map(this::toLandmarkDto)
                .toList();

        CCError<List<LandmarkDto>> ccError = new CCError<>(CCErrorStatus.SUCCESS, SUCCESS_RETRIEVE_LANDMARKS);
        ccError.setData(landmarks);
        return ccError;
    }

    public CCError<LandmarkDto> addLandmarkToHotel(Long hotelId, Landmark landmark) {
        Optional<Hotel> hotelOpt = hotelRepository.findById(hotelId);
        if (hotelOpt.isPresent()) {
            landmark.setHotel(hotelOpt.get());
            Landmark saved = landmarkRepository.save(landmark);

            CCError<LandmarkDto> ccError = new CCError<>(CCErrorStatus.SUCCESS, SUCCESS_CREATE_LANDMARK);
            ccError.setData(toLandmarkDto(saved));
            return ccError;
        }

        CCError<LandmarkDto> ccError = new CCError<>(CCErrorStatus.ERROR, ERROR_RETRIEVE_HOTEL_NOT_FOUND);
        ccError.setData(null);
        return ccError;
    }



    public CCError<Boolean> deleteLandmark(Long landmarkId) {
        Optional<Landmark> landmarkOpt = landmarkRepository.findById(landmarkId);
        if (landmarkOpt.isPresent()) {
            landmarkRepository.delete(landmarkOpt.get());
            CCError<Boolean> ccError = new CCError<>(CCErrorStatus.SUCCESS, SUCCESS_DELETE_LANDMARK);
            ccError.setData(true);
            return ccError;
        }

        CCError<Boolean> ccError = new CCError<>(CCErrorStatus.ERROR, ERROR_LANDMARK_NOT_FOUND);
        ccError.setData(false);
        return ccError;
    }

    private HotelDto toDto(Hotel hotel) {
        return new HotelDto(
                hotel.getId(),
                hotel.getName(),
                hotel.getDescription(),
                hotel.getLocationHighlight(),
                hotel.getStarRating(),
                toDto(hotel.getAddress()));
    }

    private AddressDto toDto(Address address) {
        if (address == null) return null;
        return new AddressDto(
                address.getId(),
                address.getAddressLine1(),
                address.getAddressLine2()
        );
    }


    private LandmarkDto toLandmarkDto(Landmark landmark) {
        Long hotelId = (landmark.getHotel() != null) ? landmark.getHotel().getId() : null;
        return new LandmarkDto(
                landmark.getId(),
                landmark.getLandmarkName(),
                landmark.getLandmarkDist(),
                hotelId
        );
    }
}