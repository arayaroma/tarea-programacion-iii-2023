package cr.ac.una.services.impl;

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
 * 2023-08-20T21:23:33.412-06:00
 * Generated source version: 4.0.2
 *
 */
@WebService(targetNamespace = "http://impl.services.una.ac.cr/", name = "PositionServiceImpl")
@XmlSeeAlso({ObjectFactory.class})
public interface PositionServiceImpl {

    @WebMethod
    @Action(input = "http://impl.services.una.ac.cr/PositionServiceImpl/createPositionRequest", output = "http://impl.services.una.ac.cr/PositionServiceImpl/createPositionResponse")
    @RequestWrapper(localName = "createPosition", targetNamespace = "http://impl.services.una.ac.cr/", className = "cr.ac.una.services.impl.CreatePosition")
    @ResponseWrapper(localName = "createPositionResponse", targetNamespace = "http://impl.services.una.ac.cr/", className = "cr.ac.una.services.impl.CreatePositionResponse")
    @WebResult(name = "return", targetNamespace = "")
    public cr.ac.una.services.impl.Response createPosition(

        @WebParam(name = "arg0", targetNamespace = "")
        cr.ac.una.services.impl.PositionDto arg0
    );

    @WebMethod
    @Action(input = "http://impl.services.una.ac.cr/PositionServiceImpl/getPositionByIdRequest", output = "http://impl.services.una.ac.cr/PositionServiceImpl/getPositionByIdResponse")
    @RequestWrapper(localName = "getPositionById", targetNamespace = "http://impl.services.una.ac.cr/", className = "cr.ac.una.services.impl.GetPositionById")
    @ResponseWrapper(localName = "getPositionByIdResponse", targetNamespace = "http://impl.services.una.ac.cr/", className = "cr.ac.una.services.impl.GetPositionByIdResponse")
    @WebResult(name = "return", targetNamespace = "")
    public cr.ac.una.services.impl.Response getPositionById(

        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.Long arg0
    );

    @WebMethod
    @Action(input = "http://impl.services.una.ac.cr/PositionServiceImpl/updatePositionByIdRequest", output = "http://impl.services.una.ac.cr/PositionServiceImpl/updatePositionByIdResponse")
    @RequestWrapper(localName = "updatePositionById", targetNamespace = "http://impl.services.una.ac.cr/", className = "cr.ac.una.services.impl.UpdatePositionById")
    @ResponseWrapper(localName = "updatePositionByIdResponse", targetNamespace = "http://impl.services.una.ac.cr/", className = "cr.ac.una.services.impl.UpdatePositionByIdResponse")
    @WebResult(name = "return", targetNamespace = "")
    public cr.ac.una.services.impl.Response updatePositionById(

        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.Long arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        cr.ac.una.services.impl.PositionDto arg1
    );

    @WebMethod
    @Action(input = "http://impl.services.una.ac.cr/PositionServiceImpl/deletePositionByIdRequest", output = "http://impl.services.una.ac.cr/PositionServiceImpl/deletePositionByIdResponse")
    @RequestWrapper(localName = "deletePositionById", targetNamespace = "http://impl.services.una.ac.cr/", className = "cr.ac.una.services.impl.DeletePositionById")
    @ResponseWrapper(localName = "deletePositionByIdResponse", targetNamespace = "http://impl.services.una.ac.cr/", className = "cr.ac.una.services.impl.DeletePositionByIdResponse")
    @WebResult(name = "return", targetNamespace = "")
    public cr.ac.una.services.impl.Response deletePositionById(

        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.Long arg0
    );
}
