package cr.ac.una.services;

import cr.ac.una.dto.EvaluatedDto;
import cr.ac.una.util.ResponseWrapper;
import jakarta.ejb.Local;

/**
 * @author arayaroma
 */
@Local
public interface EvaluatedService {

    ResponseWrapper createEvaluated(EvaluatedDto evaluatedDto);

    ResponseWrapper updateEvaluated(EvaluatedDto evaluatedDto);

    ResponseWrapper getEvaluatedById(Long id);

    ResponseWrapper getFinalNote(Long id);

    ResponseWrapper getAllEvaluated();

    ResponseWrapper deleteEvaluatedById(Long id);

}
