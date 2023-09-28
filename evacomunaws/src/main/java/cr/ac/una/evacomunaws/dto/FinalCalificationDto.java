package cr.ac.una.dto;

import cr.ac.una.entities.Evaluated;
import cr.ac.una.entities.FinalCalification;
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
public class FinalCalificationDto implements DtoMapper<FinalCalification, FinalCalificationDto> {
    private Long id;
    private Long finalNote;
    private Long average;
    private EvaluatedDto evaluated;
    private SkillDto skill;
    private Long version;

    @Override
    public FinalCalificationDto convertFromEntityToDTO(FinalCalification entity,
            FinalCalificationDto dto) {
        dto.setEvaluated(new EvaluatedDto(entity.getEvaluated()));
        dto.setSkill(new SkillDto(entity.getSkill()));
        return dto;
    }

    @Override
    public FinalCalification convertFromDTOToEntity(FinalCalificationDto dto, FinalCalification entity) {
        entity.setEvaluated(new Evaluated(dto.getEvaluated()));
        entity.setSkill(new Skill(dto.getSkill()));
        return entity;
    }

    /**
     * Constructor from entity to dto
     * 
     * @param finalCalification entity to copy from
     */
    public FinalCalificationDto(FinalCalification finalCalification) {
        this.id = finalCalification.getId();
        this.finalNote = finalCalification.getFinalNote();
        this.average = finalCalification.getAverage();
        this.version = finalCalification.getVersion();
        this.evaluated = new EvaluatedDto();
        this.skill = new SkillDto();
    }

}
