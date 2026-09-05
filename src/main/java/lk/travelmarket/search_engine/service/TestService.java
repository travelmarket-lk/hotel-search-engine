package lk.travelmarket.search_engine.service;

import lk.travelmarket.search_engine.dao.test.TestRepository;
import lk.travelmarket.search_engine.dto.TestDto;
import lk.travelmarket.search_engine.network.commons.CCError;
import lk.travelmarket.search_engine.network.commons.CCErrorStatus;
import lk.travelmarket.search_engine.network.commons.CCResponse;
import lk.travelmarket.search_engine.network.commons.CCResponsePack;
import lk.travelmarket.search_engine.network.error.code.ErrorLayer;
import lk.travelmarket.search_engine.network.error.code.ErrorSource;
import lk.travelmarket.search_engine.network.error.code.Status;
import org.springframework.stereotype.Service;

import java.util.List;

import static lk.travelmarket.search_engine.util.Constants.*;

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

    @Override
    public CCResponse<TestDto> findTest(Long id) {
        try {
            CCError<TestDto> ccError = testServiceImpl.findTest( id );
            if( ccError.getStatus().equals( CCErrorStatus.ERROR))
            {
                return new CCResponse<>( Status.ERROR, ccError.getMessage(), null );
            }
            return new CCResponse<>( ccError.getData() );
        } catch ( Exception e ) {
            return new CCResponse<>( ErrorLayer.HSL_LAYER, ErrorSource.SERVER_ERROR, ERROR_RETRIEVE_TEST, e );
        }
    }

    @Override
    public CCResponse<TestDto> createTest(TestDto dto) {
        try {
            CCError<TestDto> ccError = testServiceImpl.createTest( dto );
            if( ccError.getStatus().equals( CCErrorStatus.ERROR))
            {
                return new CCResponse<>( Status.ERROR, ccError.getMessage(), null );
            }
            return new CCResponse<>( ccError.getData() );
        } catch ( Exception e ) {
            return new CCResponse<>( ErrorLayer.HSL_LAYER, ErrorSource.SERVER_ERROR, ERROR_CREATE_TESTS, e );
        }
    }

    @Override
    public CCResponse<TestDto> updateTest(Long id, TestDto dto) {
        try {
            CCError<TestDto> ccError = testServiceImpl.updateTest( id , dto );
            if( ccError.getStatus().equals( CCErrorStatus.ERROR))
            {
                return new CCResponse<>( Status.ERROR, ccError.getMessage(), null );
            }
            return new CCResponse<>( ccError.getData() );
        } catch ( Exception e ) {
            return new CCResponse<>( ErrorLayer.HSL_LAYER, ErrorSource.SERVER_ERROR, ERROR_UPDATE_TEST, e );
        }
    }

    @Override
    public CCResponse<TestDto> deleteTest(Long id) {
        try {
            CCError<TestDto> ccError = testServiceImpl.deleteTest( id );
            if( ccError.getStatus().equals( CCErrorStatus.ERROR))
            {
                return new CCResponse<>( Status.ERROR, ccError.getMessage(), null );
            }
            return new CCResponse<>( ccError.getData() );
        } catch ( Exception e ) {
            return new CCResponse<>( ErrorLayer.HSL_LAYER, ErrorSource.SERVER_ERROR, ERROR_DELETE_TEST, e );
        }
    }
}
