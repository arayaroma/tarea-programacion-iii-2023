package cr.ac.una.evacomunaws.dto;
<<<<<<< HEAD

import cr.ac.una.evacomunaws.entities.Evaluated;
import cr.ac.una.evacomunaws.entities.Evaluator;
import cr.ac.una.evacomunaws.entities.User;
import cr.ac.una.evacomunaws.util.DtoMapper;

=======

import cr.ac.una.evacomunaws.entities.Evaluated;
import cr.ac.una.evacomunaws.entities.Evaluator;
import cr.ac.una.evacomunaws.entities.User;
import cr.ac.una.evacomunaws.util.DtoMapper;
>>>>>>> 29c7236 ([FIXING] cr.ac.una.evacomunaws import to ALL CLASSES)
import java.util.List;
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
public class EvaluatorDto implements DtoMapper<Evaluator, EvaluatorDto> {

    private Long id;
    private UserDto evaluator;
    private String role;
    private String feedback;
    private EvaluatedDto evaluated;
    private Long version;
    private List<CalificationDto> califications;

    /**
     * @param entity update the entity with the dto
     */
    public EvaluatorDto(Evaluator entity) {
        this.id = entity.getId();
        this.role = entity.getRole();
        this.feedback = entity.getFeedback();
        this.version = entity.getVersion();
    }

    @Override
    public EvaluatorDto convertFromEntityToDTO(Evaluator entity, EvaluatorDto dto) {
        dto.setEvaluator(new UserDto(entity.getEvaluator()));
        dto.setCalifications(DtoMapper.fromEntityList(entity.getCalifications(), CalificationDto.class).getList());
        
        dto.setEvaluated(new EvaluatedDto(entity.getEvaluated()));
        return dto;
    }

    @Override
    public Evaluator convertFromDTOToEntity(EvaluatorDto dto, Evaluator entity) {
        entity.setEvaluated(new Evaluated(dto.getEvaluated()));
        entity.setEvaluator(new User(dto.getEvaluator()));
        return entity;
    }
}
