package lk.travelmarket.search_engine.controller;

import lk.travelmarket.search_engine.dao.City;
import lk.travelmarket.search_engine.dao.District;
import lk.travelmarket.search_engine.service.master.MasterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MasterDataController implements IMasterDataController{

    private final MasterService masterService;

    public MasterDataController(MasterService masterService) {
        this.masterService = masterService;
    }

    // CREATE
    @PostMapping("api/districts/add")
    public District addDistrict(@RequestBody District district) {
        return masterService.addDistrict(district);
    }

    // READ ALL
    @GetMapping("api/districts/getAllDistricts")
    public List<District> getAllDistricts() {
        return masterService.getAllDistricts();
    }

    // READ ONE
    @GetMapping("api/districts/{id}")
    public ResponseEntity<District> getDistrictById(@PathVariable Long id) {

        return masterService.getDistrictById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // UPDATE
    @PutMapping("api/districts/update/{id}")
    public ResponseEntity<District> updateDistrict(
            @PathVariable Long id,
            @RequestBody District district) {

        try {
            return ResponseEntity.ok(
                    masterService.updateDistrict(id, district)
            );
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE
    @DeleteMapping("api/districts/delete/{id}")
    public ResponseEntity<Void> deleteDistrict(@PathVariable Long id) {

        try {
            masterService.deleteDistrict(id);
            return ResponseEntity.noContent().build();

        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // CREATE
    @PostMapping("api/cities/add")
    public City addCity(@RequestBody City city) {
        return masterService.addCity(city);
    }

    // READ ALL
    @GetMapping("api/cities/getAllCities")
    public List<City> getAllCities() {
        return masterService.getAllCities();
    }

    // READ ONE
    @GetMapping("api/cities/{id}")
    public ResponseEntity<City> getCityById(@PathVariable Long id) {

        return masterService.getCityById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // UPDATE
    @PutMapping("api/cities/update/{id}")
    public ResponseEntity<City> updateCity(
            @PathVariable Long id,
            @RequestBody City city) {

        try {
            return ResponseEntity.ok(
                    masterService.updateCity(id, city)
            );
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE
    @DeleteMapping("api/cities/delete/{id}")
    public ResponseEntity<Void> deleteCity(@PathVariable Long id) {

        try {
            masterService.deleteCity(id);
            return ResponseEntity.noContent().build();

        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

}
