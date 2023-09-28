package cr.ac.una.evacomunaws.services;

import cr.ac.una.evacomunaws.dto.EvaluationDto;
import cr.ac.una.evacomunaws.entities.Evaluation;
import cr.ac.una.evacomunaws.util.EntityUtil;
<<<<<<< HEAD
=======
<<<<<<< HEAD
import cr.ac.una.evacomunaws.util.ListWrapper;
=======
>>>>>>> 29c7236 ([FIXING] cr.ac.una.evacomunaws import to ALL CLASSES)
>>>>>>> master
import cr.ac.una.evacomunaws.util.ResponseCode;
import cr.ac.una.evacomunaws.util.ResponseWrapper;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
<<<<<<< HEAD
import cr.ac.una.evacomunaws.util.ListWrapper;
import jakarta.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import static cr.ac.una.evacomunaws.util.Constants.PERSISTENCE_UNIT_NAME;
=======
<<<<<<< HEAD
import jakarta.persistence.Query;

import static cr.ac.una.evacomunaws.util.Constants.PERSISTENCE_UNIT_NAME;

import java.util.ArrayList;
import java.util.List;
=======
import cr.ac.una.evacomunaws.util.ListWrapper;
import jakarta.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import static cr.ac.una.evacomunaws.util.Constants.PERSISTENCE_UNIT_NAME;
>>>>>>> 29c7236 ([FIXING] cr.ac.una.evacomunaws import to ALL CLASSES)
>>>>>>> master

/**
 *
 * @author arayaroma
 */
@Stateless
@LocalBean
public class EvaluationServiceImpl implements EvaluationService {

    @PersistenceContext(name = PERSISTENCE_UNIT_NAME)
    private EntityManager em;

    @Override
    public ResponseWrapper createEvaluation(EvaluationDto evaluationDto) {
        try {
            Evaluation evaluation = new Evaluation(evaluationDto);

            ResponseWrapper CONSTRAINT_VIOLATION = EntityUtil.verifyEntity(evaluation, Evaluation.class);
            if (CONSTRAINT_VIOLATION != null) {
                return CONSTRAINT_VIOLATION;
            }
            em.persist(evaluation);
            em.flush();
           // em.refresh(evaluation);
            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "Evaluation created successfully.",
                    new EvaluationDto(evaluation));
        } catch (Exception e) {
            return new ResponseWrapper(
                    ResponseCode.INTERNAL_SERVER_ERROR.getCode(),
                    ResponseCode.INTERNAL_SERVER_ERROR,
                    "Error creating evaluation:" + e.getMessage(),
                    null);
        }

    }

    @Override
    public ResponseWrapper updateEvaluation(EvaluationDto evaluationDto) {
        try {
            Evaluation evaluation = em.find(Evaluation.class, evaluationDto.getId());
            if (evaluation == null) {
                return new ResponseWrapper(
                        ResponseCode.NOT_FOUND.getCode(),
                        ResponseCode.NOT_FOUND,
                        "Evaluation not found.",
                        null);
            }
            evaluation.updateEvaluation(evaluationDto);
            ResponseWrapper CONSTRAINT_VIOLATION = EntityUtil.verifyEntity(evaluation, Evaluation.class);
            if (CONSTRAINT_VIOLATION != null) {
                return CONSTRAINT_VIOLATION;
            }
            em.merge(evaluation);
            em.flush();
            em.refresh(evaluation);
            EvaluationDto updatedDto = new EvaluationDto(evaluation);
            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "Evaluation updated successfully.",
                    updatedDto);
        } catch (Exception e) {
            return new ResponseWrapper(
                    ResponseCode.INTERNAL_SERVER_ERROR.getCode(),
                    ResponseCode.INTERNAL_SERVER_ERROR,
                    "Error updating evaluation: " + e.getMessage(),
                    null);
        }
    }

    @Override
    public ResponseWrapper getEvaluationById(Long id) {
        try {
            Evaluation evaluation = em.find(Evaluation.class, id);
            if (evaluation == null) {
                return new ResponseWrapper(
                        ResponseCode.NOT_FOUND.getCode(),
                        ResponseCode.NOT_FOUND,
                        "Evaluation not found.",
                        null);
            }
            EvaluationDto evaluationDto = new EvaluationDto(evaluation);
            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "Evaluation retrieved successfully.",
                    evaluationDto);
        } catch (Exception e) {
            return new ResponseWrapper(
                    ResponseCode.INTERNAL_SERVER_ERROR.getCode(),
                    ResponseCode.INTERNAL_SERVER_ERROR,
                    "Error retrieving evaluation:" + e.getMessage(),
                    null);
        }
    }

    @Override
    public ResponseWrapper getEvaluationByName(String name) {
        try {
            Evaluation evaluation = em.createNamedQuery("Evaluation.findByName", Evaluation.class)
                    .setParameter("name", name)
                    .getSingleResult();
            System.out.println("Size evaluated: " + evaluation.getEvaluated().size());
            evaluation.getEvaluated().forEach((t -> System.out.print("Size ebvalators: " + t.getEvaluators().size())));
            EvaluationDto evaluationDto = new EvaluationDto(evaluation);
            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "Evaluation retrieved successfully.",
                    evaluationDto.convertFromEntityToDTO(evaluation, evaluationDto));
        } catch (Exception e) {
            return new ResponseWrapper(
                    ResponseCode.INTERNAL_SERVER_ERROR.getCode(),
                    ResponseCode.INTERNAL_SERVER_ERROR,
                    "Error retrieving evaluation:" + e.getMessage(),
                    null);
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public ResponseWrapper getAllEvaluation() {
        try {
            Query query = em.createNamedQuery("Evaluation.findAll", Evaluation.class);
            List<Evaluation> evaluationList = (List<Evaluation>) query.getResultList();
            List<EvaluationDto> evaluationDtos = new ArrayList<>();
            evaluationList.forEach(
                    t -> evaluationDtos.add(new EvaluationDto(t).convertFromEntityToDTO(t, new EvaluationDto(t))));
            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "Evaluations retrieved successfully.",
                    new ListWrapper<>(evaluationDtos));
        } catch (Exception e) {
            return new ResponseWrapper(
                    ResponseCode.INTERNAL_SERVER_ERROR.getCode(),
                    ResponseCode.INTERNAL_SERVER_ERROR,
                    "Error retrieving evaluations:" + e.getMessage(),
                    null);
        }
    }

    @Override
    public ResponseWrapper deleteEvaluationById(Long id) {
        try {
            Evaluation evaluation = em.find(Evaluation.class, id);
            if (evaluation == null) {
                return new ResponseWrapper(
                        ResponseCode.NOT_FOUND.getCode(),
                        ResponseCode.NOT_FOUND,
                        "Evaluation not found.",
                        null);
            }
            em.remove(evaluation);
            em.flush();
            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "Evaluation deleted successfully.",
                    null);
        } catch (Exception e) {
            return new ResponseWrapper(
                    ResponseCode.INTERNAL_SERVER_ERROR.getCode(),
                    ResponseCode.INTERNAL_SERVER_ERROR,
                    "Error deleting evaluation:" + e.getMessage(),
                    null);
        }
    }

}
