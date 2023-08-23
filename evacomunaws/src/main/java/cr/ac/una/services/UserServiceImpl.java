package cr.ac.una.services;

import cr.ac.una.dto.UserDto;
import cr.ac.una.entities.User;
import cr.ac.una.util.ResponseWrapper;
import cr.ac.una.util.ResponseCode;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import static cr.ac.una.util.Constants.PERSISTENCE_UNIT_NAME;

@Stateless
@LocalBean
public class UserServiceImpl implements UserService {

    @PersistenceContext(name = PERSISTENCE_UNIT_NAME)
    private EntityManager em;

<<<<<<< HEAD
   @Override
=======
    @Override
    @Transactional
>>>>>>> 45c85a1 ([fix] debugging db connection)
    public ResponseWrapper createUser(UserDto userDto) {
        try {
            User user;
            user = new User(userDto);
            em.persist(user);
            em.flush();
            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "User created successfully.",
                    userDto);
        } catch (Exception ex) {
            return new ResponseWrapper(
                    ResponseCode.INTERNAL_SERVER_ERROR.getCode(),
                    ResponseCode.INTERNAL_SERVER_ERROR,
                    "Exception occurred while creating user: " + ex.getMessage(),
                    null);
        }
    }


    @Override
    public ResponseWrapper getUserById(Long id) {
        return null;
    }

    @Override
    public ResponseWrapper updateUserById(Long id, UserDto user) {
        return null;
    }

    @Override
    public ResponseWrapper deleteUserById(Long id) {
        return null;
    }

}
