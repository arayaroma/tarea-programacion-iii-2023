package cr.ac.una.evacomunaws.services;

import cr.ac.una.evacomunaws.dto.CharacteristicDto;
import cr.ac.una.evacomunaws.util.ResponseWrapper;
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

    ResponseWrapper getSkillsByCharacteristicId(Long id);

    ResponseWrapper deleteCharacteristicById(Long id);

    ResponseWrapper deleteCharacteristicByName(String name);

    ResponseWrapper deleteAllCharacteristics();
}
