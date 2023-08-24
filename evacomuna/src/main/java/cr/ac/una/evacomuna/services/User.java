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

    public ResponseWrapper createUser(UserDto user) {
        return port.createUser(user);
    }

//    public ResponseWrapper updateUser(Long id, UserDto user) {
//        return port.(id, user);
//    }
//
//    public ResponseWrapper deleteUser(Long id) {
//        return port.deleteUserById(id);
//    }
}
