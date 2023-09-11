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

    ResponseWrapper getCharacteristicById(Long id);

    ResponseWrapper getCharacteristicByName(String name);

    ResponseWrapper getCharacteristics();

    ResponseWrapper deleteCharacteristicById(Long id);

    ResponseWrapper deleteCharacteristicByName(String name);

    ResponseWrapper deleteAllCharacteristics();
}
