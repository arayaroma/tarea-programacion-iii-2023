package cr.ac.una.evacomunaws.services;

import cr.ac.una.evacomunaws.dto.FinalCalificationDto;
import cr.ac.una.evacomunaws.entities.Evaluated;
import cr.ac.una.evacomunaws.entities.Skill;
import cr.ac.una.evacomunaws.util.DtoMapper;
import cr.ac.una.evacomunaws.util.ListWrapper;
import cr.ac.una.evacomunaws.util.ResponseWrapper;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import static cr.ac.una.evacomunaws.util.Constants.PERSISTENCE_UNIT_NAME;
import static cr.ac.una.evacomunaws.util.EntityUtil.verifyEntity;
import cr.ac.una.evacomunaws.entities.FinalCalification;
import cr.ac.una.evacomunaws.util.ResponseCode;

/**
 * 
 * @author arayaroma
 * @author Angelo
 */
@Stateless
@LocalBean
public class FinalCalificationServiceImpl implements FinalCalificationService {
    @PersistenceContext(name = PERSISTENCE_UNIT_NAME)
    private EntityManager em;

    @Override
    public ResponseWrapper createFinalCalification(FinalCalificationDto finalCalificationDto) {
        try {
            FinalCalification finalCalification = new FinalCalification(finalCalificationDto);

            Evaluated evaluated = em.find(Evaluated.class, finalCalificationDto.getEvaluated().getId());
            Skill skill = em.find(Skill.class, finalCalificationDto.getSkill().getId());
            finalCalification.setEvaluated(evaluated);
            finalCalification.setSkill(skill);

            ResponseWrapper CONSTRAINT_VIOLATION = verifyEntity(finalCalification, FinalCalification.class);
            if (CONSTRAINT_VIOLATION != null) {
                return CONSTRAINT_VIOLATION;
            }
            em.persist(finalCalification);
            em.flush();
            return new ResponseWrapper(ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "FinalCalification successfully created",
                    finalCalificationDto.convertFromEntityToDTO(finalCalification,
                            new FinalCalificationDto(finalCalification)));
        } catch (Exception e) {
            return new ResponseWrapper(ResponseCode.INTERNAL_SERVER_ERROR.getCode(),
                    ResponseCode.INTERNAL_SERVER_ERROR,
                    "Error creating finalCalification: " + e.getMessage(),
                    null);
        }
    }

    @Override
    public ResponseWrapper updateFinalCalification(FinalCalificationDto finalCalificationDto) {
        try {
            FinalCalification finalCalification = em.find(FinalCalification.class, finalCalificationDto.getId());
            if (finalCalification == null) {
                return new ResponseWrapper(ResponseCode.NOT_FOUND.getCode(),
                        ResponseCode.NOT_FOUND,
                        "The finalCalification to be updated does not exist",
                        null);
            }
            finalCalification.setFinalNote(finalCalificationDto.getFinalNote());
            finalCalification.setAverage(finalCalificationDto.getAverage());
            finalCalification.setEvaluated(em.find(Evaluated.class, finalCalificationDto.getEvaluated().getId()));
            finalCalification.setSkill(em.find(Skill.class, finalCalificationDto.getSkill().getId()));
            ResponseWrapper CONSTRAINT_VIOLATION = verifyEntity(finalCalification, FinalCalification.class);
            if (CONSTRAINT_VIOLATION != null) {
                return CONSTRAINT_VIOLATION;
            }
            em.merge(finalCalification);
            em.flush();
            return new ResponseWrapper(ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "FinalCalification successfully updated",
                    finalCalificationDto.convertFromEntityToDTO(finalCalification,
                            new FinalCalificationDto(finalCalification)));
        } catch (Exception e) {
            return new ResponseWrapper(ResponseCode.INTERNAL_SERVER_ERROR.getCode(),
                    ResponseCode.INTERNAL_SERVER_ERROR,
                    "Error updating finalCalification: " + e.getMessage(),
                    null);
        }
    }

    @Override
    public ResponseWrapper getFinalCalificationById(Long id) {
        try {
            FinalCalification finalCalification = em.find(FinalCalification.class, id);
            if (finalCalification == null) {
                return new ResponseWrapper(ResponseCode.NOT_FOUND.getCode(),
                        ResponseCode.NOT_FOUND,
                        "The finalCalification to be updated does not exist",
                        null);
            }
            FinalCalificationDto finalCalificationDto = new FinalCalificationDto(finalCalification);
            return new ResponseWrapper(ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "FinalCalification successfully retrieved",
                    finalCalificationDto);
        } catch (Exception e) {
            return new ResponseWrapper(ResponseCode.INTERNAL_SERVER_ERROR.getCode(),
                    ResponseCode.INTERNAL_SERVER_ERROR,
                    "Error retrieving final Calification: " + e.getMessage(),
                    null);
        }
    }

    @Override
    public ResponseWrapper getFinalCalificationNote(Long id) {
        try {
            FinalCalification finalCalification = em.find(FinalCalification.class, id);
            if (finalCalification == null) {
                return new ResponseWrapper(ResponseCode.NOT_FOUND.getCode(),
                        ResponseCode.NOT_FOUND,
                        "The finalCalification to be updated does not exist",
                        null);
            }
            FinalCalificationDto finalCalificationDto = new FinalCalificationDto(finalCalification);
            return new ResponseWrapper(ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "FinalCalification successfully retrieved",
                    finalCalificationDto.getFinalNote());
        } catch (Exception e) {
            return new ResponseWrapper(ResponseCode.INTERNAL_SERVER_ERROR.getCode(),
                    ResponseCode.INTERNAL_SERVER_ERROR,
                    "Error retrieving final Calification: " + e.getMessage(),
                    null);
        }
    }

    @Override
    public ResponseWrapper getAverage(Long id) {
        try {
            FinalCalification finalCalification = em.find(FinalCalification.class, id);
            if (finalCalification == null) {
                return new ResponseWrapper(ResponseCode.NOT_FOUND.getCode(),
                        ResponseCode.NOT_FOUND,
                        "The finalCalification to be updated does not exist",
                        null);
            }
            FinalCalificationDto finalCalificationDto = new FinalCalificationDto(finalCalification);
            return new ResponseWrapper(ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "FinalCalification successfully retrieved",
                    finalCalificationDto.getAverage());
        } catch (Exception e) {
            return new ResponseWrapper(ResponseCode.INTERNAL_SERVER_ERROR.getCode(),
                    ResponseCode.INTERNAL_SERVER_ERROR,
                    "Error retrieving final Calification: " + e.getMessage(),
                    null);
        }
    }

    @Override
    public ResponseWrapper getAllFinalCalification() {
        try {
            ListWrapper<FinalCalificationDto> finalCalificationDtoList;
            finalCalificationDtoList = DtoMapper.fromEntityList(
                    em.createQuery("select fc from FinalCalification fc", FinalCalification.class).getResultList(),
                    FinalCalificationDto.class);
            return new ResponseWrapper(ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "All finalCalifications successfully retrieved",
                    finalCalificationDtoList);
        } catch (Exception e) {
            return new ResponseWrapper(ResponseCode.INTERNAL_SERVER_ERROR.getCode(),
                    ResponseCode.INTERNAL_SERVER_ERROR,
                    "Error retrieving finalCalifications: " + e.getMessage(),
                    null);
        }
    }

    @Override
    public ResponseWrapper deleteFinalCalificationById(Long id) {
        try {
            FinalCalification finalCalification = em.find(FinalCalification.class, id);
            if (finalCalification == null) {
                return new ResponseWrapper(ResponseCode.NOT_FOUND.getCode(),
                        ResponseCode.NOT_FOUND,
                        "The finalCalification to be updated does not exist",
                        null);
            }
            em.remove(finalCalification);
            em.flush();
            return new ResponseWrapper(ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "FinalCalification successfully deleted",
                    null);
        } catch (Exception e) {
            return new ResponseWrapper(ResponseCode.INTERNAL_SERVER_ERROR.getCode(),
                    ResponseCode.INTERNAL_SERVER_ERROR,
                    "Error deleting finalCalification: " + e.getMessage(),
                    null);
        }
    }

}
