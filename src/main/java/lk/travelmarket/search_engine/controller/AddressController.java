package lk.travelmarket.search_engine.controller;

import lk.travelmarket.search_engine.dao.Address;
import lk.travelmarket.search_engine.dto.AddressDto;
import lk.travelmarket.search_engine.dto.criteria.AddressCreationCriteria;
import lk.travelmarket.search_engine.network.CCResponseWrapper;
import lk.travelmarket.search_engine.network.commons.CCResponsePack;
import lk.travelmarket.search_engine.service.address.AddressService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class AddressController implements IAddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @Override
    public ResponseEntity<CCResponseWrapper<AddressDto>> getAllAddresses() {
        CCResponsePack<AddressDto> response = addressService.getAllAddresses();
        return ResponseEntity.ok(new CCResponseWrapper<>(response));
    }

    @Override
    public ResponseEntity<CCResponseWrapper<AddressDto>> getAddressById(@PathVariable Long id) {
        CCResponsePack<AddressDto> response = addressService.getAddressById(id);
        return ResponseEntity.ok(new CCResponseWrapper<>(response));
    }

    @Override
    public ResponseEntity<CCResponseWrapper<AddressDto>> createAddress(@RequestBody AddressCreationCriteria criteria) {
        CCResponsePack<AddressDto> response = addressService.createAddress(criteria);
        return ResponseEntity.ok(new CCResponseWrapper<>(response));
    }

    @Override
    public ResponseEntity<CCResponseWrapper<AddressDto>> updateAddress(@PathVariable Long id, @RequestBody Address addressDetails) {
        CCResponsePack<AddressDto> response = addressService.updateAddress(id, addressDetails);
        return ResponseEntity.ok(new CCResponseWrapper<>(response));
    }

    @Override
    public ResponseEntity<CCResponseWrapper<Boolean>> deleteAddress(@PathVariable Long id) {
        CCResponsePack<Boolean> response = addressService.deleteAddress(id);
        return ResponseEntity.ok(new CCResponseWrapper<>(response));
    }
}
