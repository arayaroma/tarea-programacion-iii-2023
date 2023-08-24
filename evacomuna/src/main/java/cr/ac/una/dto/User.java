package cr.ac.una.dto;

import cr.ac.una.controller.ResponseWrapper;
import cr.ac.una.controller.UserController;
import cr.ac.una.controller.UserController_Service;

/**
 *
 * @author estebannajera
 */
public class User {

    private UserController_Service service;
    private UserController port;

    public User() {
        service = new UserController_Service();
        port = service.getUserControllerPort();
    }

    public ResponseWrapper createUser(cr.ac.una.controller.UserDto user) {
        return port.createUser(user);
    }

}
