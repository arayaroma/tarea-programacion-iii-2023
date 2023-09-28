package cr.ac.una.services;

import cr.ac.una.dto.FinalCalificationDto;
import cr.ac.una.util.ResponseWrapper;
import jakarta.ejb.Local;

/**
 * 
 * @author arayaroma
 */
@Local
public interface FinalCalificationService {

    ResponseWrapper createFinalCalification(FinalCalificationDto finalCalificationDto);

    ResponseWrapper updateFinalCalification(FinalCalificationDto finalCalificationDto);

    ResponseWrapper getFinalCalificationById(Long id);

    ResponseWrapper getFinalCalificationNote(Long id);

    ResponseWrapper getAverage(Long id);

    ResponseWrapper getAllFinalCalification();

    ResponseWrapper deleteFinalCalificationById(Long id);

}
