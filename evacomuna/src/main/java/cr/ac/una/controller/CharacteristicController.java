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
 * 2023-09-19T09:43:14.653-06:00
 * Generated source version: 4.0.2
 *
 */
@WebService(targetNamespace = "http://controller.una.ac.cr/", name = "CharacteristicController")
@XmlSeeAlso({ObjectFactory.class})
public interface CharacteristicController {

    @WebMethod
    @Action(input = "http://controller.una.ac.cr/CharacteristicController/createCharacteristicRequest", output = "http://controller.una.ac.cr/CharacteristicController/createCharacteristicResponse")
    @RequestWrapper(localName = "createCharacteristic", targetNamespace = "http://controller.una.ac.cr/", className = "cr.ac.una.controller.CreateCharacteristic")
    @ResponseWrapper(localName = "createCharacteristicResponse", targetNamespace = "http://controller.una.ac.cr/", className = "cr.ac.una.controller.CreateCharacteristicResponse")
    @WebResult(name = "return", targetNamespace = "")
    public cr.ac.una.controller.ResponseWrapper createCharacteristic(

        @WebParam(name = "arg0", targetNamespace = "")
        cr.ac.una.controller.CharacteristicDto arg0
    );

    @WebMethod
    @Action(input = "http://controller.una.ac.cr/CharacteristicController/getCharacteristicByNameRequest", output = "http://controller.una.ac.cr/CharacteristicController/getCharacteristicByNameResponse")
    @RequestWrapper(localName = "getCharacteristicByName", targetNamespace = "http://controller.una.ac.cr/", className = "cr.ac.una.controller.GetCharacteristicByName")
    @ResponseWrapper(localName = "getCharacteristicByNameResponse", targetNamespace = "http://controller.una.ac.cr/", className = "cr.ac.una.controller.GetCharacteristicByNameResponse")
    @WebResult(name = "return", targetNamespace = "")
    public cr.ac.una.controller.ResponseWrapper getCharacteristicByName(

        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0
    );

    @WebMethod
    @Action(input = "http://controller.una.ac.cr/CharacteristicController/getCharacteristicByIdRequest", output = "http://controller.una.ac.cr/CharacteristicController/getCharacteristicByIdResponse")
    @RequestWrapper(localName = "getCharacteristicById", targetNamespace = "http://controller.una.ac.cr/", className = "cr.ac.una.controller.GetCharacteristicById")
    @ResponseWrapper(localName = "getCharacteristicByIdResponse", targetNamespace = "http://controller.una.ac.cr/", className = "cr.ac.una.controller.GetCharacteristicByIdResponse")
    @WebResult(name = "return", targetNamespace = "")
    public cr.ac.una.controller.ResponseWrapper getCharacteristicById(

        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.Long arg0
    );

    @WebMethod
    @Action(input = "http://controller.una.ac.cr/CharacteristicController/updateCharacteristicRequest", output = "http://controller.una.ac.cr/CharacteristicController/updateCharacteristicResponse")
    @RequestWrapper(localName = "updateCharacteristic", targetNamespace = "http://controller.una.ac.cr/", className = "cr.ac.una.controller.UpdateCharacteristic")
    @ResponseWrapper(localName = "updateCharacteristicResponse", targetNamespace = "http://controller.una.ac.cr/", className = "cr.ac.una.controller.UpdateCharacteristicResponse")
    @WebResult(name = "return", targetNamespace = "")
    public cr.ac.una.controller.ResponseWrapper updateCharacteristic(

        @WebParam(name = "arg0", targetNamespace = "")
        cr.ac.una.controller.CharacteristicDto arg0
    );

    @WebMethod
    @Action(input = "http://controller.una.ac.cr/CharacteristicController/deleteAllCharacteristicsRequest", output = "http://controller.una.ac.cr/CharacteristicController/deleteAllCharacteristicsResponse")
    @RequestWrapper(localName = "deleteAllCharacteristics", targetNamespace = "http://controller.una.ac.cr/", className = "cr.ac.una.controller.DeleteAllCharacteristics")
    @ResponseWrapper(localName = "deleteAllCharacteristicsResponse", targetNamespace = "http://controller.una.ac.cr/", className = "cr.ac.una.controller.DeleteAllCharacteristicsResponse")
    @WebResult(name = "return", targetNamespace = "")
    public cr.ac.una.controller.ResponseWrapper deleteAllCharacteristics()
;

    @WebMethod
    @Action(input = "http://controller.una.ac.cr/CharacteristicController/deleteCharacteristicByIdRequest", output = "http://controller.una.ac.cr/CharacteristicController/deleteCharacteristicByIdResponse")
    @RequestWrapper(localName = "deleteCharacteristicById", targetNamespace = "http://controller.una.ac.cr/", className = "cr.ac.una.controller.DeleteCharacteristicById")
    @ResponseWrapper(localName = "deleteCharacteristicByIdResponse", targetNamespace = "http://controller.una.ac.cr/", className = "cr.ac.una.controller.DeleteCharacteristicByIdResponse")
    @WebResult(name = "return", targetNamespace = "")
    public cr.ac.una.controller.ResponseWrapper deleteCharacteristicById(

        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.Long arg0
    );

    @WebMethod
    @Action(input = "http://controller.una.ac.cr/CharacteristicController/deleteCharacteristicByNameRequest", output = "http://controller.una.ac.cr/CharacteristicController/deleteCharacteristicByNameResponse")
    @RequestWrapper(localName = "deleteCharacteristicByName", targetNamespace = "http://controller.una.ac.cr/", className = "cr.ac.una.controller.DeleteCharacteristicByName")
    @ResponseWrapper(localName = "deleteCharacteristicByNameResponse", targetNamespace = "http://controller.una.ac.cr/", className = "cr.ac.una.controller.DeleteCharacteristicByNameResponse")
    @WebResult(name = "return", targetNamespace = "")
    public cr.ac.una.controller.ResponseWrapper deleteCharacteristicByName(

        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0
    );

    @WebMethod
    @Action(input = "http://controller.una.ac.cr/CharacteristicController/getCharacteristicsRequest", output = "http://controller.una.ac.cr/CharacteristicController/getCharacteristicsResponse")
    @RequestWrapper(localName = "getCharacteristics", targetNamespace = "http://controller.una.ac.cr/", className = "cr.ac.una.controller.GetCharacteristics")
    @ResponseWrapper(localName = "getCharacteristicsResponse", targetNamespace = "http://controller.una.ac.cr/", className = "cr.ac.una.controller.GetCharacteristicsResponse")
    @WebResult(name = "return", targetNamespace = "")
    public cr.ac.una.controller.ResponseWrapper getCharacteristics()
;
}
