package cr.ac.una.services;

import cr.ac.una.dto.CalificationDto;
import cr.ac.una.util.ResponseWrapper;
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