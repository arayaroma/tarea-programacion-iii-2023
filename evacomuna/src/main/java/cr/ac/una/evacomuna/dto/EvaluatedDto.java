package cr.ac.una.evacomuna.dto;

import java.util.ArrayList;
import java.util.List;

import cr.ac.una.evacomuna.util.DtoMapper;

/**
 * 
 * @author estebannajera
 * @author arayaroma
 */
public class EvaluatedDto implements DtoMapper<cr.ac.una.evacomunaws.controller.EvaluatedDto, EvaluatedDto> {

    private Long id;
    private UserDto evaluated;
    private String finalNote;
    private List<FinalCalificationDto> finalCalifications;
    private List<EvaluatorDto> evaluators;
    private EvaluationDto evaluation;
    private Long version;

    @Override
    public EvaluatedDto convertFromGeneratedToDTO(cr.ac.una.evacomunaws.controller.EvaluatedDto generated,
            EvaluatedDto dto) {
        dto.setEvaluated(new UserDto(generated.getEvaluated()));
        dto.setEvaluation(new EvaluationDto(generated.getEvaluation()));

        dto.setFinalCalifications(
                DtoMapper.fromGeneratedList(generated.getFinalCalifications(), FinalCalificationDto.class).getList());

        return dto;
    }

    @Override
    public cr.ac.una.evacomunaws.controller.EvaluatedDto convertFromDTOToGenerated(EvaluatedDto dto,
            cr.ac.una.evacomunaws.controller.EvaluatedDto generated) {
        generated.setEvaluated(dto.getEvaluated().getDto());
        generated.setEvaluation(dto.getEvaluation().getDto());
        generated.getFinalCalifications()
                .addAll(DtoMapper
                        .fromDtoList(dto.getFinalCalifications(),
                                cr.ac.una.evacomunaws.controller.FinalCalificationDto.class)
                        .getList());
        return generated;
    }

    public EvaluatedDto() {
    }

    public EvaluatedDto(UserDto evaluated) {
        this.evaluated = evaluated;
    }

    public EvaluatedDto(cr.ac.una.evacomunaws.controller.EvaluatedDto evaluated) {
        this.id = evaluated.getId();
        this.evaluated = new UserDto();
        this.finalNote = evaluated.getFinalNote();
        this.evaluation = new EvaluationDto();
        this.evaluators = new ArrayList<>();
        this.finalCalifications = new ArrayList<>();
        this.version = evaluated.getVersion();
    }

    public EvaluatedDto(cr.ac.una.evacomunaws.controller.UserDto t) {
    }

    public cr.ac.una.evacomunaws.controller.EvaluatedDto getDto() {
        cr.ac.una.evacomunaws.controller.EvaluatedDto evaluatedDto = new cr.ac.una.evacomunaws.controller.EvaluatedDto();
        evaluatedDto.setId(id);
        evaluatedDto.setEvaluated(evaluated.getDto());
        evaluatedDto.setFinalNote(finalNote);
        evaluatedDto.setEvaluation(evaluation.getDto());
        evaluatedDto.setVersion(version);
        return evaluatedDto;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserDto getEvaluated() {
        return this.evaluated;
    }

    public void setEvaluated(UserDto evaluated) {
        this.evaluated = evaluated;
    }

    public String getFinalNote() {
        return this.finalNote;
    }

    public void setFinalNote(String finalNote) {
        this.finalNote = finalNote;
    }

    public List<FinalCalificationDto> getFinalCalifications() {
        return this.finalCalifications;
    }

    public void setFinalCalifications(List<FinalCalificationDto> finalCalifications) {
        this.finalCalifications = finalCalifications;
    }

    public List<EvaluatorDto> getEvaluators() {
        return this.evaluators;
    }

    public void setEvaluators(List<EvaluatorDto> evaluators) {
        this.evaluators = evaluators;
    }

    public EvaluationDto getEvaluation() {
        return this.evaluation;
    }

    public void setEvaluation(EvaluationDto evaluation) {
        this.evaluation = evaluation;
    }

    public Long getVersion() {
        return this.version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", evaluated='" + getEvaluated() + "'" +
                ", finalNote='" + getFinalNote() + "'" +
                ", finalCalifications='" + getFinalCalifications() + "'" +
                ", evaluators='" + getEvaluators() + "'" +
                ", evaluation='" + getEvaluation() + "'" +
                ", version='" + getVersion() + "'" +
                "}";
    }

}
