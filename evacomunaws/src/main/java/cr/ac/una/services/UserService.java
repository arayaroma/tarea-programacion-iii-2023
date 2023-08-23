package cr.ac.una.services;

import cr.ac.una.dto.UserDto;
import cr.ac.una.util.ResponseWrapper;
import jakarta.ejb.Local;


@Local
public interface UserService {
   
    public ResponseWrapper createUser(UserDto userDto);

    public ResponseWrapper getUserById(Long id);

    public ResponseWrapper updateUserById(Long id, UserDto userDto);

    public ResponseWrapper deleteUserById(Long id);

}
