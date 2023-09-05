package cr.ac.una.dto;

import cr.ac.una.entities.Calification;
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
public class CalificationDto {

    private Long id;
    private String calification;
    private SkillDto skillId;
    private UserDto evaluatorId;
    private Long version;

    /**
     * @param calification constructor from entity to dto
     */
    public CalificationDto(Calification calification) {
        this.id = calification.getId();
        this.calification = calification.getCalification();
        this.skillId = calification.getSkillId() != null
                ? new SkillDto(calification.getSkillId())
                : null;
        this.evaluatorId = calification.getEvaluatorId() != null
                ? new UserDto(calification.getEvaluatorId())
                : null;
        this.version = calification.getVersion();
    }
}
