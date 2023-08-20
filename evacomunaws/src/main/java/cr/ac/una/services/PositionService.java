package cr.ac.una.services;

import cr.ac.una.dto.PositionDto;
import cr.ac.una.util.Response;
import jakarta.jws.WebMethod;

public interface PositionService {
    @WebMethod(operationName = "createPosition")
    public Response createPosition(PositionDto position);

    @WebMethod(operationName = "getPositionById")
    public Response getPositionById(Long id);

    @WebMethod(operationName = "updatePositionById")
    Response updatePositionById(Long id, PositionDto position);

    @WebMethod(operationName = "deletePositionById")
    Response deletePositionById(Long id);
}
