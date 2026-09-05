package lk.travelmarket.search_engine.service.master;

import jakarta.transaction.Transactional;
import lk.travelmarket.search_engine.dao.HotelRoom.BedType;
import lk.travelmarket.search_engine.repository.BedTypeRepository;
import lk.travelmarket.search_engine.network.commons.CCError;
import lk.travelmarket.search_engine.network.commons.CCErrorStatus;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

import static lk.travelmarket.search_engine.util.Constants.*;


@Component
@Transactional
public class MasterServiceImpl {

    private final BedTypeRepository bedTypeRepository;

    public MasterServiceImpl(BedTypeRepository bedTypeRepository) {
        this.bedTypeRepository = bedTypeRepository;
    }

// BED TYPES
    // READ ALL (GET)
    public CCError<List<BedType>> findAllBedTypes() {
        CCError<List<BedType>> ccError = new CCError<>(CCErrorStatus.SUCCESS, SUCCESS_RETRIEVE_BED_TYPES);
        List<BedType> bedTypes = this.bedTypeRepository.findAll();
        ccError.setData(bedTypes);
        return ccError;
    }

    // CREATE (POST)
    public CCError<BedType> addBedType(BedType bedType) {
        CCError<BedType> ccError = new CCError<>(CCErrorStatus.SUCCESS, SUCCESS_ADD_BED_TYPES);
        BedType savedBedType = this.bedTypeRepository.save(bedType);
        ccError.setData(savedBedType);
        return ccError;
    }


    // DELETE (DELETE)
    public CCError<Void> deleteBedType(Long id) {
        if (!this.bedTypeRepository.existsById(id)) {
            return new CCError<>(CCErrorStatus.ERROR, ERROR_BED_ID_NOT_FOUND + id);
        }
        this.bedTypeRepository.deleteById(id);
        return new CCError<>(CCErrorStatus.SUCCESS, SUCCESS_DELETE_BED_TYPES);
    }

    // RETRIEVE BY ID (GET)
    public CCError<BedType> findBedTypeById(Long id) {
        Optional<BedType> optionalBedType = this.bedTypeRepository.findById(id);
        if (optionalBedType.isEmpty()) {
            return new CCError<>(CCErrorStatus.ERROR, ERROR_RETRIEVE_BED_TYPES + id);
        }
        CCError<BedType> ccError = new CCError<>(CCErrorStatus.SUCCESS, SUCCESS_RETRIEVE_BED_TYPES);
        ccError.setData(optionalBedType.get());
        return ccError;
    }

    // UPDATE (PUT)
    public CCError<BedType> updateBedType(Long id, BedType bedType) {
        if (!this.bedTypeRepository.existsById(id)) {
            return new CCError<>(CCErrorStatus.ERROR, ERROR_BED_ID_NOT_FOUND + id);
        }
        bedType.setId(id);
        BedType updatedBedType = this.bedTypeRepository.save(bedType);
        return new CCError<>(CCErrorStatus.SUCCESS, SUCCESS_UPDATE_BED_TYPES);
    }
}