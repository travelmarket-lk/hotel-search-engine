package lk.travelmarket.search_engine.service.Policy;

import jakarta.transaction.Transactional;
import lk.travelmarket.search_engine.Repository.PolicyRepository;
import lk.travelmarket.search_engine.dao.Policy.Policy;
import lk.travelmarket.search_engine.dto.PolicyBulkRequestDto;
import lk.travelmarket.search_engine.dto.PolicyDto;
import lk.travelmarket.search_engine.network.commons.CCError;
import lk.travelmarket.search_engine.network.commons.CCErrorStatus;
import lk.travelmarket.search_engine.network.commons.CCResponse;
import lk.travelmarket.search_engine.network.commons.CCResponsePack;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class PolicyServiceImpl implements IPolicyService {

    private final PolicyRepository policyRepository;

    public PolicyServiceImpl(PolicyRepository policyRepository) {
        this.policyRepository = policyRepository;
    }

    public CCError<List<PolicyDto>> findPoliciesByHotelId(String hotelId) {
        CCError<List<PolicyDto>> ccError = new CCError<>(CCErrorStatus.SUCCESS, "Policies retrieved successfully");


        List<PolicyDto> policyData = this.policyRepository.findByHotelId(hotelId).stream()
                .map(this::toDto)
                .toList();

        ccError.setData(policyData);
        return ccError;
    }

    public CCError<List<PolicyDto>> bulkUpdatePolicies(String hotelId, PolicyBulkRequestDto request) {
        CCError<List<PolicyDto>> ccError = new CCError<>(CCErrorStatus.SUCCESS, "Policies updated successfully");


        if (request.getCreated() != null) {
            for (PolicyDto dto : request.getCreated()) {
                Policy entity = new Policy();
                entity.setHotelId(hotelId);
                entity.setName(dto.getName());
                entity.setDescription(dto.getDescription());
                policyRepository.save(entity);
            }
        }


        if (request.getModified() != null) {
            for (PolicyDto dto : request.getModified()) {
                if (dto.getId() != null) {
                    policyRepository.findById(dto.getId()).ifPresent(entity -> {
                        entity.setName(dto.getName());
                        entity.setDescription(dto.getDescription());
                        policyRepository.save(entity);
                    });
                }
            }
        }


        if (request.getDeleted() != null && !request.getDeleted().isEmpty()) {
            policyRepository.deleteAllById(List.of(request.getDeleted()));
        }


        return findPoliciesByHotelId(hotelId);
    }

    private PolicyDto toDto(Policy policy) {
        PolicyDto policyDto = new PolicyDto();
        policyDto.setId(policy.getPolicyId());
        policyDto.setName(policy.getName());
        policyDto.setDescription(policy.getPolicyDetails());
        return policyDto;
    }

    @Override
    public CCResponse<PolicyDto> createPolicy(PolicyDto dto) {
        return null;
    }

    @Override
    public CCResponse<PolicyDto> findPolicy(Long id) {
        return null;
    }

    @Override
    public CCResponse<PolicyDto> findPolicy(String id) {
        return null;
    }

    @Override
    public CCResponsePack<PolicyDto> findAll() {
        return null;
    }

    @Override
    public CCResponse<PolicyDto> updatePolicy(Long id, PolicyDto dto) {
        return null;
    }

    @Override
    public CCResponse<PolicyDto> updatePolicy(String id, PolicyDto dto) {
        return null;
    }

    @Override
    public CCResponse<PolicyDto> deletePolicy(Long id) {
        return null;
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