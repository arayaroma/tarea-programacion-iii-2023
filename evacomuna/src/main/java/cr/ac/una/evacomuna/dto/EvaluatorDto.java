package cr.ac.una.evacomuna.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * FIXME: Equals and Hash
 * 
 * @author estebannajera
 * @author arayaroma
 */
public class EvaluatorDto {

    private Long id;
    private UserDto evaluator;
    private String role;
    private String feedback;
    private EvaluatedDto evaluated;
    private Long version;
    private List<CalificationDto> califications;

    public EvaluatorDto() {
    }

    public EvaluatorDto(UserDto evaluator) {
        this.evaluator = evaluator;
    }

    public EvaluatorDto(cr.ac.una.controller.EvaluatorDto evaluatorDto) {
        this.id = evaluatorDto.getId();
        this.evaluator = new UserDto();
        this.role = evaluatorDto.getRole();
        this.feedback = evaluatorDto.getFeedback();
        this.evaluated = new EvaluatedDto();
        this.version = evaluatorDto.getVersion();
        this.califications = new ArrayList<>();
    }

    public EvaluatorDto(cr.ac.una.controller.UserDto t) {
    }

    public cr.ac.una.controller.EvaluatorDto getDto() {
        cr.ac.una.controller.EvaluatorDto evaluatorDto = new cr.ac.una.controller.EvaluatorDto();
        evaluatorDto.setId(id);
        evaluatorDto.setEvaluator(new cr.ac.una.controller.UserDto());
        evaluatorDto.setRole(role);
        evaluatorDto.setFeedback(feedback);
        evaluatorDto.setEvaluated(new cr.ac.una.controller.EvaluatedDto());
        evaluatorDto.setVersion(version);
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
        return "{" +
                " id='" + getId() + "'" +
                ", evaluator='" + getEvaluator() + "'" +
                ", role='" + getRole() + "'" +
                ", feedback='" + getFeedback() + "'" +
                ", evaluated='" + getEvaluated() + "'" +
                ", version='" + getVersion() + "'" +
                ", califications='" + getCalifications() + "'" +
                "}";
    }

}
