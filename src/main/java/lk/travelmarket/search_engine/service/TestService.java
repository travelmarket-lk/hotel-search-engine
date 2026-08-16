package lk.travelmarket.search_engine.service;

import lk.travelmarket.search_engine.dao.test.TestRepository;
import lk.travelmarket.search_engine.dto.TestDto;
import lk.travelmarket.search_engine.network.commons.CCError;
import lk.travelmarket.search_engine.network.commons.CCErrorStatus;
import lk.travelmarket.search_engine.network.commons.CCResponsePack;
import lk.travelmarket.search_engine.network.error.code.ErrorLayer;
import lk.travelmarket.search_engine.network.error.code.ErrorSource;
import lk.travelmarket.search_engine.network.error.code.Status;
import org.springframework.stereotype.Service;

import java.util.List;

import static lk.travelmarket.search_engine.util.Constants.ERROR_RETRIEVE_TESTS;

@Service
public class TestService implements ITestService {

    private final TestServiceImpl testServiceImpl;

    public TestService(TestServiceImpl testServiceImpl) {
        this.testServiceImpl = testServiceImpl;
    }

    @Override
    public CCResponsePack<TestDto> findAll() {
        try {
            CCError<List<TestDto>> ccError = testServiceImpl.findAll();
            if( ccError.getStatus().equals( CCErrorStatus.ERROR))
            {
                return new CCResponsePack<>( Status.ERROR, ccError.getMessage(), null );
            }
            return new CCResponsePack<>( ccError.getData() );
        } catch ( Exception e ) {
            return new CCResponsePack<>( ErrorLayer.HSL_LAYER, ErrorSource.SERVER_ERROR, ERROR_RETRIEVE_TESTS, e );
        }
    }
}
