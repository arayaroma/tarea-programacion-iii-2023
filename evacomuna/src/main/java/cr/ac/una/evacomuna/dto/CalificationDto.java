package cr.ac.una.evacomuna.dto;

import javafx.scene.Node;
import javafx.scene.layout.Pane;

/**
 * FIXME: Equals and Hash
 * 
 * @author estebannajera
 * @author arayaroma
 */
public class CalificationDto extends Pane {

    private Long id;
    private String calification;
    private SkillDto skill;
    private EvaluatorDto evaluator;
    private Long version;
    private int x;
    private int y;
    private Node data;

    public CalificationDto() {
    }

    public CalificationDto(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public CalificationDto(int x, int y, Node data) {
        this.x = x;
        this.y = y;
        this.data = data;
    }

    public CalificationDto(cr.ac.una.controller.CalificationDto calificationDto) {
        this.id = calificationDto.getId();
        this.calification = calificationDto.getCalification();
        this.skill = new SkillDto();
        this.evaluator = new EvaluatorDto();
        this.version = calificationDto.getVersion();
    }

    public Long getID() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCalification() {
        return this.calification;
    }

    public void setCalification(String calification) {
        this.calification = calification;
    }

    public SkillDto getSkill() {
        return this.skill;
    }

    public void setSkill(SkillDto skill) {
        this.skill = skill;
    }

    public EvaluatorDto getEvaluator() {
        return this.evaluator;
    }

    public void setEvaluator(EvaluatorDto evaluator) {
        this.evaluator = evaluator;
    }

    public Long getVersion() {
        return this.version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Node getData() {
        return this.data;
    }

    public void setData(Node data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", calification='" + getCalification() + "'" +
                ", skill='" + getSkill() + "'" +
                ", evaluator='" + getEvaluator() + "'" +
                ", version='" + getVersion() + "'" +
                ", x='" + getX() + "'" +
                ", y='" + getY() + "'" +
                ", data='" + getData() + "'" +
                "}";
    }

}
