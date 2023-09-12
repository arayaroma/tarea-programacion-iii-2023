package cr.ac.una.evacomuna.dto;

import cr.ac.una.controller.SkillDto;

/**
 *
 * @author estebannajera
 */
public class SkillWrapper {

    private String name;
    private String state;
    private Long id;

    public SkillWrapper() {
    }

    public SkillWrapper(String name, String state, Long id) {
        this.name = name;
        this.state = state;
        this.id = id;
    }

    public SkillDto getDto() {
        SkillDto dto = new SkillDto();
        dto.setName(this.name);
        dto.setState(this.state);
        dto.setId(this.id);
        return dto;
    }

    public Long getId() {
        return id;
    }

    public String getState() {
        return state;
    }

    public String getName() {
        return name;
    }

}
