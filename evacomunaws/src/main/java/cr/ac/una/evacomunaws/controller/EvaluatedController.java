package cr.ac.una.evacomunaws.controller;

import cr.ac.una.evacomunaws.dto.EvaluatedDto;
import cr.ac.una.evacomunaws.services.EvaluatedService;
import cr.ac.una.evacomunaws.util.ResponseWrapper;
import jakarta.ejb.EJB;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

/**
 * 
 * @author arayaroma
 */
@WebService(serviceName = "EvaluatedController")
public class EvaluatedController {

    @EJB
    EvaluatedService evaluatedService;

    @WebMethod(operationName = "createEvaluated")
    public ResponseWrapper createEvaluated(EvaluatedDto evaluatedDto) {
        return evaluatedService.createEvaluated(evaluatedDto);
    }

    @WebMethod(operationName = "updateEvaluated")
    public ResponseWrapper updateEvaluated(EvaluatedDto evaluatedDto) {
        return evaluatedService.updateEvaluated(evaluatedDto);
    }

    @WebMethod(operationName = "getEvaluatedById")
    public ResponseWrapper getEvaluatedById(Long id) {
        return evaluatedService.getEvaluatedById(id);
    }

    @WebMethod(operationName = "getFinalNote")
    public ResponseWrapper getFinalNote(Long id) {
        return evaluatedService.getFinalNote(id);
    }

    @WebMethod(operationName = "getAllEvaluated")
    public ResponseWrapper getAllEvaluated() {
        return evaluatedService.getAllEvaluated();
    }

    @WebMethod(operationName = "deleteEvaluatedById")
    public ResponseWrapper deleteEvaluatedById(Long id) {
        return evaluatedService.deleteEvaluatedById(id);
    }
}
