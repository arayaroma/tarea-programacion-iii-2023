package cr.ac.una.evacomuna.services;

import cr.ac.una.controller.CharacteristicController;
import cr.ac.una.controller.CharacteristicController_Service;
import cr.ac.una.evacomuna.dto.CharacteristicDto;
import cr.ac.una.evacomuna.util.ResponseWrapper;
import cr.ac.una.evacomuna.util.ResponseCode;

/**
 *
 * @author estebannajera
 * @author arayaroma
 */
public class CharacteristicService {

    CharacteristicController port;
    CharacteristicController_Service service;

    /**
     * Default instance of the service
     */
    public CharacteristicService() {
        service = new CharacteristicController_Service();
        port = service.getCharacteristicControllerPort();
    }

    /**
     * Create a new characteristic
     * 
     * @param characteristicDto characteristic to create
     * @return ResponseWrapper with the response of the request
     */
    public ResponseWrapper createCharacteristic(CharacteristicDto characteristicDto) {
        try {
            cr.ac.una.controller.ResponseWrapper response = port.createCharacteristic(characteristicDto.getDto());
            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "Characteristic created successfully",
                    response.getData());
        } catch (Exception e) {
            return new ResponseWrapper(
                    ResponseCode.NOT_FOUND.getCode(),
                    ResponseCode.NOT_FOUND,
                    "Error creating characteristic",
                    null);
        }
    }

    /**
     * Get all characteristics
     * 
     * @return ResponseWrapper with the response of the request
     */
    public ResponseWrapper getCharacteristics() {
        try {
            cr.ac.una.controller.ResponseWrapper response = port.getCharacteristics();
            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "Characteristics found successfully",
                    response.getData());
        } catch (Exception e) {
            return new ResponseWrapper(
                    ResponseCode.NOT_FOUND.getCode(),
                    ResponseCode.NOT_FOUND,
                    "Characteristics not found",
                    null);
        }
    }

    /**
     * Get a characteristic by name
     * 
     * @param name of the characteristic
     * @return ResponseWrapper with the response of the request
     */
    public ResponseWrapper getCharacteristicByName(String name) {
        try {
            cr.ac.una.controller.ResponseWrapper response = port.getCharacteristicByName(name);
            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "Characteristic found successfully",
                    response.getData());
        } catch (Exception e) {
            return new ResponseWrapper(
                    ResponseCode.NOT_FOUND.getCode(),
                    ResponseCode.NOT_FOUND,
                    "Characteristic not found",
                    null);
        }
    }

    /**
     * Updates a characteristic
     * 
     * @param characteristicDto characteristic to update
     * @return ResponseWrapper with the response of the request
     */
    public ResponseWrapper updateCharacteristic(CharacteristicDto characteristicDto) {
        try {
            cr.ac.una.controller.ResponseWrapper response = port.updateCharacteristic(characteristicDto.getDto());
            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "Characteristic updated successfully",
                    response.getData());
        } catch (Exception e) {
            return new ResponseWrapper(
                    ResponseCode.NOT_FOUND.getCode(),
                    ResponseCode.NOT_FOUND,
                    "Error updating characteristic",
                    null);
        }
    }

    /**
     * Delete a characteristic by id
     * 
     * @param id of the characteristic
     * @return ResponseWrapper with the response of the request
     */
    public ResponseWrapper deleteCharacteristicById(Long id) {
        try {
            cr.ac.una.controller.ResponseWrapper response = port.deleteCharacteristicById(id);
            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "Characteristic deleted successfully",
                    response.getData());
        } catch (Exception e) {
            return new ResponseWrapper(
                    ResponseCode.NOT_FOUND.getCode(),
                    ResponseCode.NOT_FOUND,
                    "Characteristic not found",
                    null);
        }
    }

}
