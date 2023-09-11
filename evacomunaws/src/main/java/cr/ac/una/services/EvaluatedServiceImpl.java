package cr.ac.una.services;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import static cr.ac.una.util.Constants.PERSISTENCE_UNIT_NAME;

import cr.ac.una.dto.EvaluatedDto;
import cr.ac.una.util.ResponseWrapper;;

/**
 * 
 * @author arayaroma
 */
@Stateless
@LocalBean
public class EvaluatedServiceImpl implements EvaluatedService {

    @PersistenceContext(name = PERSISTENCE_UNIT_NAME)
    private EntityManager em;

    @Override
    public ResponseWrapper createEvaluated(EvaluatedDto evaluatedDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createEvaluated'");
    }

    @Override
    public ResponseWrapper updateEvaluated(EvaluatedDto evaluatedDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateEvaluated'");
    }

    @Override
    public ResponseWrapper getEvaluatedById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getEvaluatedById'");
    }

    @Override
    public ResponseWrapper getEvaluatedByName(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getEvaluatedByName'");
    }

    @Override
    public ResponseWrapper getFinalNote(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getFinalNote'");
    }

    @Override
    public ResponseWrapper getAllEvaluated() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllEvaluated'");
    }

    @Override
    public ResponseWrapper deleteEvaluatedById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteEvaluatedById'");
    }

}
