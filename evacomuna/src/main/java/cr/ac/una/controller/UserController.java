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
 * 2023-08-24T00:41:38.057-06:00
 * Generated source version: 4.0.2
 *
 */
@WebService(targetNamespace = "http://controller.una.ac.cr/", name = "UserController")
@XmlSeeAlso({ObjectFactory.class})
public interface UserController {

    @WebMethod
    @Action(input = "http://controller.una.ac.cr/UserController/createUserRequest", output = "http://controller.una.ac.cr/UserController/createUserResponse")
    @RequestWrapper(localName = "createUser", targetNamespace = "http://controller.una.ac.cr/", className = "cr.ac.una.controller.CreateUser")
    @ResponseWrapper(localName = "createUserResponse", targetNamespace = "http://controller.una.ac.cr/", className = "cr.ac.una.controller.CreateUserResponse")
    @WebResult(name = "return", targetNamespace = "")
    public cr.ac.una.controller.ResponseWrapper createUser(

        @WebParam(name = "arg0", targetNamespace = "")
        cr.ac.una.controller.UserDto arg0
    );
}
