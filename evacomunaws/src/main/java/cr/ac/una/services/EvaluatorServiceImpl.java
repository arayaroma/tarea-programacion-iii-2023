package cr.ac.una.services;

import cr.ac.una.dto.EvaluatorDto;
import cr.ac.una.entities.Evaluator;
import cr.ac.una.util.EntityUtil;
import cr.ac.una.util.ListWrapper;
import cr.ac.una.util.ResponseCode;
import cr.ac.una.util.ResponseWrapper;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import static cr.ac.una.util.Constants.PERSISTENCE_UNIT_NAME;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author arayaroma
 */
@Stateless
@LocalBean
public class EvaluatorServiceImpl implements EvaluatorService {

    @PersistenceContext(name = PERSISTENCE_UNIT_NAME)
    private EntityManager em;

    @Override
    public ResponseWrapper createEvaluator(EvaluatorDto evaluatorDto) {
        try {
            Evaluator evaluator = evaluatorDto.convertFromDTOToEntity(evaluatorDto, new Evaluator(evaluatorDto));

            ResponseWrapper CONSTRAINT_VIOLATION = EntityUtil.verifyEntity(evaluator, Evaluator.class);
            if (CONSTRAINT_VIOLATION != null) {
                return CONSTRAINT_VIOLATION;
            }
            em.persist(evaluator);
            em.flush();
            em.remove(evaluator);
            return new ResponseWrapper(ResponseCode.OK.getCode(), ResponseCode.OK, "Evaluator successfully created",
                    evaluatorDto.convertFromEntityToDTO(evaluator, new EvaluatorDto(evaluator)));
        } catch (Exception e) {
            return new ResponseWrapper(ResponseCode.INTERNAL_SERVER_ERROR.getCode(), ResponseCode.INTERNAL_SERVER_ERROR,
                    "Error creating evaluator: " + e.getMessage(), null);
        }
    }

    @Override
    public ResponseWrapper updateEvaluator(EvaluatorDto evaluatorDto) {
        try {
            Evaluator evaluator = em.find(Evaluator.class, evaluatorDto.getId());
            if (evaluator == null) {
                return new ResponseWrapper(ResponseCode.NOT_FOUND.getCode(), ResponseCode.NOT_FOUND,
                        "The evaluator to be updated does not exist", null);
            }

            evaluator = evaluatorDto.convertFromDTOToEntity(evaluatorDto, evaluator);
            evaluator.updateEvaluator(evaluatorDto);
            ResponseWrapper CONSTRAINT_VIOLATION = EntityUtil.verifyEntity(evaluator, Evaluator.class);
            if (CONSTRAINT_VIOLATION != null) {
                return CONSTRAINT_VIOLATION;
            }
            evaluator.updateEvaluator(evaluatorDto);
            evaluator = evaluatorDto.convertFromDTOToEntity(evaluatorDto, evaluator);
            em.merge(evaluator);
            em.flush();
            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "Evaluator successfully updated",
                    new EvaluatorDto(evaluator));
        } catch (Exception e) {
            return new ResponseWrapper(
                    ResponseCode.INTERNAL_SERVER_ERROR.getCode(),
                    ResponseCode.INTERNAL_SERVER_ERROR,
                    "Error updating evaluator",
                    e.getMessage());
        }
    }

    @Override
    public ResponseWrapper getEvaluatorById(Long id) {
        try {
            Evaluator evaluator = em.find(Evaluator.class, id);
            if (evaluator == null) {
                return new ResponseWrapper(ResponseCode.NOT_FOUND.getCode(), ResponseCode.NOT_FOUND,
                        "The evaluator to be updated does not exist", null);
            }
            EvaluatorDto evaluatorDto = new EvaluatorDto(evaluator);
            return new ResponseWrapper(ResponseCode.OK.getCode(), ResponseCode.OK, "Evaluator successfully retrieved",
                    evaluatorDto);
        } catch (Exception e) {
            return new ResponseWrapper(ResponseCode.INTERNAL_SERVER_ERROR.getCode(), ResponseCode.INTERNAL_SERVER_ERROR,
                    "Error retrieving evaluator", e.getMessage());
        }
    }

    @Override
    public ResponseWrapper getEvaluatorByEvaluatedId(Long id) {
        try {
            Evaluator evaluator;
            Query query = em.createNamedQuery("Evaluator.findByEvaluatedId", Evaluator.class);
            query.setParameter("evaluatedId", id);

            evaluator = (Evaluator) query.getSingleResult();
            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "Evaluator successfully retrieved",
                    new EvaluatorDto(evaluator));
        } catch (Exception e) {
            return new ResponseWrapper(
                    ResponseCode.INTERNAL_SERVER_ERROR.getCode(),
                    ResponseCode.INTERNAL_SERVER_ERROR,
                    "Error retrieving evaluator",
                    e.getMessage());
        }
    }

    @Override
    public ResponseWrapper getAllEvaluator() {
        try {
            List<Evaluator> evaluators = em.createNamedQuery("Evaluator.findAll", Evaluator.class).getResultList();
            List<EvaluatorDto> evaluatorDtos = new ArrayList<>();
            for (Evaluator e : evaluators) {
                evaluatorDtos.add(new EvaluatorDto(e).convertFromEntityToDTO(e, new EvaluatorDto(e)));
            }

            return new ResponseWrapper(ResponseCode.OK.getCode(), ResponseCode.OK, "Evaluators successfully retrieved",
                    new ListWrapper<>(evaluatorDtos));
        } catch (Exception e) {
            return new ResponseWrapper(ResponseCode.INTERNAL_SERVER_ERROR.getCode(), ResponseCode.INTERNAL_SERVER_ERROR,
                    "Error retrieving evaluators", e.getMessage());
        }
    }

    @Override
    public ResponseWrapper deleteEvaluatorById(Long id) {
        try {
            Evaluator evaluator = em.find(Evaluator.class, id);
            if (evaluator == null) {
                return new ResponseWrapper(ResponseCode.NOT_FOUND.getCode(), ResponseCode.NOT_FOUND,
                        "The evaluator to be deleted does not exist", null);
            }
            em.remove(evaluator);
            em.flush();
            return new ResponseWrapper(ResponseCode.OK.getCode(), ResponseCode.OK, "Evaluator successfully deleted",
                    null);
        } catch (Exception e) {
            return new ResponseWrapper(ResponseCode.INTERNAL_SERVER_ERROR.getCode(), ResponseCode.INTERNAL_SERVER_ERROR,
                    "Error deleting evaluator", e.getMessage());
        }
    }

}
