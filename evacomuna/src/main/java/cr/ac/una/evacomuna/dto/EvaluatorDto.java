package cr.ac.una.evacomuna.dto;

import java.util.ArrayList;
import java.util.List;

import cr.ac.una.evacomuna.util.DtoMapper;

/**
 *
 * @author estebannajera
 * @author arayaroma
 */
public class EvaluatorDto implements DtoMapper<cr.ac.una.evacomunaws.controller.EvaluatorDto, EvaluatorDto> {

    private Long id;
    private UserDto evaluator;
    private String role;
    private String feedback;
    private EvaluatedDto evaluated;
    private Long version;
    private List<CalificationDto> califications;

    @Override
    public EvaluatorDto convertFromGeneratedToDTO(cr.ac.una.evacomunaws.controller.EvaluatorDto generated, EvaluatorDto dto) {
        dto.setEvaluator(new UserDto(generated.getEvaluator()));
        dto.setEvaluated(new EvaluatedDto(generated.getEvaluated()));
        return dto;
    }

    @Override
    public cr.ac.una.evacomunaws.controller.EvaluatorDto convertFromDTOToGenerated(EvaluatorDto dto, cr.ac.una.evacomunaws.controller.EvaluatorDto generated) {
        generated.setEvaluator(dto.getEvaluator().getDto());
        generated.setEvaluated(dto.getEvaluated().getDto());
        return generated;
    }

    public EvaluatorDto() {
    }

    public EvaluatorDto(UserDto evaluator) {
        this.evaluator = evaluator;
    }

    public EvaluatorDto(cr.ac.una.evacomunaws.controller.EvaluatorDto evaluatorDto) {
        //    if (evaluatorDto != null) {
        this.id = evaluatorDto.getId();
//        this.evaluator = new UserDto();
        this.role = evaluatorDto.getRole();
        this.feedback = evaluatorDto.getFeedback();
//        this.evaluated = new EvaluatedDto();
        this.version = evaluatorDto.getVersion();
        this.califications = new ArrayList<>();
        //}
    }

    public EvaluatorDto(cr.ac.una.evacomunaws.controller.UserDto t) {
    }

    public cr.ac.una.evacomunaws.controller.EvaluatorDto getDto() {
        cr.ac.una.evacomunaws.controller.EvaluatorDto evaluatorDto = new cr.ac.una.evacomunaws.controller.EvaluatorDto();
        evaluatorDto.setId(this.id);
        //evaluatorDto.setEvaluator(this.evaluator.getDto());
        evaluatorDto.setRole(this.role);
        evaluatorDto.setFeedback(this.feedback);
        //evaluatorDto.setEvaluated(this.evaluated.getDto());
        evaluatorDto.setVersion(this.version);
        return evaluatorDto;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserDto getEvaluator() {
        return this.evaluator;
    }

    public void setEvaluator(UserDto evaluator) {
        this.evaluator = evaluator;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getFeedback() {
        return this.feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public EvaluatedDto getEvaluated() {
        return this.evaluated;
    }

    public void setEvaluated(EvaluatedDto evaluated) {
        this.evaluated = evaluated;
    }

    public Long getVersion() {
        return this.version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public List<CalificationDto> getCalifications() {
        return this.califications;
    }

    public void setCalifications(List<CalificationDto> califications) {
        this.califications = califications;
    }

    @Override
    public String toString() {
        return "{"
                + " id='" + getId() + "'"
                + ", evaluator='" + getEvaluator() + "'"
                + ", role='" + getRole() + "'"
                + ", feedback='" + getFeedback() + "'"
                + ", evaluated='" + getEvaluated() + "'"
                + ", version='" + getVersion() + "'"
                + ", califications='" + getCalifications() + "'"
                + "}";
    }

}
