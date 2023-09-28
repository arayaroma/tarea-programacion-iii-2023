package cr.ac.una.evacomuna.services;

import cr.ac.una.evacomunaws.controller.UserController_Service;
import cr.ac.una.evacomuna.dto.UserDto;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import cr.ac.una.evacomunaws.controller.UserController;
import cr.ac.una.evacomuna.util.Connection;
import cr.ac.una.evacomuna.util.Constants;
import cr.ac.una.evacomuna.util.ResponseCode;
import cr.ac.una.evacomuna.util.ResponseWrapper;

/**
 *
 * @author estebannajera
 * @author arayaroma
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
            cr.ac.una.evacomunaws.controller.ResponseWrapper response = port.createUser(userDto.getDto());
            cr.ac.una.evacomunaws.controller.UserDto user = (cr.ac.una.evacomunaws.controller.UserDto) response
                    .getData();
            userDto = new UserDto(user);
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
            cr.ac.una.evacomunaws.controller.ResponseWrapper response = port.updateUser(userDto.getDto());
            cr.ac.una.evacomunaws.controller.UserDto user = (cr.ac.una.evacomunaws.controller.UserDto) response
                    .getData();
            userDto = new UserDto(user);
            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "User updated successfully",
                    userDto);
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
            cr.ac.una.evacomunaws.controller.ResponseWrapper response = port.getUsers();
            cr.ac.una.evacomunaws.controller.ListWrapper listWrapper = (cr.ac.una.evacomunaws.controller.ListWrapper) response
                    .getData();
            List<cr.ac.una.evacomunaws.controller.UserDto> listGenerated = new ArrayList<>();
            List<UserDto> listDto = listWrapper
                    .getElement()
                    .stream()
                    .filter(i -> i instanceof cr.ac.una.evacomunaws.controller.UserDto)
                    .map(i -> {
                        cr.ac.una.evacomunaws.controller.UserDto userDto = (cr.ac.una.evacomunaws.controller.UserDto) i;
                        listGenerated.add(userDto);
                        UserDto userDtoClient = new UserDto(userDto);
                        return userDtoClient.convertFromGeneratedToDTO(userDto, userDtoClient);
                    })
                    .collect(Collectors.toList());

            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "Users found",
                    listDto);
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
    public ResponseWrapper deleteUserById(Long id) {
        try {
            cr.ac.una.evacomunaws.controller.ResponseWrapper response = port.deleteUserById(id);
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
            cr.ac.una.evacomunaws.controller.ResponseWrapper response = port.getUserByUserAndPassword(username,
                    password);
            cr.ac.una.evacomunaws.controller.UserDto user = (cr.ac.una.evacomunaws.controller.UserDto) response
                    .getData();
            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "User found",
                    new UserDto(user));
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
            cr.ac.una.evacomunaws.controller.ResponseWrapper response = port.recoverPassword(email);
            cr.ac.una.evacomunaws.controller.UserDto user = (cr.ac.una.evacomunaws.controller.UserDto) response
                    .getData();
            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "Password recovered successfully",
                    new UserDto(user));
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
            cr.ac.una.evacomunaws.controller.ResponseWrapper response = port.changePassword(id, oldPassword,
                    newPassword);
            cr.ac.una.evacomunaws.controller.UserDto user = (cr.ac.una.evacomunaws.controller.UserDto) response
                    .getData();
            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "Password changed successfully",
                    new UserDto(user));
        } catch (Exception e) {
            return new ResponseWrapper(
                    ResponseCode.INTERNAL_SERVER_ERROR.getCode(),
                    ResponseCode.INTERNAL_SERVER_ERROR,
                    "Error changing password",
                    null);
        }
    }
}
