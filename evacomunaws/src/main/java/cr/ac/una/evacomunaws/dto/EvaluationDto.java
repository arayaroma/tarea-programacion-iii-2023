package cr.ac.una.evacomunaws.dto;

import java.util.ArrayList;
import java.util.List;
import cr.ac.una.evacomunaws.entities.Evaluated;
import cr.ac.una.evacomunaws.entities.Evaluation;
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
                dto.getEvaluated()
                        .get(i).setEvaluated(new UserDto(entity.getEvaluated().get(i).getEvaluated()));
                dto.getEvaluated()
                        .get(i).setFinalCalifications(DtoMapper.fromEntityList(entity.getEvaluated()
                        .get(i).getFinalCalifications(), FinalCalificationDto.class).getList());
                if (dto.getEvaluated().get(i).getFinalCalifications() != null) {
                    for (int j = 0; j < dto.getEvaluated().get(i).getFinalCalifications().size(); j++) {
                        dto.getEvaluated().get(i).getFinalCalifications().get(j).setSkill(new SkillDto(entity.getEvaluated().get(i).getFinalCalifications().get(j).getSkill()));
                    }
                }
                dto.getEvaluated()
                        .get(i)
                        .setEvaluators(DtoMapper
                                .fromEntityList(entity.getEvaluated()
                                        .get(i).getEvaluators(), EvaluatorDto.class)
                                .getList());

                if (dto.getEvaluated().get(i).getEvaluators() != null) {
                    for (int j = 0; j < dto.getEvaluated().get(i).getEvaluators().size(); j++) {
                        dto.getEvaluated()
                                .get(i).getEvaluators()
                                .get(j).setEvaluator(
                                new UserDto(
                                        entity.getEvaluated()
                                                .get(i).getEvaluators()
                                                .get(j).getEvaluator()));

                        dto.getEvaluated()
                                .get(i).getEvaluators()
                                .get(j).setCalifications(DtoMapper
                                .fromDtoList(
                                        entity.getEvaluated()
                                                .get(i).getEvaluators()
                                                .get(j).getCalifications(),
                                        CalificationDto.class)
                                .getList());

                        if (dto.getEvaluated().get(i).getEvaluators().get(j).getCalifications() != null) {
                            for (int k = 0; k < dto.getEvaluated().get(i).getEvaluators().get(j).getCalifications().size(); k++) {
                                dto.getEvaluated().get(i).getEvaluators().get(j).getCalifications().get(k)
                                        .setSkill(new SkillDto(entity.getEvaluated().get(i).getEvaluators().get(j)
                                                .getCalifications().get(k).getSkill()));
                                dto.getEvaluated().get(i).getEvaluators().get(j).getCalifications().get(k)
                                        .setEvaluator(new EvaluatorDto(entity.getEvaluated().get(i).getEvaluators().get(j)
                                                .getCalifications().get(k).getEvaluator()));
                            }
                        }
                    }
                }

                dto.getEvaluated()
                        .get(i).getEvaluated()
                        .setPosition(new PositionDto(entity.getEvaluated()
                                .get(i).getEvaluated().getPosition()));
            }
        }
        return dto;
    }

    @Override
    public Evaluation convertFromDTOToEntity(EvaluationDto dto, Evaluation entity) {
        entity.setEvaluated(DtoMapper.fromDtoList(dto.getEvaluated(), Evaluated.class).getList());
        return entity;
    }

}
