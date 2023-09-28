package cr.ac.una.evacomunaws.controller;

import cr.ac.una.evacomunaws.dto.CalificationDto;
import cr.ac.una.evacomunaws.services.CalificationService;
import cr.ac.una.evacomunaws.util.ResponseWrapper;
import jakarta.ejb.EJB;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

/**
 * 
 * @author arayaroma
 */
@WebService(serviceName = "CalificationController")
public class CalificationController {

    @EJB
    CalificationService calificationService;

    @WebMethod(operationName = "createCalification")
    public ResponseWrapper createCalification(CalificationDto calificationDto) {
        return calificationService.createCalification(calificationDto);
    }

    @WebMethod(operationName = "updateCalification")
    public ResponseWrapper updateCalification(CalificationDto calificationDto) {
        return calificationService.updateCalification(calificationDto);
    }

    @WebMethod(operationName = "getCalificationById")
    public ResponseWrapper getCalificationById(Long id) {
        return calificationService.getCalificationById(id);
    }

    @WebMethod(operationName = "getCalificationNote")
    public ResponseWrapper getCalificationNote(Long id) {
        return calificationService.getCalificationNote(id);
    }

    @WebMethod(operationName = "getAllCalification")
    public ResponseWrapper getAllCalification() {
        return calificationService.getAllCalification();
    }

    @WebMethod(operationName = "deleteCalificationById")
    public ResponseWrapper deleteCalificationById(Long id) {
        return calificationService.deleteCalificationById(id);
    }
}
