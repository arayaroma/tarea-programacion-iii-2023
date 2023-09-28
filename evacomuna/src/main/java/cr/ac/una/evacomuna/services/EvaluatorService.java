package cr.ac.una.evacomuna.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import cr.ac.una.evacomunaws.controller.EvaluatorController;
import cr.ac.una.evacomunaws.controller.EvaluatorController_Service;
import cr.ac.una.evacomuna.dto.CalificationDto;
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
    private CalificationService calificationService;

    /**
     * Default instance of the service
     */
    public EvaluatorService() {
        service = new EvaluatorController_Service();
        port = service.getEvaluatorControllerPort();
        calificationService = new CalificationService();
    }

    /**
     * Creates a new evaluator
     *
     * @param evaluatorDto object to create
     * @return EvaluatorDto with the created evaluator if found, null otherwise
     */
    public ResponseWrapper createEvaluator(EvaluatorDto evaluatorDto) {
        try {
            cr.ac.una.evacomunaws.controller.EvaluatorDto entity = evaluatorDto.getDto();
            entity = evaluatorDto.convertFromDTOToGenerated(evaluatorDto, entity);
            cr.ac.una.evacomunaws.controller.ResponseWrapper response = port.createEvaluator(entity);
            cr.ac.una.evacomunaws.controller.EvaluatorDto evaluator = (cr.ac.una.evacomunaws.controller.EvaluatorDto) response.getData();
            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "Evaluator created successfully",
                    new EvaluatorDto(evaluator));
        } catch (Exception e) {
            return new ResponseWrapper(
                    ResponseCode.INTERNAL_SERVER_ERROR.getCode(),
                    ResponseCode.INTERNAL_SERVER_ERROR,
                    "Error creating evaluator",
                    null);
        }
    }

    /**
     * Gets the evaluator with the given id
     *
     * @param id of the evaluator to get
     * @return EvaluatorDto with the found evaluator if found, null otherwise
     */
    public ResponseWrapper getEvaluatorById(Long id) {
        try {
            cr.ac.una.evacomunaws.controller.ResponseWrapper response = port.getEvaluatorById(id);
            cr.ac.una.evacomunaws.controller.EvaluatorDto evaluator = (cr.ac.una.evacomunaws.controller.EvaluatorDto) response.getData();
            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "Evaluator retrieved successfully",
                    new EvaluatorDto(evaluator));
        } catch (Exception e) {
            return new ResponseWrapper(
                    ResponseCode.INTERNAL_SERVER_ERROR.getCode(),
                    ResponseCode.INTERNAL_SERVER_ERROR,
                    "Error retrieving the evaluator",
                    null);
        }
    }

    /**
     * Gets the evaluator with the given id of the evaluated
     *
     * @param id of the evaluted to get
     * @return EvaluatorDto with the found evaluator if found, null otherwise
     */
    public ResponseWrapper getEvaluatorByEvaluatedId(Long id) {
        try {
            cr.ac.una.evacomunaws.controller.ResponseWrapper response = port.getEvaluatorByEvaluatedId(id);
            cr.ac.una.evacomunaws.controller.EvaluatorDto evaluator = (cr.ac.una.evacomunaws.controller.EvaluatorDto) response.getData();
            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "Evaluator retrieved successfully",
                    new EvaluatorDto(evaluator));
        } catch (Exception e) {
            return new ResponseWrapper(
                    ResponseCode.INTERNAL_SERVER_ERROR.getCode(),
                    ResponseCode.INTERNAL_SERVER_ERROR,
                    "Error retrieving the evaluator",
                    null);
        }
    }

    /**
     * Gets all the evaluators
     *
     * @return List of EvaluatorDto with the found evaluators if found, null
     * otherwise
     */
    public ResponseWrapper getAllEvaluator() {
        try {
            cr.ac.una.evacomunaws.controller.ResponseWrapper response = port.getAllEvaluator();
            cr.ac.una.evacomunaws.controller.ListWrapper listWrapper = (cr.ac.una.evacomunaws.controller.ListWrapper) response.getData();
            List<cr.ac.una.evacomunaws.controller.EvaluatorDto> listGenerated = new ArrayList<>();
            List<EvaluatorDto> listDto = listWrapper
                    .getElement()
                    .stream()
                    .filter(i -> i instanceof cr.ac.una.evacomunaws.controller.EvaluatorDto)
                    .map(i -> {
                        cr.ac.una.evacomunaws.controller.EvaluatorDto evaluator = (cr.ac.una.evacomunaws.controller.EvaluatorDto) i;
                        listGenerated.add(evaluator);
                        EvaluatorDto evaluatorDto = new EvaluatorDto(evaluator);
                        return evaluatorDto.convertFromGeneratedToDTO(evaluator, evaluatorDto);
                    })
                    .collect(Collectors.toList());
            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "Evaluators retrieved successfully",
                    listDto);
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
            cr.ac.una.evacomunaws.controller.EvaluatorDto entity = evaluatorDto.getDto();
            entity = evaluatorDto.convertFromDTOToGenerated(evaluatorDto, entity);
            cr.ac.una.evacomunaws.controller.ResponseWrapper response = port.updateEvaluator(entity);
            cr.ac.una.evacomunaws.controller.EvaluatorDto evaluator = (cr.ac.una.evacomunaws.controller.EvaluatorDto) response.getData();
            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "Evaluator updated successfully",
                    new EvaluatorDto(evaluator));
        } catch (Exception e) {
            return new ResponseWrapper(
                    ResponseCode.INTERNAL_SERVER_ERROR.getCode(),
                    ResponseCode.INTERNAL_SERVER_ERROR,
                    "Error updating evaluator: " + e.toString(),
                    null);
        }
    }

    /**
     * Gets the evaluator with the given id
     *
     * @param id of the evaluator to get
     * @return EvaluatorDto with the found evaluator if found, null otherwise
     */
    public ResponseWrapper deleteEvaluatorById(EvaluatorDto evaluatorDto) {
        try {
            for (CalificationDto i : evaluatorDto.getCalifications()) {
                calificationService.deleteCalificationById(i.getID());
            }
            cr.ac.una.evacomunaws.controller.ResponseWrapper response = port.deleteEvaluatorById(evaluatorDto.getId());
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
