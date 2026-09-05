package lk.travelmarket.search_engine.service.facility;

import lk.travelmarket.search_engine.dao.facility.FacilityCategory;
import lk.travelmarket.search_engine.dto.facility.FacilityCategoryDto;
import lk.travelmarket.search_engine.repository.facility.FacilityCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FacilityCategoryServiceImpl
        implements IFacilityCategoryService {

    @Autowired
    private FacilityCategoryRepository facilityCategoryRepository;

    @Override
    public FacilityCategoryDto createFacilityCategory(
            FacilityCategoryDto facilityCategoryDto) {

        FacilityCategory facilityCategory = new FacilityCategory();

        facilityCategory.setFacilityCategory(
                facilityCategoryDto.getFacilityCategory()
        );

        FacilityCategory savedFacilityCategory =
                facilityCategoryRepository.save(facilityCategory);

        return convertToDto(savedFacilityCategory);
    }

    @Override
    public FacilityCategoryDto getFacilityCategoryById(Long id) {

        FacilityCategory facilityCategory =
                facilityCategoryRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Facility Category not found with id: " + id
                                )
                        );

        return convertToDto(facilityCategory);
    }

    @Override
    public List<FacilityCategoryDto> getFacilityCategories() {

        List<FacilityCategoryDto> dtoList = new ArrayList<>();

        for (FacilityCategory facilityCategory :
                facilityCategoryRepository.findAll()) {

            dtoList.add(convertToDto(facilityCategory));
        }

        return dtoList;
    }

    @Override
    public FacilityCategoryDto getFacilityCategoryByName(
            String name) {

        FacilityCategory facilityCategory =
                facilityCategoryRepository
                        .findByFacilityCategory(name)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Facility Category not found with name: "
                                                + name
                                )
                        );

        return convertToDto(facilityCategory);
    }

    @Override
    public List<FacilityCategoryDto> getFacilityCategoriesByName(
            String name) {

        List<FacilityCategoryDto> dtoList = new ArrayList<>();

        List<FacilityCategory> categories =
                facilityCategoryRepository
                        .findByFacilityCategoryContainingIgnoreCase(name);

        for (FacilityCategory facilityCategory : categories) {
            dtoList.add(convertToDto(facilityCategory));
        }

        return dtoList;
    }

    @Override
    public FacilityCategoryDto updateFacilityCategory(
            FacilityCategoryDto facilityCategoryDto) {

        FacilityCategory facilityCategory =
                facilityCategoryRepository
                        .findById(facilityCategoryDto.getId())
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Facility Category not found with id: "
                                                + facilityCategoryDto.getId()
                                )
                        );

        facilityCategory.setFacilityCategory(
                facilityCategoryDto.getFacilityCategory()
        );

        FacilityCategory updatedFacilityCategory =
                facilityCategoryRepository.save(facilityCategory);

        return convertToDto(updatedFacilityCategory);
    }

    @Override
    public void deleteFacilityCategoryById(Long id) {

        FacilityCategory facilityCategory =
                facilityCategoryRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Facility Category not found with id: " + id
                                )
                        );

        facilityCategoryRepository.delete(facilityCategory);
    }

    private FacilityCategoryDto convertToDto(
            FacilityCategory facilityCategory) {

        FacilityCategoryDto dto = new FacilityCategoryDto();

        dto.setId(facilityCategory.getId());
        dto.setFacilityCategory(
                facilityCategory.getFacilityCategory()
        );

        return dto;
    }
}