package cr.ac.una.services;

import cr.ac.una.dto.PositionDto;
import cr.ac.una.util.ResponseWrapper;

public interface PositionService {
    public ResponseWrapper createPosition(PositionDto position);

    public ResponseWrapper getPositionById(Long id);

    public ResponseWrapper updatePositionById(Long id, PositionDto position);

    public ResponseWrapper deletePositionById(Long id);
}
