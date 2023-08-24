package cr.ac.una.dto;

import cr.ac.una.controller.ResponseWrapper;
import cr.ac.una.controller.UserController;
import cr.ac.una.controller.UserController_Service;

/**
 *
 * @author estebannajera
 */
public class UserDto {

    UserController_Service service;
    UserController port;

    public UserDto() {
        service = new UserController_Service();
        port = service.getUserControllerPort();
    }

    public ResponseWrapper createUser(cr.ac.una.controller.UserDto user) {
        return port.createUser(user);
    }

}
