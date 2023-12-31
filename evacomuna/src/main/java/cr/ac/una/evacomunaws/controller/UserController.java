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
 * 2023-10-02T16:14:20.974-06:00
 * Generated source version: 4.0.2
 *
 */
@WebService(targetNamespace = "http://controller.evacomunaws.una.ac.cr/", name = "UserController")
@XmlSeeAlso({ObjectFactory.class})
public interface UserController {

    @WebMethod
    @Action(input = "http://controller.evacomunaws.una.ac.cr/UserController/getUserByIdRequest", output = "http://controller.evacomunaws.una.ac.cr/UserController/getUserByIdResponse")
    @RequestWrapper(localName = "getUserById", targetNamespace = "http://controller.evacomunaws.una.ac.cr/", className = "cr.ac.una.evacomunaws.controller.GetUserById")
    @ResponseWrapper(localName = "getUserByIdResponse", targetNamespace = "http://controller.evacomunaws.una.ac.cr/", className = "cr.ac.una.evacomunaws.controller.GetUserByIdResponse")
    @WebResult(name = "return", targetNamespace = "")
    public cr.ac.una.evacomunaws.controller.ResponseWrapper getUserById(

        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.Long arg0
    );

    @WebMethod
    @Action(input = "http://controller.evacomunaws.una.ac.cr/UserController/getUserListByNameRequest", output = "http://controller.evacomunaws.una.ac.cr/UserController/getUserListByNameResponse")
    @RequestWrapper(localName = "getUserListByName", targetNamespace = "http://controller.evacomunaws.una.ac.cr/", className = "cr.ac.una.evacomunaws.controller.GetUserListByName")
    @ResponseWrapper(localName = "getUserListByNameResponse", targetNamespace = "http://controller.evacomunaws.una.ac.cr/", className = "cr.ac.una.evacomunaws.controller.GetUserListByNameResponse")
    @WebResult(name = "return", targetNamespace = "")
    public cr.ac.una.evacomunaws.controller.ResponseWrapper getUserListByName(

        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0
    );

    @WebMethod
    @Action(input = "http://controller.evacomunaws.una.ac.cr/UserController/getUserByUsernameRequest", output = "http://controller.evacomunaws.una.ac.cr/UserController/getUserByUsernameResponse")
    @RequestWrapper(localName = "getUserByUsername", targetNamespace = "http://controller.evacomunaws.una.ac.cr/", className = "cr.ac.una.evacomunaws.controller.GetUserByUsername")
    @ResponseWrapper(localName = "getUserByUsernameResponse", targetNamespace = "http://controller.evacomunaws.una.ac.cr/", className = "cr.ac.una.evacomunaws.controller.GetUserByUsernameResponse")
    @WebResult(name = "return", targetNamespace = "")
    public cr.ac.una.evacomunaws.controller.ResponseWrapper getUserByUsername(

        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0
    );

    @WebMethod
    @Action(input = "http://controller.evacomunaws.una.ac.cr/UserController/updateUserRequest", output = "http://controller.evacomunaws.una.ac.cr/UserController/updateUserResponse")
    @RequestWrapper(localName = "updateUser", targetNamespace = "http://controller.evacomunaws.una.ac.cr/", className = "cr.ac.una.evacomunaws.controller.UpdateUser")
    @ResponseWrapper(localName = "updateUserResponse", targetNamespace = "http://controller.evacomunaws.una.ac.cr/", className = "cr.ac.una.evacomunaws.controller.UpdateUserResponse")
    @WebResult(name = "return", targetNamespace = "")
    public cr.ac.una.evacomunaws.controller.ResponseWrapper updateUser(

        @WebParam(name = "arg0", targetNamespace = "")
        cr.ac.una.evacomunaws.controller.UserDto arg0
    );

    @WebMethod
    @Action(input = "http://controller.evacomunaws.una.ac.cr/UserController/changePasswordRequest", output = "http://controller.evacomunaws.una.ac.cr/UserController/changePasswordResponse")
    @RequestWrapper(localName = "changePassword", targetNamespace = "http://controller.evacomunaws.una.ac.cr/", className = "cr.ac.una.evacomunaws.controller.ChangePassword")
    @ResponseWrapper(localName = "changePasswordResponse", targetNamespace = "http://controller.evacomunaws.una.ac.cr/", className = "cr.ac.una.evacomunaws.controller.ChangePasswordResponse")
    @WebResult(name = "return", targetNamespace = "")
    public cr.ac.una.evacomunaws.controller.ResponseWrapper changePassword(

        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.Long arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        java.lang.String arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        java.lang.String arg2
    );

    @WebMethod
    @Action(input = "http://controller.evacomunaws.una.ac.cr/UserController/getUserByIdentificationRequest", output = "http://controller.evacomunaws.una.ac.cr/UserController/getUserByIdentificationResponse")
    @RequestWrapper(localName = "getUserByIdentification", targetNamespace = "http://controller.evacomunaws.una.ac.cr/", className = "cr.ac.una.evacomunaws.controller.GetUserByIdentification")
    @ResponseWrapper(localName = "getUserByIdentificationResponse", targetNamespace = "http://controller.evacomunaws.una.ac.cr/", className = "cr.ac.una.evacomunaws.controller.GetUserByIdentificationResponse")
    @WebResult(name = "return", targetNamespace = "")
    public cr.ac.una.evacomunaws.controller.ResponseWrapper getUserByIdentification(

        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0
    );

    @WebMethod
    @Action(input = "http://controller.evacomunaws.una.ac.cr/UserController/getUserByUserAndPasswordRequest", output = "http://controller.evacomunaws.una.ac.cr/UserController/getUserByUserAndPasswordResponse")
    @RequestWrapper(localName = "getUserByUserAndPassword", targetNamespace = "http://controller.evacomunaws.una.ac.cr/", className = "cr.ac.una.evacomunaws.controller.GetUserByUserAndPassword")
    @ResponseWrapper(localName = "getUserByUserAndPasswordResponse", targetNamespace = "http://controller.evacomunaws.una.ac.cr/", className = "cr.ac.una.evacomunaws.controller.GetUserByUserAndPasswordResponse")
    @WebResult(name = "return", targetNamespace = "")
    public cr.ac.una.evacomunaws.controller.ResponseWrapper getUserByUserAndPassword(

        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        java.lang.String arg1
    );

    @WebMethod
    @Action(input = "http://controller.evacomunaws.una.ac.cr/UserController/deleteUserByIdentificationRequest", output = "http://controller.evacomunaws.una.ac.cr/UserController/deleteUserByIdentificationResponse")
    @RequestWrapper(localName = "deleteUserByIdentification", targetNamespace = "http://controller.evacomunaws.una.ac.cr/", className = "cr.ac.una.evacomunaws.controller.DeleteUserByIdentification")
    @ResponseWrapper(localName = "deleteUserByIdentificationResponse", targetNamespace = "http://controller.evacomunaws.una.ac.cr/", className = "cr.ac.una.evacomunaws.controller.DeleteUserByIdentificationResponse")
    @WebResult(name = "return", targetNamespace = "")
    public cr.ac.una.evacomunaws.controller.ResponseWrapper deleteUserByIdentification(

        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0
    );

    @WebMethod
    @Action(input = "http://controller.evacomunaws.una.ac.cr/UserController/getUsersRequest", output = "http://controller.evacomunaws.una.ac.cr/UserController/getUsersResponse")
    @RequestWrapper(localName = "getUsers", targetNamespace = "http://controller.evacomunaws.una.ac.cr/", className = "cr.ac.una.evacomunaws.controller.GetUsers")
    @ResponseWrapper(localName = "getUsersResponse", targetNamespace = "http://controller.evacomunaws.una.ac.cr/", className = "cr.ac.una.evacomunaws.controller.GetUsersResponse")
    @WebResult(name = "return", targetNamespace = "")
    public cr.ac.una.evacomunaws.controller.ResponseWrapper getUsers()
;

    @WebMethod
    @Action(input = "http://controller.evacomunaws.una.ac.cr/UserController/recoverPasswordRequest", output = "http://controller.evacomunaws.una.ac.cr/UserController/recoverPasswordResponse")
    @RequestWrapper(localName = "recoverPassword", targetNamespace = "http://controller.evacomunaws.una.ac.cr/", className = "cr.ac.una.evacomunaws.controller.RecoverPassword")
    @ResponseWrapper(localName = "recoverPasswordResponse", targetNamespace = "http://controller.evacomunaws.una.ac.cr/", className = "cr.ac.una.evacomunaws.controller.RecoverPasswordResponse")
    @WebResult(name = "return", targetNamespace = "")
    public cr.ac.una.evacomunaws.controller.ResponseWrapper recoverPassword(

        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0
    );

    @WebMethod
    @Action(input = "http://controller.evacomunaws.una.ac.cr/UserController/activateUserRequest", output = "http://controller.evacomunaws.una.ac.cr/UserController/activateUserResponse")
    @RequestWrapper(localName = "activateUser", targetNamespace = "http://controller.evacomunaws.una.ac.cr/", className = "cr.ac.una.evacomunaws.controller.ActivateUser")
    @ResponseWrapper(localName = "activateUserResponse", targetNamespace = "http://controller.evacomunaws.una.ac.cr/", className = "cr.ac.una.evacomunaws.controller.ActivateUserResponse")
    @WebResult(name = "return", targetNamespace = "")
    public cr.ac.una.evacomunaws.controller.ResponseWrapper activateUser(

        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0
    );

    @WebMethod
    @Action(input = "http://controller.evacomunaws.una.ac.cr/UserController/createUserRequest", output = "http://controller.evacomunaws.una.ac.cr/UserController/createUserResponse")
    @RequestWrapper(localName = "createUser", targetNamespace = "http://controller.evacomunaws.una.ac.cr/", className = "cr.ac.una.evacomunaws.controller.CreateUser")
    @ResponseWrapper(localName = "createUserResponse", targetNamespace = "http://controller.evacomunaws.una.ac.cr/", className = "cr.ac.una.evacomunaws.controller.CreateUserResponse")
    @WebResult(name = "return", targetNamespace = "")
    public cr.ac.una.evacomunaws.controller.ResponseWrapper createUser(

        @WebParam(name = "arg0", targetNamespace = "")
        cr.ac.una.evacomunaws.controller.UserDto arg0
    );

    @WebMethod
    @Action(input = "http://controller.evacomunaws.una.ac.cr/UserController/getUsersByPositionRequest", output = "http://controller.evacomunaws.una.ac.cr/UserController/getUsersByPositionResponse")
    @RequestWrapper(localName = "getUsersByPosition", targetNamespace = "http://controller.evacomunaws.una.ac.cr/", className = "cr.ac.una.evacomunaws.controller.GetUsersByPosition")
    @ResponseWrapper(localName = "getUsersByPositionResponse", targetNamespace = "http://controller.evacomunaws.una.ac.cr/", className = "cr.ac.una.evacomunaws.controller.GetUsersByPositionResponse")
    @WebResult(name = "return", targetNamespace = "")
    public cr.ac.una.evacomunaws.controller.ResponseWrapper getUsersByPosition(

        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0
    );

    @WebMethod
    @Action(input = "http://controller.evacomunaws.una.ac.cr/UserController/deleteUserByIdRequest", output = "http://controller.evacomunaws.una.ac.cr/UserController/deleteUserByIdResponse")
    @RequestWrapper(localName = "deleteUserById", targetNamespace = "http://controller.evacomunaws.una.ac.cr/", className = "cr.ac.una.evacomunaws.controller.DeleteUserById")
    @ResponseWrapper(localName = "deleteUserByIdResponse", targetNamespace = "http://controller.evacomunaws.una.ac.cr/", className = "cr.ac.una.evacomunaws.controller.DeleteUserByIdResponse")
    @WebResult(name = "return", targetNamespace = "")
    public cr.ac.una.evacomunaws.controller.ResponseWrapper deleteUserById(

        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.Long arg0
    );
}
