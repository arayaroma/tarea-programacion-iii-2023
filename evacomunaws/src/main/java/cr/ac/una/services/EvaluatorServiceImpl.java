package cr.ac.una.services;

import cr.ac.una.dto.EvaluatorDto;
import cr.ac.una.util.ResponseWrapper;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import static cr.ac.una.util.Constants.PERSISTENCE_UNIT_NAME;

/**
 * 
 * @author arayaroma
 */
@Stateless
@LocalBean
public class EvaluatorServiceImpl implements EvaluatorService {

    @PersistenceContext(name = PERSISTENCE_UNIT_NAME)
    private EntityManager em;

    @Override
    public ResponseWrapper createEvaluator(EvaluatorDto evaluatorDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createEvaluator'");
    }

    @Override
    public ResponseWrapper updateEvaluator(EvaluatorDto evaluatorDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateEvaluator'");
    }

    @Override
    public ResponseWrapper getEvaluatorById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getEvaluatorById'");
    }

    @Override
    public ResponseWrapper getEvaluatorByName(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getEvaluatorByName'");
    }

    @Override
    public ResponseWrapper getAllEvaluator() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllEvaluator'");
    }

    @Override
    public ResponseWrapper deleteEvaluatorById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteEvaluatorById'");
    }

}
