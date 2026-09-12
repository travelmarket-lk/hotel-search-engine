package lk.travelmarket.search_engine.controller;

import lk.travelmarket.search_engine.dao.Address;
import lk.travelmarket.search_engine.dto.AddressDto;
import lk.travelmarket.search_engine.dto.criteria.AddressCreationCriteria;
import lk.travelmarket.search_engine.network.CCResponseWrapper;
import lk.travelmarket.search_engine.util.EndpointConstants;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(EndpointConstants.V1)
public interface IAddressController {

    @GetMapping(EndpointConstants.ADDRESS)
    ResponseEntity<CCResponseWrapper<AddressDto>> getAllAddresses();

    @GetMapping(EndpointConstants.ADDRESS_BY_ID)
    ResponseEntity<CCResponseWrapper<AddressDto>> getAddressById(@PathVariable Long id);

    @PostMapping(EndpointConstants.ADDRESS)
    ResponseEntity<CCResponseWrapper<AddressDto>> createAddress(@RequestBody AddressCreationCriteria criteria);

    @PutMapping(EndpointConstants.ADDRESS_BY_ID)
    ResponseEntity<CCResponseWrapper<AddressDto>> updateAddress(@PathVariable Long id, @RequestBody Address addressDetails);

    @DeleteMapping(EndpointConstants.ADDRESS_BY_ID)
    ResponseEntity<CCResponseWrapper<Boolean>> deleteAddress(@PathVariable Long id);
}
