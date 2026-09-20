package lk.travelmarket.search_engine.service.data;

import lk.travelmarket.search_engine.dao.City;
import lk.travelmarket.search_engine.dao.District;
import lk.travelmarket.search_engine.dto.CityDto;
import lk.travelmarket.search_engine.dto.DistrictDto;
import lk.travelmarket.search_engine.network.commons.CCError;
import lk.travelmarket.search_engine.network.commons.CCErrorStatus;
import lk.travelmarket.search_engine.repository.*;
import lk.travelmarket.search_engine.repository.hotel.HotelTypeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import static lk.travelmarket.search_engine.util.Constants.*;

@Service
public class DataServiceImpl {

    private final DistrictRepository districtRepository;
    private final CityRepository cityRepository;

    public DataServiceImpl(

            DistrictRepository districtRepository,
            CityRepository cityRepository
    )
    {
        this.districtRepository = districtRepository;
        this.cityRepository = cityRepository;
    }

    public CCError<Page<DistrictDto>> findAllDistricts(
            int page,
            int size
    ) {

        CCError<Page<DistrictDto>> ccError =
                new CCError<>(
                        CCErrorStatus.SUCCESS,
                        SUCCESS_RETRIEVE_DISTRICTS
                );

        Pageable pageable = PageRequest.of(page, size);

        Page<DistrictDto> districtData =
                districtRepository
                        .findAll(pageable)
                        .map(this::toDistrictDto);

        ccError.setData(districtData);

        return ccError;
    }

    private DistrictDto toDistrictDto(District district) {

        return new DistrictDto(
                district.getId(),
                district.getName()
        );
    }

    public CCError<Page<CityDto>> findAllCities(
            int page,
            int size
    ) {

        CCError<Page<CityDto>> ccError =
                new CCError<>(
                        CCErrorStatus.SUCCESS,
                        SUCCESS_RETRIEVE_CITIES
                );

        Pageable pageable = PageRequest.of(page, size);

        Page<CityDto> cityData =
                cityRepository
                        .findAll(pageable)
                        .map(this::toCityDto);

        ccError.setData(cityData);

        return ccError;
    }

    private CityDto toCityDto(City city) {

        return new CityDto(
                city.getId(),
                city.getName()
        );
    }
}
