package lk.travelmarket.search_engine.service.data;

import lk.travelmarket.search_engine.dao.City;
import lk.travelmarket.search_engine.dao.District;
import lk.travelmarket.search_engine.dto.CityDto;
import lk.travelmarket.search_engine.dto.DistrictDto;
import lk.travelmarket.search_engine.network.commons.CCError;
import lk.travelmarket.search_engine.network.commons.CCErrorStatus;
import lk.travelmarket.search_engine.dao.BoardBasis;
import lk.travelmarket.search_engine.dao.HotelRoom.RoomType;
import lk.travelmarket.search_engine.dao.RoomCategory;
import lk.travelmarket.search_engine.dto.BoardBasisDto;
import lk.travelmarket.search_engine.dto.RoomCategoryDto;
import lk.travelmarket.search_engine.dto.RoomTypeDto;
import lk.travelmarket.search_engine.network.commons.CCError;
import lk.travelmarket.search_engine.network.commons.CCErrorStatus;
import lk.travelmarket.search_engine.repository.*;
import lk.travelmarket.search_engine.repository.hotel.HotelTypeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

import static lk.travelmarket.search_engine.util.Constants.*;

import static lk.travelmarket.search_engine.util.Constants.*;

@Service
public class DataServiceImpl {

    private final DistrictRepository districtRepository;
    private final CityRepository cityRepository;
    private final SeasonRepository seasonRepository;
    private final HotelRepository hotelRepository;
    private final LandmarkRepository landmarkRepository;
    private final RoomRepository roomRepository;
    private final HotelOwnerRepository hotelOwnerRepository;
    private final HotelTypeRepository hotelTypeRepository;
    private final RoomCategoryRepository categoryRepository;
    private final BoardBasisRepository boardBasisRepository;
    private final RoomTypeRepository roomTypeRepository;

    public DataServiceImpl(

            DistrictRepository districtRepository,
            CityRepository cityRepository
            SeasonRepository seasonRepository,
            HotelRepository hotelRepository,
            LandmarkRepository landmarkRepository,
            RoomRepository roomRepository,
            HotelOwnerRepository hotelOwnerRepository,
            HotelTypeRepository hotelTypeRepository,
            RoomCategoryRepository categoryRepository,
            BoardBasisRepository boardBasisRepository,
            RoomTypeRepository roomTypeRepository
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
        this.seasonRepository = seasonRepository;
        this.hotelRepository = hotelRepository;
        this.landmarkRepository = landmarkRepository;
        this.roomRepository = roomRepository;
        this.hotelOwnerRepository = hotelOwnerRepository;
        this.hotelTypeRepository = hotelTypeRepository;
        this.categoryRepository = categoryRepository;
        this.boardBasisRepository = boardBasisRepository;
        this.roomTypeRepository = roomTypeRepository;
    }
    //----------Room Category------------
    public CCError<Page<RoomCategoryDto>> findAllRoomCategories(int page, int size) {
        CCError<Page<RoomCategoryDto>> ccError = new CCError<>(CCErrorStatus.SUCCESS, SUCCESS_RETRIEVE_ROOM_CATEGORIES);
        Pageable pageable = PageRequest.of(page, size);
        Page<RoomCategoryDto> roomCategoryData = this.categoryRepository.findAll(pageable)
                .map(this::toRoomCategoryDto);
        ccError.setData(roomCategoryData);
        return ccError;
    }

    private RoomCategoryDto toRoomCategoryDto(RoomCategory roomCategory) {
        return new RoomCategoryDto(roomCategory.getId(), roomCategory.getName());
    }

    //----------Board Basis--------------
    public CCError<Page<BoardBasisDto>> findAllBoardBasis(int page,int size) {
        CCError<Page<BoardBasisDto>> ccError = new CCError<>(CCErrorStatus.SUCCESS, SUCCESS_RETRIEVE_BOARD_BASIS);

        Pageable pageable = PageRequest.of(page, size);
        Page<BoardBasisDto> boardBasisData = this.boardBasisRepository.findAll(pageable)
                .map(this::toBoardBasisDto);

        ccError.setData(boardBasisData);
        return ccError;
    }
    private BoardBasisDto toBoardBasisDto(BoardBasis boardBasis) {
        return new BoardBasisDto(boardBasis.getId(), boardBasis.getName(), boardBasis.getDescription());
    }

    //----------Room Type-----------------
    public CCError<Page<RoomTypeDto>> findAllRoomType(int page, int size) {
        CCError<Page<RoomTypeDto>> ccError = new CCError<>(CCErrorStatus.SUCCESS, SUCCESS_RETRIEVE_ROOM_TYPE);

        Pageable pageable = PageRequest.of(page, size);
        Page<RoomTypeDto> roomTypeData = roomTypeRepository.findAll(pageable)
                .map(this::toRoomTypeDto);

        ccError.setData(roomTypeData);
        return ccError;
    }
    private RoomTypeDto toRoomTypeDto(RoomType roomType) {
        return new RoomTypeDto(roomType.getId(), roomType.getType());
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
