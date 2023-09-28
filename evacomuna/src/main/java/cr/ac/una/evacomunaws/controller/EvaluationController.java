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
<<<<<<< HEAD
 * 2023-09-28T02:53:45.269-06:00
=======
 * 2023-09-28T02:30:04.377-06:00
>>>>>>> b27927f ([update] load positions with skills in getPositionByName)
 * Generated source version: 4.0.2
 *
 */
@WebService(targetNamespace = "http://controller.evacomunaws.una.ac.cr/", name = "EvaluationController")
@XmlSeeAlso({ObjectFactory.class})
public interface EvaluationController {

    @WebMethod
    @Action(input = "http://controller.evacomunaws.una.ac.cr/EvaluationController/getEvaluationByNameRequest", output = "http://controller.evacomunaws.una.ac.cr/EvaluationController/getEvaluationByNameResponse")
    @RequestWrapper(localName = "getEvaluationByName", targetNamespace = "http://controller.evacomunaws.una.ac.cr/", className = "cr.ac.una.evacomunaws.controller.GetEvaluationByName")
    @ResponseWrapper(localName = "getEvaluationByNameResponse", targetNamespace = "http://controller.evacomunaws.una.ac.cr/", className = "cr.ac.una.evacomunaws.controller.GetEvaluationByNameResponse")
    @WebResult(name = "return", targetNamespace = "")
    public cr.ac.una.evacomunaws.controller.ResponseWrapper getEvaluationByName(

        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0
    );

    @WebMethod
    @Action(input = "http://controller.evacomunaws.una.ac.cr/EvaluationController/createEvaluationRequest", output = "http://controller.evacomunaws.una.ac.cr/EvaluationController/createEvaluationResponse")
    @RequestWrapper(localName = "createEvaluation", targetNamespace = "http://controller.evacomunaws.una.ac.cr/", className = "cr.ac.una.evacomunaws.controller.CreateEvaluation")
    @ResponseWrapper(localName = "createEvaluationResponse", targetNamespace = "http://controller.evacomunaws.una.ac.cr/", className = "cr.ac.una.evacomunaws.controller.CreateEvaluationResponse")
    @WebResult(name = "return", targetNamespace = "")
    public cr.ac.una.evacomunaws.controller.ResponseWrapper createEvaluation(

        @WebParam(name = "arg0", targetNamespace = "")
        cr.ac.una.evacomunaws.controller.EvaluationDto arg0
    );

    @WebMethod
    @Action(input = "http://controller.evacomunaws.una.ac.cr/EvaluationController/getEvaluationByIdRequest", output = "http://controller.evacomunaws.una.ac.cr/EvaluationController/getEvaluationByIdResponse")
    @RequestWrapper(localName = "getEvaluationById", targetNamespace = "http://controller.evacomunaws.una.ac.cr/", className = "cr.ac.una.evacomunaws.controller.GetEvaluationById")
    @ResponseWrapper(localName = "getEvaluationByIdResponse", targetNamespace = "http://controller.evacomunaws.una.ac.cr/", className = "cr.ac.una.evacomunaws.controller.GetEvaluationByIdResponse")
    @WebResult(name = "return", targetNamespace = "")
    public cr.ac.una.evacomunaws.controller.ResponseWrapper getEvaluationById(

        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.Long arg0
    );

    @WebMethod
    @Action(input = "http://controller.evacomunaws.una.ac.cr/EvaluationController/getAllEvaluationRequest", output = "http://controller.evacomunaws.una.ac.cr/EvaluationController/getAllEvaluationResponse")
    @RequestWrapper(localName = "getAllEvaluation", targetNamespace = "http://controller.evacomunaws.una.ac.cr/", className = "cr.ac.una.evacomunaws.controller.GetAllEvaluation")
    @ResponseWrapper(localName = "getAllEvaluationResponse", targetNamespace = "http://controller.evacomunaws.una.ac.cr/", className = "cr.ac.una.evacomunaws.controller.GetAllEvaluationResponse")
    @WebResult(name = "return", targetNamespace = "")
    public cr.ac.una.evacomunaws.controller.ResponseWrapper getAllEvaluation()
;

    @WebMethod
    @Action(input = "http://controller.evacomunaws.una.ac.cr/EvaluationController/deleteEvaluationByIdRequest", output = "http://controller.evacomunaws.una.ac.cr/EvaluationController/deleteEvaluationByIdResponse")
    @RequestWrapper(localName = "deleteEvaluationById", targetNamespace = "http://controller.evacomunaws.una.ac.cr/", className = "cr.ac.una.evacomunaws.controller.DeleteEvaluationById")
    @ResponseWrapper(localName = "deleteEvaluationByIdResponse", targetNamespace = "http://controller.evacomunaws.una.ac.cr/", className = "cr.ac.una.evacomunaws.controller.DeleteEvaluationByIdResponse")
    @WebResult(name = "return", targetNamespace = "")
    public cr.ac.una.evacomunaws.controller.ResponseWrapper deleteEvaluationById(

        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.Long arg0
    );

    @WebMethod
    @Action(input = "http://controller.evacomunaws.una.ac.cr/EvaluationController/updateEvaluationRequest", output = "http://controller.evacomunaws.una.ac.cr/EvaluationController/updateEvaluationResponse")
    @RequestWrapper(localName = "updateEvaluation", targetNamespace = "http://controller.evacomunaws.una.ac.cr/", className = "cr.ac.una.evacomunaws.controller.UpdateEvaluation")
    @ResponseWrapper(localName = "updateEvaluationResponse", targetNamespace = "http://controller.evacomunaws.una.ac.cr/", className = "cr.ac.una.evacomunaws.controller.UpdateEvaluationResponse")
    @WebResult(name = "return", targetNamespace = "")
    public cr.ac.una.evacomunaws.controller.ResponseWrapper updateEvaluation(

        @WebParam(name = "arg0", targetNamespace = "")
        cr.ac.una.evacomunaws.controller.EvaluationDto arg0
    );
}
