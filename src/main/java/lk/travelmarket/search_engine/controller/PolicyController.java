package lk.travelmarket.search_engine.controller;

import lk.travelmarket.search_engine.dto.PolicyDto;
import lk.travelmarket.search_engine.network.CCResponseWrapper;
import lk.travelmarket.search_engine.network.util.NetworkUtils;
import lk.travelmarket.search_engine.service.Policy.IPolicyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PolicyController implements IPolicyController {

    private final IPolicyService policyService;

    public PolicyController(IPolicyService policyService) {
        this.policyService = policyService;
    }

    @Override
    public ResponseEntity<CCResponseWrapper<PolicyDto>> create(PolicyDto request) {
        return NetworkUtils.wrap( policyService.createpolicy( request) );
    }


    @Override
    public ResponseEntity<CCResponseWrapper<PolicyDto>> getAll() {
        return NetworkUtils.wrap( policyService.findAll() );
    }

    @Override
    public ResponseEntity<CCResponseWrapper<PolicyDto>> getById(Long id) {
        return NetworkUtils.wrap( policyService.findpolicy(String.valueOf(id)) );
    }

    @Override
    public ResponseEntity<CCResponseWrapper<PolicyDto>> update(Long id, PolicyDto request) {
        return NetworkUtils.wrap( policyService.updatepolicy(String.valueOf(id), request) );
    }

    @Override
    public ResponseEntity<CCResponseWrapper<PolicyDto>> delete(Long id) {
        return NetworkUtils.wrap( policyService.deletepolicy( String.valueOf(id) ) );
    }

}
