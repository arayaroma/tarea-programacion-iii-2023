package cr.ac.una.evacomuna.services;

import cr.ac.una.controller.*;

/**
 *
 * @author estebannajera
 */
public class User {

    UserController_Service service;
    UserController port;

    public User() {
        service = new UserController_Service();
        port = service.getUserControllerPort();
    }

    public ResponseWrapper createUser(UserDto userDto) {
        return port.createUser(userDto);
    }

    public ResponseWrapper updateUser(UserDto userDto) {
        return port.updateUser(userDto);
    }

    public ResponseWrapper getUsers() {
        return port.getUsers();
    }

    public ResponseWrapper deleteUser(Long id) {
        return port.deleteUserById(id);
    }

    public ResponseWrapper getByUserAndPassword(String user, String password) {
        return port.getUserByUserAndPassword(user, password);
    }

    public ResponseWrapper recoverPassword(Long id) {
        return port.recoverPassword(id);
    }

    public ResponseWrapper changePassword(Long id, String oldPassword, String newPassword) {
        return port.changePassword(id, oldPassword, newPassword);
    }
}
