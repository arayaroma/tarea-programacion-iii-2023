package cr.ac.una.services;

import cr.ac.una.dto.PositionDto;
import cr.ac.una.dto.SkillDto;
import cr.ac.una.dto.UserDto;
import cr.ac.una.entities.Position;

import static cr.ac.una.util.Constants.PERSISTENCE_UNIT_NAME;

import java.util.ArrayList;

import cr.ac.una.util.EntityUtil;
import cr.ac.una.util.ResponseCode;
import cr.ac.una.util.ResponseWrapper;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 * @author arayaroma
 */
@Stateless
@LocalBean
public class PositionServiceImpl implements PositionService {

    @PersistenceContext(name = PERSISTENCE_UNIT_NAME)
    private EntityManager em;

    /**
     * @param position position to be created
     * @return ResponseWrapper with the response of the service call
     */
    @Override
    public ResponseWrapper createPosition(PositionDto positionDto) {
        try {
            createPositionList(positionDto);
            Position position = new Position(positionDto);
            ResponseWrapper INVALID_REQUEST = EntityUtil.verifyEntity(position, Position.class);
            if (INVALID_REQUEST != null) {
                return INVALID_REQUEST;
            }
            em.persist(position);
            em.flush();
            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "Position created successfully.",
                    positionDto);
        } catch (Exception ex) {
            return new ResponseWrapper(
                    ResponseCode.INTERNAL_SERVER_ERROR.getCode(),
                    ResponseCode.INTERNAL_SERVER_ERROR,
                    "Exception occurred while creating position: " + ex.getMessage(),
                    null);
        }
    }

    private void createPositionList(PositionDto positionDto) {
        positionDto.setUsers(new ArrayList<UserDto>());
        positionDto.setSkills(new ArrayList<SkillDto>());
    }

    /**
     * @param id position id to be updated
     * @return ResponseWrapper with the response of the service call
     */
    @Override
    public ResponseWrapper getPositionById(Long id) {
        try {
            Position position = em.find(Position.class, id);
            if (position == null) {
                return new ResponseWrapper(
                        ResponseCode.NOT_FOUND.getCode(),
                        ResponseCode.NOT_FOUND,
                        "Position not found.",
                        null);
            }
            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "Position retrieved successfully.",
                    new PositionDto(position));
        } catch (Exception e) {
            return new ResponseWrapper(
                    ResponseCode.INTERNAL_SERVER_ERROR.getCode(),
                    ResponseCode.INTERNAL_SERVER_ERROR,
                    "Exception occurred while retrieving position: " + e.getMessage(),
                    null);
        }
    }

    /**
     * @param id position id to be retrieved
     * @return ResponseWrapper with the response of the service call
     *         getUsersByPositionId
     */
    @Override
    @SuppressWarnings("unchecked")
    public ResponseWrapper getUsersByPositionId(Long id) {
        try {
            Position position = em.find(Position.class, id);
            if (position == null) {
                return new ResponseWrapper(
                        ResponseCode.NOT_FOUND.getCode(),
                        ResponseCode.NOT_FOUND,
                        "Position not found.",
                        null);
            }
            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "Users retrieved successfully.",
                    EntityUtil.fromEntityList(
                            em.createNamedQuery("Position.getUsersByPositionId").getResultList(),
                            UserDto.class));
        } catch (Exception e) {
            return new ResponseWrapper(
                    ResponseCode.INTERNAL_SERVER_ERROR.getCode(),
                    ResponseCode.INTERNAL_SERVER_ERROR,
                    "Exception occurred while retrieving users: " + e.getMessage(),
                    null);
        }
    }

    /**
     * @param id position id to be retrieved
     * @return ResponseWrapper with the response of the service call
     *         getSkillsByPositionId
     */
    @Override
    @SuppressWarnings("unchecked")
    public ResponseWrapper getSkillsByPositionId(Long id) {
        try {
            Position position = em.find(Position.class, id);
            if (position == null) {
                return new ResponseWrapper(
                        ResponseCode.NOT_FOUND.getCode(),
                        ResponseCode.NOT_FOUND,
                        "Position not found.",
                        null);
            }
            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "Skills retrieved successfully.",
                    EntityUtil.fromEntityList(
                            em.createNamedQuery("Position.getSkillsByPositionId").getResultList(),
                            SkillDto.class));
        } catch (Exception e) {
            return new ResponseWrapper(
                    ResponseCode.INTERNAL_SERVER_ERROR.getCode(),
                    ResponseCode.INTERNAL_SERVER_ERROR,
                    "Exception occurred while retrieving skills: " + e.getMessage(),
                    null);
        }
    }

    /**
     * @param id       position id to be updated
     * @param position position to be updated
     * @return ResponseWrapper with the response of the service call
     */
    @Override
    public ResponseWrapper updatePositionById(Long id) {
        try {
            Position position = em.find(Position.class, id);
            if (position == null) {
                return new ResponseWrapper(
                        ResponseCode.NOT_FOUND.getCode(),
                        ResponseCode.NOT_FOUND,
                        "Position not found.",
                        null);
            }
            ResponseWrapper INVALID_REQUEST = EntityUtil.verifyEntity(position, Position.class);
            if (INVALID_REQUEST != null) {
                return INVALID_REQUEST;
            }
            em.merge(position);
            em.flush();
            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "Position updated successfully.",
                    new PositionDto(position));
        } catch (Exception ex) {
            return new ResponseWrapper(
                    ResponseCode.INTERNAL_SERVER_ERROR.getCode(),
                    ResponseCode.INTERNAL_SERVER_ERROR,
                    "Exception occurred while updating position: " + ex.getMessage(),
                    null);
        }
    }

    /**
     * @param id position id to be deleted
     * @return ResponseWrapper with the response of the service call
     */
    @Override
    public ResponseWrapper deletePositionById(Long id) {
        try {
            Position position = em.find(Position.class, id);
            if (position == null) {
                return new ResponseWrapper(
                        ResponseCode.NOT_FOUND.getCode(),
                        ResponseCode.NOT_FOUND,
                        "Position not found.",
                        null);
            }
            em.remove(position);
            em.flush();
            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "Position deleted successfully.",
                    null);
        } catch (Exception ex) {
            return new ResponseWrapper(
                    ResponseCode.INTERNAL_SERVER_ERROR.getCode(),
                    ResponseCode.INTERNAL_SERVER_ERROR,
                    "Exception occurred while deleting position: " + ex.getMessage(),
                    null);
        }
    }

    /**
     * @return ResponseWrapper with the response of the service call
     *         deleteAllPositions
     */
    @Override
    public ResponseWrapper deleteAllPositions() {
        try {
            em.createNamedQuery("Position.deleteAll").executeUpdate();
            em.flush();
            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "All positions deleted successfully.",
                    null);
        } catch (Exception ex) {
            return new ResponseWrapper(
                    ResponseCode.INTERNAL_SERVER_ERROR.getCode(),
                    ResponseCode.INTERNAL_SERVER_ERROR,
                    "Exception occurred while deleting all positions: " + ex.getMessage(),
                    null);
        }
    }

}
