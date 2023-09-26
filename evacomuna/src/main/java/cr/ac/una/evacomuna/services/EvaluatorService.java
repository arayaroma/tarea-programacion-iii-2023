package cr.ac.una.evacomuna.services;

import cr.ac.una.controller.EvaluatorController;
import cr.ac.una.controller.EvaluatorController_Service;
import cr.ac.una.evacomuna.dto.EvaluatorDto;
import cr.ac.una.evacomuna.util.ResponseCode;
import cr.ac.una.evacomuna.util.ResponseWrapper;

/**
 *
 * @author estebannajera
 * @author arayaroma
 */
public class EvaluatorService {

    private EvaluatorController port;
    private EvaluatorController_Service service;

    /**
     * Default instance of the service
     */
    public EvaluatorService() {
        service = new EvaluatorController_Service();
        port = service.getEvaluatorControllerPort();
    }

    /**
     * Creates a new evaluator
     * 
     * @param evaluatorDto object to create
     * @return EvaluatorDto with the created evaluator if found, null otherwise
     */
    public ResponseWrapper createEvaluator(EvaluatorDto evaluatorDto) {
        try {
            cr.ac.una.controller.ResponseWrapper response = port.createEvaluator(evaluatorDto.getDto());
            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "Evaluator created successfully",
                    response.getData());
        } catch (Exception e) {
            return new ResponseWrapper(
                    ResponseCode.INTERNAL_SERVER_ERROR.getCode(),
                    ResponseCode.INTERNAL_SERVER_ERROR,
                    "Error creating evaluator",
                    null);
        }
    }

    public ResponseWrapper getEvaluatorById(Long id) {
        try {
            cr.ac.una.controller.ResponseWrapper response = port.getEvaluatorById(id);
            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "Evaluator retrieved successfully",
                    response.getData());
        } catch (Exception e) {
            return new ResponseWrapper(
                    ResponseCode.INTERNAL_SERVER_ERROR.getCode(),
                    ResponseCode.INTERNAL_SERVER_ERROR,
                    "Error retrieving the evaluator",
                    null);
        }
    }

    public ResponseWrapper getEvaluatorByEvaluatedId(Long id) {
        try {
            cr.ac.una.controller.ResponseWrapper response = port.getEvaluatorByEvaluatedId(id);
            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "Evaluator retrieved successfully",
                    response.getData());
        } catch (Exception e) {
            return new ResponseWrapper(
                    ResponseCode.INTERNAL_SERVER_ERROR.getCode(),
                    ResponseCode.INTERNAL_SERVER_ERROR,
                    "Error retrieving the evaluator",
                    null);
        }
    }

    public ResponseWrapper getAllEvaluator() {
        try {
            cr.ac.una.controller.ResponseWrapper response = port.getAllEvaluator();
            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "Evaluators retrieved successfully",
                    response.getData());
        } catch (Exception e) {
            return new ResponseWrapper(
                    ResponseCode.INTERNAL_SERVER_ERROR.getCode(),
                    ResponseCode.INTERNAL_SERVER_ERROR,
                    "Error retrieving the evaluators",
                    null);
        }
    }

    /**
     * Updates the evaluator with the given id
     * 
     * @param evaluatorDto object to update
     * @return EvaluatorDto with the updated evaluator if found, null otherwise
     */
    public ResponseWrapper updateEvaluator(EvaluatorDto evaluatorDto) {
        try {
            cr.ac.una.controller.ResponseWrapper response = port.updateEvaluator(evaluatorDto.getDto());
            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "Evaluator updated successfully",
                    response.getData());
        } catch (Exception e) {
            return new ResponseWrapper(
                    ResponseCode.INTERNAL_SERVER_ERROR.getCode(),
                    ResponseCode.INTERNAL_SERVER_ERROR,
                    "Error updating evaluator",
                    null);
        }
    }

    /**
     * Gets the evaluator with the given id
     * 
     * @param id of the evaluator to get
     * @return EvaluatorDto with the found evaluator if found, null otherwise
     */
    public ResponseWrapper deleteEvaluatorById(Long id) {
        try {
            cr.ac.una.controller.ResponseWrapper response = port.deleteEvaluatorById(id);
            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "Evaluator deleted successfully",
                    response.getData());
        } catch (Exception e) {
            return new ResponseWrapper(
                    ResponseCode.INTERNAL_SERVER_ERROR.getCode(),
                    ResponseCode.INTERNAL_SERVER_ERROR,
                    "Error deleting evaluator",
                    null);
        }
    }

}
