package cr.ac.una.services;

import cr.ac.una.dto.UserDto;
import cr.ac.una.entities.User;
import cr.ac.una.entities.Position;
import cr.ac.una.util.ResponseWrapper;
import cr.ac.una.util.ResponseCode;
import jakarta.ejb.EJB;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import static cr.ac.una.util.Constants.PERSISTENCE_UNIT_NAME;
import static cr.ac.una.util.EntityUtil.verifyEntity;

import cr.ac.una.util.Constants;
import cr.ac.una.util.EntityUtil;
import cr.ac.una.util.HashGenerator;
import cr.ac.una.util.HtmlFileReader;
import cr.ac.una.util.LinkGenerator;
import cr.ac.una.util.ListWrapper;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
            User user = new User(userDto);
            user.setPosition(new Position(userDto.getPosition()));
            ResponseWrapper INVALID_REQUEST = verifyEntity(user, User.class);
            if (INVALID_REQUEST != null) {
                return INVALID_REQUEST;
            }
            try {
                user.setActivationCode(generateHash(userDto));
                userDto.setActivationCode(user.getActivationCode());
                sendActivationEmail(userDto);
            } catch (Exception ex) {
                return new ResponseWrapper(
                        ResponseCode.OK.getCode(),
                        ResponseCode.OK,
                        "User created successfully, but email could not be sent: " + ex.getMessage(),
                        userDto);
            }
            em.persist(user);
            em.flush();
            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "User created successfully.",
                    new UserDto(user));
        } catch (Exception ex) {
            return new ResponseWrapper(
                    ResponseCode.INTERNAL_SERVER_ERROR.getCode(),
                    ResponseCode.INTERNAL_SERVER_ERROR,
                    "Exception occurred while creating user: " + ex.getMessage(),
                    null);
        }
    }

    private String generateHash(UserDto userDto) {
        return HashGenerator.generateHash(userDto.getUsername(),
                HashGenerator.HashAlgorithm.SHA256.getAlgorithm());
    }

    private ResponseWrapper sendActivationEmail(UserDto userDto) {
        try {
            emailService.sendActivationHashLink(
                    userDto.getEmail(), "Complete your account registration",
                    HtmlFileReader.readEmailTemplate(
                            "Complete your account registration",
                            "Welcome to " + Constants.COMPANY_NAME + "!",
                            userDto.getName(),
                            "Please click the following link to complete your registration: " +
                                    "<a href=" +
                                    LinkGenerator.generateActivationLink(userDto.getId(), userDto.getActivationCode())
                                    + "> Activate account!</a>",
                            "Thank you for registering with us!"));
            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "User created successfully.",
                    userDto);
        } catch (Exception ex) {
            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "User created successfully, but email could not be sent: " + ex.getMessage(),
                    userDto);
        }
    }

    /**
     * @param id user id to be activated
     * @return ResponseWrapper with the response from database, or null if an
     */
    @Override
    @Transactional
    public ResponseWrapper activateUser(Long id, String hash) {
        if (isUserIdNull(id)) {
            return handleUserIdNull();
        }
        try {
            User user;
            user = em.find(User.class, id);
            if (isUserNull(user)) {
                return handleUserNull();
            }
            UserDto userDto = new UserDto(user);
            if (HashGenerator.validateHash(userDto.getActivationCode(), hash)) {
                em.createNativeQuery("CALL EVACOMUNA.ACTIVATE_USER(?id)")
                        .setParameter("id", id)
                        .executeUpdate();

                em.merge(user);
                em.flush();

                emailService.sendActivatedUserEmail(
                        userDto.getEmail(),
                        "Registration completed successfully!",
                        HtmlFileReader.readEmailTemplate(
                                "Registration completed successfully!",
                                "We're glad you just join us!",
                                userDto.getName(),
                                "Feel free to explore our application and get to know us better!",
                                "Thank you for choosing us!"));
                return new ResponseWrapper(
                        ResponseCode.OK.getCode(),
                        ResponseCode.OK,
                        "User activated successfully.",
                        userDto);
            }
            return new ResponseWrapper(
                    ResponseCode.UNAUTHORIZED.getCode(),
                    ResponseCode.UNAUTHORIZED,
                    "Invalid hash.",
                    null);
        } catch (Exception ex) {
            return new ResponseWrapper(
                    ResponseCode.INTERNAL_SERVER_ERROR.getCode(),
                    ResponseCode.INTERNAL_SERVER_ERROR,
                    "Exception occurred while activating user: " + ex.getMessage(),
                    null);
        }
    }

    private boolean isUserIdNull(Long id) {
        return id == null || id <= 0;
    }

    private ResponseWrapper handleUserIdNull() {
        return new ResponseWrapper(
                ResponseCode.BAD_REQUEST.getCode(),
                ResponseCode.BAD_REQUEST,
                "Id can't be null.",
                null);
    }

    private boolean isUserNull(User user) {
        return user == null;
    }

    private ResponseWrapper handleUserNull() {
        return new ResponseWrapper(
                ResponseCode.NOT_FOUND.getCode(),
                ResponseCode.NOT_FOUND,
                "User not found.",
                null);
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
                    ResponseCode.BAD_REQUEST.getCode(),
                    ResponseCode.BAD_REQUEST,
                    "Id can't be null.",
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
     * @param id id from user to be deleted
     * @return ResponseWrapper with the response from database, or null if an
     *         exception occurred
     */
    @Override
    public ResponseWrapper deleteUserById(Long id) {
        if (id == null || id <= 0) {
            return new ResponseWrapper(
                    ResponseCode.BAD_REQUEST.getCode(),
                    ResponseCode.BAD_REQUEST,
                    "Id can't be null.",
                    null);
        }
        try {
            User user;
            user = em.find(User.class, id);
            if (user == null) {
                return new ResponseWrapper(
                        ResponseCode.NOT_FOUND.getCode(),
                        ResponseCode.NOT_FOUND,
                        "User not found, id: " + id + ")",
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
    @SuppressWarnings("unchecked")
    public ResponseWrapper getUserByIdentification(String identification) {
        if (identification == null || identification.isEmpty()) {
            return new ResponseWrapper(
                    ResponseCode.BAD_REQUEST.getCode(),
                    ResponseCode.BAD_REQUEST,
                    "Identification can't be null or empty.",
                    null);
        }
        try {
            User user;
            Query query = em.createNamedQuery("user.findByIdentification", User.class);
            query.setParameter("identification", identification);
            List<User> results = query.getResultList();
            if (results.isEmpty()) {
                return new ResponseWrapper(
                        ResponseCode.NOT_FOUND.getCode(),
                        ResponseCode.NOT_FOUND,
                        "User with identification: " + identification + " not found.",
                        null);
            }
            user = results.get(0);
            if (user == null) {
                return new ResponseWrapper(
                        ResponseCode.INTERNAL_SERVER_ERROR.getCode(),
                        ResponseCode.INTERNAL_SERVER_ERROR,
                        "Retrieved user is null.",
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
    @SuppressWarnings("unchecked")
    public ResponseWrapper deleteUserByIdentification(String identification) {
        if (identification == null || identification.isEmpty()) {
            return new ResponseWrapper(
                    ResponseCode.BAD_REQUEST.getCode(),
                    ResponseCode.BAD_REQUEST,
                    "Identification can't be null.",
                    null);
        }
        try {
            User user;
            Query query = em.createNamedQuery("user.findByIdentification", User.class);
            query.setParameter("identification", identification);
            List<User> results = query.getResultList();
            if (results.isEmpty()) {
                return new ResponseWrapper(
                        ResponseCode.NOT_FOUND.getCode(),
                        ResponseCode.NOT_FOUND,
                        "User with identification: " + identification + " not found.",
                        null);
            }
            user = results.get(0);
            if (user == null) {
                return new ResponseWrapper(
                        ResponseCode.INTERNAL_SERVER_ERROR.getCode(),
                        ResponseCode.INTERNAL_SERVER_ERROR,
                        "Retrieved user is null.",
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
     * @param username Username to match the user
     * @return ResponseWrapper with the response from database, or null if an
     *         exception occurred
     */
    @Override
    @SuppressWarnings("unchecked")
    public ResponseWrapper getUserByUsername(String username) {
        if (username == null || username.isEmpty()) {
            return new ResponseWrapper(
                    ResponseCode.BAD_REQUEST.getCode(),
                    ResponseCode.BAD_REQUEST,
                    "Username can't be null.",
                    null);
        }
        try {
            User user;
            Query query = em.createNamedQuery("user.findByUsername", User.class);
            query.setParameter("username", username);
            List<User> results = query.getResultList();
            if (results.isEmpty()) {
                return new ResponseWrapper(
                        ResponseCode.NOT_FOUND.getCode(),
                        ResponseCode.NOT_FOUND,
                        "User with username: " + username + " not found.",
                        null);
            }
            user = results.get(0);
            if (user == null) {
                return new ResponseWrapper(
                        ResponseCode.INTERNAL_SERVER_ERROR.getCode(),
                        ResponseCode.INTERNAL_SERVER_ERROR,
                        "Retrieved user is null.",
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
     * @param username Username to match the user
     * @param password Password to match the user
     * @return
     */
    @Override
    @SuppressWarnings("unchecked")
    public ResponseWrapper getUserByUserAndPassword(String username, String password) {
        if (username == null || username.isEmpty()) {
            return new ResponseWrapper(
                    ResponseCode.BAD_REQUEST.getCode(),
                    ResponseCode.BAD_REQUEST,
                    "Username can't be null.",
                    null);
        }
        if (password == null || password.isEmpty()) {
            return new ResponseWrapper(
                    ResponseCode.BAD_REQUEST.getCode(),
                    ResponseCode.BAD_REQUEST,
                    "A password is required.",
                    null);
        }
        try {
            User user;
            Query query = em.createNamedQuery("user.findByUsernameAndPassword", User.class);
            query.setParameter("username", username);
            query.setParameter("password", password);
            List<User> results = query.getResultList();
            if (results.isEmpty()) {
                return new ResponseWrapper(
                        ResponseCode.NOT_FOUND.getCode(),
                        ResponseCode.NOT_FOUND,
                        "Authentication failed, username: " + username + ")",
                        null);
            }
            user = results.get(0);
            if (user == null) {
                return new ResponseWrapper(
                        ResponseCode.INTERNAL_SERVER_ERROR.getCode(),
                        ResponseCode.INTERNAL_SERVER_ERROR,
                        "Retrieved user is null.",
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
     * @param userDto User to be updated
     * @return ResponseWrapper with the response from database, or null if an
     *         exception occurred
     */
    @Override
    public ResponseWrapper updateUser(UserDto userDto) {
        if (userDto.getId() == null || userDto.getId() <= 0) {
            return new ResponseWrapper(
                    ResponseCode.BAD_REQUEST.getCode(),
                    ResponseCode.BAD_REQUEST,
                    "Id can't be null.",
                    null);
        }
        try {
            User user;
            user = em.find(User.class, userDto.getId());
            if (user == null) {
                return new ResponseWrapper(
                        ResponseCode.NOT_FOUND.getCode(),
                        ResponseCode.NOT_FOUND,
                        "User not found, id: " + userDto.getId() + ")",
                        null);
            }
            if (!Objects.equals(userDto.getUsername(), user.getUsername())) {
                if (!verifyUniqueUsername(userDto.getUsername())) {
                    return new ResponseWrapper(
                            ResponseCode.CONFLICT.getCode(),
                            ResponseCode.CONFLICT,
                            "Username already exists.",
                            null);
                }
            }
            if (!Objects.equals(userDto.getIdentification(), user.getIdentification())) {
                if (!verifyUniqueIdentification(userDto.getIdentification())) {
                    return new ResponseWrapper(
                            ResponseCode.CONFLICT.getCode(),
                            ResponseCode.CONFLICT,
                            "Identification already exists.",
                            null);
                }
            }
            user.updateUser(userDto);
            user.setPosition(new Position(userDto.getPosition()));
            System.out.println(userDto.getPosition());
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
     * @param name Name to match one or more users
     * @return ResponseWrapper with the response from database, or null if an
     *         exception occurred
     */
    @Override
    public ResponseWrapper getUserListByName(String name) {

        if (name == null || name.isEmpty()) {
            return new ResponseWrapper(
                    ResponseCode.BAD_REQUEST.getCode(),
                    ResponseCode.BAD_REQUEST,
                    "Name can't be null.",
                    null);
        }
        try {
            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "User retrieved successfully.",
                    EntityUtil.fromEntityList(
                            em.createNamedQuery("user.findByName", User.class)
                                    .setParameter("name", "%" + name + "%")
                                    .getResultList(),
                            UserDto.class));

        } catch (Exception ex) {
            return new ResponseWrapper(
                    ResponseCode.INTERNAL_SERVER_ERROR.getCode(),
                    ResponseCode.INTERNAL_SERVER_ERROR,
                    "Exception occurred while retrieving user: " + ex.getMessage(),
                    null);
        }
    }

    /**
     * @param position Position to match users
     * @return ResponseWrapper with the response from database, or null if an
     *         exception occurred
     */
    @Override
    public ResponseWrapper getUserListByPosition(String position) {
        if (position == null || position.isEmpty()) {
            return new ResponseWrapper(
                    ResponseCode.BAD_REQUEST.getCode(),
                    ResponseCode.BAD_REQUEST,
                    "Position can't be null.",
                    null);
        }
        try {
            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "Users retrieved successfully.",
                    EntityUtil.fromEntityList(
                            em.createNamedQuery("user.findByPosition", User.class)
                                    .setParameter("position", "%" + position + "%")
                                    .getResultList(),
                            UserDto.class));
        } catch (Exception ex) {
            return new ResponseWrapper(
                    ResponseCode.INTERNAL_SERVER_ERROR.getCode(),
                    ResponseCode.INTERNAL_SERVER_ERROR,
                    "Exception occurred while retrieving user: " + ex.getMessage(),
                    null);
        }
    }

    /**
     * @return ResponseWrapper with the response from database, or null if an
     *         exception occurred
     */
    @Override
    @SuppressWarnings("unchecked")
    public ResponseWrapper getUsers() {
        try {
            Query query = em.createNamedQuery("user.findAll", User.class);
            List<User> users = (List<User>) query.getResultList();
            List<UserDto> usersDto = new ArrayList<>();

            for (User user : users) {
                UserDto userDto = new UserDto(user);
                usersDto.add(userDto.convertFromEntityToDTO(user, userDto));
            }

            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "Users retrieved successfully.",
                    new ListWrapper<>(usersDto));
        } catch (Exception e) {
            return new ResponseWrapper(
                    ResponseCode.INTERNAL_SERVER_ERROR.getCode(),
                    ResponseCode.INTERNAL_SERVER_ERROR,
                    "Exception occurred while retrieving users: " + e.getMessage(),
                    null);
        }
    }

    private boolean verifyUniqueUsername(String username) {
        return em.createNamedQuery("user.findByUsername", User.class)
                .setParameter("username", username)
                .getResultList().isEmpty();
    }

    private boolean verifyUniqueIdentification(String identification) {
        return em.createNamedQuery("user.findByIdentification", User.class)
                .setParameter("identification", identification)
                .getResultList().isEmpty();
    }
}
