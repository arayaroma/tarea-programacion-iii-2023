package cr.ac.una.services.impl;

import cr.ac.una.dto.UserDto;
import cr.ac.una.repositories.UserRepository;
import cr.ac.una.services.UserService;
import cr.ac.una.util.Response;
import cr.ac.una.util.ResponseCode;
import jakarta.inject.Inject;
import jakarta.jws.WebService;

@WebService(serviceName = "UserService")
public class UserServiceImpl implements UserService {

    @Inject
    private UserRepository userRepository;

    @Override
    public Response createUser(UserDto user) {
        try {
            userRepository.createUser(user);
            return new Response(true,
                    ResponseCode.OK,
                    "User created successfully.",
                    user);
        } catch (Exception ex) {
            return new Response(false,
                    ResponseCode.INTERNAL_SERVER_ERROR,
                    "Exception occurred while creating user.",
                    null);
        }
    }

    @Override
    public Response getUserById(Long id) {
        try {
            Response response = userRepository.getUserById(id);
            if (response.getState()) {
                return new Response(true,
                        ResponseCode.OK,
                        "User retrieved successfully.",
                        response.getData());
            } else {
                return new Response(false,
                        ResponseCode.NOT_FOUND,
                        "User not found.",
                        null);
            }
        } catch (Exception ex) {
            return new Response(false,
                    ResponseCode.INTERNAL_SERVER_ERROR,
                    "Exception occurred while getting user by ID.",
                    null);
        }
    }

    @Override
    public Response updateUserById(Long id, UserDto user) {
        try {
            Response response = userRepository.getUserById(id);
            if (response.getState()) {
                userRepository.updateUser(user);
                return new Response(true,
                        ResponseCode.OK,
                        "User updated successfully.",
                        user);
            } else {
                return new Response(false,
                        ResponseCode.NOT_FOUND,
                        "User not found.",
                        null);
            }
        } catch (Exception ex) {
            return new Response(false,
                    ResponseCode.INTERNAL_SERVER_ERROR,
                    "Exception occurred while updating user by ID.",
                    null);
        }
    }

    @Override
    public Response deleteUserById(Long id) {
        try {
            Response response = userRepository.getUserById(id);
            if (response.getState()) {
                userRepository.deleteUser(id);
                return new Response(true,
                        ResponseCode.OK,
                        "User deleted successfully.",
                        null);
            } else {
                return new Response(false,
                        ResponseCode.NOT_FOUND,
                        "User not found.",
                        null);
            }
        } catch (Exception ex) {
            return new Response(false,
                    ResponseCode.INTERNAL_SERVER_ERROR,
                    "Exception occurred while deleting user by ID.",
                    null);
        }
    }

}
