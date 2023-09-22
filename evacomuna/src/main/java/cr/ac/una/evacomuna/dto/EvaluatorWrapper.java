package cr.ac.una.evacomuna.dto;

import cr.ac.una.controller.EvaluatedDto;
import cr.ac.una.controller.EvaluatorDto;
import cr.ac.una.controller.UserDto;

/**
 *
 * @author estebannajera
 */
public class EvaluatorWrapper {
    
    private Long id;
    private Long version;
    private UserDto evaluator;
    private EvaluatedDto evaluatedDto;
    private String role;
    private String feedBack;
    
    public EvaluatorWrapper(UserDto evaluator) {
        this.evaluator = evaluator;
    }
    
    public EvaluatorWrapper(EvaluatorDto evaluator) {
//        this.evaluatedDto = evaluator.getEvaluated();
//        this.evaluator = evaluator.getEvaluator();
        this.id = evaluator.getId();
        this.version = evaluator.getVersion();
        this.feedBack = evaluator.getFeedback();
        this.role = evaluator.getRole();
    }
    
    public EvaluatorDto getDto() {
        EvaluatorDto evaluatorDto = new EvaluatorDto();
        evaluatorDto.setEvaluator(evaluator);
        evaluatorDto.setEvaluated(evaluatedDto);
        evaluatorDto.setFeedback(feedBack);
        evaluatorDto.setRole(role);
        evaluatorDto.setId(id);
        evaluatorDto.setVersion(version);
        return evaluatorDto;
    }
    
}
