package cr.ac.una.evacomunaws.controller;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.ws.Action;
import jakarta.xml.ws.RequestWrapper;
import jakarta.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 4.0.2
 * 2023-09-28T11:35:09.431-06:00
 * Generated source version: 4.0.2
 *
 */
@WebService(targetNamespace = "http://controller.evacomunaws.una.ac.cr/", name = "CalificationController")
@XmlSeeAlso({ObjectFactory.class})
public interface CalificationController {

    @WebMethod
    @Action(input = "http://controller.evacomunaws.una.ac.cr/CalificationController/getCalificationByIdRequest", output = "http://controller.evacomunaws.una.ac.cr/CalificationController/getCalificationByIdResponse")
    @RequestWrapper(localName = "getCalificationById", targetNamespace = "http://controller.evacomunaws.una.ac.cr/", className = "cr.ac.una.evacomunaws.controller.GetCalificationById")
    @ResponseWrapper(localName = "getCalificationByIdResponse", targetNamespace = "http://controller.evacomunaws.una.ac.cr/", className = "cr.ac.una.evacomunaws.controller.GetCalificationByIdResponse")
    @WebResult(name = "return", targetNamespace = "")
    public cr.ac.una.evacomunaws.controller.ResponseWrapper getCalificationById(

        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.Long arg0
    );

    @WebMethod
    @Action(input = "http://controller.evacomunaws.una.ac.cr/CalificationController/deleteCalificationByIdRequest", output = "http://controller.evacomunaws.una.ac.cr/CalificationController/deleteCalificationByIdResponse")
    @RequestWrapper(localName = "deleteCalificationById", targetNamespace = "http://controller.evacomunaws.una.ac.cr/", className = "cr.ac.una.evacomunaws.controller.DeleteCalificationById")
    @ResponseWrapper(localName = "deleteCalificationByIdResponse", targetNamespace = "http://controller.evacomunaws.una.ac.cr/", className = "cr.ac.una.evacomunaws.controller.DeleteCalificationByIdResponse")
    @WebResult(name = "return", targetNamespace = "")
    public cr.ac.una.evacomunaws.controller.ResponseWrapper deleteCalificationById(

        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.Long arg0
    );

    @WebMethod
    @Action(input = "http://controller.evacomunaws.una.ac.cr/CalificationController/createCalificationRequest", output = "http://controller.evacomunaws.una.ac.cr/CalificationController/createCalificationResponse")
    @RequestWrapper(localName = "createCalification", targetNamespace = "http://controller.evacomunaws.una.ac.cr/", className = "cr.ac.una.evacomunaws.controller.CreateCalification")
    @ResponseWrapper(localName = "createCalificationResponse", targetNamespace = "http://controller.evacomunaws.una.ac.cr/", className = "cr.ac.una.evacomunaws.controller.CreateCalificationResponse")
    @WebResult(name = "return", targetNamespace = "")
    public cr.ac.una.evacomunaws.controller.ResponseWrapper createCalification(

        @WebParam(name = "arg0", targetNamespace = "")
        cr.ac.una.evacomunaws.controller.CalificationDto arg0
    );

    @WebMethod
    @Action(input = "http://controller.evacomunaws.una.ac.cr/CalificationController/updateCalificationRequest", output = "http://controller.evacomunaws.una.ac.cr/CalificationController/updateCalificationResponse")
    @RequestWrapper(localName = "updateCalification", targetNamespace = "http://controller.evacomunaws.una.ac.cr/", className = "cr.ac.una.evacomunaws.controller.UpdateCalification")
    @ResponseWrapper(localName = "updateCalificationResponse", targetNamespace = "http://controller.evacomunaws.una.ac.cr/", className = "cr.ac.una.evacomunaws.controller.UpdateCalificationResponse")
    @WebResult(name = "return", targetNamespace = "")
    public cr.ac.una.evacomunaws.controller.ResponseWrapper updateCalification(

        @WebParam(name = "arg0", targetNamespace = "")
        cr.ac.una.evacomunaws.controller.CalificationDto arg0
    );

    @WebMethod
    @Action(input = "http://controller.evacomunaws.una.ac.cr/CalificationController/getAllCalificationRequest", output = "http://controller.evacomunaws.una.ac.cr/CalificationController/getAllCalificationResponse")
    @RequestWrapper(localName = "getAllCalification", targetNamespace = "http://controller.evacomunaws.una.ac.cr/", className = "cr.ac.una.evacomunaws.controller.GetAllCalification")
    @ResponseWrapper(localName = "getAllCalificationResponse", targetNamespace = "http://controller.evacomunaws.una.ac.cr/", className = "cr.ac.una.evacomunaws.controller.GetAllCalificationResponse")
    @WebResult(name = "return", targetNamespace = "")
    public cr.ac.una.evacomunaws.controller.ResponseWrapper getAllCalification()
;

    @WebMethod
    @Action(input = "http://controller.evacomunaws.una.ac.cr/CalificationController/getCalificationNoteRequest", output = "http://controller.evacomunaws.una.ac.cr/CalificationController/getCalificationNoteResponse")
    @RequestWrapper(localName = "getCalificationNote", targetNamespace = "http://controller.evacomunaws.una.ac.cr/", className = "cr.ac.una.evacomunaws.controller.GetCalificationNote")
    @ResponseWrapper(localName = "getCalificationNoteResponse", targetNamespace = "http://controller.evacomunaws.una.ac.cr/", className = "cr.ac.una.evacomunaws.controller.GetCalificationNoteResponse")
    @WebResult(name = "return", targetNamespace = "")
    public cr.ac.una.evacomunaws.controller.ResponseWrapper getCalificationNote(

        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.Long arg0
    );
}
