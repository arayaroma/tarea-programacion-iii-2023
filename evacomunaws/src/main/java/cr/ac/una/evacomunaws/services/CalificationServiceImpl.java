package cr.ac.una.evacomunaws.services;

<<<<<<< HEAD
import static cr.ac.una.evacomunaws.util.Constants.PERSISTENCE_UNIT_NAME;
import static cr.ac.una.evacomunaws.util.EntityUtil.verifyEntity;

=======
>>>>>>> 29c7236 ([FIXING] cr.ac.una.evacomunaws import to ALL CLASSES)
import cr.ac.una.evacomunaws.dto.CalificationDto;
import cr.ac.una.evacomunaws.entities.Calification;
import cr.ac.una.evacomunaws.entities.Evaluator;
import cr.ac.una.evacomunaws.entities.Skill;
import cr.ac.una.evacomunaws.util.DtoMapper;
import cr.ac.una.evacomunaws.util.ListWrapper;
import cr.ac.una.evacomunaws.util.ResponseCode;
import cr.ac.una.evacomunaws.util.ResponseWrapper;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
<<<<<<< HEAD
=======
import static cr.ac.una.evacomunaws.util.Constants.PERSISTENCE_UNIT_NAME;
import static cr.ac.una.evacomunaws.util.EntityUtil.verifyEntity;
>>>>>>> 29c7236 ([FIXING] cr.ac.una.evacomunaws import to ALL CLASSES)

/**
 *
 * @author arayaroma
 * @author Angelo
 */
@Stateless
@LocalBean
public class CalificationServiceImpl implements CalificationService {

    @PersistenceContext(name = PERSISTENCE_UNIT_NAME)
    private EntityManager em;

    @Override
    public ResponseWrapper createCalification(CalificationDto calificationDto) {
        try {
            Calification calification = calificationDto.convertFromDTOToEntity(calificationDto,
                    new Calification(calificationDto));
            ResponseWrapper CONSTRAINT_VIOLATION = verifyEntity(calification, Calification.class);
            if (CONSTRAINT_VIOLATION != null) {
                return CONSTRAINT_VIOLATION;
            }
            em.persist(calification);
            em.flush();
            return new ResponseWrapper(ResponseCode.OK.getCode(), ResponseCode.OK, "Calification successfully created",
                    calificationDto.convertFromEntityToDTO(calification, new CalificationDto(calification)));
        } catch (Exception e) {
            return new ResponseWrapper(ResponseCode.INTERNAL_SERVER_ERROR.getCode(), ResponseCode.INTERNAL_SERVER_ERROR,
                    "Error creating calification: " + e.getMessage(), null);
        }
    }

    @Override
    public ResponseWrapper updateCalification(CalificationDto calificationDto) {
        try {
            Calification calification = em.find(Calification.class, calificationDto.getId());
            if (calification == null) {
                return new ResponseWrapper(ResponseCode.NOT_FOUND.getCode(), ResponseCode.NOT_FOUND,
                        "The calification to be updated does not exist", null);
            }
            calification.setCalification(calificationDto.getCalification());
            calification.setSkill(em.find(Skill.class, calificationDto.getSkill().getId()));
            calification.setEvaluator(em.find(Evaluator.class, calificationDto.getEvaluator().getId()));
            ResponseWrapper CONSTRAINT_VIOLATION = verifyEntity(calification, Calification.class);
            if (CONSTRAINT_VIOLATION != null) {
                return CONSTRAINT_VIOLATION;
            }
            em.merge(calification);
            em.flush();
            CalificationDto newCalificationDto = new CalificationDto(calification);
            return new ResponseWrapper(ResponseCode.OK.getCode(), ResponseCode.OK, "Calification successfully updated",
                    newCalificationDto);
        } catch (Exception e) {
            return new ResponseWrapper(ResponseCode.INTERNAL_SERVER_ERROR.getCode(), ResponseCode.INTERNAL_SERVER_ERROR,
                    "Error updating calification: " + e.getMessage(), null);
        }
    }

    @Override
    public ResponseWrapper getCalificationById(Long id) {
        try {
            Calification calification = em.find(Calification.class, id);
            if (calification == null) {
                return new ResponseWrapper(ResponseCode.NOT_FOUND.getCode(), ResponseCode.NOT_FOUND,
                        "The calification to be updated does not exist", null);
            }
            CalificationDto calificationDto = new CalificationDto(calification);
            return new ResponseWrapper(ResponseCode.OK.getCode(), ResponseCode.OK,
                    "Calification successfully retrieved", calificationDto);
        } catch (Exception e) {
            return new ResponseWrapper(ResponseCode.INTERNAL_SERVER_ERROR.getCode(), ResponseCode.INTERNAL_SERVER_ERROR,
                    "Error retrieving calification: " + e.getMessage(), null);
        }
    }

    // TODO: Make sure it works as intended
    @Override
    public ResponseWrapper getCalificationNote(Long id) {
        try {
            Calification calification = em.find(Calification.class, id);
            if (calification == null) {
                return new ResponseWrapper(ResponseCode.NOT_FOUND.getCode(), ResponseCode.NOT_FOUND,
                        "The calification to be updated does not exist", null);
            }
            CalificationDto calificationDto = new CalificationDto(calification);
            return new ResponseWrapper(ResponseCode.OK.getCode(), ResponseCode.OK,
                    "Calification successfully retrieved", calificationDto.getCalification());
        } catch (Exception e) {
            return new ResponseWrapper(ResponseCode.INTERNAL_SERVER_ERROR.getCode(), ResponseCode.INTERNAL_SERVER_ERROR,
                    "Error retrieving calification: " + e.getMessage(), null);
        }
    }

    @Override
    public ResponseWrapper getAllCalification() {
        try {
            ListWrapper<CalificationDto> calificationDtoList;
            calificationDtoList = DtoMapper.fromEntityList(
                    em.createQuery("select c from Calification c", Calification.class).getResultList(),
                    CalificationDto.class);
            return new ResponseWrapper(ResponseCode.OK.getCode(), ResponseCode.OK,
                    "All califications successfully retrieved", calificationDtoList);
        } catch (Exception e) {
            return new ResponseWrapper(ResponseCode.INTERNAL_SERVER_ERROR.getCode(), ResponseCode.INTERNAL_SERVER_ERROR,
                    "Error retrieving califications: " + e.getMessage(), null);
        }
    }

    @Override
    public ResponseWrapper deleteCalificationById(Long id) {
        try {
            Calification calification = em.find(Calification.class, id);
            if (calification == null) {
                return new ResponseWrapper(ResponseCode.NOT_FOUND.getCode(), ResponseCode.NOT_FOUND,
                        "The calification to be updated does not exist", null);
            }
            em.remove(calification);
            em.flush();
            return new ResponseWrapper(ResponseCode.OK.getCode(), ResponseCode.OK, "Calification successfully deleted",
                    null);
        } catch (Exception e) {
            return new ResponseWrapper(ResponseCode.INTERNAL_SERVER_ERROR.getCode(), ResponseCode.INTERNAL_SERVER_ERROR,
                    "Error deleting calification: " + e.getMessage(), null);
        }
    }

}
