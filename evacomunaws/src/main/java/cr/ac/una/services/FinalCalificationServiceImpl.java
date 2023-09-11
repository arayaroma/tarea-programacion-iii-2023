package cr.ac.una.services;

import cr.ac.una.dto.FinalCalificationDto;
import cr.ac.una.util.ResponseWrapper;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;

/**
 * 
 * @author arayaroma
 */
@Stateless
@LocalBean
public class FinalCalificationServiceImpl implements FinalCalificationService {

    @Override
    public ResponseWrapper createFinalCalification(FinalCalificationDto finalCalificationDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createFinalCalification'");
    }

    @Override
    public ResponseWrapper updateFinalCalification(FinalCalificationDto finalCalificationDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateFinalCalification'");
    }

    @Override
    public ResponseWrapper getFinalCalificationById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getFinalCalificationById'");
    }

    @Override
    public ResponseWrapper getFinalCalificationNote(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getFinalCalificationNote'");
    }

    @Override
    public ResponseWrapper getAverage(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAverage'");
    }

    @Override
    public ResponseWrapper getAllFinalCalification() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllFinalCalification'");
    }

    @Override
    public ResponseWrapper deleteFinalCalificationById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteFinalCalificationById'");
    }

}
