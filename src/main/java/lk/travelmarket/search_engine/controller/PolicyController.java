package lk.travelmarket.search_engine.controller;

import jakarta.validation.Valid;
import lk.travelmarket.search_engine.dto.PolicyDto;
import lk.travelmarket.search_engine.network.CCResponseWrapper;
import lk.travelmarket.search_engine.network.util.NetworkUtils;
import lk.travelmarket.search_engine.service.Policy.IPolicyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/policies")
public class PolicyController implements IPolicyController {

    private final IPolicyService policyService;

    public PolicyController(IPolicyService policyService) {
        this.policyService = policyService;
    }

    @PostMapping
    public ResponseEntity<CCResponseWrapper<PolicyDto>> create(@Valid @RequestBody PolicyDto request) {
        return NetworkUtils.wrap(policyService.createPolicy(request));
    }

    @GetMapping
    public ResponseEntity<CCResponseWrapper<PolicyDto>> getAll() {
        return NetworkUtils.wrap(policyService.findAll());
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<CCResponseWrapper<PolicyDto>> getById(@PathVariable Long id) {
        return NetworkUtils.wrap(policyService.findPolicy(id));
    }

    @Override
    @PutMapping("/{id}")
    public ResponseEntity<CCResponseWrapper<PolicyDto>> update(@PathVariable Long id, @Valid @RequestBody PolicyDto request) {
        return NetworkUtils.wrap(policyService.updatePolicy(id, request));
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<CCResponseWrapper<PolicyDto>> delete(@PathVariable Long id) {
        return NetworkUtils.wrap(policyService.deletePolicy(id));
    }

}