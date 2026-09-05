package lk.travelmarket.search_engine.controller;

import lk.travelmarket.search_engine.dto.facility.FacilityCategoryDto;
import lk.travelmarket.search_engine.service.facility.IFacilityCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/facility-categories")
public class FacilityCategoryController {

    @Autowired
    private IFacilityCategoryService facilityCategoryService;

    @PostMapping
    public FacilityCategoryDto create(
            @RequestBody FacilityCategoryDto facilityCategoryDto) {

        return facilityCategoryService.createFacilityCategory(
                facilityCategoryDto
        );
    }

    @GetMapping
    public List<FacilityCategoryDto> getAll() {

        return facilityCategoryService.getFacilityCategories();
    }

    @GetMapping("/{id}")
    public FacilityCategoryDto getById(
            @PathVariable Long id) {

        return facilityCategoryService.getFacilityCategoryById(id);
    }

    @GetMapping("/name/{name}")
    public FacilityCategoryDto getByName(
            @PathVariable String name) {

        return facilityCategoryService.getFacilityCategoryByName(name);
    }

    @GetMapping("/search/{name}")
    public List<FacilityCategoryDto> getByNameContaining(
            @PathVariable String name) {

        return facilityCategoryService.getFacilityCategoriesByName(name);
    }

    @PutMapping
    public FacilityCategoryDto update(
            @RequestBody FacilityCategoryDto facilityCategoryDto) {

        return facilityCategoryService.updateFacilityCategory(
                facilityCategoryDto
        );
    }

    @DeleteMapping("/{id}")
    public void delete(
            @PathVariable Long id) {

        facilityCategoryService.deleteFacilityCategoryById(id);
    }
}