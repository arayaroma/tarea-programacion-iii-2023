package cr.ac.una.evacomuna.services;

import cr.ac.una.controller.PositionController;
import cr.ac.una.controller.PositionController_Service;
import cr.ac.una.controller.PositionDto;
import cr.ac.una.evacomuna.util.ResponseCode;
import cr.ac.una.evacomuna.util.ResponseWrapper;

/**
 *
 * @author estebannajera
 * @author arayaroma
 */
public class PositionService {

    private PositionController_Service service;
    private PositionController port;

    /**
     * Default instance of the service
     */
    public PositionService() {
        service = new PositionController_Service();
        port = service.getPositionControllerPort();

    }

    /**
     * Get all positions
     * 
     * @return ResponseWrapper with the response of the request
     */
    public ResponseWrapper getPositions() {
        try {
            cr.ac.una.controller.ResponseWrapper response = port.getPositions();
            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "Positions found successfully",
                    response.getData());
        } catch (Exception e) {
            return new ResponseWrapper(
                    ResponseCode.NOT_FOUND.getCode(),
                    ResponseCode.NOT_FOUND,
                    "Positions not found",
                    null);
        }
    }

    /**
     * Get position by id
     * 
     * @param id of the position
     * @return ResponseWrapper with the response of the request
     */
    public ResponseWrapper updatePositionById(Long id) {
        try {
            cr.ac.una.controller.ResponseWrapper response = port.updatePositionById(id);
            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "Position found successfully",
                    response.getData());
        } catch (Exception e) {
            return new ResponseWrapper(
                    ResponseCode.NOT_FOUND.getCode(),
                    ResponseCode.NOT_FOUND,
                    "Position not found",
                    null);
        }
    }

    /**
     * Update a position
     * 
     * @param position to update
     * @return ResponseWrapper with the response of the request
     */
    public ResponseWrapper updatePosition(PositionDto position) {
        try {
            cr.ac.una.controller.ResponseWrapper response = port.updatePosition(position);
            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "Position updated successfully",
                    response.getData());
        } catch (Exception e) {
            return new ResponseWrapper(
                    ResponseCode.INTERNAL_SERVER_ERROR.getCode(),
                    ResponseCode.INTERNAL_SERVER_ERROR,
                    "Error updating position",
                    null);
        }
    }

    /**
     * Get position by name
     * 
     * @param name of the position
     * @return ResponseWrapper with the response of the request
     */
    public ResponseWrapper getPositionByName(String name) {
        try {
            cr.ac.una.controller.ResponseWrapper response = port.getPositionByName(name);
            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "Position found successfully",
                    response.getData());
        } catch (Exception e) {
            return new ResponseWrapper(
                    ResponseCode.NOT_FOUND.getCode(),
                    ResponseCode.NOT_FOUND,
                    "Position not found",
                    null);
        }
    }

    /**
     * Delete a position by id
     * 
     * @param id of the position
     * @return ResponseWrapper with the response of the request
     */
    public ResponseWrapper deletePositionById(Long id) {
        try {
            cr.ac.una.controller.ResponseWrapper response = port.deletePositionById(id);
            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "Position deleted successfully",
                    response.getData());
        } catch (Exception e) {
            return new ResponseWrapper(
                    ResponseCode.INTERNAL_SERVER_ERROR.getCode(),
                    ResponseCode.INTERNAL_SERVER_ERROR,
                    "Error deleting position",
                    null);
        }
    }

    /**
     * Creates a new position
     * 
     * @param position to create
     * @return ResponseWrapper with the response of the request
     */
    public ResponseWrapper createPosition(PositionDto position) {
        try {
            cr.ac.una.controller.ResponseWrapper response = port.createPosition(position);
            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "Position created successfully",
                    response.getData());
        } catch (Exception e) {
            return new ResponseWrapper(
                    ResponseCode.INTERNAL_SERVER_ERROR.getCode(),
                    ResponseCode.INTERNAL_SERVER_ERROR,
                    "Error creating position",
                    null);
        }
    }

}
