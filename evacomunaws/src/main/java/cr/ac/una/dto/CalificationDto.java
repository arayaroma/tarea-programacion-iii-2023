package cr.ac.una.dto;

import cr.ac.una.entities.Calification;
import cr.ac.una.entities.Evaluator;
import cr.ac.una.entities.Skill;
import cr.ac.una.util.DtoMapper;
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
public class CalificationDto implements DtoMapper<Calification, CalificationDto> {

    private Long id;
    private Long calification;
    private SkillDto skill;
    private EvaluatorDto evaluator;
    private Long version;

    @Override
    public CalificationDto convertFromEntityToDTO(Calification entity, CalificationDto dto) {
        dto.setEvaluator(new EvaluatorDto(entity.getEvaluator()));
        dto.setSkill(new SkillDto(entity.getSkill()));
        return dto;
    }

    @Override
    public Calification convertFromDTOToEntity(CalificationDto dto, Calification entity) {
        entity.setEvaluator(new Evaluator(dto.getEvaluator()));
        entity.setSkill(new Skill(dto.getSkill()));
        return entity;
    }

    /**
     * @param calification constructor from entity to dto
     */
    public CalificationDto(Calification calification) {
        this.id = calification.getId();
        this.calification = calification.getCalification();
        this.version = calification.getVersion();
    }
}
