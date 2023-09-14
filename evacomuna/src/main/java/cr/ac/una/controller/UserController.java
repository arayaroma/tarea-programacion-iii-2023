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
 * 2023-09-13T20:18:33.570-06:00
 * Generated source version: 4.0.2
 *
 */
@WebService(targetNamespace = "http://controller.una.ac.cr/", name = "UserController")
@XmlSeeAlso({ObjectFactory.class})
public interface UserController {

    @WebMethod
    @Action(input = "http://controller.una.ac.cr/UserController/deleteUserByIdentificationRequest", output = "http://controller.una.ac.cr/UserController/deleteUserByIdentificationResponse")
    @RequestWrapper(localName = "deleteUserByIdentification", targetNamespace = "http://controller.una.ac.cr/", className = "cr.ac.una.controller.DeleteUserByIdentification")
    @ResponseWrapper(localName = "deleteUserByIdentificationResponse", targetNamespace = "http://controller.una.ac.cr/", className = "cr.ac.una.controller.DeleteUserByIdentificationResponse")
    @WebResult(name = "return", targetNamespace = "")
    public cr.ac.una.controller.ResponseWrapper deleteUserByIdentification(

        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0
    );

    @WebMethod
    @Action(input = "http://controller.una.ac.cr/UserController/getUserByIdRequest", output = "http://controller.una.ac.cr/UserController/getUserByIdResponse")
    @RequestWrapper(localName = "getUserById", targetNamespace = "http://controller.una.ac.cr/", className = "cr.ac.una.controller.GetUserById")
    @ResponseWrapper(localName = "getUserByIdResponse", targetNamespace = "http://controller.una.ac.cr/", className = "cr.ac.una.controller.GetUserByIdResponse")
    @WebResult(name = "return", targetNamespace = "")
    public cr.ac.una.controller.ResponseWrapper getUserById(

        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.Long arg0
    );

    @WebMethod
    @Action(input = "http://controller.una.ac.cr/UserController/getUserByUserAndPasswordRequest", output = "http://controller.una.ac.cr/UserController/getUserByUserAndPasswordResponse")
    @RequestWrapper(localName = "getUserByUserAndPassword", targetNamespace = "http://controller.una.ac.cr/", className = "cr.ac.una.controller.GetUserByUserAndPassword")
    @ResponseWrapper(localName = "getUserByUserAndPasswordResponse", targetNamespace = "http://controller.una.ac.cr/", className = "cr.ac.una.controller.GetUserByUserAndPasswordResponse")
    @WebResult(name = "return", targetNamespace = "")
    public cr.ac.una.controller.ResponseWrapper getUserByUserAndPassword(

        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        java.lang.String arg1
    );

    @WebMethod
    @Action(input = "http://controller.una.ac.cr/UserController/getUserByIdentificationRequest", output = "http://controller.una.ac.cr/UserController/getUserByIdentificationResponse")
    @RequestWrapper(localName = "getUserByIdentification", targetNamespace = "http://controller.una.ac.cr/", className = "cr.ac.una.controller.GetUserByIdentification")
    @ResponseWrapper(localName = "getUserByIdentificationResponse", targetNamespace = "http://controller.una.ac.cr/", className = "cr.ac.una.controller.GetUserByIdentificationResponse")
    @WebResult(name = "return", targetNamespace = "")
    public cr.ac.una.controller.ResponseWrapper getUserByIdentification(

        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0
    );

    @WebMethod
    @Action(input = "http://controller.una.ac.cr/UserController/getUserByUsernameRequest", output = "http://controller.una.ac.cr/UserController/getUserByUsernameResponse")
    @RequestWrapper(localName = "getUserByUsername", targetNamespace = "http://controller.una.ac.cr/", className = "cr.ac.una.controller.GetUserByUsername")
    @ResponseWrapper(localName = "getUserByUsernameResponse", targetNamespace = "http://controller.una.ac.cr/", className = "cr.ac.una.controller.GetUserByUsernameResponse")
    @WebResult(name = "return", targetNamespace = "")
    public cr.ac.una.controller.ResponseWrapper getUserByUsername(

        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0
    );

    @WebMethod
    @Action(input = "http://controller.una.ac.cr/UserController/getUserListByNameRequest", output = "http://controller.una.ac.cr/UserController/getUserListByNameResponse")
    @RequestWrapper(localName = "getUserListByName", targetNamespace = "http://controller.una.ac.cr/", className = "cr.ac.una.controller.GetUserListByName")
    @ResponseWrapper(localName = "getUserListByNameResponse", targetNamespace = "http://controller.una.ac.cr/", className = "cr.ac.una.controller.GetUserListByNameResponse")
    @WebResult(name = "return", targetNamespace = "")
    public cr.ac.una.controller.ResponseWrapper getUserListByName(

        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0
    );

    @WebMethod
    @Action(input = "http://controller.una.ac.cr/UserController/updateUserRequest", output = "http://controller.una.ac.cr/UserController/updateUserResponse")
    @RequestWrapper(localName = "updateUser", targetNamespace = "http://controller.una.ac.cr/", className = "cr.ac.una.controller.UpdateUser")
    @ResponseWrapper(localName = "updateUserResponse", targetNamespace = "http://controller.una.ac.cr/", className = "cr.ac.una.controller.UpdateUserResponse")
    @WebResult(name = "return", targetNamespace = "")
    public cr.ac.una.controller.ResponseWrapper updateUser(

        @WebParam(name = "arg0", targetNamespace = "")
        cr.ac.una.controller.UserDto arg0
    );

    @WebMethod
    @Action(input = "http://controller.una.ac.cr/UserController/getUsersByPositionRequest", output = "http://controller.una.ac.cr/UserController/getUsersByPositionResponse")
    @RequestWrapper(localName = "getUsersByPosition", targetNamespace = "http://controller.una.ac.cr/", className = "cr.ac.una.controller.GetUsersByPosition")
    @ResponseWrapper(localName = "getUsersByPositionResponse", targetNamespace = "http://controller.una.ac.cr/", className = "cr.ac.una.controller.GetUsersByPositionResponse")
    @WebResult(name = "return", targetNamespace = "")
    public cr.ac.una.controller.ResponseWrapper getUsersByPosition(

        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0
    );

    @WebMethod
    @Action(input = "http://controller.una.ac.cr/UserController/createUserRequest", output = "http://controller.una.ac.cr/UserController/createUserResponse")
    @RequestWrapper(localName = "createUser", targetNamespace = "http://controller.una.ac.cr/", className = "cr.ac.una.controller.CreateUser")
    @ResponseWrapper(localName = "createUserResponse", targetNamespace = "http://controller.una.ac.cr/", className = "cr.ac.una.controller.CreateUserResponse")
    @WebResult(name = "return", targetNamespace = "")
    public cr.ac.una.controller.ResponseWrapper createUser(

        @WebParam(name = "arg0", targetNamespace = "")
        cr.ac.una.controller.UserDto arg0
    );

    @WebMethod
    @Action(input = "http://controller.una.ac.cr/UserController/deleteUserByIdRequest", output = "http://controller.una.ac.cr/UserController/deleteUserByIdResponse")
    @RequestWrapper(localName = "deleteUserById", targetNamespace = "http://controller.una.ac.cr/", className = "cr.ac.una.controller.DeleteUserById")
    @ResponseWrapper(localName = "deleteUserByIdResponse", targetNamespace = "http://controller.una.ac.cr/", className = "cr.ac.una.controller.DeleteUserByIdResponse")
    @WebResult(name = "return", targetNamespace = "")
    public cr.ac.una.controller.ResponseWrapper deleteUserById(

        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.Long arg0
    );
}
