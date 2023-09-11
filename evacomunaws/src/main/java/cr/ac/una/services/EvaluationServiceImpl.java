package cr.ac.una.services;

import cr.ac.una.dto.EvaluationDto;
import cr.ac.una.util.ResponseWrapper;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;

/**
 * 
 * @author arayaroma
 */
@Stateless
@LocalBean
public class EvaluationServiceImpl implements EvaluationService{

    @Override
    public ResponseWrapper createEvaluation(EvaluationDto evaluationDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createEvaluation'");
    }

    @Override
    public ResponseWrapper updateEvaluation(EvaluationDto evaluationDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateEvaluation'");
    }

    @Override
    public ResponseWrapper getEvaluationById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getEvaluationById'");
    }

    @Override
    public ResponseWrapper getEvaluationByName(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getEvaluationByName'");
    }

    @Override
    public ResponseWrapper getAllEvaluation() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllEvaluation'");
    }

    @Override
    public ResponseWrapper deleteEvaluationById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteEvaluationById'");
    }
    
}
