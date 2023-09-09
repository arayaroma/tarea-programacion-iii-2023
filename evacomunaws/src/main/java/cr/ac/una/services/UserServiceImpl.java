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
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

import java.util.Iterator;
import java.util.Set;

/**
 * 
 * @author arayaroma
 */
@Stateless
@LocalBean
public class UserServiceImpl implements UserService {

    @PersistenceContext(name = PERSISTENCE_UNIT_NAME)
    private EntityManager em;

    @EJB
    EmailService emailService;

    /**
     * @param userDto user to be created, also sends an email to the user to
     *                verify the registration
     * @return ResponseWrapper with the response from database, or null if an
     *         exception occurred
     */
    @Override
    @Transactional
    public ResponseWrapper createUser(UserDto userDto) {
        try {
            User user;
            user = new User(userDto);

            ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
            Validator validator = factory.getValidator();
            Set<ConstraintViolation<User>> constraintViolations = validator.validate(user);
            if(!constraintViolations.isEmpty()) {
                StringBuilder message = new StringBuilder();
                for (ConstraintViolation<User> cv : constraintViolations) {
                    System.err.println(cv.getRootBeanClass().getName() + "." + cv.getPropertyPath() + " " + cv.getMessage());

                    message.append(cv.getRootBeanClass().getSimpleName()).append(".").append(cv.getPropertyPath()).append(" ").append(cv.getMessage());
                }
                return new ResponseWrapper(
                        ResponseCode.BAD_REQUEST.getCode(),
                        ResponseCode.BAD_REQUEST,
                        "User not created, validation error: " + message,
                        null);
            }

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

    /**
     * @param id user id to be retrieved
     * @return ResponseWrapper with the response from database, or null if an
     *         exception occurred
     */
    @Override
    public ResponseWrapper getUserById(Long id) {
        if (id == null || id <= 0) {
            return new ResponseWrapper(
                    ResponseCode.NOT_FOUND.getCode(),
                    ResponseCode.NOT_FOUND,
                    "User not found, id null.",
                    null);
        }
        try {
            User user;
            user = em.find(User.class, id);
            if (user == null) {
                return new ResponseWrapper(
                        ResponseCode.NOT_FOUND.getCode(),
                        ResponseCode.NOT_FOUND,
                        "User not found, id: " + id.toString() + ")",
                        null);
            }
            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "User retrieved successfully.",
                    new UserDto(user));
        } catch (Exception ex) {
            return new ResponseWrapper(
                    ResponseCode.INTERNAL_SERVER_ERROR.getCode(),
                    ResponseCode.INTERNAL_SERVER_ERROR,
                    "Exception occurred while retrieving user: " + ex.getMessage(),
                    null);
        }
    }

    /**
     * @param id      user id to be updated
     * @param userDto user to be updated
     * @return ResponseWrapper with the response from database, or null if an
     *         exception occurred
     */
    @Override
    public ResponseWrapper updateUserById(Long id, UserDto userDto) {
        if(id == null || id <= 0){
            return new ResponseWrapper(
                    ResponseCode.NOT_FOUND.getCode(),
                    ResponseCode.NOT_FOUND,
                    "User not found, id null.",
                    null);
        }
        try {
            User user;
            user = em.find(User.class, id);
            if (user == null) {
                return new ResponseWrapper(
                        ResponseCode.NOT_FOUND.getCode(),
                        ResponseCode.NOT_FOUND,
                        "User not found, id: " + id.toString() + ")",
                        null);
            }
            user.updateUser(userDto);
            em.merge(user);
            em.flush();
            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "User updated successfully.",
                    new UserDto(user));
        } catch (Exception ex) {
            return new ResponseWrapper(
                    ResponseCode.INTERNAL_SERVER_ERROR.getCode(),
                    ResponseCode.INTERNAL_SERVER_ERROR,
                    "Exception occurred while updating user: " + ex.getMessage(),
                    null);
        }
    }

    /**
     * @param id user id to be deleted
     * @return ResponseWrapper with the response from database, or null if an
     *         exception occurred
     */
    @Override
    public ResponseWrapper deleteUserById(Long id) {
        if(id == null || id <= 0){
            return new ResponseWrapper(
                    ResponseCode.NOT_FOUND.getCode(),
                    ResponseCode.NOT_FOUND,
                    "User not found, id null.",
                    null);
        }
        try {
            User user;
            user = em.find(User.class, id);
            if (user == null) {
                return new ResponseWrapper(
                        ResponseCode.NOT_FOUND.getCode(),
                        ResponseCode.NOT_FOUND,
                        "User not found, id: " + id.toString() + ")",
                        null);
            }
            em.remove(user);
            em.flush();
            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "User deleted successfully.",
                    null);
        } catch (Exception ex) {
            return new ResponseWrapper(
                    ResponseCode.INTERNAL_SERVER_ERROR.getCode(),
                    ResponseCode.INTERNAL_SERVER_ERROR,
                    "Exception occurred while deleting user: " + ex.getMessage(),
                    null);
        }
    }

    /**
     * @param identification user identification to be retrieved
     * @return ResponseWrapper with the response from database, or null if an
     *         exception occurred
     */
    @Override
    public ResponseWrapper getUserByIdentification(String identification) {
        if (identification == null || identification.isEmpty()) {
            return new ResponseWrapper(
                    ResponseCode.NOT_FOUND.getCode(),
                    ResponseCode.NOT_FOUND,
                    "User not found, identification null.",
                    null);
        }
        try {
            User user;
            user = em.createNamedQuery("user.findByIdentification", User.class)
                    .setParameter("identification", identification)
                    .getSingleResult();
            if (user == null) {
                return new ResponseWrapper(
                        ResponseCode.NOT_FOUND.getCode(),
                        ResponseCode.NOT_FOUND,
                        "User not found, identification: " + identification + ")",
                        null);
            }
            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "User retrieved successfully.",
                    new UserDto(user));
        } catch (Exception ex) {
            return new ResponseWrapper(
                    ResponseCode.INTERNAL_SERVER_ERROR.getCode(),
                    ResponseCode.INTERNAL_SERVER_ERROR,
                    "Exception occurred while retrieving user: " + ex.getMessage(),
                    null);
        }
    }

    /**
     * @param identification user identification to be deleted
     * @return ResponseWrapper with the response from database, or null if an
     *         exception occurred
     */
    @Override
    public ResponseWrapper deleteUserByIdentification(String identification) {
        if (identification == null || identification.isEmpty()) {
            return new ResponseWrapper(
                    ResponseCode.NOT_FOUND.getCode(),
                    ResponseCode.NOT_FOUND,
                    "User not found, identification null.",
                    null);
        }
        try {
            User user;
            user = em.createNamedQuery("user.findByIdentification", User.class)
                    .setParameter("identification", identification)
                    .getSingleResult();
            if (user == null) {
                return new ResponseWrapper(
                        ResponseCode.NOT_FOUND.getCode(),
                        ResponseCode.NOT_FOUND,
                        "User not found, identification: " + identification + ")",
                        null);
            }
            em.remove(user);
            em.flush();
            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "User deleted successfully.",
                    null);
        } catch (Exception ex) {
            return new ResponseWrapper(
                    ResponseCode.INTERNAL_SERVER_ERROR.getCode(),
                    ResponseCode.INTERNAL_SERVER_ERROR,
                    "Exception occurred while deleting user: " + ex.getMessage(),
                    null);
        }
    }


}
