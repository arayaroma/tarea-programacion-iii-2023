package cr.ac.una.services;

import cr.ac.una.domain.User;
import jakarta.jws.WebMethod;

public interface UserService {
    @WebMethod(operationName = "getUser")
    public User getUser(int id);
}
