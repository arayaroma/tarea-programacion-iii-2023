package cr.ac.una.repositories.impl;

import java.util.logging.Level;
import java.util.logging.Logger;

import cr.ac.una.entities.User;
import cr.ac.una.repositories.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

public class JpaUserRepository implements UserRepository {

    private static final Logger LOG = Logger.getLogger(JpaUserRepository.class.getName());

    @PersistenceContext(unitName = "EvaComUNA")
    private EntityManager em;

    @Override
    public User createUser(User user) {
        try {
            if (user != null && user.getId() > 0) {
                User existingUser = em.find(User.class, user.getId());
                if (existingUser == null) {
                    LOG.warning("User with ID " + user.getId() + " does not exist.");
                }
                updateUser(user);
                LOG.info("User with ID " + user.getId() + " was updated successfully.");
                return em.merge(existingUser);
            } else {
                em.persist(user);
                LOG.info("User with ID " + user.getId() + " was saved successfully.");
                return user;
            }
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Exception occurred while saving user.", ex);
        }
        return null;
    }

    @Override
    public User getUserById(Long id) {
        try {
            User user = em.find(User.class, id);
            if (user != null) {
                LOG.info("User with ID " + id + " was retrieved successfully.");
                return user;
            } else {
                LOG.warning("User with ID " + id + " does not exist.");
            }
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Exception occurred while retrieving user.", ex);
        }
        return null;
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        if (user != null) {
            User existingUser = em.find(User.class, user.getId());
            if (existingUser != null) {
                em.getTransaction().begin();
                em.merge(existingUser);
                em.getTransaction().commit();
            }
        }
    }

    @Override
    public void deleteUser(Long id) {
        try {
            User user = em.find(User.class, id);
            if (user != null) {
                em.remove(user);
                LOG.info("User with ID " + id + " was deleted successfully.");
            } else {
                LOG.warning("User with ID " + id + " does not exist.");
            }
        } catch (Exception ex) {
            LOG.log(Level.SEVERE, "Exception occurred while deleting user.", ex);
        }
    }

}
