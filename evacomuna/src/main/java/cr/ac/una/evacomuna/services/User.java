package cr.ac.una.evacomuna.services;

import cr.ac.una.services.impl.Response;
import cr.ac.una.services.impl.UserDto;
import cr.ac.una.services.impl.UserService;
import cr.ac.una.services.impl.UserServiceImpl;

/**
 *
 * @author estebannajera
 */
public class User {

    UserService service;
    UserServiceImpl port;

    public User() {
        service = new UserService();
        port = service.getUserServiceImplPort();
    }

    public Response createUser(UserDto user) {
        return port.createUser(user);
    }

    public Response updateUser(Long id, UserDto user) {
        return port.updateUserById(id, user);
    }

    public Response deleteUser(Long id) {
        return port.deleteUserById(id);
    }
}
