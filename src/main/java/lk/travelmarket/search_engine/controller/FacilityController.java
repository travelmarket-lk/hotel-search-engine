package lk.travelmarket.search_engine.controller;

import lk.travelmarket.search_engine.dto.facility.FacilityDto;
import lk.travelmarket.search_engine.service.facility.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/facilities")
public class FacilityController {

    @Autowired
    private IFacilityService facilityService;

    @PostMapping
    public FacilityDto create(
            @RequestBody FacilityDto facilityDto) {

        return facilityService.createFacility(facilityDto);
    }

    @GetMapping
    public List<FacilityDto> getAll() {

        return facilityService.getFacilities();
    }

    @GetMapping("/{id}")
    public FacilityDto getById(
            @PathVariable Long id) {

        return facilityService.getFacilityById(id);
    }

    @PutMapping("/{id}")
    public FacilityDto update(
            @PathVariable Long id,
            @RequestBody FacilityDto facilityDto) {

        return facilityService.updateFacility(id, facilityDto);
    }

    @DeleteMapping("/{id}")
    public void delete(
            @PathVariable Long id) {

        facilityService.deleteFacility(id);
    }
}