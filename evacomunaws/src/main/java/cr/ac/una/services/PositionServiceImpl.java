package cr.ac.una.services;

import cr.ac.una.dto.PositionDto;
import static cr.ac.una.util.Constants.PERSISTENCE_UNIT_NAME;
import cr.ac.una.util.ResponseWrapper;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 * @author arayaroma
 */
@Stateless
@LocalBean
public class PositionServiceImpl implements PositionService {

    @PersistenceContext(name = PERSISTENCE_UNIT_NAME)
    private EntityManager em;

    /**
     * @param position position to be created
     * @return ResponseWrapper with the response of the service call
     */
    @Override
    public ResponseWrapper createPosition(PositionDto position) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createPosition'");
    }

    /**
     * @param id position id to be updated
     * @return ResponseWrapper with the response of the service call
     */
    @Override
    public ResponseWrapper getPositionById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPositionById'");
    }

    /**
     * @param id       position id to be updated
     * @param position position to be updated
     * @return ResponseWrapper with the response of the service call
     */
    @Override
    public ResponseWrapper updatePositionById(Long id, PositionDto position) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updatePositionById'");
    }

    /**
     * @param id position id to be deleted
     * @return ResponseWrapper with the response of the service call
     */
    @Override
    public ResponseWrapper deletePositionById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deletePositionById'");
    }

}
