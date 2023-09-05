package cr.ac.una.dto;

import cr.ac.una.entities.FinalCalification;
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
public class FinalCalificationDto {
    private Long id;
    private Long finalNote;
    private Long average;
    private EvaluatedDto evaluatedId;
    private SkillDto skillId;
    private Long version;

    /**
     * @param entity constructor from a entity to dto
     */
    public FinalCalificationDto(FinalCalification finalCalification) {
        this.id = finalCalification.getId();
        this.finalNote = finalCalification.getFinalNote();
        this.average = finalCalification.getAverage();
        this.evaluatedId = new EvaluatedDto(finalCalification.getEvaluatedId());
        this.skillId = new SkillDto(finalCalification.getSkillId());
        this.version = finalCalification.getVersion();
    }
}
