package cr.ac.una.services;

import cr.ac.una.dto.UserDto;
import cr.ac.una.util.Response;
import jakarta.jws.WebMethod;

public interface UserService {
    @WebMethod(operationName = "createUser")
    public Response createUser(UserDto user);

    @WebMethod(operationName = "getUserById")
    public Response getUserById(Long id);

    @WebMethod(operationName = "updateUserById")
    public Response updateUserById(Long id, UserDto user);

    @WebMethod(operationName = "deleteUserById")
    public Response deleteUserById(Long id);

}
