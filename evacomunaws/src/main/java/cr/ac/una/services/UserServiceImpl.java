package cr.ac.una.services;

import cr.ac.una.dto.UserDto;
import cr.ac.una.entities.User;
import cr.ac.una.util.ResponseWrapper;
import cr.ac.una.util.ResponseCode;
import jakarta.ejb.EJB;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import static cr.ac.una.util.Constants.PERSISTENCE_UNIT_NAME;
import cr.ac.una.util.HtmlFileReader;

@Stateless
@LocalBean
public class UserServiceImpl implements UserService {

    @PersistenceContext(name = PERSISTENCE_UNIT_NAME)
    private EntityManager em;

    @EJB
    EmailService emailService;

    @Override
    @Transactional
    public ResponseWrapper createUser(UserDto userDto) {
        try {
            User user;
            user = new User(userDto);
            em.persist(user);
            em.flush();
            try {
                emailService.sendRegistrationEmail(user.getEmail(), "Complete your account registration",
                        HtmlFileReader.readRegistrationTemplate(
                                user.getName(),
                                user.getUsername(),
                                user.getEmail()));
            } catch (Exception ex) {
                return new ResponseWrapper(
                        ResponseCode.OK.getCode(),
                        ResponseCode.OK,
                        "User created successfully, but email could not be sent: " + ex.getMessage(),
                        userDto);
            }
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getUserById'");
    }

    @Override
    public ResponseWrapper updateUserById(Long id, UserDto userDto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateUserById'");
    }

    @Override
    public ResponseWrapper deleteUserById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteUserById'");
    }

}
