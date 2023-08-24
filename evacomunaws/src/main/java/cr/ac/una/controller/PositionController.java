package cr.ac.una.controller;

import cr.ac.una.dto.PositionDto;
import cr.ac.una.dto.UserDto;
import cr.ac.una.services.PositionService;
import cr.ac.una.services.UserService;
import cr.ac.una.util.ResponseWrapper;
import jakarta.ejb.EJB;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

/**
 *
 * @author estebannajera
 */
@WebService(serviceName = "PositionController")
public class PositionController {

    @EJB
    private PositionService positionService;

    @WebMethod(operationName = "createPosition")
    public ResponseWrapper createPosition(PositionDto position) {
        return positionService.createPosition(position);
    }

    @WebMethod(operationName = "getPositionById")
    public ResponseWrapper getPositionById(Long id) {
        return positionService.getPositionById(id);
    }

    @WebMethod(operationName = "updatePosition")
    public ResponseWrapper updatePositionById(Long id, PositionDto position) {
        return positionService.updatePositionById(id, position);
    }

    @WebMethod(operationName = "deletePositionById")
    public ResponseWrapper deletePositionById(Long id) {
        return positionService.deletePositionById(id);
    }
}
