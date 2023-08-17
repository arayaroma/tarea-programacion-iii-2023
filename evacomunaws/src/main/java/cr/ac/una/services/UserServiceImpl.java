package cr.ac.una.services;

import jakarta.jws.WebService;

import cr.ac.una.model.User;

@WebService(serviceName = "user")
public class UserServiceImpl implements UserService {
    
    @Override
    public User getUser(int id) {
        return new User(1, "enajera");
    }
}
