package cr.ac.una.evacomuna.dto;

import cr.ac.una.controller.EvaluatedDto;
import cr.ac.una.controller.EvaluationDto;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author estebannajera
 */
public class EvaluationWrapper {

    private Long id;
    private String name;
    private LocalDate applicationDate;
    private LocalDate initialPeriod;
    private LocalDate finalPeriod;
    private String state;
    private List<EvaluatedDto> evaluated;

    public EvaluationWrapper(Long id, String name, LocalDate applicationDate, LocalDate InitialPeriod, LocalDate finalPeriod, String state) {
        this.id = id;
        this.name = name;
        this.applicationDate = applicationDate;
        this.initialPeriod = InitialPeriod;
        this.finalPeriod = finalPeriod;
        this.state = state;
        this.evaluated = new ArrayList<>();
    }

    public EvaluationDto getDto() {
        EvaluationDto evaluationDto = new EvaluationDto();
        evaluationDto.setApplicationDate(this.applicationDate.toString());
        evaluationDto.setFinalPeriod(this.finalPeriod.toString());
        evaluationDto.setInitialPeriod(this.initialPeriod.toString());
        evaluationDto.setName(this.name);
        evaluationDto.setState(this.state);
        evaluationDto.setId(this.id);
        return evaluationDto;
    }

    public List<EvaluatedDto> getEvaluated() {
        return evaluated;
    }

    public void setEvaluated(List<EvaluatedDto> evaluated) {
        this.evaluated = evaluated;
    }

}
