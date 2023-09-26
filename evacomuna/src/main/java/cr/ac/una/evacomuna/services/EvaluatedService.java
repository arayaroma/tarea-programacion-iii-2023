package cr.ac.una.evacomuna.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
            cr.ac.una.controller.EvaluatedDto evaluated = (cr.ac.una.controller.EvaluatedDto) response.getData();
            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "Evaluated created successfully",
                    new EvaluatedDto(evaluated));
        } catch (Exception e) {
            return new ResponseWrapper(
                    ResponseCode.INTERNAL_SERVER_ERROR.getCode(),
                    ResponseCode.INTERNAL_SERVER_ERROR,
                    "Error creating evaluated",
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
            cr.ac.una.controller.EvaluatedDto evaluated = (cr.ac.una.controller.EvaluatedDto) response.getData();
            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "Evaluated fetched successfully",
                    new EvaluatedDto(evaluated));
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
            cr.ac.una.controller.ListWrapper listWrapper = (cr.ac.una.controller.ListWrapper) response.getData();
            List<cr.ac.una.controller.EvaluatedDto> listGenerated = new ArrayList<>();
            List<EvaluatedDto> listDto = listWrapper
                    .getElement()
                    .stream()
                    .filter(i -> i instanceof cr.ac.una.controller.EvaluatedDto)
                    .map(i -> {
                        cr.ac.una.controller.EvaluatedDto evaluatedDto = (cr.ac.una.controller.EvaluatedDto) i;
                        listGenerated.add(evaluatedDto);
                        EvaluatedDto evaluatedDtoClient = new EvaluatedDto(evaluatedDto);
                        return evaluatedDtoClient.convertFromGeneratedToDTO(evaluatedDto, evaluatedDtoClient);
                    })
                    .collect(Collectors.toList());
            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "Evaluated fetched successfully",
                    listDto);
        } catch (Exception e) {
            return new ResponseWrapper(
                    ResponseCode.INTERNAL_SERVER_ERROR.getCode(),
                    ResponseCode.INTERNAL_SERVER_ERROR,
                    e.getMessage(),
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
            cr.ac.una.controller.EvaluatedDto evaluated = (cr.ac.una.controller.EvaluatedDto) response.getData();
            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "Evaluated updated successfully",
                    new EvaluatedDto(evaluated));

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
            cr.ac.una.controller.ResponseWrapper response = port.deleteEvaluatedById(id);
            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "Evaluated deleted successfully",
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
