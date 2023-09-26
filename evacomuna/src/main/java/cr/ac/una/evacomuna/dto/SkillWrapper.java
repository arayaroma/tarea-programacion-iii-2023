package cr.ac.una.evacomuna.dto;

import cr.ac.una.controller.SkillDto;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

/**
 *
 * @author estebannajera
 */
public class SkillWrapper extends Pane {
    
    private String name;
    private String state;
    private Long ID;
    private Long version;
    
    public SkillWrapper() {
    }
    
    public SkillWrapper(SkillDto skillDto) {
        this.name = skillDto.getName();
        this.state = skillDto.getState();
        this.ID = skillDto.getId();
        this.version = skillDto.getVersion();
    }
    
    public SkillWrapper(String name) {
        this.name = name;
    }
    
    public SkillDto getDto() {
        SkillDto dto = new SkillDto();
        dto.setName(this.name);
        dto.setState(this.state);
        dto.setId(this.ID);
        dto.setVersion(this.version);
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
