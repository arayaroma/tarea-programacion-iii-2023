package cr.ac.una.services;

import cr.ac.una.dto.UserDto;
import cr.ac.una.util.ResponseWrapper;
import jakarta.ejb.Local;

/**
 * 
 * @author arayaroma
 * @author Angelo2002
 */
@Local
public interface UserService {

    ResponseWrapper createUser(UserDto userDto);

    ResponseWrapper getUserById(Long id);

    ResponseWrapper deleteUserById(Long id);

    ResponseWrapper getUserByIdentification(String identification);

    ResponseWrapper deleteUserByIdentification(String identification);

    ResponseWrapper getUserByUsername(String username);

    ResponseWrapper getUserByUserAndPassword(String username, String password);

    ResponseWrapper updateUser(UserDto userDto);

    ResponseWrapper getUserListByName(String name);

    ResponseWrapper getUserListByPosition(String position);
}
