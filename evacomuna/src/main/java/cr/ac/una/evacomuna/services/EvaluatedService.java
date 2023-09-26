package cr.ac.una.evacomuna.services;

import cr.ac.una.controller.EvaluatedController;
import cr.ac.una.controller.EvaluatedController_Service;
import cr.ac.una.evacomuna.dto.EvaluatedDto;
import cr.ac.una.evacomuna.util.ResponseWrapper;
import cr.ac.una.evacomuna.util.ResponseCode;

/**
 *
 * @author estebannajera
 * @author arayaroma
 */
public class EvaluatedService {

    private EvaluatedController port;
    private EvaluatedController_Service service;

    /**
     * Default instance of the service
     */
    public EvaluatedService() {
        service = new EvaluatedController_Service();
        port = service.getEvaluatedControllerPort();
    }

    /**
     * Creates a new evaluated
     * 
     * @param evaluatedDto object to create
     * @return EvaluatedDto with the created evaluated if found, null otherwise
     */
    public ResponseWrapper createEvaluated(EvaluatedDto evaluatedDto) {
        try {
            cr.ac.una.controller.ResponseWrapper response = port.createEvaluated(evaluatedDto.getDto());
            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "Evaluated created successfully",
                    response.getData());
        } catch (Exception e) {
            return new ResponseWrapper(
                    ResponseCode.INTERNAL_SERVER_ERROR.getCode(),
                    ResponseCode.INTERNAL_SERVER_ERROR,
                    "Error creating evaluated",
                    null);
        }
    }

    /**
     * Updates the evaluated with the given id
     * 
     * @param evaluatedDto object to update
     * @return EvaluatedDto with the updated evaluated if found, null otherwise
     */
    public ResponseWrapper updateEvaluated(EvaluatedDto evaluatedDto) {
        try {
            cr.ac.una.controller.ResponseWrapper response = port.updateEvaluated(evaluatedDto.getDto());
            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "Evaluated updated successfully",
                    response.getData());

        } catch (Exception e) {
            return new ResponseWrapper(
                    ResponseCode.NOT_FOUND.getCode(),
                    ResponseCode.NOT_FOUND,
                    "Evaluated not found",
                    null);
        }
    }

    /**
     * Deletes the evaluated with the given id
     * 
     * @param id of the evaluated to delete
     */
    public ResponseWrapper deleteEvaluatedById(Long id) {
        try {
            port.deleteEvaluatedById(id);
            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "Evaluated deleted successfully",
                    null);
        } catch (Exception e) {
            return new ResponseWrapper(
                    ResponseCode.INTERNAL_SERVER_ERROR.getCode(),
                    ResponseCode.INTERNAL_SERVER_ERROR,
                    e.getMessage(),
                    null);
        }
    }

    /**
     * Retrieves the evaluated object with the given id
     * 
     * @param id id of the evaluated to fetch
     * @return EvaluatedDto with the evaluated if found, null otherwise
     */
    public ResponseWrapper getEvaluatedById(Long id) {
        try {
            cr.ac.una.controller.ResponseWrapper response = port.getEvaluatedById(id);
            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "Evaluated fetched successfully",
                    response.getData());
        } catch (Exception e) {
            return new ResponseWrapper(
                    ResponseCode.INTERNAL_SERVER_ERROR.getCode(),
                    ResponseCode.INTERNAL_SERVER_ERROR,
                    e.getMessage(),
                    null);
        }
    }

    /**
     * Retrieves all evaluated list
     * 
     * @return List of evaluated if found, null otherwise
     */
    public ResponseWrapper getAllEvaluated() {
        try {
            cr.ac.una.controller.ResponseWrapper response = port.getAllEvaluated();
            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "Evaluated fetched successfully",
                    response.getData());
        } catch (Exception e) {
            return new ResponseWrapper(
                    ResponseCode.INTERNAL_SERVER_ERROR.getCode(),
                    ResponseCode.INTERNAL_SERVER_ERROR,
                    e.getMessage(),
                    null);
        }
    }

}
