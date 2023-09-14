package cr.ac.una.evacomuna.dto;

import cr.ac.una.controller.PositionDto;

/**
 *
 * @author estebannajera
 */
public class RoleWrapper {

    private String name;
    private String state;
    private Long id;

    public RoleWrapper() {
    }

    public RoleWrapper(String name, String state, Long id) {
        this.name = name;
        this.state = state;
        this.id = id;
    }

    public PositionDto getDto() {
        PositionDto dto = new PositionDto();
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
