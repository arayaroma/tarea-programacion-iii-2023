package cr.ac.una.evacomuna.dto;

/**
 * FIXME: Equals and Hash
 * 
 * @author arayaroma
 */
public class FinalCalificationDto {

    private Long id;
    private Long finalNote;
    private Long average;
    private EvaluatedDto evaluated;
    private SkillDto skill;
    private Long version;

    public FinalCalificationDto() {
    }

    public FinalCalificationDto(cr.ac.una.controller.FinalCalificationDto finalCalificationDto) {
        this.id = finalCalificationDto.getId();
        this.finalNote = finalCalificationDto.getFinalNote();
        this.average = finalCalificationDto.getAverage();
        this.evaluated = new EvaluatedDto();
        this.skill = new SkillDto();
        this.version = finalCalificationDto.getVersion();
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFinalNote() {
        return this.finalNote;
    }

    public void setFinalNote(Long finalNote) {
        this.finalNote = finalNote;
    }

    public Long getAverage() {
        return this.average;
    }

    public void setAverage(Long average) {
        this.average = average;
    }

    public EvaluatedDto getEvaluated() {
        return this.evaluated;
    }

    public void setEvaluated(EvaluatedDto evaluated) {
        this.evaluated = evaluated;
    }

    public SkillDto getSkill() {
        return this.skill;
    }

    public void setSkill(SkillDto skill) {
        this.skill = skill;
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
                ", finalNote='" + getFinalNote() + "'" +
                ", average='" + getAverage() + "'" +
                ", evaluated='" + getEvaluated() + "'" +
                ", skill='" + getSkill() + "'" +
                ", version='" + getVersion() + "'" +
                "}";
    }

}
