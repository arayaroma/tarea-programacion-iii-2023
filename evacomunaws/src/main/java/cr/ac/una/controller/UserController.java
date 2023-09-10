package cr.ac.una.controller;

import cr.ac.una.dto.UserDto;
import cr.ac.una.services.UserService;
import cr.ac.una.util.ResponseWrapper;
import jakarta.ejb.EJB;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

/**
 * @author arayaroma
 * @author Angelo2002
 */
@WebService(serviceName = "UserController")
public class UserController {

    @EJB
    private UserService userService;

    /**
     * @param userDto user to be created
     * @return ResponseWrapper with the response of the service call
     */
    @WebMethod(operationName = "createUser")
    public ResponseWrapper createUser(UserDto userDto) {
        return userService.createUser(userDto);
    }

    /**
     * @param id user id to be updated
     * @return ResponseWrapper with the response of the service call
     */
    @WebMethod(operationName = "getUserById")
    public ResponseWrapper getUserById(Long id) {
        return userService.getUserById(id);
    }

    /**
     * @param identification user identification to be updated
     * @return ResponseWrapper with the response of the service call
     */
    @WebMethod(operationName = "getUserByIdentification")
    public ResponseWrapper getUserByIdentification(String identification) {
        return userService.getUserByIdentification(identification);
    }

    /**
     * @param identification user identification to be deleted
     * @return ResponseWrapper with the response of the service call
     */
    @WebMethod(operationName = "deleteUserByIdentification")
    public ResponseWrapper deleteUserByIdentification(String identification) {
        return userService.deleteUserByIdentification(identification);
    }

    /**
     * @param id user id to be deleted
     * @return ResponseWrapper with the response of the service call
     */
    @WebMethod(operationName = "deleteUserById")
    public ResponseWrapper deleteUserById(Long id) {
        return userService.deleteUserById(id);
    }

    /**
     * @param username Username to be matched
     * @return ResponseWrapper with the response of the service call
     */
    @WebMethod(operationName = "getUserByUsername")
    public ResponseWrapper getUserByUsername(String username) {
        return userService.getUserByUsername(username);
    }

    /**
     * @param username user username to be matched
     * @param password user password to be matched
     * @return ResponseWrapper with the response of the service call
     */
    @WebMethod(operationName = "getUserByUserAndPassword")
    public ResponseWrapper getUserByUserAndPassword(String username, String password) {
        return userService.getUserByUserAndPassword(username, password);
    }

    /**
     * @param userDto user to be updated
     * @return ResponseWrapper with the response of the service call
     */
    @WebMethod(operationName = "updateUser")
    public ResponseWrapper updateUser(UserDto userDto) {
        return userService.updateUser(userDto);
    }

    /**
     * @param name Name to be searched
     * @return ResponseWrapper with the response of the service call
     */
    @WebMethod(operationName = "getUserListByName")
    public ResponseWrapper getUserListByName(String name) {
        return userService.getUserListByName(name);
    }

    /**
     * @param position Position to be matched with the users
     * @return ResponseWrapper with the response of the service call
     */
    @WebMethod(operationName = "getUsersByPosition")
    public ResponseWrapper getUsersByPosition(String position) {
        return userService.getUserListByPosition(position);
    }

}