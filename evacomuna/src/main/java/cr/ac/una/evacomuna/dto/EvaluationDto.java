package cr.ac.una.evacomuna.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * FIXME: Equals and Hash
 * 
 * @author estebannajera
 * @author arayaroma
 */
public class EvaluationDto {

    private Long id;
    private String name;
    private LocalDate applicationDate;
    private LocalDate initialPeriod;
    private LocalDate finalPeriod;
    private String state;
    private List<EvaluatedDto> evaluated;
    private Long version;

    public EvaluationDto() {
    }

    public EvaluationDto(Long id, String name, LocalDate applicationDate, LocalDate InitialPeriod,
            LocalDate finalPeriod, String state) {
        this.id = id;
        this.name = name;
        this.applicationDate = applicationDate;
        this.initialPeriod = InitialPeriod;
        this.finalPeriod = finalPeriod;
        this.state = state;
        this.evaluated = new ArrayList<>();
    }

    public EvaluationDto(cr.ac.una.controller.EvaluationDto evaluationDto) {
        this.id = evaluationDto.getId();
        this.name = evaluationDto.getName();
        this.applicationDate = LocalDate.parse(evaluationDto.getApplicationDate());
        this.initialPeriod = LocalDate.parse(evaluationDto.getInitialPeriod());
        this.finalPeriod = LocalDate.parse(evaluationDto.getFinalPeriod());
        this.state = evaluationDto.getState();
        this.evaluated = new ArrayList<>();
    }

    public cr.ac.una.controller.EvaluationDto getDto() {
        cr.ac.una.controller.EvaluationDto evaluationDto = new cr.ac.una.controller.EvaluationDto();
        evaluationDto.setApplicationDate(this.applicationDate.toString());
        evaluationDto.setFinalPeriod(this.finalPeriod.toString());
        evaluationDto.setInitialPeriod(this.initialPeriod.toString());
        evaluationDto.setName(this.name);
        evaluationDto.setState(this.state);
        evaluationDto.setId(this.id);
        return evaluationDto;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getApplicationDate() {
        return this.applicationDate;
    }

    public void setApplicationDate(LocalDate applicationDate) {
        this.applicationDate = applicationDate;
    }

    public LocalDate getInitialPeriod() {
        return this.initialPeriod;
    }

    public void setInitialPeriod(LocalDate initialPeriod) {
        this.initialPeriod = initialPeriod;
    }

    public LocalDate getFinalPeriod() {
        return this.finalPeriod;
    }

    public void setFinalPeriod(LocalDate finalPeriod) {
        this.finalPeriod = finalPeriod;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<EvaluatedDto> getEvaluated() {
        return evaluated;
    }

    public void setEvaluated(List<EvaluatedDto> evaluated) {
        this.evaluated = evaluated;
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
                ", name='" + getName() + "'" +
                ", applicationDate='" + getApplicationDate() + "'" +
                ", initialPeriod='" + getInitialPeriod() + "'" +
                ", finalPeriod='" + getFinalPeriod() + "'" +
                ", state='" + getState() + "'" +
                ", evaluated='" + getEvaluated() + "'" +
                ", version='" + getVersion() + "'" +
                "}";
    }

}
