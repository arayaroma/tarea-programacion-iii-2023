package cr.ac.una.evacomuna.dto;

import cr.ac.una.controller.UserDto;
import cr.ac.una.controller.EvaluatedDto;
import cr.ac.una.controller.EvaluationDto;

/**
 *
 * @author estebannajera
 */
public class EvaluatedWrapper {

    private UserDto evaluated;
    private Long id;
    private String finalCalification;
    private Long version;
    private EvaluationDto evaluationDto;

    public EvaluatedWrapper(UserDto evaluated) {
        this.evaluated = evaluated;
    }

    public EvaluatedWrapper(EvaluatedDto evaluated) {
        this.evaluated = null;
        this.finalCalification = evaluated.getFinalNote();
        this.id = evaluated.getId();
        this.version = evaluated.getVersion();
        this.evaluationDto = null;
    }

    public EvaluatedDto getDto() {
        EvaluatedDto evaluatedDto = new EvaluatedDto();
        evaluatedDto.setEvaluated(evaluated);
        evaluatedDto.setEvaluation(evaluationDto);
        evaluatedDto.setId(id);
        evaluatedDto.setVersion(version);
        evaluatedDto.setFinalNote(finalCalification);
        return evaluatedDto;
    }

    public void setEvaluated(UserDto evaluated) {
        this.evaluated = evaluated;
    }

    public void setEvaluationDto(EvaluationDto evaluationDto) {
        this.evaluationDto = evaluationDto;
    }

}
