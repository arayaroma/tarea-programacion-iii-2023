package cr.ac.una.dto;

import cr.ac.una.entities.Evaluated;
import java.util.ArrayList;
import java.util.List;
import cr.ac.una.entities.Evaluation;
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
public class EvaluationDto implements DtoMapper<Evaluation, EvaluationDto> {

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
        dto.setEvaluated(DtoMapper.fromEntityList(entity.getEvaluated(), EvaluatedDto.class).getList());
        if (dto.getEvaluated() != null) {
            for (int i = 0; i < dto.getEvaluated().size(); i++) {
                dto.getEvaluated().get(i).setEvaluated(new UserDto(entity.getEvaluated().get(i).getEvaluated()));
                dto.getEvaluated().get(i).setEvaluators(DtoMapper
                        .fromEntityList(entity.getEvaluated().get(i).getEvaluators(), EvaluatorDto.class).getList());
                if (dto.getEvaluated().get(i).getEvaluators() != null) {
                    for (int j = 0; j < dto.getEvaluated().get(i).getEvaluators().size(); j++) {
<<<<<<< HEAD
                        dto.getEvaluated().get(i).getEvaluators().get(j).setEvaluator(
                                new UserDto(entity.getEvaluated().get(i).getEvaluators().get(j).getEvaluator()));
=======
                        dto.getEvaluated().get(i).getEvaluators().get(j).setEvaluator(new UserDto(entity.getEvaluated().get(i).getEvaluators().get(j).getEvaluator()));
                        dto.getEvaluated().get(i).getEvaluators().get(j).setCalifications(EntityUtil.fromDtoList(entity.getEvaluated().get(i).getEvaluators().get(j).getCalifications(), CalificationDto.class).getList());
                        if (dto.getEvaluated().get(i).getEvaluators().get(j).getCalifications() != null) {
                            for (int k = 0; k < dto.getEvaluated().get(i).getEvaluators().get(j).getCalifications().size(); k++) {
                                dto.getEvaluated().get(i).getEvaluators().get(j).getCalifications().get(k).setSkill(new SkillDto(entity.getEvaluated().get(i).getEvaluators().get(j).getCalifications().get(k).getSkill()));
                            }
                        }
>>>>>>> f2b8918 ([update] load califications in pending evaluations controller)
                    }
                }
                dto.getEvaluated().get(i).getEvaluated()
                        .setPosition(new PositionDto(entity.getEvaluated().get(i).getEvaluated().getPosition()));
            }

        }
        return dto;
    }

    @Override
    public Evaluation convertFromDTOToEntity(EvaluationDto dto, Evaluation entity) {
        entity.setEvaluated(DtoMapper.fromDtoList(dto.getEvaluated(), Evaluated.class).getList());
        // for (int i = 0; i < entity.getEvaluated().size(); i++) {
        // entity.getEvaluated().get(i).setEvaluated(new
        // User(dto.getEvaluated().get(i).getEvaluated()));
        // //entity.getEvaluated().get(i).setEvaluation(new
        // Evaluation(dto.getEvaluated().get(i).getEvaluation()));
        // }
        //
        return entity;
    }

}
