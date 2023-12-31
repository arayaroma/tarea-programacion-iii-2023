package cr.ac.una.evacomunaws.services;

import cr.ac.una.evacomunaws.dto.PositionDto;
import cr.ac.una.evacomunaws.dto.SkillDto;
import cr.ac.una.evacomunaws.dto.UserDto;
import cr.ac.una.evacomunaws.entities.Position;
import cr.ac.una.evacomunaws.entities.Skill;
import cr.ac.una.evacomunaws.entities.User;
import cr.ac.una.evacomunaws.util.DtoMapper;
import cr.ac.una.evacomunaws.util.EntityUtil;
import cr.ac.una.evacomunaws.util.ListWrapper;
import cr.ac.una.evacomunaws.util.ResponseCode;
import cr.ac.una.evacomunaws.util.ResponseWrapper;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import static cr.ac.una.evacomunaws.util.Constants.PERSISTENCE_UNIT_NAME;
import java.util.ArrayList;
import java.util.List;

/**
 * @author arayaroma
 */
@Stateless
@LocalBean
public class PositionServiceImpl implements PositionService {
    
    @PersistenceContext(name = PERSISTENCE_UNIT_NAME)
    private EntityManager em;

    /**
     * @param dto EntityDto to copy to
     * @param entity Entity to copy from
     * @return dto with the values from the entity
     */
    private PositionDto convertFromEntityToDTO(PositionDto dto, Position entity) {
        dto.setUsers(DtoMapper.fromEntityList(entity.getUsers(),
                UserDto.class).getList());
        
        dto.setSkills(
                DtoMapper.fromEntityList(entity.getSkills(),
                        SkillDto.class).getList());
        return dto;
    }

    /**
     * @param entity Entity to copy to
     * @param dto EntityDto to copy from
     * @return entity with the values from the dto
     */
    private Position convertFromDTOToEntity(Position entity, PositionDto dto) {
        entity.setUsers(DtoMapper.fromDtoList(dto.getUsers(),
                User.class).getList());
        
        entity.setSkills(DtoMapper.fromDtoList(dto.getSkills(),
                Skill.class).getList());
        return entity;
    }
    
    @Override
    public ResponseWrapper createPosition(PositionDto positionDto) {
        try {
            Position position = convertFromDTOToEntity(new Position(positionDto), positionDto);
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
     * getUsersByPositionId
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
                    DtoMapper.fromEntityList(
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
     * getSkillsByPositionId
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
                    DtoMapper.fromEntityList(
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
     * @param id id of the position to be updated
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
     * deleteAllPositions
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
    
    @Override
    @SuppressWarnings("unchecked")
    public ResponseWrapper getPositions() {
        try {
            List<Position> positions = em.createNamedQuery("Position.findAll").getResultList();
            List<PositionDto> positionDtos = new ArrayList<>();
            for (Position p : positions) {
                positionDtos.add(convertFromEntityToDTO(new PositionDto(p), p));
            }
            return new ResponseWrapper(ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "Successful retrieval of positions.",
                    new ListWrapper<>(positionDtos));
        } catch (Exception e) {
            return new ResponseWrapper(
                    ResponseCode.INTERNAL_SERVER_ERROR.getCode(),
                    ResponseCode.INTERNAL_SERVER_ERROR,
                    "Exception occurred while retrieving positions: " + e.getMessage(),
                    null);
        }
    }
    
    @Override
    public ResponseWrapper getPositionByName(String name) {
        try {
            Position position = (Position) em.createNamedQuery("Position.findByName").setParameter("name", name)
                    .getSingleResult();
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
                    "Successful retrieval of position.",
                    convertFromEntityToDTO(new PositionDto(position), position));
        } catch (Exception e) {
            return new ResponseWrapper(
                    ResponseCode.INTERNAL_SERVER_ERROR.getCode(),
                    ResponseCode.INTERNAL_SERVER_ERROR,
                    "Exception occurred while retrieving position: " + e.getMessage(),
                    null);
        }
    }
    
    @Override
    public ResponseWrapper updatePosition(PositionDto positionDto) {
        try {
            Position position = em.find(Position.class, positionDto.getId());
            
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
            position.updatePosition(positionDto);
            position = convertFromDTOToEntity(position, positionDto);
            System.out.println("DtoSize: "+positionDto.getSkills().size());
            System.out.println("Size: "+position.getSkills().size());
            em.merge(position);
            em.flush();
            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "Position updated successfully.",
                    positionDto.convertFromEntityToDTO(position, positionDto));
        } catch (Exception e) {
            return new ResponseWrapper(
                    ResponseCode.INTERNAL_SERVER_ERROR.getCode(),
                    ResponseCode.INTERNAL_SERVER_ERROR,
                    "Exception occurred while updating position: " + e.getMessage(),
                    null);
        }
    }
    
}
