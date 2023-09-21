package cr.ac.una.services;

import cr.ac.una.entities.Evaluated;
import cr.ac.una.util.ResponseCode;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import static cr.ac.una.util.Constants.PERSISTENCE_UNIT_NAME;

import cr.ac.una.dto.EvaluatedDto;
import cr.ac.una.util.ResponseWrapper;;
import cr.ac.una.util.ListWrapper;
import cr.ac.una.util.EntityUtil;
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
            Evaluated evaluated = new Evaluated(evaluatedDto);
            evaluated.setEvaluated(em.find(cr.ac.una.entities.User.class, evaluatedDto.getId()));
            //TODO: move to a proper method
            if(evaluatedDto.getEvaluators()!=null){
                evaluatedDto.getEvaluators().forEach(evaluatorDto -> {
                    evaluated.getEvaluators().add(em.find(cr.ac.una.entities.Evaluator.class,evaluatorDto.getId()));
                });
            }
            if(evaluatedDto.getFinalCalifications()!=null){
                evaluatedDto.getFinalCalifications().forEach(finalCalificationDto -> {
                    evaluated.getFinalCalifications().add(em.find(cr.ac.una.entities.FinalCalification.class,finalCalificationDto.getId()));
                });
            }
            if(evaluatedDto.getEvaluation()!=null){
                evaluated.setEvaluation(em.find(cr.ac.una.entities.Evaluation.class,evaluatedDto.getEvaluation().getId()));
            }


            ResponseWrapper CONSTRAINT_VIOLATION = EntityUtil.verifyEntity(evaluated,Evaluated.class);
            if(CONSTRAINT_VIOLATION != null)return CONSTRAINT_VIOLATION;



            em.persist(evaluated);
            em.flush();
            EvaluatedDto newEvaluatedDto = new EvaluatedDto(evaluated);
            return new ResponseWrapper(ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "Evaluated created successfully.",
                    newEvaluatedDto);
        }catch (Exception e){
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
            if (evaluated==null){
                return new ResponseWrapper(ResponseCode.NOT_FOUND.getCode(),
                        ResponseCode.NOT_FOUND,
                        "Evaluated not found.",
                        null);
            }
            evaluated.updateEvaluated(evaluatedDto);
            ResponseWrapper CONSTRAINT_VIOLATION = EntityUtil.verifyEntity(evaluated,Evaluated.class);
            if(CONSTRAINT_VIOLATION != null)return CONSTRAINT_VIOLATION;
            em.merge(evaluated);
            em.flush();
            EvaluatedDto newEvaluatedDto = new EvaluatedDto(evaluated);
            return new ResponseWrapper(ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "Evaluated updated successfully.",
                    newEvaluatedDto);
        }catch (Exception e){
            return new ResponseWrapper(ResponseCode.INTERNAL_SERVER_ERROR.getCode(),
                    ResponseCode.INTERNAL_SERVER_ERROR,
                    "Error updating evaluated:" + e.getMessage(),
                    null);
        }
    }

    @Override
    public ResponseWrapper getEvaluatedById(Long id) {
        try {
            Evaluated evaluated = em.find(Evaluated.class, id);
            if (evaluated == null) {
                return new ResponseWrapper(ResponseCode.NOT_FOUND.getCode(),
                        ResponseCode.NOT_FOUND,
                        "Evaluated not found.",
                        null);
            }
            EvaluatedDto newEvaluatedDto = new EvaluatedDto(evaluated);
            newEvaluatedDto.setEvaluators(EntityUtil.fromEntityList(evaluated.getEvaluators(),cr.ac.una.dto.EvaluatorDto.class).getList());
            newEvaluatedDto.setEvaluation(new cr.ac.una.dto.EvaluationDto(evaluated.getEvaluation()));
            newEvaluatedDto.setFinalCalifications(EntityUtil.fromEntityList(evaluated.getFinalCalifications(),cr.ac.una.dto.FinalCalificationDto.class).getList());
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
    public ResponseWrapper getEvaluatedByName(String name) {
        //fixme: names aren't unique and don't belong to this entity, this might produce repeated or unwanted results.
        // Talk with the team.
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ResponseWrapper getFinalNote(Long id) {
        try{
            Evaluated evaluated = em.find(Evaluated.class,id);
            if(evaluated==null){
                return new ResponseWrapper(
                        ResponseCode.NOT_FOUND.getCode(),
                        ResponseCode.NOT_FOUND,
                        "Evaluated not found.",
                        null
                );
            }
            if (evaluated.getFinalNote() == null) {
                return new ResponseWrapper(
                        ResponseCode.NOT_FOUND.getCode(),
                        ResponseCode.NOT_FOUND,
                        "Evaluated note not found.",
                        null
                );
            }
            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "Evaluated note retrieved successfully.",
                    evaluated.getFinalNote());
        }catch (Exception e){
            return new ResponseWrapper(
                    ResponseCode.INTERNAL_SERVER_ERROR.getCode(),
                    ResponseCode.INTERNAL_SERVER_ERROR,
                    "Error retrieving evaluated:" + e.getMessage(),
                    null
            );
        }
    }

    @Override
    public ResponseWrapper getAllEvaluated() {
        try {
            ListWrapper<EvaluatedDto> evaluatedDtos = EntityUtil.fromEntityList(em.createNamedQuery("Evaluated.findAll", Evaluated.class)
                    .getResultList(), EvaluatedDto.class);
            return new ResponseWrapper(ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "Evaluated list retrieved successfully.",
                    evaluatedDtos);
        } catch (Exception e) {
            return new ResponseWrapper(ResponseCode.INTERNAL_SERVER_ERROR.getCode(),
                    ResponseCode.INTERNAL_SERVER_ERROR,
                    "Error retrieving evaluated list:" + e.getMessage(),
                    null);
        }
    }

    @Override
    public ResponseWrapper deleteEvaluatedById(Long id) {
        try{
            Evaluated evaluated = em.find(Evaluated.class,id);
            if(evaluated==null){
                return new ResponseWrapper(
                        ResponseCode.NOT_FOUND.getCode(),
                        ResponseCode.NOT_FOUND,
                        "Evaluated not found.",
                        null
                );
            }
            em.remove(evaluated);
            em.flush();
            return new ResponseWrapper(
                    ResponseCode.OK.getCode(),
                    ResponseCode.OK,
                    "Evaluated deleted successfully.",
                    null);
        }catch (Exception e){
            return new ResponseWrapper(
                    ResponseCode.INTERNAL_SERVER_ERROR.getCode(),
                    ResponseCode.INTERNAL_SERVER_ERROR,
                    "Error deleting evaluated:" + e.getMessage(),
                    null
            );
        }
    }

}
