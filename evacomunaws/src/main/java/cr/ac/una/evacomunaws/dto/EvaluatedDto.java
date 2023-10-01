package cr.ac.una.evacomunaws.dto;

import java.util.ArrayList;
import java.util.List;
import cr.ac.una.evacomunaws.entities.Evaluated;
import cr.ac.una.evacomunaws.entities.Evaluation;
import cr.ac.una.evacomunaws.entities.User;
import cr.ac.una.evacomunaws.util.DtoMapper;
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
public class EvaluatedDto implements DtoMapper<Evaluated, EvaluatedDto> {

    private Long id;
    private UserDto evaluated;
    private String finalNote;
    private List<FinalCalificationDto> finalCalifications;
    private List<EvaluatorDto> evaluators;
    private EvaluationDto evaluation;
    private Long version;

    /**
     * @param evaluated constructor from an entity to dto
     */
    public EvaluatedDto(Evaluated evaluated) {
        this.id = evaluated.getId();
        this.finalNote = evaluated.getFinalNote();
        this.version = evaluated.getVersion();
        this.finalCalifications = new ArrayList<>();
        this.evaluators = new ArrayList<>();
    }

    @Override
    public EvaluatedDto convertFromEntityToDTO(Evaluated entity, EvaluatedDto dto) {
        dto.setEvaluated(new UserDto(entity.getEvaluated()));
        dto.setEvaluation(new EvaluationDto(entity.getEvaluation()));
        dto.setEvaluators(DtoMapper.fromEntityList(entity.getEvaluators(), EvaluatorDto.class).getList());

        dto.setFinalCalifications(
                DtoMapper.fromEntityList(entity.getFinalCalifications(), FinalCalificationDto.class).getList());
        for (int i = 0; i < dto.getEvaluators().size(); i++) {
            dto.getEvaluators().get(i).setCalifications(
                    DtoMapper.fromEntityList(entity.getEvaluators().get(i).getCalifications(), CalificationDto.class).getList());
        }
        if (dto.getFinalCalifications() != null) {
            for (int i = 0; i < dto.getFinalCalifications().size(); i++) {
                dto.getFinalCalifications()
                        .get(i)
                        .setSkill(new SkillDto(entity
                                .getFinalCalifications()
                                .get(i).getSkill()));
            }
        }
        return dto;
    }

    @Override
    public Evaluated convertFromDTOToEntity(EvaluatedDto dto, Evaluated entity) {
        entity.setEvaluated(new User(dto.getEvaluated()));
        entity.setEvaluation(new Evaluation(dto.getEvaluation()));
        return entity;

    }

}
