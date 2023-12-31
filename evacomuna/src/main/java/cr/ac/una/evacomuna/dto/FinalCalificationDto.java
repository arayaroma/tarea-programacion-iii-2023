package cr.ac.una.evacomuna.dto;

import cr.ac.una.evacomuna.util.DtoMapper;
import javafx.scene.Node;
import javafx.scene.layout.HBox;

/**
 * 
 * @author arayaroma
 */
public class FinalCalificationDto extends HBox
        implements DtoMapper<cr.ac.una.evacomunaws.controller.FinalCalificationDto, FinalCalificationDto> {

    private Long id;
    private Long finalNote;
    private Long average;
    private EvaluatedDto evaluated;
    private SkillDto skill;
    private Long version;
    private Node data;
    private HBox container;

    @Override
    public FinalCalificationDto convertFromGeneratedToDTO(
            cr.ac.una.evacomunaws.controller.FinalCalificationDto generated,
            FinalCalificationDto dto) {
        dto.setEvaluated(new EvaluatedDto(generated.getEvaluated()));
        dto.setSkill(new SkillDto(generated.getSkill()));
        return dto;
    }

    @Override
    public cr.ac.una.evacomunaws.controller.FinalCalificationDto convertFromDTOToGenerated(FinalCalificationDto dto,
            cr.ac.una.evacomunaws.controller.FinalCalificationDto generated) {
        generated.setEvaluated(dto.getEvaluated().getDto());
        generated.setSkill(dto.getSkill().getDto());
        return generated;
    }

    public FinalCalificationDto() {
    }

    public FinalCalificationDto(cr.ac.una.evacomunaws.controller.FinalCalificationDto finalCalificationDto) {
        this.id = finalCalificationDto.getId();
        this.finalNote = finalCalificationDto.getFinalNote();
        this.average = finalCalificationDto.getAverage();
        this.version = finalCalificationDto.getVersion();
    }

    public cr.ac.una.evacomunaws.controller.FinalCalificationDto getDto() {
        cr.ac.una.evacomunaws.controller.FinalCalificationDto dto = new cr.ac.una.evacomunaws.controller.FinalCalificationDto();
        dto.setId(this.id);
        dto.setFinalNote(this.finalNote);
        dto.setAverage(this.average);
        dto.setVersion(this.version);
        return dto;
    }

    public Long getID() {
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

    public Node getData() {
        return this.data;
    }

    public void setData(Node data) {
        this.data = data;
    }

    public HBox getContainer() {
        return this.container;
    }

    public void setContainer(HBox container) {
        this.container = container;
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
