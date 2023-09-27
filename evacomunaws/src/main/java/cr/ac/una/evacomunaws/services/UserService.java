package cr.ac.una.evacomunaws.services;

import cr.ac.una.evacomunaws.dto.UserDto;
import cr.ac.una.evacomunaws.util.ResponseWrapper;
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

    ResponseWrapper getUsers();

    ResponseWrapper activateUser(String hash);

    ResponseWrapper recoverPassword(String email);

    ResponseWrapper changePassword(Long id, String oldPassword, String newPassword);

}
