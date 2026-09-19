package lk.travelmarket.search_engine.service.room;

import lk.travelmarket.search_engine.dto.RoomDto;
import lk.travelmarket.search_engine.dto.SeasonDto;
import lk.travelmarket.search_engine.network.commons.CCError;
import lk.travelmarket.search_engine.network.commons.CCErrorStatus;
import lk.travelmarket.search_engine.network.commons.CCResponse;
import lk.travelmarket.search_engine.network.commons.CCResponsePack;
import lk.travelmarket.search_engine.network.error.code.ErrorLayer;
import lk.travelmarket.search_engine.network.error.code.ErrorSource;
import lk.travelmarket.search_engine.network.error.code.Status;
import org.springframework.stereotype.Service;

import java.util.List;

import static lk.travelmarket.search_engine.util.Constants.*;

@Service
public class RoomService implements IRoomService {

    private final RoomServiceImpl roomServiceImpl;

    public RoomService(RoomServiceImpl roomServiceImpl) {
        this.roomServiceImpl = roomServiceImpl;
    }

    @Override
    public CCResponsePack<RoomDto> findAll() {

        try {

            CCError<List<RoomDto>> ccError =
                    roomServiceImpl.findAll();

            if (ccError.getStatus().equals(CCErrorStatus.ERROR)) {

                return new CCResponsePack<>(
                        Status.ERROR,
                        ccError.getMessage(),
                        null
                );
            }

            return new CCResponsePack<>(
                    ccError.getData()
            );

        } catch (Exception e) {

            return new CCResponsePack<>(
                    ErrorLayer.HSL_LAYER,
                    ErrorSource.SERVER_ERROR,
                    ERROR_RETRIEVE_SEASONS,
                    e
            );
        }
    }

    @Override
    public CCResponse<RoomDto> findRoom(Long id) {

        try {

            CCError<RoomDto> ccError =
                    roomServiceImpl.findRoom(id);

            if (ccError.getStatus().equals(CCErrorStatus.ERROR)) {

                return new CCResponse<>(
                        Status.ERROR,
                        ccError.getMessage(),
                        null
                );
            }

            return new CCResponse<>(
                    ccError.getData()
            );

        } catch (Exception e) {

            return new CCResponse<>(
                    ErrorLayer.HSL_LAYER,
                    ErrorSource.SERVER_ERROR,
                    ERROR_RETRIEVE_ROOM,
                    e
            );
        }
    }

    @Override
    public CCResponse<RoomDto> createRoom(RoomDto dto) {

        try {

            CCError<RoomDto> ccError =
                    roomServiceImpl.createRoom(dto);

            if (ccError.getStatus().equals(CCErrorStatus.ERROR)) {

                return new CCResponse<>(
                        Status.ERROR,
                        ccError.getMessage(),
                        null
                );
            }

            return new CCResponse<>(
                    ccError.getData()
            );

        } catch (Exception e) {

            return new CCResponse<>(
                    ErrorLayer.HSL_LAYER,
                    ErrorSource.SERVER_ERROR,
                    ERROR_CREATE_ROOM,
                    e
            );
        }
    }

    @Override
    public CCResponse<RoomDto> updateRoom(
            Long id,
            RoomDto dto) {

        try {

            CCError<RoomDto> ccError =
                    roomServiceImpl.updateRoom(id, dto);

            if (ccError.getStatus().equals(CCErrorStatus.ERROR)) {

                return new CCResponse<>(
                        Status.ERROR,
                        ccError.getMessage(),
                        null
                );
            }

            return new CCResponse<>(
                    ccError.getData()
            );

        } catch (Exception e) {

            return new CCResponse<>(
                    ErrorLayer.HSL_LAYER,
                    ErrorSource.SERVER_ERROR,
                    ERROR_UPDATE_ROOM,
                    e
            );
        }
    }

    @Override
    public CCResponse<RoomDto> deleteRoom(Long id) {

        try {

            CCError<RoomDto> ccError =
                    roomServiceImpl.deleteRoom(id);

            if (ccError.getStatus().equals(CCErrorStatus.ERROR)) {

                return new CCResponse<>(
                        Status.ERROR,
                        ccError.getMessage(),
                        null
                );
            }

            return new CCResponse<>(
                    ccError.getData()
            );

        } catch (Exception e) {

            return new CCResponse<>(
                    ErrorLayer.HSL_LAYER,
                    ErrorSource.SERVER_ERROR,
                    ERROR_DELETE_ROOM,
                    e
            );
        }
    }
}