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
 * 2023-10-01T18:20:01.303-06:00
 * Generated source version: 4.0.2
 *
 */
@WebService(targetNamespace = "http://controller.evacomunaws.una.ac.cr/", name = "FinalCalificationController")
@XmlSeeAlso({ObjectFactory.class})
public interface FinalCalificationController {

    @WebMethod
    @Action(input = "http://controller.evacomunaws.una.ac.cr/FinalCalificationController/getFinalCalificationNoteRequest", output = "http://controller.evacomunaws.una.ac.cr/FinalCalificationController/getFinalCalificationNoteResponse")
    @RequestWrapper(localName = "getFinalCalificationNote", targetNamespace = "http://controller.evacomunaws.una.ac.cr/", className = "cr.ac.una.evacomunaws.controller.GetFinalCalificationNote")
    @ResponseWrapper(localName = "getFinalCalificationNoteResponse", targetNamespace = "http://controller.evacomunaws.una.ac.cr/", className = "cr.ac.una.evacomunaws.controller.GetFinalCalificationNoteResponse")
    @WebResult(name = "return", targetNamespace = "")
    public cr.ac.una.evacomunaws.controller.ResponseWrapper getFinalCalificationNote(

        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.Long arg0
    );

    @WebMethod
    @Action(input = "http://controller.evacomunaws.una.ac.cr/FinalCalificationController/createFinalCalificationRequest", output = "http://controller.evacomunaws.una.ac.cr/FinalCalificationController/createFinalCalificationResponse")
    @RequestWrapper(localName = "createFinalCalification", targetNamespace = "http://controller.evacomunaws.una.ac.cr/", className = "cr.ac.una.evacomunaws.controller.CreateFinalCalification")
    @ResponseWrapper(localName = "createFinalCalificationResponse", targetNamespace = "http://controller.evacomunaws.una.ac.cr/", className = "cr.ac.una.evacomunaws.controller.CreateFinalCalificationResponse")
    @WebResult(name = "return", targetNamespace = "")
    public cr.ac.una.evacomunaws.controller.ResponseWrapper createFinalCalification(

        @WebParam(name = "arg0", targetNamespace = "")
        cr.ac.una.evacomunaws.controller.FinalCalificationDto arg0
    );

    @WebMethod
    @Action(input = "http://controller.evacomunaws.una.ac.cr/FinalCalificationController/getAllFinalCalificationRequest", output = "http://controller.evacomunaws.una.ac.cr/FinalCalificationController/getAllFinalCalificationResponse")
    @RequestWrapper(localName = "getAllFinalCalification", targetNamespace = "http://controller.evacomunaws.una.ac.cr/", className = "cr.ac.una.evacomunaws.controller.GetAllFinalCalification")
    @ResponseWrapper(localName = "getAllFinalCalificationResponse", targetNamespace = "http://controller.evacomunaws.una.ac.cr/", className = "cr.ac.una.evacomunaws.controller.GetAllFinalCalificationResponse")
    @WebResult(name = "return", targetNamespace = "")
    public cr.ac.una.evacomunaws.controller.ResponseWrapper getAllFinalCalification()
;

    @WebMethod
    @Action(input = "http://controller.evacomunaws.una.ac.cr/FinalCalificationController/updateFinalCalificationRequest", output = "http://controller.evacomunaws.una.ac.cr/FinalCalificationController/updateFinalCalificationResponse")
    @RequestWrapper(localName = "updateFinalCalification", targetNamespace = "http://controller.evacomunaws.una.ac.cr/", className = "cr.ac.una.evacomunaws.controller.UpdateFinalCalification")
    @ResponseWrapper(localName = "updateFinalCalificationResponse", targetNamespace = "http://controller.evacomunaws.una.ac.cr/", className = "cr.ac.una.evacomunaws.controller.UpdateFinalCalificationResponse")
    @WebResult(name = "return", targetNamespace = "")
    public cr.ac.una.evacomunaws.controller.ResponseWrapper updateFinalCalification(

        @WebParam(name = "arg0", targetNamespace = "")
        cr.ac.una.evacomunaws.controller.FinalCalificationDto arg0
    );

    @WebMethod
    @Action(input = "http://controller.evacomunaws.una.ac.cr/FinalCalificationController/deleteFinalCalificationByIdRequest", output = "http://controller.evacomunaws.una.ac.cr/FinalCalificationController/deleteFinalCalificationByIdResponse")
    @RequestWrapper(localName = "deleteFinalCalificationById", targetNamespace = "http://controller.evacomunaws.una.ac.cr/", className = "cr.ac.una.evacomunaws.controller.DeleteFinalCalificationById")
    @ResponseWrapper(localName = "deleteFinalCalificationByIdResponse", targetNamespace = "http://controller.evacomunaws.una.ac.cr/", className = "cr.ac.una.evacomunaws.controller.DeleteFinalCalificationByIdResponse")
    @WebResult(name = "return", targetNamespace = "")
    public cr.ac.una.evacomunaws.controller.ResponseWrapper deleteFinalCalificationById(

        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.Long arg0
    );

    @WebMethod
    @Action(input = "http://controller.evacomunaws.una.ac.cr/FinalCalificationController/getFinalCalificationByIdRequest", output = "http://controller.evacomunaws.una.ac.cr/FinalCalificationController/getFinalCalificationByIdResponse")
    @RequestWrapper(localName = "getFinalCalificationById", targetNamespace = "http://controller.evacomunaws.una.ac.cr/", className = "cr.ac.una.evacomunaws.controller.GetFinalCalificationById")
    @ResponseWrapper(localName = "getFinalCalificationByIdResponse", targetNamespace = "http://controller.evacomunaws.una.ac.cr/", className = "cr.ac.una.evacomunaws.controller.GetFinalCalificationByIdResponse")
    @WebResult(name = "return", targetNamespace = "")
    public cr.ac.una.evacomunaws.controller.ResponseWrapper getFinalCalificationById(

        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.Long arg0
    );

    @WebMethod
    @Action(input = "http://controller.evacomunaws.una.ac.cr/FinalCalificationController/getAverageRequest", output = "http://controller.evacomunaws.una.ac.cr/FinalCalificationController/getAverageResponse")
    @RequestWrapper(localName = "getAverage", targetNamespace = "http://controller.evacomunaws.una.ac.cr/", className = "cr.ac.una.evacomunaws.controller.GetAverage")
    @ResponseWrapper(localName = "getAverageResponse", targetNamespace = "http://controller.evacomunaws.una.ac.cr/", className = "cr.ac.una.evacomunaws.controller.GetAverageResponse")
    @WebResult(name = "return", targetNamespace = "")
    public cr.ac.una.evacomunaws.controller.ResponseWrapper getAverage(

        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.Long arg0
    );
}
