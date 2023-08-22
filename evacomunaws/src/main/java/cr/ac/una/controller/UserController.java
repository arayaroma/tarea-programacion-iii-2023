package cr.ac.una.controller;

import cr.ac.una.dto.UserDto;
import cr.ac.una.services.UserService;
import cr.ac.una.util.ResponseWrapper;
import jakarta.ejb.EJB;
import jakarta.jws.WebService;

@WebService(serviceName = "UserController")
public class UserController {

    @EJB
    private UserService userService;

    public ResponseWrapper createUser(
            UserDto userDto) {
        return userService.createUser(userDto);
    }

}
