package cr.ac.una.evacomuna.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import cr.ac.una.controller.EvaluationController;
import cr.ac.una.controller.EvaluationController_Service;
import cr.ac.una.evacomuna.dto.EvaluatedDto;
import cr.ac.una.evacomuna.dto.EvaluationDto;
import cr.ac.una.evacomuna.dto.UserDto;
import cr.ac.una.evacomuna.util.DtoMapper;
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
<<<<<<< HEAD
=======
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
>>>>>>> f2b8918 ([update] load califications in pending evaluations controller)
     * Creates a new evaluation
     *
     * @param evaluationDto object to create
     * @return ResponseWrapper with the response of the request
     */
    public ResponseWrapper createEvaluation(EvaluationDto evaluationDto) {
        try {
            cr.ac.una.controller.ResponseWrapper response = port.createEvaluation(evaluationDto.getDto());
            cr.ac.una.controller.EvaluationDto evaluation = (cr.ac.una.controller.EvaluationDto) response.getData();
            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "Evaluation created successfully",
                    new EvaluationDto(evaluation));
        } catch (Exception e) {
            return new ResponseWrapper(
                    ResponseCode.INTERNAL_SERVER_ERROR.getCode(),
                    ResponseCode.INTERNAL_SERVER_ERROR,
                    "Error creating evaluation",
                    null);
        }
    }

    /**
     * Get all evaluations
     *
     * @return ResponseWrapper with the response of the request
     */
    public ResponseWrapper getAllEvaluation() {
        try {
            cr.ac.una.controller.ResponseWrapper response = port.getAllEvaluation();
            cr.ac.una.controller.ListWrapper listWrapper = (cr.ac.una.controller.ListWrapper) response.getData();
            List<cr.ac.una.controller.EvaluationDto> listGenerated = new ArrayList<>();
            List<EvaluationDto> listDto = listWrapper
                    .getElement()
                    .stream()
                    .filter(i -> i instanceof cr.ac.una.controller.EvaluationDto)
                    .map(i -> {
                        cr.ac.una.controller.EvaluationDto evaluationDto = (cr.ac.una.controller.EvaluationDto) i;
                        listGenerated.add(evaluationDto);
                        EvaluationDto evaluationDtoClient = new EvaluationDto(evaluationDto);
                        return evaluationDtoClient.convertFromGeneratedToDTO(evaluationDto, evaluationDtoClient);
                    })
                    .collect(Collectors.toList());
            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "Evaluations found successfully",
                    listDto);
        } catch (Exception e) {
            return new ResponseWrapper(
                    ResponseCode.NOT_FOUND.getCode(),
                    ResponseCode.NOT_FOUND,
                    "Evaluations not found",
                    null);
        }
    }

    public ResponseWrapper getEvaluationById(Long id) {
        try {
            cr.ac.una.controller.ResponseWrapper response = port.getEvaluationById(id);
            cr.ac.una.controller.EvaluationDto evaluation = (cr.ac.una.controller.EvaluationDto) response.getData();
            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "Evaluation found successfully",
                    new EvaluationDto(evaluation));
        } catch (Exception e) {
            return new ResponseWrapper(
                    ResponseCode.NOT_FOUND.getCode(),
                    ResponseCode.NOT_FOUND,
                    "Evaluation not found",
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
            cr.ac.una.controller.EvaluationDto evaluation = (cr.ac.una.controller.EvaluationDto) response.getData();
            EvaluationDto evaluationDto = new EvaluationDto(evaluation);
            evaluationDto.setEvaluated(DtoMapper.fromGeneratedList(evaluation.getEvaluated(), EvaluatedDto.class).getList());
            for(int i =0;i<evaluationDto.getEvaluated().size();i++){
                evaluationDto.getEvaluated().get(i).setEvaluated(new UserDto(evaluation.getEvaluated().get(i).getEvaluated()));
            }
            
            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "Evaluation found successfully",
                    evaluationDto
            );
        } catch (Exception e) {
            return new ResponseWrapper(
                    ResponseCode.NOT_FOUND.getCode(),
                    ResponseCode.NOT_FOUND,
                    "Evaluation not found",
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
            cr.ac.una.controller.ResponseWrapper response = port.updateEvaluation(evaluationDto.getDto());
            cr.ac.una.controller.EvaluationDto evaluation = (cr.ac.una.controller.EvaluationDto) response.getData();
            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "Evaluation updated successfully",
                    new EvaluationDto(evaluation));
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
            if (response.getCode() == cr.ac.una.controller.ResponseCode.OK) {
                return new ResponseWrapper(
                        ResponseCode.OK.getCode(),
                        ResponseCode.OK,
                        "Evaluation deleted successfully",
                        response.getData());
            }
            return new ResponseWrapper(
                    ResponseCode.INTERNAL_SERVER_ERROR.getCode(),
                    ResponseCode.INTERNAL_SERVER_ERROR,
                    "Error removing evaluation:" + response.getMessage(),
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
