package lk.travelmarket.search_engine.service.facility;


import lk.travelmarket.search_engine.dto.facility.FacilityDto;

import java.util.List;

public interface IFacilityService {

    FacilityDto createFacility(FacilityDto facilityDto);

    List<FacilityDto> getFacilities();


    FacilityDto getFacilityById(Long id);

    FacilityDto updateFacility(Long id ,FacilityDto facilityDto);

    void deleteFacility(Long id);



}