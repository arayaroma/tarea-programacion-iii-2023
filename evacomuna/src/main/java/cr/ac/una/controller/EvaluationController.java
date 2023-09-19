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
 * 2023-09-19T09:43:15.462-06:00
 * Generated source version: 4.0.2
 *
 */
@WebService(targetNamespace = "http://controller.una.ac.cr/", name = "EvaluationController")
@XmlSeeAlso({ObjectFactory.class})
public interface EvaluationController {

    @WebMethod
    @Action(input = "http://controller.una.ac.cr/EvaluationController/getEvaluationByIdRequest", output = "http://controller.una.ac.cr/EvaluationController/getEvaluationByIdResponse")
    @RequestWrapper(localName = "getEvaluationById", targetNamespace = "http://controller.una.ac.cr/", className = "cr.ac.una.controller.GetEvaluationById")
    @ResponseWrapper(localName = "getEvaluationByIdResponse", targetNamespace = "http://controller.una.ac.cr/", className = "cr.ac.una.controller.GetEvaluationByIdResponse")
    @WebResult(name = "return", targetNamespace = "")
    public cr.ac.una.controller.ResponseWrapper getEvaluationById(

        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.Long arg0
    );

    @WebMethod
    @Action(input = "http://controller.una.ac.cr/EvaluationController/createEvaluationRequest", output = "http://controller.una.ac.cr/EvaluationController/createEvaluationResponse")
    @RequestWrapper(localName = "createEvaluation", targetNamespace = "http://controller.una.ac.cr/", className = "cr.ac.una.controller.CreateEvaluation")
    @ResponseWrapper(localName = "createEvaluationResponse", targetNamespace = "http://controller.una.ac.cr/", className = "cr.ac.una.controller.CreateEvaluationResponse")
    @WebResult(name = "return", targetNamespace = "")
    public cr.ac.una.controller.ResponseWrapper createEvaluation(

        @WebParam(name = "arg0", targetNamespace = "")
        cr.ac.una.controller.EvaluationDto arg0
    );

    @WebMethod
    @Action(input = "http://controller.una.ac.cr/EvaluationController/getEvaluationByNameRequest", output = "http://controller.una.ac.cr/EvaluationController/getEvaluationByNameResponse")
    @RequestWrapper(localName = "getEvaluationByName", targetNamespace = "http://controller.una.ac.cr/", className = "cr.ac.una.controller.GetEvaluationByName")
    @ResponseWrapper(localName = "getEvaluationByNameResponse", targetNamespace = "http://controller.una.ac.cr/", className = "cr.ac.una.controller.GetEvaluationByNameResponse")
    @WebResult(name = "return", targetNamespace = "")
    public cr.ac.una.controller.ResponseWrapper getEvaluationByName(

        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0
    );

    @WebMethod
    @Action(input = "http://controller.una.ac.cr/EvaluationController/getAllEvaluationRequest", output = "http://controller.una.ac.cr/EvaluationController/getAllEvaluationResponse")
    @RequestWrapper(localName = "getAllEvaluation", targetNamespace = "http://controller.una.ac.cr/", className = "cr.ac.una.controller.GetAllEvaluation")
    @ResponseWrapper(localName = "getAllEvaluationResponse", targetNamespace = "http://controller.una.ac.cr/", className = "cr.ac.una.controller.GetAllEvaluationResponse")
    @WebResult(name = "return", targetNamespace = "")
    public cr.ac.una.controller.ResponseWrapper getAllEvaluation()
;

    @WebMethod
    @Action(input = "http://controller.una.ac.cr/EvaluationController/deleteEvaluationByIdRequest", output = "http://controller.una.ac.cr/EvaluationController/deleteEvaluationByIdResponse")
    @RequestWrapper(localName = "deleteEvaluationById", targetNamespace = "http://controller.una.ac.cr/", className = "cr.ac.una.controller.DeleteEvaluationById")
    @ResponseWrapper(localName = "deleteEvaluationByIdResponse", targetNamespace = "http://controller.una.ac.cr/", className = "cr.ac.una.controller.DeleteEvaluationByIdResponse")
    @WebResult(name = "return", targetNamespace = "")
    public cr.ac.una.controller.ResponseWrapper deleteEvaluationById(

        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.Long arg0
    );

    @WebMethod
    @Action(input = "http://controller.una.ac.cr/EvaluationController/updateEvaluationRequest", output = "http://controller.una.ac.cr/EvaluationController/updateEvaluationResponse")
    @RequestWrapper(localName = "updateEvaluation", targetNamespace = "http://controller.una.ac.cr/", className = "cr.ac.una.controller.UpdateEvaluation")
    @ResponseWrapper(localName = "updateEvaluationResponse", targetNamespace = "http://controller.una.ac.cr/", className = "cr.ac.una.controller.UpdateEvaluationResponse")
    @WebResult(name = "return", targetNamespace = "")
    public cr.ac.una.controller.ResponseWrapper updateEvaluation(

        @WebParam(name = "arg0", targetNamespace = "")
        cr.ac.una.controller.EvaluationDto arg0
    );
}
