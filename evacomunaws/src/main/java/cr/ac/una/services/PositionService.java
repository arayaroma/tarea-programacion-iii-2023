package cr.ac.una.services;

import cr.ac.una.dto.PositionDto;
import cr.ac.una.util.ResponseWrapper;

/**
 * @author arayaroma
 */
public interface PositionService {
    ResponseWrapper createPosition(PositionDto position);

    ResponseWrapper getPositionById(Long id);

    ResponseWrapper getUsersByPositionId(Long id);

    ResponseWrapper getSkillsByPositionId(Long id);

    ResponseWrapper updatePositionById(Long id);

    ResponseWrapper deletePositionById(Long id);

    ResponseWrapper deleteAllPositions();

}
