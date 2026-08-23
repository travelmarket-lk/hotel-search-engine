package lk.travelmarket.search_engine.service.hotelOwner;

import jakarta.transaction.Transactional;
import lk.travelmarket.search_engine.dao.HotelOwner;
import lk.travelmarket.search_engine.dto.HotelOwnerDto;
import lk.travelmarket.search_engine.network.commons.CCError;
import lk.travelmarket.search_engine.network.commons.CCErrorStatus;
import lk.travelmarket.search_engine.repository.HotelOwnerRepository;
import org.springframework.stereotype.Component;

import static lk.travelmarket.search_engine.util.Constants.SUCCESS_REGISTER_HOTEL_OWNER;

@Component
@Transactional
public class HotelOwnerServiceImpl {

    private final HotelOwnerRepository hotelOwnerRepository;

    public HotelOwnerServiceImpl(
            HotelOwnerRepository hotelOwnerRepository) {

        this.hotelOwnerRepository = hotelOwnerRepository;
    }

    public CCError<HotelOwnerDto> registerOwner(
            HotelOwnerDto dto) {

        CCError<HotelOwnerDto> ccError =
                new CCError<>(
                        CCErrorStatus.SUCCESS,
                        SUCCESS_REGISTER_HOTEL_OWNER
                );

        HotelOwner hotelOwner = new HotelOwner();

        hotelOwner.setName(dto.getName());
        hotelOwner.setPhoneNumber(dto.getPhoneNumber());
        hotelOwner.setNic(dto.getNic());
        hotelOwner.setEmail(dto.getEmail());

        HotelOwner savedOwner =
                hotelOwnerRepository.save(hotelOwner);

        HotelOwnerDto ownerData =
                this.toDto(savedOwner);

        ccError.setData(ownerData);

        return ccError;
    }

    private HotelOwnerDto toDto(HotelOwner hotelOwner) {

        return new HotelOwnerDto(
                hotelOwner.getId(),
                hotelOwner.getName(),
                hotelOwner.getPhoneNumber(),
                hotelOwner.getNic(),
                hotelOwner.getEmail()
        );
    }
}