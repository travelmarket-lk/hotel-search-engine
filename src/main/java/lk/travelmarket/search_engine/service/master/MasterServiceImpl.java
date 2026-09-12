package lk.travelmarket.search_engine.service.master;

import jakarta.transaction.Transactional;
import lk.travelmarket.search_engine.dao.BoardBasis;
import lk.travelmarket.search_engine.dao.RoomCategory;
import lk.travelmarket.search_engine.dto.BoardBasisDto;
import lk.travelmarket.search_engine.dto.RoomCategoryDto;
import lk.travelmarket.search_engine.network.commons.CCError;
import lk.travelmarket.search_engine.network.commons.CCErrorStatus;
import lk.travelmarket.search_engine.repository.BoardBasisRepository;
import lk.travelmarket.search_engine.repository.RoomCategoryRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

import static lk.travelmarket.search_engine.util.Constants.*;

@Component
@Transactional
public class MasterServiceImpl {

    private final RoomCategoryRepository categoryRepository;
    private final BoardBasisRepository boardBasisRepository;

    public MasterServiceImpl(RoomCategoryRepository categoryRepository,
                             BoardBasisRepository boardBasisRepository) {
        this.categoryRepository = categoryRepository;
        this.boardBasisRepository = boardBasisRepository;
    }

    public CCError<List<RoomCategoryDto>> findAllRoomCategories() {
        CCError<List<RoomCategoryDto>> ccError = new CCError<>(CCErrorStatus.SUCCESS, SUCCESS_RETRIEVE_ROOM_CATEGORIES);
        List<RoomCategoryDto> roomCategoryData = this.categoryRepository.findAll().stream()
                .map(this::toRoomCategoryDto)
                .toList();
        ccError.setData(roomCategoryData);
        return ccError;
    }

    private RoomCategoryDto toRoomCategoryDto(RoomCategory roomCategory) {
        return new RoomCategoryDto(roomCategory.getId(), roomCategory.getName());
    }

    public CCError<RoomCategoryDto> findRoomCategoryById( Long id ) {
        CCError<RoomCategoryDto> ccError = new CCError<>(CCErrorStatus.SUCCESS, SUCCESS_RETRIEVE_ROOM_CATEGORIES);

        Optional<RoomCategory> dao = this.categoryRepository.findById( id );

        if( dao.isEmpty() )
        {
            ccError.setStatus( CCErrorStatus.ERROR );
            ccError.setMessage( ERROR_RETRIEVE_ROOM_CATEGORIES_NOT_FOUND );
            return ccError;
        }

        RoomCategoryDto roomCategoryDto = this.toRoomCategoryDto( dao.get() );
        ccError.setData(roomCategoryDto);
        return ccError;
    }

    public CCError<RoomCategoryDto> createRoomCategory( RoomCategoryDto dto ) {
        CCError<RoomCategoryDto> ccError = new CCError<>(CCErrorStatus.SUCCESS, SUCCESS_CREATE_ROOM_CATEGORY);

        RoomCategory dao = new RoomCategory();
        dao.setName( dto.getName() );
        dao.setName( dto.getName());

        RoomCategory savedRoomCategory = categoryRepository.save( dao );

        RoomCategoryDto roomCategoryDto = this.toRoomCategoryDto( savedRoomCategory );
        ccError.setData(roomCategoryDto);
        return ccError;
    }

    public CCError<RoomCategoryDto> updateRoomCategory( Long id, RoomCategoryDto roomCategoryDto ) {
        CCError<RoomCategoryDto> ccError = new CCError<>(CCErrorStatus.SUCCESS, SUCCESS_UPDATE_ROOM_CATEGORY);

        Optional<RoomCategory> dao = this.categoryRepository.findById( id );

        if( dao.isEmpty() )
        {
            ccError.setStatus( CCErrorStatus.ERROR );
            ccError.setMessage( ERROR_RETRIEVE_ROOM_CATEGORIES_NOT_FOUND );
            return ccError;
        }

        dao.get().setName( roomCategoryDto.getName() );
        dao.get().setName( roomCategoryDto.getName());

        this.categoryRepository.save( dao.get() );

        RoomCategoryDto roomCategoryDto1 = this.toRoomCategoryDto( dao.get() );
        ccError.setData(roomCategoryDto1);
        return ccError;
    }

    public CCError<RoomCategoryDto> deleteRoomCategory( Long id ) {
        CCError<RoomCategoryDto> ccError = new CCError<>(CCErrorStatus.SUCCESS, SUCCESS_DELETE_ROOM_CATEGORY);

        Optional<RoomCategory> dao = this.categoryRepository.findById( id );

        if( dao.isEmpty() )
        {
            ccError.setStatus( CCErrorStatus.ERROR );
            ccError.setMessage( ERROR_RETRIEVE_ROOM_CATEGORIES_NOT_FOUND );
            return ccError;
        }

        this.categoryRepository.delete( dao.get() );

        RoomCategoryDto roomCategoryDto = this.toRoomCategoryDto( dao.get() );
        ccError.setData(roomCategoryDto);
        return ccError;
    }


    private BoardBasisDto toBoardBasisDto(BoardBasis boardBasis) {
        return new BoardBasisDto(boardBasis.getId(), boardBasis.getName(), boardBasis.getDescription());
    }

    public CCError<BoardBasisDto> createBoardBasis(BoardBasisDto dto) {
        CCError<BoardBasisDto> ccError = new CCError<>(CCErrorStatus.SUCCESS, SUCCESS_CREATE_BOARD_BASIS);

        BoardBasis dao = new BoardBasis();
        dao.setName(dto.getName());
        dao.setDescription(dto.getDescription());

        BoardBasis saved = boardBasisRepository.save(dao);
        ccError.setData(toBoardBasisDto(saved));
        return ccError;
    }

    public CCError<List<BoardBasisDto>> findAllBoardBasis() {
        CCError<List<BoardBasisDto>> ccError = new CCError<>(CCErrorStatus.SUCCESS, SUCCESS_RETRIEVE_BOARD_BASIS);

        List<BoardBasisDto> data = boardBasisRepository.findAll().stream()
                .map(this::toBoardBasisDto)
                .toList();

        ccError.setData(data);
        return ccError;
    }

    public CCError<BoardBasisDto> findBoardBasisById(Long id) {
        CCError<BoardBasisDto> ccError = new CCError<>(CCErrorStatus.SUCCESS, SUCCESS_RETRIEVE_BOARD_BASIS);

        Optional<BoardBasis> dao = boardBasisRepository.findById(id);
        if (dao.isEmpty()) {
            ccError.setStatus(CCErrorStatus.ERROR);
            ccError.setMessage(ERROR_RETRIEVE_BOARD_BASIS_NOT_FOUND);
            return ccError;
        }

        ccError.setData(toBoardBasisDto(dao.get()));
        return ccError;
    }

    public CCError<BoardBasisDto> updateBoardBasis(Long id, BoardBasisDto dto) {
        CCError<BoardBasisDto> ccError = new CCError<>(CCErrorStatus.SUCCESS, SUCCESS_UPDATE_BOARD_BASIS);

        Optional<BoardBasis> dao = boardBasisRepository.findById(id);
        if (dao.isEmpty()) {
            ccError.setStatus(CCErrorStatus.ERROR);
            ccError.setMessage(ERROR_RETRIEVE_BOARD_BASIS_NOT_FOUND);
            return ccError;
        }

        dao.get().setName(dto.getName());
        dao.get().setDescription(dto.getDescription());
        BoardBasis updated = boardBasisRepository.save(dao.get());

        ccError.setData(toBoardBasisDto(updated));
        return ccError;
    }

    public CCError<BoardBasisDto> deleteBoardBasis(Long id) {
        CCError<BoardBasisDto> ccError = new CCError<>(CCErrorStatus.SUCCESS, SUCCESS_DELETE_BOARD_BASIS);

        Optional<BoardBasis> dao = boardBasisRepository.findById(id);
        if (dao.isEmpty()) {
            ccError.setStatus(CCErrorStatus.ERROR);
            ccError.setMessage(ERROR_RETRIEVE_BOARD_BASIS_NOT_FOUND);
            return ccError;
        }

        boardBasisRepository.delete(dao.get());
        ccError.setData(toBoardBasisDto(dao.get()));
        return ccError;
    }
}
