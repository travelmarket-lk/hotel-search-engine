package lk.travelmarket.search_engine.controller;

import lk.travelmarket.search_engine.dto.TestDto;
import lk.travelmarket.search_engine.network.CCResponseWrapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController implements ITestController {

    @Override
    public ResponseEntity<CCResponseWrapper<TestDto>> getTest() {
        return null;
    }
}
