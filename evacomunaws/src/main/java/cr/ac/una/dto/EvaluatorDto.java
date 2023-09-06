package cr.ac.una.dto;

import cr.ac.una.entities.Evaluator;
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
public class EvaluatorDto {
    private Long id;
    private UserDto evaluator;
    private String role;
    private String feedback;
    private EvaluatedDto evaluated;
    private Long version;

    /**
     * @param entity update the entity with the dto
     */
    public EvaluatorDto(Evaluator entity) {
        this.id = entity.getId();
        this.role = entity.getRole();
        this.feedback = entity.getFeedback();
        this.version = entity.getVersion();
    }
}