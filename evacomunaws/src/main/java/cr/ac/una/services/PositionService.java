package cr.ac.una.services;

import cr.ac.una.dto.PositionDto;
import cr.ac.una.util.ResponseWrapper;
import jakarta.ejb.Local;

/**
 * @author arayaroma
 */
@Local
public interface PositionService {

    ResponseWrapper createPosition(PositionDto position);

    ResponseWrapper getPositionById(Long id);

    ResponseWrapper getPositions();

    ResponseWrapper getUsersByPositionId(Long id);

    ResponseWrapper getSkillsByPositionId(Long id);

    ResponseWrapper getPositionByName(String name);

    ResponseWrapper updatePositionById(Long id);

    ResponseWrapper updatePosition(PositionDto position);

    ResponseWrapper deletePositionById(Long id);

    ResponseWrapper deleteAllPositions();

}
