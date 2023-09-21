package cr.ac.una.evacomuna.dto;

import cr.ac.una.controller.SkillDto;
import javafx.scene.layout.Pane;

/**
 *
 * @author estebannajera
 */
public class SkillWrapper extends Pane{

    private String name;
    private String state;
    private Long ID;

    public SkillWrapper() {
    }

    public SkillWrapper(String name, String state, Long id) {
        this.name = name;
        this.state = state;
        this.ID = id;
    }
    public SkillWrapper(String name) {
        this.name = name;
    }

    public SkillDto getDto() {
        SkillDto dto = new SkillDto();
        dto.setName(this.name);
        dto.setState(this.state);
        dto.setId(this.ID);
        return dto;
    }

    public Long getID() {
        return ID;
    }


    public String getState() {
        return state;
    }

    public String getName() {
        return name;
    }

}
