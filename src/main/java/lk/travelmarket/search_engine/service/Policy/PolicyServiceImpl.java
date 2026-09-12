package lk.travelmarket.search_engine.service.Policy;

import jakarta.transaction.Transactional;
import lk.travelmarket.search_engine.Repository.PolicyRepository;
import lk.travelmarket.search_engine.dao.Policy.Policy;
import lk.travelmarket.search_engine.dto.PolicyDto;
import lk.travelmarket.search_engine.network.commons.CCError;
import lk.travelmarket.search_engine.network.commons.CCErrorStatus;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
@Transactional
public class PolicyServiceImpl {

    private final PolicyRepository policyRepository;

    public PolicyServiceImpl(PolicyRepository policyRepository) {
        this.policyRepository = policyRepository;
    }

    public CCError<List<PolicyDto>> findAll() {
        CCError<List<PolicyDto>> ccError = new CCError<>(CCErrorStatus.SUCCESS, "Policies retrieved successfully");
        List<PolicyDto> policyData = this.policyRepository.findAll().stream()
                .map(this::toDto)
                .toList();
        ccError.setData(policyData);
        return ccError;
    }

    public CCError<PolicyDto> findPolicy( Long id ) {
        CCError<PolicyDto> ccError = new CCError<>(CCErrorStatus.SUCCESS, "Policy retrieved successfully");

        Optional<Policy> dao = this.policyRepository.findById(String.valueOf(id));

        if( dao.isEmpty() )
        {
            ccError.setStatus( CCErrorStatus.ERROR );
            ccError.setMessage( "Policy retrieve not found" );
            return ccError;
        }

        PolicyDto policyData = this.toDto( dao.get() );
        ccError.setData(policyData);
        return ccError;
    }

    public CCError<PolicyDto> createPolicy( PolicyDto dto ) {
        CCError<PolicyDto> ccError = new CCError<>(CCErrorStatus.SUCCESS, "Policy created successfully");

        Policy dao = new Policy();
        String name = dto.getPolicyName();
        String description = dto.getPolicyDescription();

        Policy savedPolicy = policyRepository.save( dao );

        PolicyDto policyData = this.toDto( savedPolicy );
        ccError.setData(policyData);
        return ccError;
    }

    public CCError<PolicyDto> updatePolicy( Long id, PolicyDto dto ) {
        CCError<PolicyDto> ccError = new CCError<>(CCErrorStatus.SUCCESS, "Policy updated successfully");

        Optional<Policy> dao = this.policyRepository.findById(String.valueOf(id));

        if( dao.isEmpty() )
        {
            ccError.setStatus( CCErrorStatus.ERROR );
            ccError.setMessage( "Policy retrieve  not found" );
            return ccError;
        }

        dao.get().setName( dto.getName() );
        dao.get().setDescription( dto.getDescription());

        this.policyRepository.save( dao.get() );

        PolicyDto policyData = this.toDto( dao.get() );
        ccError.setData(policyData);
        return ccError;
    }

    public CCError<PolicyDto> deletePolicy( Long id ) {
        CCError<PolicyDto> ccError = new CCError<>(CCErrorStatus.SUCCESS, "Policy deleted successfully");

        Optional<Policy> dao = this.policyRepository.findById(String.valueOf(id));

        if( dao.isEmpty() )
        {
            ccError.setStatus( CCErrorStatus.ERROR );
            ccError.setMessage( "Policy retrieve not found" );
            return ccError;
        }

        this.policyRepository.delete( dao.get() );

        PolicyDto policyData = this.toDto( dao.get() );
        ccError.setData(policyData);
        return ccError;
    }

    private PolicyDto toDto(Policy policy) {
        PolicyDto policyDto = new PolicyDto();
        String arg1 = policy.getPolicyId();
        policyDto.setField1(arg1);
        String arg2 = policy.getPolicyDetails();
        policyDto.setField2(arg2);
        String arg3 = policy.getName();
        policyDto.setField3(arg3);
        return policyDto;
    }

}
