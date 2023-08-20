package cr.ac.una.services.impl;

import cr.ac.una.entities.User;
import cr.ac.una.repositories.UserRepository;
import cr.ac.una.services.UserService;
import jakarta.jws.WebService;

@WebService(serviceName = "User")
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) {
        return userRepository.createUser(user);
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.getUserById(id);
    }

    @Override
    public void updateUser(User user) {
        userRepository.updateUser(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteUser(id);
    }

}
