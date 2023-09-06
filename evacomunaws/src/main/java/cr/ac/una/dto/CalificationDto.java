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
    private SkillDto skill;
    private UserDto evaluator;
    private Long version;

    /**
     * @param calification constructor from entity to dto
     */
    public CalificationDto(Calification calification) {
        this.id = calification.getId();
        this.calification = calification.getCalification();
        this.version = calification.getVersion();
    }
}
