package cr.ac.una.evacomuna.services;

import cr.ac.una.controller.UserController_Service;
import cr.ac.una.controller.UserDto;
import cr.ac.una.controller.UserController;
import cr.ac.una.evacomuna.util.Connection;
import cr.ac.una.evacomuna.util.Constants;
import cr.ac.una.evacomuna.util.ResponseCode;
import cr.ac.una.evacomuna.util.ResponseWrapper;

/**
 *
 * @author estebannajera
 */
public class UserService {

    UserController_Service service;
    UserController port;

    /**
     * Default instance of the service
     */
    public UserService() {
        service = new UserController_Service();
        port = service.getUserControllerPort();
    }

    public boolean checkConnection() {
        String serviceUrl = Connection.getSocket() + Constants.DOMAIN + "UserController?wsdl";
        return Connection.isConnected(serviceUrl);
    }

    /**
     * Create a new user
     * 
     * @param userDto user to create
     * @return ResponseWrapper with the response of the request
     */
    public ResponseWrapper createUser(UserDto userDto) {
        try {
            cr.ac.una.controller.ResponseWrapper response = port.createUser(userDto);
            userDto = (UserDto) response.getData();
            System.out.println("response: " + userDto.toString());

            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "User created successfully",
                    userDto);
        } catch (Exception e) {
            return new ResponseWrapper(
                    ResponseCode.INTERNAL_SERVER_ERROR.getCode(),
                    ResponseCode.INTERNAL_SERVER_ERROR,
                    "Error creating user",
                    null);
        }
    }

    /**
     * Update a user
     * 
     * @param userDto user to update
     * @return ResponseWrapper with the response of the request
     */
    public ResponseWrapper updateUser(UserDto userDto) {
        try {
            cr.ac.una.controller.ResponseWrapper response = port.updateUser(userDto);
            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "User updated successfully",
                    response.getData());
        } catch (Exception e) {
            return new ResponseWrapper(
                    ResponseCode.INTERNAL_SERVER_ERROR.getCode(),
                    ResponseCode.INTERNAL_SERVER_ERROR,
                    "Error updating user",
                    null);
        }
    }

    /**
     * Get all users
     * 
     * @return ResponseWrapper with the response of the request
     */
    public ResponseWrapper getUsers() {
        try {
            cr.ac.una.controller.ResponseWrapper response = port.getUsers();
            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "Users found",
                    response.getData());
        } catch (Exception e) {
            return new ResponseWrapper(
                    ResponseCode.NOT_FOUND.getCode(),
                    ResponseCode.NOT_FOUND,
                    "Users not found",
                    null);
        }
    }

    /**
     * Delete a user by id
     * 
     * @param id of the user
     * @return ResponseWrapper with the response of the request
     */
    public ResponseWrapper deleteUser(Long id) {
        try {
            cr.ac.una.controller.ResponseWrapper response = port.deleteUserById(id);
            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "User deleted successfully",
                    response.getData());
        } catch (Exception e) {
            return new ResponseWrapper(
                    ResponseCode.INTERNAL_SERVER_ERROR.getCode(),
                    ResponseCode.INTERNAL_SERVER_ERROR,
                    "Error deleting user",
                    null);
        }
    }

    /**
     * Get a user by username and password
     * 
     * @param username of the user
     * @param password of the user
     * @return ResponseWrapper with the response of the request
     */
    public ResponseWrapper getByUserAndPassword(String username, String password) {
        try {
            cr.ac.una.controller.ResponseWrapper response = port.getUserByUserAndPassword(username, password);
            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "User found",
                    response.getData());
        } catch (Exception e) {
            return new ResponseWrapper(
                    ResponseCode.NOT_FOUND.getCode(),
                    ResponseCode.NOT_FOUND,
                    "User not found",
                    null);
        }
    }

    /**
     * Recover a password
     * 
     * @param email of the user
     * @return ResponseWrapper with the response of the request
     */
    public ResponseWrapper recoverPassword(String email) {
        try {
            cr.ac.una.controller.ResponseWrapper response = port.recoverPassword(email);
            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "Password recovered successfully",
                    response.getData());
        } catch (Exception e) {
            return new ResponseWrapper(
                    ResponseCode.INTERNAL_SERVER_ERROR.getCode(),
                    ResponseCode.INTERNAL_SERVER_ERROR,
                    "Error recovering password",
                    null);
        }
    }

    /**
     * Change a password
     * 
     * @param id          of the user
     * @param oldPassword of the user
     * @param newPassword of the user
     * @return ResponseWrapper with the response of the request
     */
    public ResponseWrapper changePassword(Long id, String oldPassword, String newPassword) {
        try {
            cr.ac.una.controller.ResponseWrapper response = port.changePassword(id, oldPassword, newPassword);
            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "Password changed successfully",
                    response.getData());
        } catch (Exception e) {
            return new ResponseWrapper(
                    ResponseCode.INTERNAL_SERVER_ERROR.getCode(),
                    ResponseCode.INTERNAL_SERVER_ERROR,
                    "Error changing password",
                    null);
        }
    }
}
