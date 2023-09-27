package cr.ac.una.evacomunaws.services;

import cr.ac.una.evacomunaws.dto.EvaluatedDto;
import cr.ac.una.evacomunaws.util.ResponseWrapper;
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
