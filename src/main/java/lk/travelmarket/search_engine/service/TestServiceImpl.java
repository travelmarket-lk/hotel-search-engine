package lk.travelmarket.search_engine.service;

import jakarta.transaction.Transactional;
import lk.travelmarket.search_engine.dao.test.Test;
import lk.travelmarket.search_engine.dao.test.TestRepository;
import lk.travelmarket.search_engine.dto.TestDto;
import lk.travelmarket.search_engine.network.commons.CCError;
import lk.travelmarket.search_engine.network.commons.CCErrorStatus;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static lk.travelmarket.search_engine.util.Constants.SUCCESS_RETRIEVE_TESTS;

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

    private TestDto toDto(Test test) {
        return new TestDto(test.getId(), test.getName(), test.getDescription());
    }
}
