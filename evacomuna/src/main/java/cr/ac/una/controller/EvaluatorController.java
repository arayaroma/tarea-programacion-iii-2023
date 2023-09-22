package cr.ac.una.controller;

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
 * 2023-09-21T21:51:16.215-06:00
 * Generated source version: 4.0.2
 *
 */
@WebService(targetNamespace = "http://controller.una.ac.cr/", name = "EvaluatorController")
@XmlSeeAlso({ObjectFactory.class})
public interface EvaluatorController {

    @WebMethod
    @Action(input = "http://controller.una.ac.cr/EvaluatorController/deleteEvaluatorByIdRequest", output = "http://controller.una.ac.cr/EvaluatorController/deleteEvaluatorByIdResponse")
    @RequestWrapper(localName = "deleteEvaluatorById", targetNamespace = "http://controller.una.ac.cr/", className = "cr.ac.una.controller.DeleteEvaluatorById")
    @ResponseWrapper(localName = "deleteEvaluatorByIdResponse", targetNamespace = "http://controller.una.ac.cr/", className = "cr.ac.una.controller.DeleteEvaluatorByIdResponse")
    @WebResult(name = "return", targetNamespace = "")
    public cr.ac.una.controller.ResponseWrapper deleteEvaluatorById(

        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.Long arg0
    );

    @WebMethod
    @Action(input = "http://controller.una.ac.cr/EvaluatorController/getEvaluatorByIdRequest", output = "http://controller.una.ac.cr/EvaluatorController/getEvaluatorByIdResponse")
    @RequestWrapper(localName = "getEvaluatorById", targetNamespace = "http://controller.una.ac.cr/", className = "cr.ac.una.controller.GetEvaluatorById")
    @ResponseWrapper(localName = "getEvaluatorByIdResponse", targetNamespace = "http://controller.una.ac.cr/", className = "cr.ac.una.controller.GetEvaluatorByIdResponse")
    @WebResult(name = "return", targetNamespace = "")
    public cr.ac.una.controller.ResponseWrapper getEvaluatorById(

        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.Long arg0
    );

    @WebMethod
    @Action(input = "http://controller.una.ac.cr/EvaluatorController/getAllEvaluatorRequest", output = "http://controller.una.ac.cr/EvaluatorController/getAllEvaluatorResponse")
    @RequestWrapper(localName = "getAllEvaluator", targetNamespace = "http://controller.una.ac.cr/", className = "cr.ac.una.controller.GetAllEvaluator")
    @ResponseWrapper(localName = "getAllEvaluatorResponse", targetNamespace = "http://controller.una.ac.cr/", className = "cr.ac.una.controller.GetAllEvaluatorResponse")
    @WebResult(name = "return", targetNamespace = "")
    public cr.ac.una.controller.ResponseWrapper getAllEvaluator()
;

    @WebMethod
    @Action(input = "http://controller.una.ac.cr/EvaluatorController/updateEvaluatorRequest", output = "http://controller.una.ac.cr/EvaluatorController/updateEvaluatorResponse")
    @RequestWrapper(localName = "updateEvaluator", targetNamespace = "http://controller.una.ac.cr/", className = "cr.ac.una.controller.UpdateEvaluator")
    @ResponseWrapper(localName = "updateEvaluatorResponse", targetNamespace = "http://controller.una.ac.cr/", className = "cr.ac.una.controller.UpdateEvaluatorResponse")
    @WebResult(name = "return", targetNamespace = "")
    public cr.ac.una.controller.ResponseWrapper updateEvaluator(

        @WebParam(name = "arg0", targetNamespace = "")
        cr.ac.una.controller.EvaluatorDto arg0
    );

    @WebMethod
    @Action(input = "http://controller.una.ac.cr/EvaluatorController/getEvaluatorByNameRequest", output = "http://controller.una.ac.cr/EvaluatorController/getEvaluatorByNameResponse")
    @RequestWrapper(localName = "getEvaluatorByName", targetNamespace = "http://controller.una.ac.cr/", className = "cr.ac.una.controller.GetEvaluatorByName")
    @ResponseWrapper(localName = "getEvaluatorByNameResponse", targetNamespace = "http://controller.una.ac.cr/", className = "cr.ac.una.controller.GetEvaluatorByNameResponse")
    @WebResult(name = "return", targetNamespace = "")
    public cr.ac.una.controller.ResponseWrapper getEvaluatorByName(

        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0
    );

    @WebMethod
    @Action(input = "http://controller.una.ac.cr/EvaluatorController/createEvaluatorRequest", output = "http://controller.una.ac.cr/EvaluatorController/createEvaluatorResponse")
    @RequestWrapper(localName = "createEvaluator", targetNamespace = "http://controller.una.ac.cr/", className = "cr.ac.una.controller.CreateEvaluator")
    @ResponseWrapper(localName = "createEvaluatorResponse", targetNamespace = "http://controller.una.ac.cr/", className = "cr.ac.una.controller.CreateEvaluatorResponse")
    @WebResult(name = "return", targetNamespace = "")
    public cr.ac.una.controller.ResponseWrapper createEvaluator(

        @WebParam(name = "arg0", targetNamespace = "")
        cr.ac.una.controller.EvaluatorDto arg0
    );
}
