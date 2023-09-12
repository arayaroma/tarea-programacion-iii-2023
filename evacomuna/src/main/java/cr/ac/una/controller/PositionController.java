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
 * 2023-09-11T20:50:05.793-06:00
 * Generated source version: 4.0.2
 *
 */
@WebService(targetNamespace = "http://controller.una.ac.cr/", name = "PositionController")
@XmlSeeAlso({ObjectFactory.class})
public interface PositionController {

    @WebMethod
    @Action(input = "http://controller.una.ac.cr/PositionController/deletePositionByIdRequest", output = "http://controller.una.ac.cr/PositionController/deletePositionByIdResponse")
    @RequestWrapper(localName = "deletePositionById", targetNamespace = "http://controller.una.ac.cr/", className = "cr.ac.una.controller.DeletePositionById")
    @ResponseWrapper(localName = "deletePositionByIdResponse", targetNamespace = "http://controller.una.ac.cr/", className = "cr.ac.una.controller.DeletePositionByIdResponse")
    @WebResult(name = "return", targetNamespace = "")
    public cr.ac.una.controller.ResponseWrapper deletePositionById(

        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.Long arg0
    );

    @WebMethod
    @Action(input = "http://controller.una.ac.cr/PositionController/getPositionByNameRequest", output = "http://controller.una.ac.cr/PositionController/getPositionByNameResponse")
    @RequestWrapper(localName = "getPositionByName", targetNamespace = "http://controller.una.ac.cr/", className = "cr.ac.una.controller.GetPositionByName")
    @ResponseWrapper(localName = "getPositionByNameResponse", targetNamespace = "http://controller.una.ac.cr/", className = "cr.ac.una.controller.GetPositionByNameResponse")
    @WebResult(name = "return", targetNamespace = "")
    public cr.ac.una.controller.ResponseWrapper getPositionByName(

        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0
    );

    @WebMethod
    @Action(input = "http://controller.una.ac.cr/PositionController/getPositionByIdRequest", output = "http://controller.una.ac.cr/PositionController/getPositionByIdResponse")
    @RequestWrapper(localName = "getPositionById", targetNamespace = "http://controller.una.ac.cr/", className = "cr.ac.una.controller.GetPositionById")
    @ResponseWrapper(localName = "getPositionByIdResponse", targetNamespace = "http://controller.una.ac.cr/", className = "cr.ac.una.controller.GetPositionByIdResponse")
    @WebResult(name = "return", targetNamespace = "")
    public cr.ac.una.controller.ResponseWrapper getPositionById(

        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.Long arg0
    );

    @WebMethod
    @Action(input = "http://controller.una.ac.cr/PositionController/updatePositionByIdRequest", output = "http://controller.una.ac.cr/PositionController/updatePositionByIdResponse")
    @RequestWrapper(localName = "updatePositionById", targetNamespace = "http://controller.una.ac.cr/", className = "cr.ac.una.controller.UpdatePositionById")
    @ResponseWrapper(localName = "updatePositionByIdResponse", targetNamespace = "http://controller.una.ac.cr/", className = "cr.ac.una.controller.UpdatePositionByIdResponse")
    @WebResult(name = "return", targetNamespace = "")
    public cr.ac.una.controller.ResponseWrapper updatePositionById(

        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.Long arg0
    );

    @WebMethod
    @Action(input = "http://controller.una.ac.cr/PositionController/updatePositionRequest", output = "http://controller.una.ac.cr/PositionController/updatePositionResponse")
    @RequestWrapper(localName = "updatePosition", targetNamespace = "http://controller.una.ac.cr/", className = "cr.ac.una.controller.UpdatePosition")
    @ResponseWrapper(localName = "updatePositionResponse", targetNamespace = "http://controller.una.ac.cr/", className = "cr.ac.una.controller.UpdatePositionResponse")
    @WebResult(name = "return", targetNamespace = "")
    public cr.ac.una.controller.ResponseWrapper updatePosition(

        @WebParam(name = "arg0", targetNamespace = "")
        cr.ac.una.controller.PositionDto arg0
    );

    @WebMethod
    @Action(input = "http://controller.una.ac.cr/PositionController/getPositionsRequest", output = "http://controller.una.ac.cr/PositionController/getPositionsResponse")
    @RequestWrapper(localName = "getPositions", targetNamespace = "http://controller.una.ac.cr/", className = "cr.ac.una.controller.GetPositions")
    @ResponseWrapper(localName = "getPositionsResponse", targetNamespace = "http://controller.una.ac.cr/", className = "cr.ac.una.controller.GetPositionsResponse")
    @WebResult(name = "return", targetNamespace = "")
    public cr.ac.una.controller.ResponseWrapper getPositions()
;

    @WebMethod
    @Action(input = "http://controller.una.ac.cr/PositionController/createPositionRequest", output = "http://controller.una.ac.cr/PositionController/createPositionResponse")
    @RequestWrapper(localName = "createPosition", targetNamespace = "http://controller.una.ac.cr/", className = "cr.ac.una.controller.CreatePosition")
    @ResponseWrapper(localName = "createPositionResponse", targetNamespace = "http://controller.una.ac.cr/", className = "cr.ac.una.controller.CreatePositionResponse")
    @WebResult(name = "return", targetNamespace = "")
    public cr.ac.una.controller.ResponseWrapper createPosition(

        @WebParam(name = "arg0", targetNamespace = "")
        cr.ac.una.controller.PositionDto arg0
    );
}
