package lk.travelmarket.search_engine.controller;

import lk.travelmarket.search_engine.dao.Policy.Policy;
import lk.travelmarket.search_engine.service.Policy.PolicyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/policies")
public class PolicyController {

    private final PolicyService policyService;

    public PolicyController(PolicyService policyService) {
        this.policyService = policyService;
    }
    
    @GetMapping
    public List<Policy> getAllPolicies() {
        return policyService.getAllPolicies();
    }
    
    @PostMapping
    public Policy createPolicy(@RequestBody Policy policy) {
        return policyService.savePolicy(policy);
    }


}