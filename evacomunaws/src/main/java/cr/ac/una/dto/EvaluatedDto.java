package cr.ac.una.dto;

import java.util.List;
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
    private UserDto evaluated;
    private String finalNote;
    private List<FinalCalificationDto> finalCalifications;
    private List<EvaluatorDto> evaluators;
    private EvaluationDto evaluation;
    private Long version;

    /**
     * @param entity constructor from a entity to dto
     */
    public EvaluatedDto(Evaluated evaluated) {
        this.id = evaluated.getId();
        this.finalNote = evaluated.getFinalNote();
        this.version = evaluated.getVersion();
    }
}