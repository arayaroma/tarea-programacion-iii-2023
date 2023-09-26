package cr.ac.una.dto;

import cr.ac.una.entities.Calification;
import cr.ac.una.entities.Evaluator;
import cr.ac.una.entities.Skill;
<<<<<<< HEAD
import cr.ac.una.util.DtoMapper;
=======
import cr.ac.una.util.EntityMapper;
>>>>>>> f2b8918 ([update] load califications in pending evaluations controller)
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
<<<<<<< HEAD
public class CalificationDto implements DtoMapper<Calification, CalificationDto> {

=======
public class CalificationDto implements EntityMapper<Calification, CalificationDto> {
    
>>>>>>> f2b8918 ([update] load califications in pending evaluations controller)
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
<<<<<<< HEAD

=======
    
    @Override
    public CalificationDto convertFromEntityToDTO(Calification calification, CalificationDto calificationDto) {
        
        calificationDto.setEvaluator(new EvaluatorDto(calification.getEvaluator()));
        calificationDto.setSkill(new SkillDto(calification.getSkill()));
        return calificationDto;
    }
    
    @Override
    public Calification convertFromDTOToEntity(CalificationDto dto, Calification entity) {
        entity.setEvaluator(new Evaluator(dto.getEvaluator()));
        entity.setSkill(new Skill(dto.getSkill()));
        return entity;
    }
    
>>>>>>> f2b8918 ([update] load califications in pending evaluations controller)
}
