package lk.travelmarket.search_engine.service.room;

import jakarta.transaction.Transactional;
import lk.travelmarket.search_engine.dao.HotelRoom.BedType;
import lk.travelmarket.search_engine.dao.HotelRoom.Room;
import lk.travelmarket.search_engine.dao.hotel.Hotel;
import lk.travelmarket.search_engine.dto.RoomDto;
import lk.travelmarket.search_engine.dto.SeasonDto;
import lk.travelmarket.search_engine.network.commons.CCError;
import lk.travelmarket.search_engine.network.commons.CCErrorStatus;
import lk.travelmarket.search_engine.repository.BedTypeRepository;
import lk.travelmarket.search_engine.repository.RoomRepository;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static lk.travelmarket.search_engine.util.Constants.*;

@Component
@Transactional
public class RoomServiceImpl {

    private final RoomRepository roomRepository;
    private final BedTypeRepository bedTypeRepository;

    public RoomServiceImpl(
            RoomRepository roomRepository,
            BedTypeRepository bedTypeRepository
    ) {
        this.roomRepository = roomRepository;
        this.bedTypeRepository = bedTypeRepository;
    }

    public CCError<List<RoomDto>> findAll() {

        CCError<List<RoomDto>> ccError =
                new CCError<>(
                        CCErrorStatus.SUCCESS,
                        SUCCESS_RETRIEVE_ROOMS
                );

        List<RoomDto> roomData =
                this.roomRepository.findAll()
                        .stream()
                        .map(this::toDto)
                        .toList();

        ccError.setData(roomData);

        return ccError;
    }

    public CCError<RoomDto> findRoom(Long id) {

        Room room = roomRepository.findById(id).orElse(null);

        if (room == null) {
            return new CCError<>(
                    CCErrorStatus.ERROR,
                    ERROR_RETRIEVE_ROOM_NOT_FOUND
            );
        }

        CCError<RoomDto> ccError =
                new CCError<>(
                        CCErrorStatus.SUCCESS,
                        SUCCESS_RETRIEVE_ROOM
                );

        ccError.setData(toDto(room));

        return ccError;
    }

    public CCError<RoomDto> createRoom(RoomDto dto) {

        CCError<RoomDto> ccError =
                new CCError<>(
                        CCErrorStatus.SUCCESS,
                        SUCCESS_CREATE_ROOM
                );

        Room room = new Room();

        mapDtoToEntity(dto, room);

        Room savedRoom = roomRepository.save(room);

        ccError.setData(toDto(savedRoom));

        return ccError;
    }

    public CCError<RoomDto> updateRoom(
            Long id,
            RoomDto dto
    ) {

        Room room = roomRepository.findById(id).orElse(null);

        if (room == null) {
            return new CCError<>(
                    CCErrorStatus.ERROR,
                    ERROR_RETRIEVE_ROOM_NOT_FOUND
            );
        }

        mapDtoToEntity(dto, room);

        Room updatedRoom = roomRepository.save(room);

        CCError<RoomDto> ccError =
                new CCError<>(
                        CCErrorStatus.SUCCESS,
                        SUCCESS_UPDATE_ROOM
                );

        ccError.setData(toDto(updatedRoom));

        return ccError;
    }

    public CCError<RoomDto> deleteRoom(Long id) {

        Room room = roomRepository.findById(id).orElse(null);

        if (room == null) {
            return new CCError<>(
                    CCErrorStatus.ERROR,
                    ERROR_RETRIEVE_ROOM_NOT_FOUND
            );
        }

        RoomDto deletedRoom = toDto(room);

        roomRepository.delete(room);

        CCError<RoomDto> ccError =
                new CCError<>(
                        CCErrorStatus.SUCCESS,
                        SUCCESS_DELETE_ROOM
                );

        ccError.setData(deletedRoom);

        return ccError;
    }

    private void mapDtoToEntity(
            RoomDto dto,
            Room room
    ) {

        room.setRoomCount(dto.getRoomCount());
        room.setRoomName(dto.getRoomName());
        room.setDescription(dto.getDescription());
        room.setMinPaxCount(dto.getMinPaxCount());
        room.setMaxPaxCount(dto.getMaxPaxCount());
        room.setRoomSize(dto.getRoomSize());
        room.setViewType(dto.getViewType());

        Hotel hotel = new Hotel();
        hotel.setId(dto.getHotelId());
        room.setHotel( hotel );

        if (dto.getBedTypeIds() != null) {

            Set<BedType> bedTypes = new HashSet<>(
                    bedTypeRepository.findAllById(
                            dto.getBedTypeIds()
                    )
            );

            room.setBedTypes(bedTypes);

        } else {
            room.setBedTypes(new HashSet<>());
        }
    }

    private RoomDto toDto(Room room) {

        Set<Long> bedTypeIds = room.getBedTypes() == null
                ? new HashSet<>()
                : room.getBedTypes()
                .stream()
                .map(BedType::getId)
                .collect(Collectors.toSet());

        return new RoomDto(
                room.getId(),
                room.getRoomCount(),
                room.getRoomName(),
                room.getDescription(),
                room.getMinPaxCount(),
                room.getMaxPaxCount(),
                room.getRoomSize(),
                room.getViewType(),
                room.getHotel().getId(),
                bedTypeIds
        );
    }
}