package lk.travelmarket.search_engine.service.address;

import lk.travelmarket.search_engine.dao.Address;
import lk.travelmarket.search_engine.dto.AddressDto;
import lk.travelmarket.search_engine.dto.criteria.AddressCreationCriteria;
import lk.travelmarket.search_engine.network.commons.CCError;
import lk.travelmarket.search_engine.network.commons.CCErrorStatus;
import lk.travelmarket.search_engine.network.commons.CCResponsePack;
import lk.travelmarket.search_engine.network.error.code.ErrorLayer;
import lk.travelmarket.search_engine.network.error.code.ErrorSource;
import lk.travelmarket.search_engine.network.error.code.Status;
import org.springframework.stereotype.Service;

import java.util.List;

import static lk.travelmarket.search_engine.util.Constants.*;

@Service
public class AddressService implements IAddressService {

    private final AddressServiceImpl addressServiceImpl;

    public AddressService(AddressServiceImpl addressServiceImpl) {
        this.addressServiceImpl = addressServiceImpl;
    }

    @Override
    public CCResponsePack<AddressDto> getAllAddresses() {
        try {
            CCError<List<AddressDto>> ccError = addressServiceImpl.findAll();
            if (ccError.getStatus().equals(CCErrorStatus.ERROR)) {
                return new CCResponsePack<>(Status.ERROR, ccError.getMessage(), null);
            }
            return new CCResponsePack<>(ccError.getData());
        } catch (Exception e) {
            return new CCResponsePack<>(ErrorLayer.HSL_LAYER, ErrorSource.SERVER_ERROR, ERROR_RETRIEVE_ADDRESSES, e);
        }
    }

    @Override
    public CCResponsePack<AddressDto> getAddressById(Long id) {
        try {
            CCError<AddressDto> ccError = addressServiceImpl.findById(id);
            if (ccError.getStatus().equals(CCErrorStatus.ERROR)) {
                return new CCResponsePack<>(Status.ERROR, ccError.getMessage(), null);
            }
            return new CCResponsePack<>(List.of(ccError.getData()));
        } catch (Exception e) {
            return new CCResponsePack<>(ErrorLayer.HSL_LAYER, ErrorSource.SERVER_ERROR, ERROR_RETRIEVE_ADDRESS, e);
        }
    }

    @Override
    public CCResponsePack<AddressDto> createAddress(AddressCreationCriteria criteria) {
        try {
            CCError<AddressDto> ccError = addressServiceImpl.create(criteria);
            if (ccError.getStatus().equals(CCErrorStatus.ERROR)) {
                return new CCResponsePack<>(Status.ERROR, ccError.getMessage(), null);
            }
            return new CCResponsePack<>(List.of(ccError.getData()));
        } catch (Exception e) {
            return new CCResponsePack<>(ErrorLayer.HSL_LAYER, ErrorSource.SERVER_ERROR, ERROR_CREATE_ADDRESS, e);
        }
    }

    @Override
    public CCResponsePack<AddressDto> updateAddress(Long id, Address addressDetails) {
        try {
            CCError<AddressDto> ccError = addressServiceImpl.update(id, addressDetails);
            if (ccError.getStatus().equals(CCErrorStatus.ERROR)) {
                return new CCResponsePack<>(Status.ERROR, ccError.getMessage(), null);
            }
            return new CCResponsePack<>(List.of(ccError.getData()));
        } catch (Exception e) {
            return new CCResponsePack<>(ErrorLayer.HSL_LAYER, ErrorSource.SERVER_ERROR, ERROR_UPDATE_ADDRESS, e);
        }
    }

    @Override
    public CCResponsePack<Boolean> deleteAddress(Long id) {
        try {
            CCError<Boolean> ccError = addressServiceImpl.delete(id);
            if (ccError.getStatus().equals(CCErrorStatus.ERROR)) {
                return new CCResponsePack<>(Status.ERROR, ccError.getMessage(), null);
            }
            return new CCResponsePack<>(List.of(ccError.getData()));
        } catch (Exception e) {
            return new CCResponsePack<>(ErrorLayer.HSL_LAYER, ErrorSource.SERVER_ERROR, ERROR_DELETE_ADDRESS, e);
        }
    }
}
