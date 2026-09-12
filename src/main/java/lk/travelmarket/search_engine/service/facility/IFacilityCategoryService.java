package lk.travelmarket.search_engine.service.facility;

import lk.travelmarket.search_engine.dto.facility.FacilityCategoryDto;

import java.util.List;

public interface IFacilityCategoryService {

    FacilityCategoryDto createFacilityCategory(
            FacilityCategoryDto facilityCategoryDto);

    FacilityCategoryDto getFacilityCategoryById(Long id);

    List<FacilityCategoryDto> getFacilityCategories();

    FacilityCategoryDto getFacilityCategoryByName(String name);

    List<FacilityCategoryDto> getFacilityCategoriesByName(String name);

    FacilityCategoryDto updateFacilityCategory(
            FacilityCategoryDto facilityCategoryDto);

    void deleteFacilityCategoryById(Long id);
}