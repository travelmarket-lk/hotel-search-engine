package lk.travelmarket.search_engine.controller;

import lk.travelmarket.search_engine.dto.TestDto;
import lk.travelmarket.search_engine.network.CCResponseWrapper;
import lk.travelmarket.search_engine.util.EndpointConstants;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(EndpointConstants.V1)
public interface ITestController {

    @GetMapping(EndpointConstants.TEST)
    public ResponseEntity<CCResponseWrapper<TestDto>> getTest();

}
