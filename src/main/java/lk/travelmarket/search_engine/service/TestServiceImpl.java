package lk.travelmarket.search_engine.service;

import jakarta.transaction.Transactional;
import lk.travelmarket.search_engine.dao.test.Test;
import lk.travelmarket.search_engine.dao.test.TestRepository;
import lk.travelmarket.search_engine.dto.TestDto;
import lk.travelmarket.search_engine.network.commons.CCError;
import lk.travelmarket.search_engine.network.commons.CCErrorStatus;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

import static lk.travelmarket.search_engine.util.Constants.*;

@Component
@Transactional
public class TestServiceImpl {

    private final TestRepository testRepository;

    public TestServiceImpl(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    public CCError<List<TestDto>> findAll() {
        CCError<List<TestDto>> ccError = new CCError<>(CCErrorStatus.SUCCESS, SUCCESS_RETRIEVE_TESTS);
        List<TestDto> testData = this.testRepository.findAll().stream()
                .map(this::toDto)
                .toList();
        ccError.setData(testData);
        return ccError;
    }

    public CCError<TestDto> findTest( Long id ) {
        CCError<TestDto> ccError = new CCError<>(CCErrorStatus.SUCCESS, SUCCESS_RETRIEVE_TEST);

        Optional<Test> dao = this.testRepository.findById( id );

        if( dao.isEmpty() )
        {
            ccError.setStatus( CCErrorStatus.ERROR );
            ccError.setMessage( ERROR_RETRIEVE_TEST_NOT_FOUND );
            return ccError;
        }

        TestDto testData = this.toDto( dao.get() );
        ccError.setData(testData);
        return ccError;
    }

    public CCError<TestDto> createTest( TestDto dto ) {
        CCError<TestDto> ccError = new CCError<>(CCErrorStatus.SUCCESS, SUCCESS_CREATE_TEST);

        Test dao = new Test();
        dao.setName( dto.getName() );
        dao.setDescription( dto.getDescription());

        Test savedTest = testRepository.save( dao );

        TestDto testData = this.toDto( savedTest );
        ccError.setData(testData);
        return ccError;
    }

    public CCError<TestDto> updateTest( Long id, TestDto dto ) {
        CCError<TestDto> ccError = new CCError<>(CCErrorStatus.SUCCESS, SUCCESS_UPDATE_TEST);

        Optional<Test> dao = this.testRepository.findById( id );

        if( dao.isEmpty() )
        {
            ccError.setStatus( CCErrorStatus.ERROR );
            ccError.setMessage( ERROR_RETRIEVE_TEST_NOT_FOUND );
            return ccError;
        }

        dao.get().setName( dto.getName() );
        dao.get().setDescription( dto.getDescription());

        this.testRepository.save( dao.get() );

        TestDto testData = this.toDto( dao.get() );
        ccError.setData(testData);
        return ccError;
    }

    public CCError<TestDto> deleteTest( Long id ) {
        CCError<TestDto> ccError = new CCError<>(CCErrorStatus.SUCCESS, SUCCESS_DELETE_TEST);

        Optional<Test> dao = this.testRepository.findById( id );

        if( dao.isEmpty() )
        {
            ccError.setStatus( CCErrorStatus.ERROR );
            ccError.setMessage( ERROR_RETRIEVE_TEST_NOT_FOUND );
            return ccError;
        }

        this.testRepository.delete( dao.get() );

        TestDto testData = this.toDto( dao.get() );
        ccError.setData(testData);
        return ccError;
    }

    private TestDto toDto(Test test) {
        return new TestDto(test.getId(), test.getName(), test.getDescription());
    }
}
