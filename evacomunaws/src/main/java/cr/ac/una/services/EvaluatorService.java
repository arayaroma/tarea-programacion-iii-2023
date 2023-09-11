package cr.ac.una.services;

import cr.ac.una.dto.EvaluatorDto;
import cr.ac.una.util.ResponseWrapper;
import jakarta.ejb.Local;

/**
 * @author arayaroma
 */
@Local
public interface EvaluatorService {
    ResponseWrapper createEvaluator(EvaluatorDto evaluatorDto);

    ResponseWrapper updateEvaluator(EvaluatorDto evaluatorDto);

    ResponseWrapper getEvaluatorById(Long id);

    ResponseWrapper getEvaluatorByName(String name);

    ResponseWrapper getAllEvaluator();

    ResponseWrapper deleteEvaluatorById(Long id);
}
