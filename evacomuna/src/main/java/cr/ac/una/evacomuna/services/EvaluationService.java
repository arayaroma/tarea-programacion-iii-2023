package cr.ac.una.evacomuna.services;

import cr.ac.una.controller.EvaluationController;
import cr.ac.una.controller.EvaluationController_Service;
import cr.ac.una.controller.EvaluationDto;
import cr.ac.una.evacomuna.util.ResponseCode;
import cr.ac.una.evacomuna.util.ResponseWrapper;

/**
 *
 * @author estebannajera
 * @author arayaroma
 */
public class EvaluationService {

    EvaluationController port;
    EvaluationController_Service service;

    /**
     * Default instance of the service
     */
    public EvaluationService() {
        service = new EvaluationController_Service();
        port = service.getEvaluationControllerPort();
    }

    /**
     * Get all evaluations
     * 
     * @return ResponseWrapper with the response of the request
     */
    public ResponseWrapper getAllEvaluation() {
        try {
            cr.ac.una.controller.ResponseWrapper response = port.getAllEvaluation();
            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "Evaluations found successfully",
                    response.getData());
        } catch (Exception e) {
            return new ResponseWrapper(
                    ResponseCode.NOT_FOUND.getCode(),
                    ResponseCode.NOT_FOUND,
                    "Evaluations not found",
                    null);
        }
    }

    /**
     * Get evaluation by name
     * 
     * @param name of the evaluation
     * @return ResponseWrapper with the response of the request
     */
    public ResponseWrapper getEvaluationByName(String name) {
        try {
            cr.ac.una.controller.ResponseWrapper response = port.getEvaluationByName(name);
            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "Evaluation found successfully",
                    response.getData());
        } catch (Exception e) {
            return new ResponseWrapper(
                    ResponseCode.NOT_FOUND.getCode(),
                    ResponseCode.NOT_FOUND,
                    "Evaluation not found",
                    null);
        }
    }

    /**
     * Creates a new evaluation
     * 
     * @param evaluationDto object to create
     * @return ResponseWrapper with the response of the request
     */
    public ResponseWrapper createEvaluation(EvaluationDto evaluationDto) {
        try {
            cr.ac.una.controller.ResponseWrapper response = port.createEvaluation(evaluationDto);
            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "Evaluation created successfully",
                    response.getData());
        } catch (Exception e) {
            return new ResponseWrapper(
                    ResponseCode.INTERNAL_SERVER_ERROR.getCode(),
                    ResponseCode.INTERNAL_SERVER_ERROR,
                    "Error creating evaluation",
                    null);
        }
    }

    /**
     * Updates a evaluation
     * 
     * @param evaluationDto object to update
     * @return ResponseWrapper with the response of the request
     */
    public ResponseWrapper updateEvaluation(EvaluationDto evaluationDto) {
        try {
            cr.ac.una.controller.ResponseWrapper response = port.updateEvaluation(evaluationDto);
            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "Evaluation updated successfully",
                    response.getData());
        } catch (Exception e) {
            return new ResponseWrapper(
                    ResponseCode.INTERNAL_SERVER_ERROR.getCode(),
                    ResponseCode.INTERNAL_SERVER_ERROR,
                    "Error updating evaluation",
                    null);
        }
    }

    /**
     * Deletes the evaluation with the given id
     * 
     * @param id of the evaluation to delete
     * @return ResponseWrapper with the response of the request
     */
    public ResponseWrapper deleteEvaluationById(Long id) {
        try {
            cr.ac.una.controller.ResponseWrapper response = port.deleteEvaluationById(id);
            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "Evaluation deleted successfully",
                    response.getData());
        } catch (Exception e) {
            return new ResponseWrapper(
                    ResponseCode.INTERNAL_SERVER_ERROR.getCode(),
                    ResponseCode.INTERNAL_SERVER_ERROR,
                    "Error deleting evaluation",
                    null);
        }
    }

}
