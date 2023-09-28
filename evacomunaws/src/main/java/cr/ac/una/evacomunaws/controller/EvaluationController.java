package cr.ac.una.controller;

import cr.ac.una.dto.EvaluationDto;
import cr.ac.una.services.EvaluationService;
import cr.ac.una.util.ResponseWrapper;
import jakarta.ejb.EJB;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

/**
 * 
 * @author arayaroma
 */
@WebService(serviceName = "EvaluationController")
public class EvaluationController {

    @EJB
    EvaluationService evaluationService;

    @WebMethod(operationName = "createEvaluation")
    public ResponseWrapper createEvaluation(EvaluationDto evaluationDto) {
        return evaluationService.createEvaluation(evaluationDto);
    }

    @WebMethod(operationName = "updateEvaluation")
    public ResponseWrapper updateEvaluation(EvaluationDto evaluationDto) {
        return evaluationService.updateEvaluation(evaluationDto);
    }

    @WebMethod(operationName = "getEvaluationById")
    public ResponseWrapper getEvaluationById(Long id) {
        return evaluationService.getEvaluationById(id);
    }

    @WebMethod(operationName = "getEvaluationByName")
    public ResponseWrapper getEvaluationByName(String name) {
        return evaluationService.getEvaluationByName(name);
    }

    @WebMethod(operationName = "getAllEvaluation")
    public ResponseWrapper getAllEvaluation() {
        return evaluationService.getAllEvaluation();
    }

    @WebMethod(operationName = "deleteEvaluationById")
    public ResponseWrapper deleteEvaluationById(Long id) {
        return evaluationService.deleteEvaluationById(id);
    }
    
}
