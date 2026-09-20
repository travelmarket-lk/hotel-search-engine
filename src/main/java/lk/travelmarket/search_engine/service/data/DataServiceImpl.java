package lk.travelmarket.search_engine.service.data;

import lk.travelmarket.search_engine.repository.*;
import lk.travelmarket.search_engine.repository.hotel.HotelTypeRepository;

public class DataServiceImpl {

    private final SeasonRepository seasonRepository;
    private final HotelRepository hotelRepository;
    private final LandmarkRepository landmarkRepository;
    private final RoomRepository roomRepository;
    private final HotelOwnerRepository hotelOwnerRepository;
    private final HotelTypeRepository hotelTypeRepository;

    public DataServiceImpl(

            SeasonRepository seasonRepository,
            HotelRepository hotelRepository,
            LandmarkRepository landmarkRepository,
            RoomRepository roomRepository,
            HotelOwnerRepository hotelOwnerRepository,
            HotelTypeRepository hotelTypeRepository
    )
    {

        this.seasonRepository = seasonRepository;
        this.hotelRepository = hotelRepository;
        this.landmarkRepository = landmarkRepository;
        this.roomRepository = roomRepository;
        this.hotelOwnerRepository = hotelOwnerRepository;
        this.hotelTypeRepository = hotelTypeRepository;
    }

}
