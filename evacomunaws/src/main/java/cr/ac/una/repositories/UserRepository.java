package cr.ac.una.repositories;

import cr.ac.una.entities.User;

public interface UserRepository {
    User createUser(User user);

    User getUserById(Long id);

    void updateUser(User user);

    void deleteUser(Long id);
}
