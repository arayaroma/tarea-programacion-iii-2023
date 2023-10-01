package cr.ac.una.evacomuna.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import cr.ac.una.evacomunaws.controller.EvaluatedController;
import cr.ac.una.evacomunaws.controller.EvaluatedController_Service;
import cr.ac.una.evacomuna.dto.EvaluatedDto;
import cr.ac.una.evacomuna.dto.EvaluatorDto;
import cr.ac.una.evacomuna.dto.FinalCalificationDto;
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
    private FinalCalificationService finalCalificationService;

    /**
     * Default instance of the service
     */
    public EvaluatedService() {
        service = new EvaluatedController_Service();
        port = service.getEvaluatedControllerPort();
        finalCalificationService = new FinalCalificationService();
    }

    /**
     * Creates a new evaluated
     *
     * @param evaluatedDto object to create
     * @return EvaluatedDto with the created evaluated if found, null otherwise
     */
    public ResponseWrapper createEvaluated(EvaluatedDto evaluatedDto) {
        try {
            cr.ac.una.evacomunaws.controller.EvaluatedDto entity = evaluatedDto.getDto();
            entity = evaluatedDto.convertFromDTOToGenerated(evaluatedDto, entity);
            cr.ac.una.evacomunaws.controller.ResponseWrapper response = port.createEvaluated(entity);
            cr.ac.una.evacomunaws.controller.EvaluatedDto evaluated = (cr.ac.una.evacomunaws.controller.EvaluatedDto) response
                    .getData();
            evaluatedDto = new EvaluatedDto(evaluated);
            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "Evaluated created successfully",
                    evaluatedDto.convertFromGeneratedToDTO(evaluated, evaluatedDto));
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
            cr.ac.una.evacomunaws.controller.ResponseWrapper response = port.getEvaluatedById(id);
            cr.ac.una.evacomunaws.controller.EvaluatedDto evaluated = (cr.ac.una.evacomunaws.controller.EvaluatedDto) response
                    .getData();
            if (evaluated == null) {
                return new ResponseWrapper(
                        ResponseCode.NOT_FOUND.getCode(),
                        ResponseCode.NOT_FOUND,
                        "Evaluated not found",
                        null);
            }
            EvaluatedDto evaluatedDto = new EvaluatedDto(evaluated);
            evaluatedDto.convertFromGeneratedToDTO(evaluated, evaluatedDto);
            if (evaluated.getEvaluators() != null) {
                evaluatedDto.setEvaluators(
                        evaluated.getEvaluators()
                                .stream()
                                .map(i -> {
                                    cr.ac.una.evacomunaws.controller.EvaluatorDto evaluatorDto = (cr.ac.una.evacomunaws.controller.EvaluatorDto) i;
                                    return new EvaluatorDto(evaluatorDto);
                                })
                                .collect(Collectors.toList()));
            }

            if (evaluated.getFinalCalifications() != null) {
                evaluatedDto.setFinalCalifications(
                        evaluated.getFinalCalifications()
                                .stream()
                                .map(i -> {
                                    cr.ac.una.evacomunaws.controller.FinalCalificationDto finalCalificationDto = (cr.ac.una.evacomunaws.controller.FinalCalificationDto) i;
                                    FinalCalificationDto dto = new FinalCalificationDto(finalCalificationDto);
                                    dto.convertFromGeneratedToDTO(finalCalificationDto, dto);
                                    return dto;
                                })
                                .collect(Collectors.toList()));
            }
            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "Evaluated fetched successfully",
                    evaluatedDto);
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
            cr.ac.una.evacomunaws.controller.ResponseWrapper response = port.getAllEvaluated();
            cr.ac.una.evacomunaws.controller.ListWrapper listWrapper = (cr.ac.una.evacomunaws.controller.ListWrapper) response
                    .getData();
            List<cr.ac.una.evacomunaws.controller.EvaluatedDto> listGenerated = new ArrayList<>();
            List<EvaluatedDto> listDto = listWrapper
                    .getElement()
                    .stream()
                    .filter(i -> i instanceof cr.ac.una.evacomunaws.controller.EvaluatedDto)
                    .map(i -> {
                        cr.ac.una.evacomunaws.controller.EvaluatedDto evaluatedDto = (cr.ac.una.evacomunaws.controller.EvaluatedDto) i;
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

            cr.ac.una.evacomunaws.controller.EvaluatedDto entity = evaluatedDto.getDto();
            entity = evaluatedDto.convertFromDTOToGenerated(evaluatedDto, entity);
            cr.ac.una.evacomunaws.controller.ResponseWrapper response = port.updateEvaluated(entity);
            cr.ac.una.evacomunaws.controller.EvaluatedDto evaluated = (cr.ac.una.evacomunaws.controller.EvaluatedDto) response
                    .getData();
            evaluatedDto = new EvaluatedDto(evaluated);
            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "Evaluated updated successfully",
                    evaluatedDto.convertFromGeneratedToDTO(evaluated, evaluatedDto));

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
    public ResponseWrapper deleteEvaluatedById(EvaluatedDto evaluatedDto) {
        try {

            for (FinalCalificationDto i : evaluatedDto.getFinalCalifications()) {
                finalCalificationService.deleteFinalCalificationById(i.getID());
            }
            cr.ac.una.evacomunaws.controller.ResponseWrapper response = port.deleteEvaluatedById(evaluatedDto.getId());
            if (response.getCode() == cr.ac.una.evacomunaws.controller.ResponseCode.OK) {
                return new ResponseWrapper(
                        ResponseCode.OK.getCode(),
                        ResponseCode.OK,
                        "Evaluated deleted successfully",
                        response.getData());
            }
            return new ResponseWrapper(
                    ResponseCode.INTERNAL_SERVER_ERROR.getCode(),
                    ResponseCode.INTERNAL_SERVER_ERROR,
                    "Error removing Evaluated: " + response.getMessage(),
                    null);
        } catch (Exception e) {
            return new ResponseWrapper(
                    ResponseCode.INTERNAL_SERVER_ERROR.getCode(),
                    ResponseCode.INTERNAL_SERVER_ERROR,
                    e.getMessage(),
                    null);
        }
    }

}
