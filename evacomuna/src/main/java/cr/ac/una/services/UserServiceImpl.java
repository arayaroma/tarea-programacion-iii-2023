package cr.ac.una.services;

import jakarta.jws.WebService;

import cr.ac.una.domain.User;

@WebService
public class UserServiceImpl implements UserService {
    @Override
    public User getUser(int id) {
        return new User(1, "arayaroma");
    }
}
