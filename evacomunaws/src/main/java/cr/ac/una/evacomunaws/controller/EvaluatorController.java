package cr.ac.una.evacomunaws.controller;

import cr.ac.una.evacomunaws.dto.EvaluatorDto;
import cr.ac.una.evacomunaws.services.EvaluatorService;
import cr.ac.una.evacomunaws.util.ResponseWrapper;
import jakarta.ejb.EJB;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

/**
 * 
 * @author arayaroma
 */
@WebService(serviceName = "EvaluatorController")
public class EvaluatorController {

    @EJB
    EvaluatorService evaluatorService;

    @WebMethod(operationName = "createEvaluator")
    public ResponseWrapper createEvaluator(EvaluatorDto evaluatorDto) {
        return evaluatorService.createEvaluator(evaluatorDto);
    }

    @WebMethod(operationName = "updateEvaluator")
    public ResponseWrapper updateEvaluator(EvaluatorDto evaluatorDto) {
        return evaluatorService.updateEvaluator(evaluatorDto);
    }

    @WebMethod(operationName = "getEvaluatorById")
    public ResponseWrapper getEvaluatorById(Long id) {
        return evaluatorService.getEvaluatorById(id);
    }

    @WebMethod(operationName = "getEvaluatorByEvaluatedId")
    public ResponseWrapper getEvaluatorByEvaluatedId(Long id) {
        return evaluatorService.getEvaluatorByEvaluatedId(id);
    }

    @WebMethod(operationName = "getAllEvaluator")
    public ResponseWrapper getAllEvaluator() {
        return evaluatorService.getAllEvaluator();
    }

    @WebMethod(operationName = "deleteEvaluatorById")
    public ResponseWrapper deleteEvaluatorById(Long id) {
        return evaluatorService.deleteEvaluatorById(id);
    }
}
