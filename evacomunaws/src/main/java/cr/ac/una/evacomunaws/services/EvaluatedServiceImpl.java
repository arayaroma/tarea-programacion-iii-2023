package cr.ac.una.services;

import cr.ac.una.entities.Evaluated;
import cr.ac.una.util.ResponseCode;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import static cr.ac.una.util.Constants.PERSISTENCE_UNIT_NAME;
import cr.ac.una.dto.EvaluatedDto;
import cr.ac.una.util.ResponseWrapper;
import cr.ac.una.util.ListWrapper;
import cr.ac.una.util.DtoMapper;
import cr.ac.una.util.EntityUtil;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author arayaroma
 */
@Stateless
@LocalBean
public class EvaluatedServiceImpl implements EvaluatedService {

    @PersistenceContext(name = PERSISTENCE_UNIT_NAME)
    private EntityManager em;

    /**
     *
     * @param evaluatedDto EvaluatedDto to be persisted
     * @return ResponseWrapper with the result of the transaction
     */
    @Override
    public ResponseWrapper createEvaluated(EvaluatedDto evaluatedDto) {
        try {
            Evaluated evaluated = evaluatedDto.convertFromDTOToEntity(evaluatedDto, new Evaluated(evaluatedDto));
            ResponseWrapper CONSTRAINT_VIOLATION = EntityUtil.verifyEntity(evaluated, Evaluated.class);
            if (CONSTRAINT_VIOLATION != null) {
                return CONSTRAINT_VIOLATION;
            }

            em.persist(evaluated);
            em.flush();
            em.refresh(evaluated);
            return new ResponseWrapper(ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "Evaluated created successfully.",
                    evaluatedDto.convertFromEntityToDTO(evaluated, new EvaluatedDto(evaluated)));
        } catch (Exception e) {
            return new ResponseWrapper(ResponseCode.INTERNAL_SERVER_ERROR.getCode(),
                    ResponseCode.INTERNAL_SERVER_ERROR,
                    "Error creating evaluated:" + e.getMessage(),
                    null);
        }
    }

    @Override
    public ResponseWrapper updateEvaluated(EvaluatedDto evaluatedDto) {
        try {
            Evaluated evaluated = em.find(Evaluated.class, evaluatedDto.getId());
            if (evaluated == null) {
                return new ResponseWrapper(ResponseCode.NOT_FOUND.getCode(),
                        ResponseCode.NOT_FOUND,
                        "Evaluated not found.",
                        null);
            }
            evaluated.updateEvaluated(evaluatedDto);
            ResponseWrapper CONSTRAINT_VIOLATION = EntityUtil.verifyEntity(evaluated, Evaluated.class);
            if (CONSTRAINT_VIOLATION != null) {
                return CONSTRAINT_VIOLATION;
            }
            em.merge(evaluated);
            em.flush();
            em.refresh(evaluated);
            EvaluatedDto newEvaluatedDto = new EvaluatedDto(evaluated);
            return new ResponseWrapper(ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "Evaluated updated successfully.",
                    newEvaluatedDto);
        } catch (Exception e) {
            return new ResponseWrapper(ResponseCode.INTERNAL_SERVER_ERROR.getCode(),
                    ResponseCode.INTERNAL_SERVER_ERROR,
                    "Error updating evaluated:" + e.getMessage(),
                    null);
        }
    }

    @Override
    public ResponseWrapper getEvaluatedById(Long id) {
        try {
            Evaluated evaluated = em.createNamedQuery("Evaluated.findById", Evaluated.class)
                    .setParameter("id", id)
                    .getSingleResult();
            if (evaluated == null) {
                return new ResponseWrapper(ResponseCode.NOT_FOUND.getCode(),
                        ResponseCode.NOT_FOUND,
                        "Evaluated not found.",
                        null);
            }
            EvaluatedDto newEvaluatedDto = new EvaluatedDto(evaluated);
            newEvaluatedDto.setEvaluators(
                    DtoMapper.fromEntityList(evaluated.getEvaluators(), cr.ac.una.dto.EvaluatorDto.class).getList());
            newEvaluatedDto.setEvaluation(new cr.ac.una.dto.EvaluationDto(evaluated.getEvaluation()));
            newEvaluatedDto.setFinalCalifications(DtoMapper
                    .fromEntityList(evaluated.getFinalCalifications(), cr.ac.una.dto.FinalCalificationDto.class)
                    .getList());
            newEvaluatedDto.setEvaluated(new cr.ac.una.dto.UserDto(evaluated.getEvaluated()));
            return new ResponseWrapper(ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "Evaluated retrieved successfully.",
                    newEvaluatedDto);
        } catch (Exception e) {
            return new ResponseWrapper(ResponseCode.INTERNAL_SERVER_ERROR.getCode(),
                    ResponseCode.INTERNAL_SERVER_ERROR,
                    "Error retrieving evaluated:" + e.getMessage(),
                    null);
        }
    }

    @Override
    public ResponseWrapper getFinalNote(Long id) {
        try {
            Evaluated evaluated = em.find(Evaluated.class, id);
            if (evaluated == null) {
                return new ResponseWrapper(
                        ResponseCode.NOT_FOUND.getCode(),
                        ResponseCode.NOT_FOUND,
                        "Evaluated not found.",
                        null);
            }
            if (evaluated.getFinalNote() == null) {
                return new ResponseWrapper(
                        ResponseCode.NOT_FOUND.getCode(),
                        ResponseCode.NOT_FOUND,
                        "Evaluated note not found.",
                        null);
            }
            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "Evaluated note retrieved successfully.",
                    evaluated.getFinalNote());
        } catch (Exception e) {
            return new ResponseWrapper(
                    ResponseCode.INTERNAL_SERVER_ERROR.getCode(),
                    ResponseCode.INTERNAL_SERVER_ERROR,
                    "Error retrieving evaluated:" + e.getMessage(),
                    null);
        }
    }

    @Override
    public ResponseWrapper getAllEvaluated() {
        try {
            List<Evaluated> evaluated = em.createNamedQuery("Evaluated.findAll", Evaluated.class).getResultList();
            List<EvaluatedDto> evaluatedDtos = new ArrayList<>();
            for (Evaluated i : evaluated) {
                evaluatedDtos.add(new EvaluatedDto(i).convertFromEntityToDTO(i, new EvaluatedDto(i)));
            }
            return new ResponseWrapper(ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "Evaluated list retrieved successfully.",
                    new ListWrapper<>(evaluatedDtos));
        } catch (Exception e) {
            return new ResponseWrapper(ResponseCode.INTERNAL_SERVER_ERROR.getCode(),
                    ResponseCode.INTERNAL_SERVER_ERROR,
                    "Error retrieving evaluated list:" + e.getMessage(),
                    null);
        }
    }

    @Override
    public ResponseWrapper deleteEvaluatedById(Long id) {
        try {
            Evaluated evaluated = em.find(Evaluated.class, id);
            if (evaluated == null) {
                return new ResponseWrapper(
                        ResponseCode.NOT_FOUND.getCode(),
                        ResponseCode.NOT_FOUND,
                        "Evaluated not found.",
                        null);
            }
            em.remove(evaluated);
            em.flush();
            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "Evaluated deleted successfully.",
                    null);
        } catch (Exception e) {
            return new ResponseWrapper(
                    ResponseCode.INTERNAL_SERVER_ERROR.getCode(),
                    ResponseCode.INTERNAL_SERVER_ERROR,
                    "Error deleting evaluated:" + e.getMessage(),
                    null);
        }
    }

}
