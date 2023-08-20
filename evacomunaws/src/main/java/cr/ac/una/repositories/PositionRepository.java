package cr.ac.una.repositories;

import cr.ac.una.dto.PositionDto;
import cr.ac.una.util.Response;

public interface PositionRepository {

    Response createPosition(PositionDto position);

    Response getPositionById(Long id);

    Response updatePositionById(Long id, PositionDto position);

    Response deletePositionById(Long id);

}
