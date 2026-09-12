package lk.travelmarket.search_engine.service.Policy;

import lk.travelmarket.search_engine.Repository.PolicyRepository;
import lk.travelmarket.search_engine.dao.Policy.Policy;
import lk.travelmarket.search_engine.dto.PolicyDto;
import lk.travelmarket.search_engine.network.commons.CCResponse;
import lk.travelmarket.search_engine.network.commons.CCResponsePack;
import lk.travelmarket.search_engine.network.error.code.ErrorLayer;
import lk.travelmarket.search_engine.network.error.code.ErrorSource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static lk.travelmarket.search_engine.service.Policy.PolicyService.*;

@Service
public class PolicyServiceImpl implements IPolicyService {

    private final PolicyRepository policyRepository;

    public PolicyServiceImpl(PolicyRepository policyRepository) {
        this.policyRepository = policyRepository;
    }

    @Override
    public CCResponse<PolicyDto> createPolicy(PolicyDto dto) {
        try {
            Policy policy = mapToEntity(dto);
            Policy savedPolicy = policyRepository.save(policy);
            return new CCResponse<>(mapToDto(savedPolicy));
        } catch (Exception e) {
            return new CCResponse<>(ErrorLayer.HSL_LAYER, ErrorSource.SERVER_ERROR, ERROR_CREATE_POLICY, e);
        }
    }

    @Override
    public CCResponse<PolicyDto> findPolicy(Long id) {
        try {
            Optional<Policy> optionalPolicy = policyRepository.findById(String.valueOf(id));
            if (optionalPolicy.isPresent()) {
                return new CCResponse<>(mapToDto(optionalPolicy.get()));
            }
            return new CCResponse<>(ErrorLayer.HSL_LAYER, ErrorSource.NOT_FOUND, ERROR_RETRIEVE_POLICY, null);
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
            List<PolicyDto> list = policyRepository.findAll()
                    .stream()
                    .map(this::mapToDto)
                    .collect(Collectors.toList());
            return new CCResponsePack<>(list);
        } catch (Exception e) {
            return new CCResponsePack<>(ErrorLayer.HSL_LAYER, ErrorSource.SERVER_ERROR, ERROR_RETRIEVE_POLICIES, e);
        }
    }

    @Override
    public CCResponse<PolicyDto> updatePolicy(Long id, PolicyDto dto) {
        try {
            Optional<Policy> optionalPolicy = policyRepository.findById(String.valueOf(id));
            if (optionalPolicy.isPresent()) {
                Policy policy = optionalPolicy.get();
                policy.setPolicyDetails(dto.getPolicyDetails());

                Policy updatedPolicy = policyRepository.save(policy);
                return new CCResponse<>(mapToDto(updatedPolicy));
            }
            return new CCResponse<>(ErrorLayer.HSL_LAYER, ErrorSource.NOT_FOUND, ERROR_UPDATE_POLICY, null);
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
            if (policyRepository.existsById(String.valueOf(id))) {
                policyRepository.deleteById(String.valueOf(id));
                return new CCResponse<>(null);
            }
            return new CCResponse<>(ErrorLayer.HSL_LAYER, ErrorSource.NOT_FOUND, ERROR_DELETE_POLICY, null);
        } catch (Exception e) {
            return new CCResponse<>(ErrorLayer.HSL_LAYER, ErrorSource.SERVER_ERROR, ERROR_DELETE_POLICY, e);
        }
    }

    @Override
    public CCResponse<PolicyDto> deletePolicy(String id) {
        return deletePolicy(Long.parseLong(id));
    }

    @Override
    public CCResponse createpolicy(PolicyDto request) {
        return null;
    }

    @Override
    public CCResponse findpolicy(String s) {
        return null;
    }

    @Override
    public CCResponse updatepolicy(String s, PolicyDto request) {
        return null;
    }

    @Override
    public CCResponse deletepolicy(String s) {
        return null;
    }

    private PolicyDto mapToDto(Policy policy) {
        PolicyDto dto = new PolicyDto();
        dto.setPolicyId(policy.getPolicyId());
        dto.setPolicyDetails(policy.getPolicyDetails());
        return dto;
    }

    private Policy mapToEntity(PolicyDto dto) {
        Policy policy = new Policy();
        policy.setPolicyId(dto.getPolicyId());
        policy.setPolicyDetails(dto.getPolicyDetails());
        return policy;
    }
}