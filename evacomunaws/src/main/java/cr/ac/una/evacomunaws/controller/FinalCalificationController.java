package cr.ac.una.evacomunaws.controller;

import cr.ac.una.evacomunaws.dto.FinalCalificationDto;
import cr.ac.una.evacomunaws.services.FinalCalificationService;
import cr.ac.una.evacomunaws.util.ResponseWrapper;
import jakarta.ejb.EJB;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

/**
 * 
 * @author arayaroma
 */
@WebService(serviceName = "FinalCalificationController")
public class FinalCalificationController {

    @EJB
    FinalCalificationService finalCalificationService;

    @WebMethod(operationName = "createFinalCalification")
    public ResponseWrapper createFinalCalification(FinalCalificationDto finalCalificationDto) {
        return finalCalificationService.createFinalCalification(finalCalificationDto);
    }

    @WebMethod(operationName = "updateFinalCalification")
    public ResponseWrapper updateFinalCalification(FinalCalificationDto finalCalificationDto) {
        return finalCalificationService.updateFinalCalification(finalCalificationDto);
    }

    @WebMethod(operationName = "getFinalCalificationById")
    public ResponseWrapper getFinalCalificationById(Long id) {
        return finalCalificationService.getFinalCalificationById(id);
    }

    @WebMethod(operationName = "getFinalCalificationNote")
    public ResponseWrapper getFinalCalificationNote(Long id) {
        return finalCalificationService.getFinalCalificationNote(id);
    }

    @WebMethod(operationName = "getAverage")
    public ResponseWrapper getAverage(Long id) {
        return finalCalificationService.getAverage(id);
    }

    @WebMethod(operationName = "getAllFinalCalification")
    public ResponseWrapper getAllFinalCalification() {
        return finalCalificationService.getAllFinalCalification();
    }

    @WebMethod(operationName = "deleteFinalCalificationById")
    public ResponseWrapper deleteFinalCalificationById(Long id) {
        return finalCalificationService.deleteFinalCalificationById(id);
    }
}
