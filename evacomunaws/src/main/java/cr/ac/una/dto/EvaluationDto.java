package cr.ac.una.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
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
    private LocalDate applicationDate;
    private LocalDate InitialPeriod;
    private LocalDate finalPeriod;
    private String state;
    private List<EvaluatedDto> evaluatedList;
    private Long version;

    /**
     * @param entity constructor from a entity to dto
     */
    public EvaluationDto(Evaluation evaluation) {
        this.id = evaluation.getId();
        this.name = evaluation.getName();
        this.applicationDate = evaluation.getApplicationDate();
        this.InitialPeriod = evaluation.getInitialPeriod();
        this.finalPeriod = evaluation.getFinalPeriod();
        this.state = evaluation.getState();
        this.evaluatedList = evaluation.getEvaluatedList() != null
                ? evaluation.getEvaluatedList()
                        .stream()
                        .map(evaluated -> new EvaluatedDto(evaluated))
                        .collect(Collectors.toList())
                : null;
        this.version = evaluation.getVersion();
    }
}
