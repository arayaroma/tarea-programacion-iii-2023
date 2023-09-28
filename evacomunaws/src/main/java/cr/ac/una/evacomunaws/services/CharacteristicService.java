package cr.ac.una.evacomunaws.services;
<<<<<<< HEAD

import cr.ac.una.evacomunaws.dto.CharacteristicDto;
import cr.ac.una.evacomunaws.util.ResponseWrapper;
=======
<<<<<<< HEAD
=======

import cr.ac.una.evacomunaws.dto.CharacteristicDto;
import cr.ac.una.evacomunaws.util.ResponseWrapper;
>>>>>>> 29c7236 ([FIXING] cr.ac.una.evacomunaws import to ALL CLASSES)
>>>>>>> master

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
