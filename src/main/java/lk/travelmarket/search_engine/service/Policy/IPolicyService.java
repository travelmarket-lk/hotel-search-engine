package lk.travelmarket.search_engine.service.Policy;

import jakarta.validation.Valid;
import lk.travelmarket.search_engine.dto.PolicyBulkRequestDto;
import lk.travelmarket.search_engine.dto.PolicyDto;
import lk.travelmarket.search_engine.network.commons.CCResponse;
import lk.travelmarket.search_engine.network.commons.CCResponsePack;

import java.util.List;

public interface IPolicyService {


    CCResponse<PolicyDto> createPolicy(PolicyDto dto);


    CCResponse<PolicyDto> findPolicy(Long id);

    CCResponse<PolicyDto> findPolicy(String id);

    CCResponsePack<PolicyDto> findAll();


    CCResponse<PolicyDto> updatePolicy(Long id, PolicyDto dto);


    CCResponse<PolicyDto> updatePolicy(String id, PolicyDto dto);

    CCResponse<PolicyDto> deletePolicy(Long id);

    CCResponse<PolicyDto> createpolicy(PolicyDto request);

    CCResponse<PolicyDto> findpolicy(String s);

    CCResponse<PolicyDto> updatepolicy(String s, PolicyDto request);

    CCResponse deletepolicy(String s);

    CCResponse<List<PolicyDto>> findPoliciesByHotelId(String hotelId);

    CCResponse bulkUpdatePolicies(String hotelId, @Valid PolicyBulkRequestDto request);
}