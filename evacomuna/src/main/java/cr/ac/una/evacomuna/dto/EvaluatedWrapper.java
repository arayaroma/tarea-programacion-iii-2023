package cr.ac.una.evacomuna.dto;

import cr.ac.una.controller.UserDto;

import java.util.List;
import java.util.stream.Collectors;

import cr.ac.una.controller.EvaluatedDto;
import cr.ac.una.controller.EvaluationDto;
import cr.ac.una.controller.EvaluatorDto;
import cr.ac.una.controller.FinalCalificationDto;

/**
 *
 * @author estebannajera
 * @author arayaroma
 */
public class EvaluatedWrapper {

    private Long id;
    private UserDto evaluated;
    private String finalNote;
    private EvaluationDto evaluationDto;
    private List<EvaluatorDto> evaluators;
    private List<FinalCalificationDto> finalCalifications;
    private Long version;

    public EvaluatedWrapper(UserDto evaluated) {
        this.evaluated = evaluated;
    }

    public EvaluatedWrapper(EvaluatedDto evaluated) {
        this.evaluated = null;
        this.finalNote = evaluated.getFinalNote();
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
        evaluatedDto.setFinalNote(finalNote);
        return evaluatedDto;
    }

    public void setEvaluated(UserDto evaluated) {
        this.evaluated = evaluated;
    }

    public void setEvaluationDto(EvaluationDto evaluationDto) {
        this.evaluationDto = evaluationDto;
    }

    public List<EvaluatedWrapper> getAllEvaluated(List<EvaluatedDto> evaluated) {
        return evaluated
                .stream()
                .map(e -> new EvaluatedWrapper(e))
                .collect(Collectors.toList());
    }

}
