package cr.ac.una.controller;

import cr.ac.una.dto.CharacteristicDto;
import cr.ac.una.services.CharacteristicService;
import cr.ac.una.util.ResponseWrapper;
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
    @WebMethod(operationName = "selectCharacteristics")
    public ResponseWrapper selectCharacteristics() {
        return characteristicService.selectCharacteristics();
    }

}
