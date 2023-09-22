package cr.ac.una.dto;

import cr.ac.una.entities.Calification;
import cr.ac.una.entities.Evaluated;
import cr.ac.una.entities.Evaluator;
import cr.ac.una.entities.User;
import cr.ac.una.util.EntityMapper;
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
public class EvaluatorDto implements EntityMapper<Evaluator, EvaluatorDto> {

    private Long id;
    private UserDto evaluator;
    private String role;
    private String feedback;
    private EvaluatedDto evaluated;
    private Long version;
    private List<Calification> califications;

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
        dto.setEvaluated(new EvaluatedDto(entity.getEvaluated()));
        return dto;
    }

    @Override
    public Evaluator convertFromDTOToEntity(EvaluatorDto dto, Evaluator entity) {
        entity.setEvaluated(new Evaluated(dto.getEvaluated()));
        //entity.getEvaluated().setEvaluated(new User(dto.getEvaluated().getEvaluated()));
        entity.setEvaluator(new User(dto.getEvaluator()));
//        entity.setEvaluator(new User(dto.getEvaluator()));
        //  entity.setCalifications(EntityUtil.fromDtoList(dto.getCalifications(), Calification.class).getList());
        return entity;
    }
}
