package cr.ac.una.services;

import cr.ac.una.entities.User;
import jakarta.jws.WebMethod;

public interface UserService {
    @WebMethod(operationName = "createUser")
    public User createUser(User user);

    @WebMethod(operationName = "getUser")
    public User getUserById(Long id);

    @WebMethod(operationName = "updateUser")
    void updateUser(User user);

    @WebMethod(operationName = "deleteUser")
    void deleteUser(Long id);

}
