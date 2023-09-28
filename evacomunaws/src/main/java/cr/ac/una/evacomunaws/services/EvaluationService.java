package cr.ac.una.evacomunaws.services;

import cr.ac.una.evacomunaws.dto.EvaluationDto;
import cr.ac.una.evacomunaws.util.ResponseWrapper;
import jakarta.ejb.Local;

/**
 * 
 * @author arayaroma
 */
@Local
public interface EvaluationService {

    ResponseWrapper createEvaluation(EvaluationDto evaluationDto);

    ResponseWrapper updateEvaluation(EvaluationDto evaluationDto);

    ResponseWrapper getEvaluationById(Long id);

    ResponseWrapper getEvaluationByName(String name);

    ResponseWrapper getAllEvaluation();

    ResponseWrapper deleteEvaluationById(Long id);
}
