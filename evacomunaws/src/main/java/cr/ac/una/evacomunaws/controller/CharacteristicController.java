package cr.ac.una.evacomunaws.controller;

import cr.ac.una.evacomunaws.dto.CharacteristicDto;
import cr.ac.una.evacomunaws.services.CharacteristicService;
import cr.ac.una.evacomunaws.util.ResponseWrapper;
import jakarta.ejb.EJB;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

/**
 *
 * @author arayaroma
 */
@WebService(serviceName = "CharacteristicController")
public class CharacteristicController {

    @EJB
    CharacteristicService characteristicService;

    @WebMethod(operationName = "createCharacteristic")
    public ResponseWrapper createCharacteristic(CharacteristicDto characteristicDto) {
        return characteristicService.createCharacteristic(characteristicDto);
    }

    @WebMethod(operationName = "updateCharacteristic")
    public ResponseWrapper updateCharacteristic(CharacteristicDto characteristicDto) {
        return characteristicService.updateCharacteristic(characteristicDto);
    }

    @WebMethod(operationName = "getCharacteristicById")
    public ResponseWrapper getCharacteristicById(Long id) {
        return characteristicService.getCharacteristicById(id);
    }

    @WebMethod(operationName = "getCharacteristicByName")
    public ResponseWrapper getCharacteristicByName(String name) {
        return characteristicService.getCharacteristicByName(name);
    }

    @WebMethod(operationName = "getCharacteristics")
    public ResponseWrapper getCharacteristics() {
        return characteristicService.getCharacteristics();
    }

    @WebMethod(operationName = "deleteCharacteristicById")
    public ResponseWrapper deleteCharacteristicById(Long id) {
        return characteristicService.deleteCharacteristicById(id);
    }

    @WebMethod(operationName = "deleteCharacteristicByName")
    public ResponseWrapper deleteCharacteristicByName(String name) {
        return characteristicService.deleteCharacteristicByName(name);
    }

    @WebMethod(operationName = "deleteAllCharacteristics")
    public ResponseWrapper deleteAllCharacteristics() {
        return characteristicService.deleteAllCharacteristics();
    }

}
