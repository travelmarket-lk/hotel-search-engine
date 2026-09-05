package lk.travelmarket.search_engine.service.hotelOwner;

import jakarta.transaction.Transactional;
import lk.travelmarket.search_engine.dao.HotelOwner;
import lk.travelmarket.search_engine.dao.user.User;
import lk.travelmarket.search_engine.dto.HotelOwnerDto;
import lk.travelmarket.search_engine.network.commons.CCError;
import lk.travelmarket.search_engine.network.commons.CCErrorStatus;
import lk.travelmarket.search_engine.repository.HotelOwnerRepository;
import lk.travelmarket.search_engine.repository.UserRepository;
import org.springframework.stereotype.Component;

import static lk.travelmarket.search_engine.util.Constants.*;

@Component
@Transactional
public class HotelOwnerServiceImpl {

    private final HotelOwnerRepository hotelOwnerRepository;
    private final UserRepository userRepository;

    public HotelOwnerServiceImpl(HotelOwnerRepository hotelOwnerRepository, UserRepository userRepository) {

        this.hotelOwnerRepository = hotelOwnerRepository;
        this.userRepository = userRepository;

    }

    public CCError<HotelOwnerDto> registerOwner(HotelOwnerDto dto) {

        CCError<HotelOwnerDto> ccError = new CCError<>(CCErrorStatus.SUCCESS, SUCCESS_REGISTER_HOTEL_OWNER);

        // Check whether email already exists
        if (userRepository.existsByEmail(dto.getEmail())) {

            ccError.setStatus(CCErrorStatus.ERROR);
            ccError.setMessage(ERROR_HOTEL_OWNER_EMAIL_ALREADY_EXISTS);

            return ccError;
        }

        // Check whether NIC already exists
        if (hotelOwnerRepository.existsByNic(dto.getNic())) {ccError.setStatus(CCErrorStatus.ERROR);
            ccError.setMessage(ERROR_HOTEL_OWNER_NIC_ALREADY_EXISTS);

            return ccError;
        }

        // 1. Create User
        User user = new User();

        user.setUsername(dto.getEmail());
        user.setEmail(dto.getEmail());

        user.setEnabled(true);
        user.setAccountNonExpired(true);
        user.setCredentialsNonExpired(true);
        user.setAccountNonLocked(true);

        User savedUser = userRepository.save(user);

        // 2. Create Hotel Owner
        HotelOwner hotelOwner = new HotelOwner();

        hotelOwner.setName(dto.getName());
        hotelOwner.setPhoneNumber(dto.getPhoneNumber());
        hotelOwner.setNic(dto.getNic());
        hotelOwner.setEmail(dto.getEmail());

        // 3. Link Hotel Owner to User
        hotelOwner.setUser(savedUser);

        HotelOwner savedOwner = hotelOwnerRepository.save(hotelOwner);

        // 4. Convert to DTO
        HotelOwnerDto ownerData =
                this.toDto(savedOwner);

        ccError.setData(ownerData);

        return ccError;
    }

    private HotelOwnerDto toDto(
            HotelOwner hotelOwner) {

        return new HotelOwnerDto(
                hotelOwner.getId(),
                hotelOwner.getName(),
                hotelOwner.getPhoneNumber(),
                hotelOwner.getNic(),
                hotelOwner.getEmail()
        );
    }
}