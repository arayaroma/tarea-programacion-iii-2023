package cr.ac.una.services;

import cr.ac.una.dto.CharacteristicDto;
import cr.ac.una.util.ResponseWrapper;
import jakarta.ejb.Local;

/**
 *
 * @author arayaroma
 */
@Local
public interface CharacteristicService {

    ResponseWrapper createCharacteristic(CharacteristicDto characteristicDto);

    ResponseWrapper updateCharacteristic(CharacteristicDto characteristicDto);

    ResponseWrapper selectCharactersitcs();

}
