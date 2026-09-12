package lk.travelmarket.search_engine.service.facility;

import lk.travelmarket.search_engine.dao.facility.Facility;
import lk.travelmarket.search_engine.dto.facility.FacilityDto;
import lk.travelmarket.search_engine.repository.facility.FacilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FacilityServiceImpl implements IFacilityService {

    @Autowired
    private FacilityRepository facilityRepository;

    @Override
    public FacilityDto createFacility(FacilityDto facilityDto) {

        Facility facility = new Facility();

        facility.setFacilityName(facilityDto.getFacilityName());
        facility.setFacilityCategory(facilityDto.getFacilityCategory());
        facility.setFacilityIcon(facilityDto.getFacilityIcon());
        facility.setHotelId(facilityDto.getHotelId());

        Facility savedFacility = facilityRepository.save(facility);

        return convertToDto(savedFacility);
    }

    @Override
    public List<FacilityDto> getFacilities() {

        return facilityRepository.findAll()
                .stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public FacilityDto getFacilityById(Long id) {

        Facility facility = facilityRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Facility not found with id: " + id)
                );

        return convertToDto(facility);
    }

    @Override
    public FacilityDto updateFacility(Long id, FacilityDto facilityDto) {

        Facility facility = facilityRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Facility not found with id: " + id)
                );

        facility.setFacilityName(facilityDto.getFacilityName());
        facility.setFacilityCategory(facilityDto.getFacilityCategory());
        facility.setFacilityIcon(facilityDto.getFacilityIcon());
        facility.setHotelId(facilityDto.getHotelId());

        Facility updatedFacility = facilityRepository.save(facility);

        return convertToDto(updatedFacility);
    }

    @Override
    public void deleteFacility(Long id) {

        Facility facility = facilityRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Facility not found with id: " + id)
                );

        facilityRepository.delete(facility);
    }

    private FacilityDto convertToDto(Facility facility) {

        FacilityDto dto = new FacilityDto();

        dto.setId(facility.getId());
        dto.setFacilityName(facility.getFacilityName());
        dto.setFacilityCategory(facility.getFacilityCategory());
        dto.setFacilityIcon(facility.getFacilityIcon());
        dto.setHotelId(facility.getHotelId());

        return dto;
    }
}