package cr.ac.una.evacomunaws.services;

import cr.ac.una.evacomunaws.dto.CalificationDto;
import cr.ac.una.evacomunaws.util.ResponseWrapper;
import jakarta.ejb.Local;

/**
 * 
 * @author arayaroma
 */
@Local
public interface CalificationService {

    ResponseWrapper createCalification(CalificationDto calificationDto);

    ResponseWrapper updateCalification(CalificationDto calificationDto);

    ResponseWrapper getCalificationById(Long id);

    ResponseWrapper getCalificationNote(Long id);

    ResponseWrapper getAllCalification();

    ResponseWrapper deleteCalificationById(Long id);
}