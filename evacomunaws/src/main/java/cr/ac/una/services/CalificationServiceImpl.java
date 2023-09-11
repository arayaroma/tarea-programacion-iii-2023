package cr.ac.una.services;

import cr.ac.una.dto.CalificationDto;
import cr.ac.una.util.ResponseWrapper;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;

/**
 * 
 * @author arayaroma
 */
@Stateless
@LocalBean
public class CalificationServiceImpl implements CalificationService {

    @Override
    public ResponseWrapper createCalification(CalificationDto calificationDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createCalification'");
    }

    @Override
    public ResponseWrapper updateCalification(CalificationDto calificationDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateCalification'");
    }

    @Override
    public ResponseWrapper getCalificationById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCalificationById'");
    }

    @Override
    public ResponseWrapper getCalificationNote(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCalificationNote'");
    }

    @Override
    public ResponseWrapper getAllCalification() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllCalification'");
    }

    @Override
    public ResponseWrapper deleteCalificationById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteCalificationById'");
    }

}
