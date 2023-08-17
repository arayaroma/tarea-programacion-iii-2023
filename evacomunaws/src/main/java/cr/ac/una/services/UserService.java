package cr.ac.una.services;

import cr.ac.una.model.User;
import jakarta.jws.WebMethod;
import jakarta.jws.WebService;


public interface UserService {
    @WebMethod(operationName = "getUser")
    public User getUser(int id);
}
