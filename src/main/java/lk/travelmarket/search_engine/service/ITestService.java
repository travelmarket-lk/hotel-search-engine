package lk.travelmarket.search_engine.service;

import lk.travelmarket.search_engine.dto.TestDto;
import lk.travelmarket.search_engine.network.commons.CCResponse;
import lk.travelmarket.search_engine.network.commons.CCResponsePack;


public interface ITestService {

    CCResponsePack<TestDto> findAll();
    CCResponse<TestDto> findTest( Long id );
    CCResponse<TestDto> createTest( TestDto dto );
    CCResponse<TestDto> updateTest( Long id, TestDto dto );
    CCResponse<TestDto> deleteTest( Long id );
}
