package lk.travelmarket.search_engine.service.Policy;

import lk.travelmarket.search_engine.dto.PolicyDto;
import lk.travelmarket.search_engine.network.commons.CCError;
import lk.travelmarket.search_engine.network.commons.CCErrorStatus;
import lk.travelmarket.search_engine.network.commons.CCResponse;
import lk.travelmarket.search_engine.network.commons.CCResponsePack;
import lk.travelmarket.search_engine.network.error.code.ErrorLayer;
import lk.travelmarket.search_engine.network.error.code.ErrorSource;
import lk.travelmarket.search_engine.network.error.code.Status;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PolicyService implements IPolicyService {

    static final String ERROR_RETRIEVE_POLICIES = "Error occurred while retrieving policies";
    static final String ERROR_CREATE_POLICY = "Error occurred while creating policy";
    static final String ERROR_UPDATE_POLICY = "Error occurred while updating policy";
    static final String ERROR_DELETE_POLICY = "Error occurred while deleting policy";
    static final String ERROR_RETRIEVE_POLICY = "Error occurred while retrieving policy";

    private final PolicyServiceImpl policyServiceImpl;

    public PolicyService(PolicyServiceImpl policyServiceImpl) {
        this.policyServiceImpl = policyServiceImpl;
    }

    @Override
    public CCResponse<PolicyDto> createPolicy(PolicyDto dto) {
        try {
            CCError<PolicyDto> response = policyServiceImpl.createPolicy(dto);
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
            CCError<PolicyDto> response = policyServiceImpl.findPolicy(id);
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
            CCError<List<PolicyDto>> response = policyServiceImpl.findAll();
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
            CCError<PolicyDto> response = policyServiceImpl.updatePolicy(id, dto);
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
            CCError<PolicyDto> response = policyServiceImpl.deletePolicy(id);
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
    public CCResponse deletepolicy(String s) {
        return null;
    }
}