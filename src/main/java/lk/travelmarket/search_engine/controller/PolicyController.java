package lk.travelmarket.search_engine.controller;

import jakarta.validation.Valid;
import lk.travelmarket.search_engine.dto.Policy.PolicyBulkRequestDto;
import lk.travelmarket.search_engine.dto.Policy.PolicyDto;
import lk.travelmarket.search_engine.network.CCResponseWrapper;
import lk.travelmarket.search_engine.network.util.NetworkUtils;
import lk.travelmarket.search_engine.service.Policy.IPolicyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PolicyController implements IPolicyController {

    private final IPolicyService policyService;

    public PolicyController(IPolicyService policyService) {
        this.policyService = policyService;
    }


    @Override
    @GetMapping("/hotels/{hotelId}/policies")
    public ResponseEntity<CCResponseWrapper<List<PolicyDto>>> getPolicies(@PathVariable String hotelId) {
        return NetworkUtils.wrap(policyService.findPoliciesByHotelId(hotelId));
    }

    @Override
    @PatchMapping("/hotels/{hotelId}/policies")
    public ResponseEntity<CCResponseWrapper<List<PolicyDto>>> bulkUpdatePolicies(
            @PathVariable String hotelId,
            @Valid @RequestBody PolicyBulkRequestDto request) {
        return NetworkUtils.wrap(policyService.bulkUpdatePolicies(hotelId, request));
    }

    // ---------- Basic policy CRUD ----------

    @PostMapping("/policies")
    public ResponseEntity<CCResponseWrapper<PolicyDto>> create(@Valid @RequestBody PolicyDto request) {
        return NetworkUtils.wrap(policyService.createPolicy(request));
    }

    @GetMapping("/policies")
    public ResponseEntity<CCResponseWrapper<PolicyDto>> getAll() {
        return NetworkUtils.wrap(policyService.findAll());
    }

    @Override
    @GetMapping("/policies/{id}")
    public ResponseEntity<CCResponseWrapper<PolicyDto>> getById(@PathVariable Long id) {
        return NetworkUtils.wrap(policyService.findPolicy(id));
    }

    @Override
    @PutMapping("/policies/{id}")
    public ResponseEntity<CCResponseWrapper<PolicyDto>> update(@PathVariable Long id,
                                                               @Valid @RequestBody PolicyDto request) {
        return NetworkUtils.wrap(policyService.updatePolicy(id, request));
    }

    @Override
    @DeleteMapping("/policies/{id}")
    public ResponseEntity<CCResponseWrapper<PolicyDto>> delete(@PathVariable Long id) {
        return NetworkUtils.wrap(policyService.deletePolicy(id));
    }
}