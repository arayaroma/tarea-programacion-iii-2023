package cr.ac.una.dto;

import java.util.List;
import java.util.stream.Collectors;
import cr.ac.una.entities.Evaluated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author arayaroma
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EvaluatedDto {
    private Long id;
    private UserDto evaluatedId;
    private String finalNote;
    private List<FinalCalificationDto> finalCalifications;
    private List<EvaluatorDto> evaluators;
    private EvaluationDto evaluationId;
    private Long version;

    /**
     * @param entity constructor from a entity to dto
     */
    public EvaluatedDto(Evaluated evaluated) {
        this.id = evaluated.getId();
        this.evaluatedId = new UserDto(evaluated.getEvaluatedId());
        this.finalNote = evaluated.getFinalNote();
        this.evaluationId = new EvaluationDto(evaluated.getEvaluationId());
        this.finalCalifications = evaluated.getFinalCalifications()
                .stream()
                .map(finalCalificationDto -> new FinalCalificationDto(finalCalificationDto))
                .collect(Collectors.toList());
        this.evaluators = evaluated.getEvaluators()
                .stream()
                .map(evaluatorDto -> new EvaluatorDto(evaluatorDto))
                .collect(Collectors.toList());
        this.version = evaluated.getVersion();
    }
}