package lk.travelmarket.search_engine.service.address;

import lk.travelmarket.search_engine.dao.Address;
import lk.travelmarket.search_engine.dto.AddressDto;
import lk.travelmarket.search_engine.dto.criteria.AddressCreationCriteria;
import lk.travelmarket.search_engine.network.commons.CCResponsePack;

public interface IAddressService {
    CCResponsePack<AddressDto> getAllAddresses();
    CCResponsePack<AddressDto> getAddressById(Long id);

    CCResponsePack<AddressDto> createAddress(AddressCreationCriteria criteria);

    CCResponsePack<AddressDto> updateAddress(Long id, Address addressDetails);

    CCResponsePack<Boolean> deleteAddress(Long id);
}
