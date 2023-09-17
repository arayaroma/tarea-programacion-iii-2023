package cr.ac.una.services;

import cr.ac.una.util.ResponseWrapper;
import jakarta.ejb.Local;

/**
 * 
 * @author arayaroma
 */
@Local
public interface ActivationService {

    ResponseWrapper activateUser(Long id, String hash);
}
