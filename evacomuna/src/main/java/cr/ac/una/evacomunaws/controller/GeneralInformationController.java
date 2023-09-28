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
 * 2023-09-28T01:00:14.358-06:00
 * Generated source version: 4.0.2
 *
 */
@WebService(targetNamespace = "http://controller.evacomunaws.una.ac.cr/", name = "GeneralInformationController")
@XmlSeeAlso({ObjectFactory.class})
public interface GeneralInformationController {

    @WebMethod
    @Action(input = "http://controller.evacomunaws.una.ac.cr/GeneralInformationController/createGeneralInformationRequest", output = "http://controller.evacomunaws.una.ac.cr/GeneralInformationController/createGeneralInformationResponse")
    @RequestWrapper(localName = "createGeneralInformation", targetNamespace = "http://controller.evacomunaws.una.ac.cr/", className = "cr.ac.una.evacomunaws.controller.CreateGeneralInformation")
    @ResponseWrapper(localName = "createGeneralInformationResponse", targetNamespace = "http://controller.evacomunaws.una.ac.cr/", className = "cr.ac.una.evacomunaws.controller.CreateGeneralInformationResponse")
    @WebResult(name = "return", targetNamespace = "")
    public cr.ac.una.evacomunaws.controller.ResponseWrapper createGeneralInformation(

        @WebParam(name = "arg0", targetNamespace = "")
        cr.ac.una.evacomunaws.controller.GeneralInformationDto arg0
    );

    @WebMethod
    @Action(input = "http://controller.evacomunaws.una.ac.cr/GeneralInformationController/updateGeneralInformationRequest", output = "http://controller.evacomunaws.una.ac.cr/GeneralInformationController/updateGeneralInformationResponse")
    @RequestWrapper(localName = "updateGeneralInformation", targetNamespace = "http://controller.evacomunaws.una.ac.cr/", className = "cr.ac.una.evacomunaws.controller.UpdateGeneralInformation")
    @ResponseWrapper(localName = "updateGeneralInformationResponse", targetNamespace = "http://controller.evacomunaws.una.ac.cr/", className = "cr.ac.una.evacomunaws.controller.UpdateGeneralInformationResponse")
    @WebResult(name = "return", targetNamespace = "")
    public cr.ac.una.evacomunaws.controller.ResponseWrapper updateGeneralInformation(

        @WebParam(name = "arg0", targetNamespace = "")
        cr.ac.una.evacomunaws.controller.GeneralInformationDto arg0
    );

    @WebMethod
    @Action(input = "http://controller.evacomunaws.una.ac.cr/GeneralInformationController/deleteGeneralInformationByIdRequest", output = "http://controller.evacomunaws.una.ac.cr/GeneralInformationController/deleteGeneralInformationByIdResponse")
    @RequestWrapper(localName = "deleteGeneralInformationById", targetNamespace = "http://controller.evacomunaws.una.ac.cr/", className = "cr.ac.una.evacomunaws.controller.DeleteGeneralInformationById")
    @ResponseWrapper(localName = "deleteGeneralInformationByIdResponse", targetNamespace = "http://controller.evacomunaws.una.ac.cr/", className = "cr.ac.una.evacomunaws.controller.DeleteGeneralInformationByIdResponse")
    @WebResult(name = "return", targetNamespace = "")
    public cr.ac.una.evacomunaws.controller.ResponseWrapper deleteGeneralInformationById(

        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.Long arg0
    );

    @WebMethod
    @Action(input = "http://controller.evacomunaws.una.ac.cr/GeneralInformationController/getGeneralInformationRequest", output = "http://controller.evacomunaws.una.ac.cr/GeneralInformationController/getGeneralInformationResponse")
    @RequestWrapper(localName = "getGeneralInformation", targetNamespace = "http://controller.evacomunaws.una.ac.cr/", className = "cr.ac.una.evacomunaws.controller.GetGeneralInformation")
    @ResponseWrapper(localName = "getGeneralInformationResponse", targetNamespace = "http://controller.evacomunaws.una.ac.cr/", className = "cr.ac.una.evacomunaws.controller.GetGeneralInformationResponse")
    @WebResult(name = "return", targetNamespace = "")
    public cr.ac.una.evacomunaws.controller.ResponseWrapper getGeneralInformation()
;

    @WebMethod
    @Action(input = "http://controller.evacomunaws.una.ac.cr/GeneralInformationController/getGeneralInformationByIdRequest", output = "http://controller.evacomunaws.una.ac.cr/GeneralInformationController/getGeneralInformationByIdResponse")
    @RequestWrapper(localName = "getGeneralInformationById", targetNamespace = "http://controller.evacomunaws.una.ac.cr/", className = "cr.ac.una.evacomunaws.controller.GetGeneralInformationById")
    @ResponseWrapper(localName = "getGeneralInformationByIdResponse", targetNamespace = "http://controller.evacomunaws.una.ac.cr/", className = "cr.ac.una.evacomunaws.controller.GetGeneralInformationByIdResponse")
    @WebResult(name = "return", targetNamespace = "")
    public cr.ac.una.evacomunaws.controller.ResponseWrapper getGeneralInformationById(

        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.Long arg0
    );
}
