package cr.ac.una.evacomuna.dto;

import cr.ac.una.controller.CalificationDto;
import cr.ac.una.controller.EvaluatorDto;
import cr.ac.una.controller.SkillDto;
import cr.ac.una.evacomuna.util.CalificationCode;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

/**
 *
 * @author estebannajera
 */
public class CalificationWrapper extends Pane {

    private int x;
    private int y;
    private Node data;
    private String calification;
    private Long id;
    private Long version;
    private SkillDto skillDto;
    private EvaluatorDto evaluatorDto;

    public CalificationWrapper(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public CalificationWrapper(CalificationDto calificationDto) {
        this.id = calificationDto.getId();
        this.evaluatorDto = calificationDto.getEvaluator();
        this.skillDto = calificationDto.getSkill();
        this.version = calificationDto.getVersion();
        this.calification = getCalificationString(calificationDto.getCalification());

    }

    public CalificationDto getDto() {
        CalificationDto calificationDto = new CalificationDto();
        calificationDto.setCalification(getCalificationCode(calification));
        calificationDto.setEvaluator(evaluatorDto);
        calificationDto.setId(id);
        calificationDto.setSkill(skillDto);
        calificationDto.setVersion(version);
//        calificationDto.setCalification(calification);
        return calificationDto;
    }

    public Long getCalificationCode(String calification) {
        if (calification.toUpperCase().equals("EXCEPTIONAL")) {
            return CalificationCode.EXCEPTIONAL.getCode();
        }
        if (calification.toUpperCase().equals("ABOVE EXPECTATIONS")) {
            return CalificationCode.ABOVE_EXPECTATIONS.getCode();
        }
        if (calification.toUpperCase().equals("EXPECTATIONS")) {
            return CalificationCode.EXPECTATIONS.getCode();
        }
        if (calification.toUpperCase().equals("UNDER EXPECTATIONS")) {
            return CalificationCode.UNDER_EXPECTATIONS.getCode();
        }
        return Long.valueOf(-1);
    }

    public String getCalificationString(Long code) {
        if (code == CalificationCode.EXCEPTIONAL.getCode()) {
            return "Exceptional";
        }
        if (code == CalificationCode.UNDER_EXPECTATIONS.getCode()) {
            return "Under Expectations";
        }
        if (code == CalificationCode.ABOVE_EXPECTATIONS.getCode()) {
            return "Above Expectations";
        }
        if (code == CalificationCode.EXPECTATIONS.getCode()) {
            return "Expectations";
        }
        return "";
    }

    public SkillDto getSkillDto() {
        return skillDto;
    }

    public String getCalification() {
        return calification;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public void setSkillDto(SkillDto skillDto) {
        this.skillDto = skillDto;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setEvaluatorDto(EvaluatorDto evaluatorDto) {
        this.evaluatorDto = evaluatorDto;
    }

    public void setCalification(String calification) {
        this.calification = calification;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

    public void setData(Node data) {
        this.data = data;
    }

    public Node getData() {
        return data;
    }

    public CalificationWrapper(int x, int y, Node data) {
        this.x = x;
        this.y = y;
        this.data = data;
    }

}
