package lk.travelmarket.search_engine.service.Policy;

import lk.travelmarket.search_engine.dto.Policy.PolicyBulkRequestDto;
import lk.travelmarket.search_engine.dto.Policy.PolicyDto;
import lk.travelmarket.search_engine.network.commons.CCErrorStatus;
import lk.travelmarket.search_engine.network.commons.CCResponse;
import lk.travelmarket.search_engine.network.commons.CCResponsePack;
import lk.travelmarket.search_engine.network.error.code.ErrorLayer;
import lk.travelmarket.search_engine.network.error.code.ErrorSource;
import lk.travelmarket.search_engine.network.error.code.Status;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PolicyService implements IPolicyService {

    static final String ERROR_RETRIEVE_POLICIES = "Error occurred while retrieving policies";
    static final String ERROR_CREATE_POLICY = "Error occurred while creating policy";
    static final String ERROR_UPDATE_POLICY = "Error occurred while updating policy";
    static final String ERROR_DELETE_POLICY = "Error occurred while deleting policy";
    static final String ERROR_RETRIEVE_POLICY = "Error occurred while retrieving policy";

    private final PolicyServiceImpl policyServiceImpl;

    @Override
    public CCResponse<PolicyDto> createPolicy(PolicyDto dto) {
        try {
            CCResponse<PolicyDto> response = policyServiceImpl.createPolicy(dto);
            if (response.getStatus().equals(CCErrorStatus.ERROR)) {
                return new CCResponse<>(Status.ERROR, response.getMessage(), null);
            }
            return new CCResponse<>(response.getData());
        } catch (Exception e) {
            return new CCResponse<>(ErrorLayer.HSL_LAYER, ErrorSource.SERVER_ERROR, ERROR_CREATE_POLICY, e);
        }
    }

    @Override
    public CCResponse<PolicyDto> findPolicy(Long id) {
        try {
            CCResponse<PolicyDto> response = policyServiceImpl.findPolicy(id);
            if (response.getStatus().equals(CCErrorStatus.ERROR)) {
                return new CCResponse<>(Status.ERROR, response.getMessage(), null);
            }
            return new CCResponse<>(response.getData());
        } catch (Exception e) {
            return new CCResponse<>(ErrorLayer.HSL_LAYER, ErrorSource.SERVER_ERROR, ERROR_RETRIEVE_POLICY, e);
        }
    }

    @Override
    public CCResponse<PolicyDto> findPolicy(String id) {
        return findPolicy(Long.parseLong(id));
    }

    @Override
    public CCResponsePack<PolicyDto> findAll() {
        try {
            CCResponsePack<PolicyDto> response = policyServiceImpl.findAll();
            if (response.getStatus().equals(CCErrorStatus.ERROR)) {
                return new CCResponsePack<>(Status.ERROR, response.getMessage(), null);
            }
            return new CCResponsePack<>(response.getData());
        } catch (Exception e) {
            return new CCResponsePack<>(ErrorLayer.HSL_LAYER, ErrorSource.SERVER_ERROR, ERROR_RETRIEVE_POLICIES, e);
        }
    }

    @Override
    public CCResponse<PolicyDto> updatePolicy(Long id, PolicyDto dto) {
        try {
            CCResponse<PolicyDto> response = policyServiceImpl.updatePolicy(id, dto);
            if (response.getStatus().equals(CCErrorStatus.ERROR)) {
                return new CCResponse<>(Status.ERROR, response.getMessage(), null);
            }
            return new CCResponse<>(response.getData());
        } catch (Exception e) {
            return new CCResponse<>(ErrorLayer.HSL_LAYER, ErrorSource.SERVER_ERROR, ERROR_UPDATE_POLICY, e);
        }
    }

    @Override
    public CCResponse<PolicyDto> updatePolicy(String id, PolicyDto dto) {
        return updatePolicy(Long.parseLong(id), dto);
    }

    @Override
    public CCResponse<PolicyDto> deletePolicy(Long id) {
        try {
            CCResponse<PolicyDto> response = policyServiceImpl.deletePolicy(id);
            if (response.getStatus().equals(CCErrorStatus.ERROR)) {
                return new CCResponse<>(Status.ERROR, response.getMessage(), null);
            }
            return new CCResponse<>(response.getData());
        } catch (Exception e) {
            return new CCResponse<>(ErrorLayer.HSL_LAYER, ErrorSource.SERVER_ERROR, ERROR_DELETE_POLICY, e);
        }
    }

    @Override
    public CCResponse<PolicyDto> createpolicy(PolicyDto request) {
        return null;
    }

    @Override
    public CCResponse<PolicyDto> findpolicy(String s) {
        return null;
    }

    @Override
    public CCResponse<PolicyDto> updatepolicy(String s, PolicyDto request) {
        return null;
    }

    @Override
    public CCResponse<PolicyDto> deletepolicy(String s) {
        return null;
    }

    @Override
    public CCResponse findPoliciesByHotelId(String hotelId) {
        return null;
    }

    @Override
    public CCResponse bulkUpdatePolicies(String hotelId, PolicyBulkRequestDto request) {
        return null;
    }

}

