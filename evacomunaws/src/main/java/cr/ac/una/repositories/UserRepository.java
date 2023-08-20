package cr.ac.una.repositories;

import cr.ac.una.dto.UserDto;
import cr.ac.una.util.Response;

public interface UserRepository {
    Response createUser(UserDto user);

    Response getUserById(Long id);

    Response updateUser(UserDto user);

    Response deleteUser(Long id);
}
