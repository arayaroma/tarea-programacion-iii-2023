package cr.ac.una.evacomunaws.controller;

import cr.ac.una.evacomunaws.dto.PositionDto;
import cr.ac.una.evacomunaws.services.PositionService;
import cr.ac.una.evacomunaws.util.ResponseWrapper;
import jakarta.ejb.EJB;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

/**
 *
 * @author arayaroma
 */
@WebService(serviceName = "PositionController")
public class PositionController {

    @EJB
    private PositionService positionService;

    /**
     * @param position position to be created
     * @return ResponseWrapper with the response of the service call
     */
    @WebMethod(operationName = "createPosition")
    public ResponseWrapper createPosition(PositionDto position) {
        return positionService.createPosition(position);
    }

    /**
     * @param id position id to be updated
     * @return ResponseWrapper with the response of the service call
     */
    @WebMethod(operationName = "getPositionById")
    public ResponseWrapper getPositionById(Long id) {
        return positionService.getPositionById(id);
    }

    @WebMethod(operationName = "getPositionByName")
    public ResponseWrapper getPositionByName(String name) {
        return positionService.getPositionByName(name);
    }

    /**
     * @param id position id to be updated
     * @return ResponseWrapper with the response of the service call
     */
    @WebMethod(operationName = "updatePositionById")
    public ResponseWrapper updatePositionById(Long id) {
        return positionService.updatePositionById(id);
    }

    @WebMethod(operationName = "updatePosition")
    public ResponseWrapper updatePosition(PositionDto positionDto) {
        return positionService.updatePosition(positionDto);
    }

    /**
     *
     * @return ResponseWrapper with the response of the service call
     */
    @WebMethod(operationName = "getPositions")
    public ResponseWrapper getPositions() {
        return positionService.getPositions();
    }

    /**
     * @param id position id to be deleted
     * @return ResponseWrapper with the response of the service call
     */
    @WebMethod(operationName = "deletePositionById")
    public ResponseWrapper deletePositionById(Long id) {
        return positionService.deletePositionById(id);
    }
}
