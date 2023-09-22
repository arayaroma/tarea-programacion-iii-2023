package cr.ac.una.dto;

import cr.ac.una.entities.Evaluated;
import java.util.ArrayList;
import java.util.List;
import cr.ac.una.entities.Evaluation;
import cr.ac.una.entities.User;
import cr.ac.una.util.EntityMapper;
import cr.ac.una.util.EntityUtil;
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
public class EvaluationDto implements EntityMapper<Evaluation, EvaluationDto> {

    private Long id;
    private String name;
    private String applicationDate;
    private String InitialPeriod;
    private String finalPeriod;
    private String state;
    private List<EvaluatedDto> evaluated;
    private Long version;

    /**
     * @param evaluation constructor from an entity to dto
     */
    public EvaluationDto(Evaluation evaluation) {
        this.id = evaluation.getId();
        this.name = evaluation.getName();
        this.applicationDate = evaluation.getApplicationDate().toString();
        this.InitialPeriod = evaluation.getInitialPeriod().toString();
        this.finalPeriod = evaluation.getFinalPeriod().toString();
        this.state = evaluation.getState();
        this.version = evaluation.getVersion();
        this.evaluated = new ArrayList<>();
    }

    @Override
    public EvaluationDto convertFromEntityToDTO(Evaluation entity, EvaluationDto dto) {
        dto.setEvaluated(EntityUtil.fromEntityList(entity.getEvaluated(), EvaluatedDto.class).getList());
        return dto;
    }

    @Override
    public Evaluation convertFromDTOToEntity(EvaluationDto dto, Evaluation entity) {
        entity.setEvaluated(EntityUtil.fromDtoList(dto.getEvaluated(), Evaluated.class).getList());
//        for (int i = 0; i < entity.getEvaluated().size(); i++) {
//            entity.getEvaluated().get(i).setEvaluated(new User(dto.getEvaluated().get(i).getEvaluated()));
//            //entity.getEvaluated().get(i).setEvaluation(new Evaluation(dto.getEvaluated().get(i).getEvaluation()));
//        }
//        
        return entity;
    }

}
