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
import static cr.ac.una.util.Constants.PERSISTENCE_UNIT_NAME;

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
        try{
            Evaluator evaluator = new Evaluator(evaluatorDto);
            evaluator.setEvaluator(em.find(cr.ac.una.entities.User.class,evaluatorDto.getId()));
            evaluator.setEvaluated(em.find(cr.ac.una.entities.Evaluated.class,evaluatorDto.getId()));
            ResponseWrapper CONSTRAINT_VIOLATION = EntityUtil.verifyEntity(evaluator,Evaluator.class);
            if(CONSTRAINT_VIOLATION != null)return CONSTRAINT_VIOLATION;
            em.persist(evaluator);
            em.flush();
            EvaluatorDto newEvaluatorDto = new EvaluatorDto(evaluator);
            return new ResponseWrapper(ResponseCode.OK.getCode(), ResponseCode.OK,"Evaluator successfully created" ,newEvaluatorDto);
        }catch (Exception e){
            return new ResponseWrapper(ResponseCode.INTERNAL_SERVER_ERROR.getCode(), ResponseCode.INTERNAL_SERVER_ERROR,"Error creating evaluator",e.getMessage());
        }
    }

    @Override
    public ResponseWrapper updateEvaluator(EvaluatorDto evaluatorDto) {
        try {
            Evaluator evaluator = em.find(Evaluator.class, evaluatorDto.getId());
            if (evaluator == null) {
                return new ResponseWrapper(ResponseCode.NOT_FOUND.getCode(), ResponseCode.NOT_FOUND, "The evaluator to be updated does not exist", null);
            }
            evaluator.setEvaluator(em.find(cr.ac.una.entities.User.class,evaluatorDto.getId()));
            evaluator.setEvaluated(em.find(cr.ac.una.entities.Evaluated.class,evaluatorDto.getId()));
            ResponseWrapper CONSTRAINT_VIOLATION = EntityUtil.verifyEntity(evaluator,Evaluator.class);
            if(CONSTRAINT_VIOLATION != null)return CONSTRAINT_VIOLATION;
            em.merge(evaluator);
            em.flush();
            EvaluatorDto newEvaluatorDto = new EvaluatorDto(evaluator);
            return new ResponseWrapper(ResponseCode.OK.getCode(), ResponseCode.OK,"Evaluator successfully updated" ,newEvaluatorDto);
        }catch (Exception e){
            return new ResponseWrapper(ResponseCode.INTERNAL_SERVER_ERROR.getCode(), ResponseCode.INTERNAL_SERVER_ERROR,"Error updating evaluator",e.getMessage());
        }
    }

    @Override
    public ResponseWrapper getEvaluatorById(Long id) {
        try {
            Evaluator evaluator = em.find(Evaluator.class, id);
            if (evaluator == null) {
                return new ResponseWrapper(ResponseCode.NOT_FOUND.getCode(), ResponseCode.NOT_FOUND, "The evaluator to be updated does not exist", null);
            }
            EvaluatorDto evaluatorDto = new EvaluatorDto(evaluator);
            return new ResponseWrapper(ResponseCode.OK.getCode(), ResponseCode.OK,"Evaluator successfully retrieved" ,evaluatorDto);
        }catch (Exception e){
            return new ResponseWrapper(ResponseCode.INTERNAL_SERVER_ERROR.getCode(), ResponseCode.INTERNAL_SERVER_ERROR,"Error retrieving evaluator",e.getMessage());
        }
    }

    @Override
    public ResponseWrapper getEvaluatorByName(String name) {
        //fixme: Name isn't a field in the entity, this method should be removed
        // talk with the team
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ResponseWrapper getAllEvaluator() {
        try {
            ListWrapper<EvaluatorDto> evaluators = EntityUtil.fromEntityList(em.createNamedQuery("Evaluator.findAll", Evaluator.class).getResultList(), EvaluatorDto.class);
            return new ResponseWrapper(ResponseCode.OK.getCode(), ResponseCode.OK, "Evaluators successfully retrieved", evaluators);
        } catch (Exception e) {
            return new ResponseWrapper(ResponseCode.INTERNAL_SERVER_ERROR.getCode(), ResponseCode.INTERNAL_SERVER_ERROR, "Error retrieving evaluators", e.getMessage());
        }
    }

    //fixme: Server throws the following error when attempting to delete
    //          <faultcode>S:Server</faultcode>
    //         <faultstring>Transaction aborted</faultstring>
    @Override
    public ResponseWrapper deleteEvaluatorById(Long id) {
        try {
            Evaluator evaluator = em.find(Evaluator.class, id);
            if (evaluator == null) {
                return new ResponseWrapper(ResponseCode.NOT_FOUND.getCode(), ResponseCode.NOT_FOUND, "The evaluator to be deleted does not exist", null);
            }
            em.remove(evaluator);
            return new ResponseWrapper(ResponseCode.OK.getCode(), ResponseCode.OK, "Evaluator successfully deleted", null);
        } catch (Exception e) {
            return new ResponseWrapper(ResponseCode.INTERNAL_SERVER_ERROR.getCode(), ResponseCode.INTERNAL_SERVER_ERROR, "Error deleting evaluator", e.getMessage());
        }
    }

}
