package lk.travelmarket.search_engine.service.master;

import lk.travelmarket.search_engine.dao.City;
import lk.travelmarket.search_engine.dao.District;
import lk.travelmarket.search_engine.repository.CityRepository;
import lk.travelmarket.search_engine.repository.DistrictRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MasterService implements IMasterService {

    private final DistrictRepository districtRepository;
    private final CityRepository cityRepository;

    public MasterService(DistrictRepository districtRepository, CityRepository cityRepository) {
        this.districtRepository = districtRepository;
        this.cityRepository = cityRepository;
    }

    // CREATE
    public District addDistrict(District district) {
        return districtRepository.save(district);
    }

    // READ ALL
    public List<District> getAllDistricts() {
        return districtRepository.findAll();
    }

    // READ BY ID
    public Optional<District> getDistrictById(Long id) {
        return districtRepository.findById(id);
    }

    // UPDATE
    public District updateDistrict(Long id, District district) {

        District existingDistrict = districtRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("District not found"));

        existingDistrict.setName(district.getName());

        return districtRepository.save(existingDistrict);
    }

    // DELETE
    public void deleteDistrict(Long id) {

        if (!districtRepository.existsById(id)) {
            throw new RuntimeException("District not found");
        }

        districtRepository.deleteById(id);
    }

    // CREATE
    public City addCity(City city) {
        return cityRepository.save(city);
    }

    // READ ALL
    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    // READ BY ID
    public Optional<City> getCityById(Long id) {
        return cityRepository.findById(id);
    }

    // UPDATE
    public City updateCity(Long id, City city) {

        City existingCity = cityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("City not found"));

        existingCity.setName(city.getName());

        return cityRepository.save(existingCity);
    }

    // DELETE
    public void deleteCity(Long id) {

        if (!cityRepository.existsById(id)) {
            throw new RuntimeException("City not found");
        }

        cityRepository.deleteById(id);
    }
}
