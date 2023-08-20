package cr.ac.una.repositories.impl;

import cr.ac.una.dto.UserDto;
import cr.ac.una.entities.User;
import cr.ac.una.repositories.UserRepository;
import cr.ac.una.util.Response;
import cr.ac.una.util.ResponseCode;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class UserRepositoryImpl implements UserRepository {

    @PersistenceContext(unitName = "EvaComUNA")
    private EntityManager em;

    @Override
    public Response createUser(UserDto userDto) {
        try {
            User user = new User(userDto);
            em.persist(user);
            return new Response(true,
                    ResponseCode.OK,
                    "User created successfully.",
                    new UserDto(user));
        } catch (Exception ex) {
            return new Response(false,
                    ResponseCode.INTERNAL_SERVER_ERROR,
                    "Exception occurred while creating user.",
                    null);
        }
    }

    @Override
    public Response getUserById(Long id) {
        try {
            User user = em.find(User.class, id);
            if (user != null) {
                return new Response(true,
                        ResponseCode.OK,
                        "User retrieved successfully.",
                        new UserDto(user));
            } else {
                return new Response(false,
                        ResponseCode.NOT_FOUND,
                        "User not found.",
                        null);
            }

        } catch (Exception ex) {
            return new Response(false,
                    ResponseCode.INTERNAL_SERVER_ERROR,
                    "Exception occurred while getting user by ID.",
                    null);
        }
    }

    @Override
    public Response updateUser(UserDto user) {
        try {
            User userToUpdate = em.find(User.class, user.getId());
            if (userToUpdate != null) {
                userToUpdate.updateUser(user);
                em.merge(userToUpdate);
                return new Response(true,
                        ResponseCode.OK,
                        "User updated successfully.",
                        new UserDto(userToUpdate));
            } else {
                return new Response(false,
                        ResponseCode.NOT_FOUND,
                        "User not found.", null);
            }
        } catch (Exception ex) {
            return new Response(false,
                    ResponseCode.INTERNAL_SERVER_ERROR,
                    "Exception occurred while updating user.",
                    null);
        }
    }

    @Override
    public Response deleteUser(Long id) {
        try {
            User user = em.find(User.class, id);
            if (user != null) {
                em.remove(user);
                return new Response(true,
                        ResponseCode.OK,
                        "User deleted successfully.",
                        null);
            } else {
                return new Response(false,
                        ResponseCode.NOT_FOUND,
                        "User not found.",
                        null);
            }
        } catch (Exception ex) {
            return new Response(false,
                    ResponseCode.INTERNAL_SERVER_ERROR,
                    "Exception occurred while deleting user.",
                    null);
        }
    }

}
