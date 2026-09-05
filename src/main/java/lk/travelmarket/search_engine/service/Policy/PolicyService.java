package lk.travelmarket.search_engine.service.Policy;

import lk.travelmarket.search_engine.Repository.PolicyRepository;
import lk.travelmarket.search_engine.dao.Policy.Policy;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PolicyService {

    private final PolicyRepository policyRepository;

    public PolicyService(PolicyRepository policyRepository) {
        this.policyRepository = policyRepository;
    }

    public List<Policy> getAllPolicies() {
        return policyRepository.findAll();
    }

    public Policy savePolicy(Policy policy) {
        return policyRepository.save(policy);
    }
}
