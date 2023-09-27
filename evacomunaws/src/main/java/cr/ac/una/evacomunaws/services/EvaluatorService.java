package cr.ac.una.evacomunaws.services;

import cr.ac.una.evacomunaws.dto.EvaluatorDto;
import cr.ac.una.evacomunaws.util.ResponseWrapper;
import jakarta.ejb.Local;

/**
 * @author arayaroma
 */
@Local
public interface EvaluatorService {
    ResponseWrapper createEvaluator(EvaluatorDto evaluatorDto);

    ResponseWrapper updateEvaluator(EvaluatorDto evaluatorDto);

    ResponseWrapper getEvaluatorById(Long id);

    ResponseWrapper getEvaluatorByEvaluatedId(Long id);

    ResponseWrapper getAllEvaluator();

    ResponseWrapper deleteEvaluatorById(Long id);
}
