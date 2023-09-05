package cr.ac.una.controller;

import cr.ac.una.dto.UserDto;
import cr.ac.una.services.UserService;
import cr.ac.una.util.ResponseWrapper;
import jakarta.ejb.EJB;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

/**
 * @author arayaroma
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
}