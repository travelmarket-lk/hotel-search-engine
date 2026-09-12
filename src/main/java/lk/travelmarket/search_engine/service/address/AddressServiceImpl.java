package lk.travelmarket.search_engine.service.address;
import lk.travelmarket.search_engine.dao.Address;
import lk.travelmarket.search_engine.dto.AddressDto;
import lk.travelmarket.search_engine.dto.criteria.AddressCreationCriteria;
import lk.travelmarket.search_engine.network.commons.CCError;
import lk.travelmarket.search_engine.network.commons.CCErrorStatus;
import lk.travelmarket.search_engine.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static lk.travelmarket.search_engine.util.Constants.*;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl {

    private final AddressRepository addressRepository;

    public CCError<List<AddressDto>> findAll() {
        CCError<List<AddressDto>> ccError = new CCError<>(CCErrorStatus.SUCCESS, SUCCESS_RETRIEVE_ADDRESSES);
        List<AddressDto> addresses = addressRepository.findAll().stream()
                .map(this::toDto)
                .toList();
        ccError.setData(addresses);
        return ccError;
    }

    public CCError<AddressDto> findById(Long id) {
        Optional<Address> addressOpt = addressRepository.findById(id);
        CCError<AddressDto> ccError;
        if (addressOpt.isPresent()) {
            ccError = new CCError<>(CCErrorStatus.SUCCESS, SUCCESS_RETRIEVE_ADDRESS);
            ccError.setData(toDto(addressOpt.get()));
        } else {
            ccError = new CCError<>(CCErrorStatus.ERROR, ERROR_RETRIEVE_ADDRESS);
            ccError.setData(null);
        }
        return ccError;
    }

    public CCError<AddressDto> create(AddressCreationCriteria criteria) {
        Address address = new Address();
        address.setAddressLine1(criteria.getAddressLine1());
        address.setAddressLine2(criteria.getAddressLine2());

        Address saved = addressRepository.save(address);
        CCError<AddressDto> ccError = new CCError<>(CCErrorStatus.SUCCESS, SUCCESS_CREATE_ADDRESS);
        ccError.setData(toDto(saved));
        return ccError;
    }

    public CCError<AddressDto> update(Long id, Address addressDetails) {
        Optional<Address> addressOpt = addressRepository.findById(id);
        CCError<AddressDto> ccError;

        if (addressOpt.isPresent()) {
            Address address = addressOpt.get();
            address.setAddressLine1(addressDetails.getAddressLine1());
            address.setAddressLine2(addressDetails.getAddressLine2());

            Address updated = addressRepository.save(address);
            ccError = new CCError<>(CCErrorStatus.SUCCESS, SUCCESS_UPDATE_ADDRESS);
            ccError.setData(toDto(updated));
        } else {
            ccError = new CCError<>(CCErrorStatus.ERROR, ERROR_UPDATE_ADDRESS);
            ccError.setData(null);
        }

        return ccError;
    }

    public CCError<Boolean> delete(Long id) {
        Optional<Address> addressOpt = addressRepository.findById(id);
        if (addressOpt.isPresent()) {
            addressRepository.delete(addressOpt.get());
            CCError<Boolean> ccError = new CCError<>(CCErrorStatus.SUCCESS, SUCCESS_DELETE_ADDRESS);
            ccError.setData(true);
            return ccError;
        }
        CCError<Boolean> ccError = new CCError<>(CCErrorStatus.ERROR, ERROR_DELETE_ADDRESS);
        ccError.setData(false);
        return ccError;
    }

    private AddressDto toDto(Address address) {
        return new AddressDto(address.getId(), address.getAddressLine1(), address.getAddressLine2());
    }
}
