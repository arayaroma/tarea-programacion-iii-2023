package cr.ac.una.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import cr.ac.una.entities.Evaluation;
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
public class EvaluationDto {

    private Long id;
    private String name;
    private String applicationDate;
    private String InitialPeriod;
    private String finalPeriod;
    private String state;
    private List<EvaluatedDto> evaluated;
    private Long version;

    /**
     * @param evaluation constructor from an entity to dto
     */
    public EvaluationDto(Evaluation evaluation) {
        this.id = evaluation.getId();
        this.name = evaluation.getName();
        this.applicationDate = evaluation.getApplicationDate().toString();
        this.InitialPeriod = evaluation.getInitialPeriod().toString();
        this.finalPeriod = evaluation.getFinalPeriod().toString();
        this.state = evaluation.getState();
        this.version = evaluation.getVersion();
        this.evaluated = new ArrayList<>();
    }
}
