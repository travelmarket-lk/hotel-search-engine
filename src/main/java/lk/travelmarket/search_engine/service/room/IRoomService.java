package lk.travelmarket.search_engine.service.room;

import lk.travelmarket.search_engine.dto.RoomDto;
import lk.travelmarket.search_engine.network.commons.CCResponse;
import lk.travelmarket.search_engine.network.commons.CCResponsePack;

public interface IRoomService {

    CCResponsePack<RoomDto> findAll();

    CCResponse<RoomDto> findRoom(Long id);

    CCResponse<RoomDto> createRoom(RoomDto roomDto);

    CCResponse<RoomDto> updateRoom(Long id, RoomDto roomDto);

    CCResponse<RoomDto> deleteRoom(Long id);
}