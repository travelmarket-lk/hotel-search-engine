package lk.travelmarket.search_engine.service;

import lk.travelmarket.search_engine.dto.TestDto;
import lk.travelmarket.search_engine.network.commons.CCResponsePack;


public interface ITestService {

    CCResponsePack<TestDto> findAll();
}
