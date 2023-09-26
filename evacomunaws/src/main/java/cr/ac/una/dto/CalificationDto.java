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
    private EvaluatorDto evaluator;
    private Long version;

    /**
     * @param calification constructor from entity to dto
     */
    public CalificationDto(Calification calification) {
        this.id = calification.getId();
        this.calification = calification.getCalification();
        this.version = calification.getVersion();
    }

    public CalificationDto convertFromEntityToDTO(Calification calification, CalificationDto calificationDto) {
        calificationDto.setId(calification.getId());
        calificationDto.setCalification(calification.getCalification());
        calificationDto.setVersion(calification.getVersion());
        calificationDto.setEvaluator(new EvaluatorDto(calification.getEvaluator()));
        calificationDto.setSkill(new SkillDto(calification.getSkill()));
        return calificationDto;
    }
}
