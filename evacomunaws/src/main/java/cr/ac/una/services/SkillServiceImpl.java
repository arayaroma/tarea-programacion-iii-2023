package cr.ac.una.services;

import cr.ac.una.dto.SkillDto;
import cr.ac.una.entities.Skill;
import cr.ac.una.dto.CalificationDto;
import cr.ac.una.dto.CharacteristicDto;
import cr.ac.una.dto.FinalCalificationDto;
import cr.ac.una.dto.PositionDto;
import cr.ac.una.util.EntityUtil;
import cr.ac.una.util.ResponseCode;
import cr.ac.una.util.ResponseWrapper;
import java.util.ArrayList;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
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

    @Override
    public ResponseWrapper createSkill(SkillDto skillDto) {
        try {
            createListSkills(skillDto);
            Skill skill = new Skill(skillDto);
            ResponseWrapper INVALID_REQUEST = EntityUtil.verifyEntity(skill, Skill.class);
            if (INVALID_REQUEST != null) {
                return INVALID_REQUEST;
            }
            em.persist(skill);
            em.flush();
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

    private void createListSkills(SkillDto skillDto) {
        skillDto.setPositions(new ArrayList<PositionDto>());
        skillDto.setCharacteristics(new ArrayList<CharacteristicDto>());
        skillDto.setCalifications(new ArrayList<CalificationDto>());
        skillDto.setFinalCalifications(new ArrayList<FinalCalificationDto>());
    }

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

    @Override
    @SuppressWarnings("unchecked")
    public ResponseWrapper getSkills() {
        try {
            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "Successful retrieval of skills.",
                    EntityUtil.fromEntityList(
                            em.createNamedQuery("Skill.findAll").getResultList(),
                            SkillDto.class));
        } catch (Exception ex) {
            return new ResponseWrapper(
                    ResponseCode.INTERNAL_SERVER_ERROR.getCode(),
                    ResponseCode.INTERNAL_SERVER_ERROR,
                    "Exception occurred while retrieving skills: " + ex.getMessage(),
                    null);
        }
    }

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

    @Override
    public ResponseWrapper deleteAllSkills() {
        try {
            em.createNamedQuery("Skill.deleteAll").executeUpdate();
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