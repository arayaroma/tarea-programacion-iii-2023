package cr.ac.una.services;

import cr.ac.una.dto.SkillDto;
import cr.ac.una.entities.Skill;
import cr.ac.una.dto.CalificationDto;
import cr.ac.una.dto.CharacteristicDto;
import cr.ac.una.dto.FinalCalificationDto;
import cr.ac.una.dto.PositionDto;
import cr.ac.una.entities.Characteristic;
import cr.ac.una.util.EntityUtil;
import cr.ac.una.util.ListWrapper;
import cr.ac.una.util.ResponseCode;
import cr.ac.una.util.ResponseWrapper;

import java.util.ArrayList;
import java.util.List;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import static cr.ac.una.util.Constants.PERSISTENCE_UNIT_NAME;

/**
 *
 * @author arayaroma
 */
@Stateless
@LocalBean
public class SkillServiceImpl implements SkillService {

    @PersistenceContext(name = PERSISTENCE_UNIT_NAME)
    private EntityManager em;

    /**
     * @param skillDto skill to be created
     * @return ResponseWrapper with the response of the service call
     */
    @Override
    public ResponseWrapper createSkill(SkillDto skillDto) {
        try {
            Skill skill = new Skill(skillDto);
            ResponseWrapper INVALID_REQUEST = EntityUtil.verifyEntity(skill, Skill.class);
            if (INVALID_REQUEST != null) {
                return INVALID_REQUEST;
            }
            em.persist(skill);
            em.flush();
            /**
             * Replicate to all services
             */
            skillDto = new SkillDto(skill);
            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "Skill created successfully.",
                    skillDto);
        } catch (Exception ex) {
            return new ResponseWrapper(
                    ResponseCode.INTERNAL_SERVER_ERROR.getCode(),
                    ResponseCode.INTERNAL_SERVER_ERROR,
                    "Exception occurred while creating skill: " + ex.getMessage(),
                    null);
        }
    }

    /**
     * @param skillDto skill to be updated
     * @return ResponseWrapper with the response of the service call
     */
    @Override
    public ResponseWrapper updateSkill(SkillDto skillDto) {
        try {
            Skill skill = em.find(Skill.class, skillDto.getId());
            if (skill == null) {
                return new ResponseWrapper(
                        ResponseCode.NOT_FOUND.getCode(),
                        ResponseCode.NOT_FOUND,
                        "Skill not found.",
                        null);
            }
            skill.updateSkill(skillDto);
            if (skillDto.getCharacteristics() != null) {
                for (CharacteristicDto i : skillDto.getCharacteristics()) {
                    skill.getCharacteristics().add(new Characteristic(i));
                }
            }
            ResponseWrapper INVALID_REQUEST = EntityUtil.verifyEntity(skill, Skill.class);
            if (INVALID_REQUEST != null) {
                return INVALID_REQUEST;
            }
            em.merge(skill);
            em.flush();
            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "Skill updated successfully.",
                    skillDto);
        } catch (Exception ex) {
            return new ResponseWrapper(
                    ResponseCode.INTERNAL_SERVER_ERROR.getCode(),
                    ResponseCode.INTERNAL_SERVER_ERROR,
                    "Exception occurred while updating skill: " + ex.getMessage(),
                    null);
        }
    }

    /**
     * @param id skill id to be retrieved
     * @return ResponseWrapper with the response of the service call
     */
    @Override
    public ResponseWrapper getSkillById(Long id) {
        try {
            Skill skill = em.find(Skill.class, id);
            if (skill == null) {
                return new ResponseWrapper(
                        ResponseCode.NOT_FOUND.getCode(),
                        ResponseCode.NOT_FOUND,
                        "Skill not found.",
                        null);
            }
            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "Successful retrieval of skill.",
                    new SkillDto(skill));
        } catch (Exception ex) {
            return new ResponseWrapper(
                    ResponseCode.INTERNAL_SERVER_ERROR.getCode(),
                    ResponseCode.INTERNAL_SERVER_ERROR,
                    "Exception occurred while retrieving skill: " + ex.getMessage(),
                    null);
        }
    }

    /**
     * @param name skill name to be retrieved
     * @return ResponseWrapper with the response of the service call
     */
    @Override
    public ResponseWrapper getSkillByName(String name) {
        try {
            Skill skill = (Skill) em.createNamedQuery("Skill.findByName")
                    .setParameter("name", name)
                    .getSingleResult();
            if (skill == null) {
                return new ResponseWrapper(
                        ResponseCode.NOT_FOUND.getCode(),
                        ResponseCode.NOT_FOUND,
                        "Skill not found.",
                        null);
            }
            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "Successful retrieval of skill.",
                    new SkillDto(skill));
        } catch (Exception ex) {
            return new ResponseWrapper(
                    ResponseCode.INTERNAL_SERVER_ERROR.getCode(),
                    ResponseCode.INTERNAL_SERVER_ERROR,
                    "Exception occurred while retrieving skill: " + ex.getMessage(),
                    null);
        }
    }

    /**
     * @return ResponseWrapper with the response of the service call Get all
     *         skills
     */
    @Override
    @SuppressWarnings("unchecked")
    public ResponseWrapper getSkills() {
        try {
            Query query = em.createNamedQuery("Skill.findAll", Skill.class);
            List<Skill> skills = (List<Skill>) query.getResultList();
            List<SkillDto> skillsDto = new ArrayList<>();

            for (Skill skill : skills) {
                SkillDto skillDto = new SkillDto(skill);
                skillsDto.add(skillDto.convertFromEntityToDTO(skill, skillDto));
            }

            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "Successful retrieval of skills.",
                    new ListWrapper<>(skillsDto));
        } catch (Exception ex) {
            return new ResponseWrapper(
                    ResponseCode.INTERNAL_SERVER_ERROR.getCode(),
                    ResponseCode.INTERNAL_SERVER_ERROR,
                    "Exception occurred while retrieving skills: " + ex.getMessage(),
                    null);
        }
    }

    /**
     * @param id skill id to be retrieved
     * @return ResponseWrapper with the response of the service call Get all
     *         characteristics by skill id
     */
    @Override
    @SuppressWarnings("unchecked")
    public ResponseWrapper getCharacteristicsBySkillId(Long id) {
        try {
            Skill skill = em.find(Skill.class, id);
            if (skill == null) {
                return new ResponseWrapper(
                        ResponseCode.NOT_FOUND.getCode(),
                        ResponseCode.NOT_FOUND,
                        "Skill not found.",
                        null);
            }
            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "Successful retrieval of characteristics.",
                    EntityUtil.fromEntityList(
                            em.createNamedQuery("Skill.getCharacteristicsBySkillId").getResultList(),
                            CharacteristicDto.class));
        } catch (Exception ex) {
            return new ResponseWrapper(
                    ResponseCode.INTERNAL_SERVER_ERROR.getCode(),
                    ResponseCode.INTERNAL_SERVER_ERROR,
                    "Exception occurred while retrieving characteristics: " + ex.getMessage(),
                    null);
        }
    }

    /**
     * @param id skill id to be retrieved
     * @return ResponseWrapper with the response of the service call Get all
     *         califications by skill id
     */
    @Override
    @SuppressWarnings("unchecked")
    public ResponseWrapper getCalificationsBySkillId(Long id) {
        try {
            Skill skill = em.find(Skill.class, id);
            if (skill == null) {
                return new ResponseWrapper(
                        ResponseCode.NOT_FOUND.getCode(),
                        ResponseCode.NOT_FOUND,
                        "Skill not found.",
                        null);
            }
            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "Successful retrieval of califications.",
                    EntityUtil.fromEntityList(
                            em.createNamedQuery("Skill.getCalificationsBySkillId").getResultList(),
                            CalificationDto.class));
        } catch (Exception ex) {
            return new ResponseWrapper(
                    ResponseCode.INTERNAL_SERVER_ERROR.getCode(),
                    ResponseCode.INTERNAL_SERVER_ERROR,
                    "Exception occurred while retrieving califications: " + ex.getMessage(),
                    null);
        }
    }

    /**
     * @param id skill id to be retrieved
     * @return ResponseWrapper with the response of the service call Get all
     *         final califications by skill id
     */
    @Override
    @SuppressWarnings("unchecked")
    public ResponseWrapper getFinalCalificationsBySkillId(Long id) {
        try {
            Skill skill = em.find(Skill.class, id);
            if (skill == null) {
                return new ResponseWrapper(
                        ResponseCode.NOT_FOUND.getCode(),
                        ResponseCode.NOT_FOUND,
                        "Skill not found.",
                        null);
            }
            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "Successful retrieval of final califications.",
                    EntityUtil.fromEntityList(
                            em.createNamedQuery("Skill.getFinalCalificationsBySkillId").getResultList(),
                            FinalCalificationDto.class));
        } catch (Exception ex) {
            return new ResponseWrapper(
                    ResponseCode.INTERNAL_SERVER_ERROR.getCode(),
                    ResponseCode.INTERNAL_SERVER_ERROR,
                    "Exception occurred while retrieving final califications: " + ex.getMessage(),
                    null);
        }
    }

    /**
     * @param id skill id to be retrieved
     * @return ResponseWrapper with the response of the service call Get all
     *         positions by skill id
     */
    @Override
    @SuppressWarnings("unchecked")
    public ResponseWrapper getPositionsBySkillId(Long id) {
        try {
            Skill skill = em.find(Skill.class, id);
            if (skill == null) {
                return new ResponseWrapper(
                        ResponseCode.NOT_FOUND.getCode(),
                        ResponseCode.NOT_FOUND,
                        "Skill not found.",
                        null);
            }
            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "Successful retrieval of positions.",
                    EntityUtil.fromEntityList(
                            em.createNamedQuery("Skill.getPositionsBySkillId").getResultList(),
                            PositionDto.class));
        } catch (Exception ex) {
            return new ResponseWrapper(
                    ResponseCode.INTERNAL_SERVER_ERROR.getCode(),
                    ResponseCode.INTERNAL_SERVER_ERROR,
                    "Exception occurred while retrieving positions: " + ex.getMessage(),
                    null);
        }
    }

    /**
     * @param id skill id to be deleted
     * @return ResponseWrapper with the response of the service call
     */
    @Override
    public ResponseWrapper deleteSkillById(Long id) {
        try {
            Skill skill = em.find(Skill.class, id);
            if (skill == null) {
                return new ResponseWrapper(
                        ResponseCode.NOT_FOUND.getCode(),
                        ResponseCode.NOT_FOUND,
                        "Skill not found.",
                        null);
            }
            em.remove(skill);
            em.flush();
            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "Skill deleted successfully.",
                    null);
        } catch (Exception ex) {
            return new ResponseWrapper(
                    ResponseCode.INTERNAL_SERVER_ERROR.getCode(),
                    ResponseCode.INTERNAL_SERVER_ERROR,
                    "Exception occurred while deleting skill: " + ex.getMessage(),
                    null);
        }
    }

    /**
     * @param name skill name to be deleted
     * @return ResponseWrapper with the response of the service call
     */
    @Override
    public ResponseWrapper deleteSkillByName(String name) {
        try {
            Skill skill = (Skill) em.createNamedQuery("Skill.findByName")
                    .setParameter("name", name)
                    .getSingleResult();
            if (skill == null) {
                return new ResponseWrapper(
                        ResponseCode.NOT_FOUND.getCode(),
                        ResponseCode.NOT_FOUND,
                        "Skill not found.",
                        null);
            }
            em.remove(skill);
            em.flush();
            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "Skill deleted successfully.",
                    null);
        } catch (Exception ex) {
            return new ResponseWrapper(
                    ResponseCode.INTERNAL_SERVER_ERROR.getCode(),
                    ResponseCode.INTERNAL_SERVER_ERROR,
                    "Exception occurred while deleting skill: " + ex.getMessage(),
                    null);
        }
    }

    /**
     * @return ResponseWrapper with the response of the service call Delete all
     *         skills
     */
    @Override
    public ResponseWrapper deleteAllSkills() {
        try {
            em.createNamedQuery("Skill.deleteAll").executeUpdate();
            em.flush();
            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "Skills deleted successfully.",
                    null);
        } catch (Exception ex) {
            return new ResponseWrapper(
                    ResponseCode.INTERNAL_SERVER_ERROR.getCode(),
                    ResponseCode.INTERNAL_SERVER_ERROR,
                    "Exception occurred while deleting skills: " + ex.getMessage(),
                    null);
        }
    }

}
