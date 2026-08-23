package lk.travelmarket.search_engine.service.master;

import aj.org.objectweb.asm.commons.Remapper;
import lk.travelmarket.search_engine.dao.RoomCategory;
import lk.travelmarket.search_engine.dto.RoomCategoryDto;
import lk.travelmarket.search_engine.dto.TestDto;
import lk.travelmarket.search_engine.network.commons.CCResponse;
import lk.travelmarket.search_engine.network.commons.CCResponsePack;
import org.jspecify.annotations.Nullable;

import java.util.Optional;

public interface IMasterService {

    CCResponsePack<RoomCategoryDto> findAllRoomCategories();


    CCResponse <RoomCategoryDto>createRoomCategory(RoomCategoryDto request);

    CCResponse <RoomCategoryDto>findRoomCategoryById(Long id);

    CCResponse <RoomCategoryDto>updateRoomCategory(Long id, RoomCategoryDto request);

    CCResponse <RoomCategoryDto>deleteRoomCategory(Long id);
}
