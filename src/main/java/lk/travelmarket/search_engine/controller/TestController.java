package lk.travelmarket.search_engine.controller;

import lk.travelmarket.search_engine.dto.TestDto;
import lk.travelmarket.search_engine.network.CCResponseWrapper;
import lk.travelmarket.search_engine.network.util.NetworkUtils;
import lk.travelmarket.search_engine.service.ITestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestController implements ITestController {

    private final ITestService testService;

    public TestController(ITestService testService) {
        this.testService = testService;
    }

    @Override
    public ResponseEntity<CCResponseWrapper<TestDto>> getTest() {
        return NetworkUtils.wrap( testService.findAll() );
    }
}
