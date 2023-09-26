package cr.ac.una.evacomuna.dto;

import java.util.ArrayList;
import java.util.List;

import cr.ac.una.evacomuna.util.DtoMapper;

/**
 * 
 * @author estebannajera
 * @author arayaroma
 */
public class PositionDto implements DtoMapper<cr.ac.una.controller.PositionDto, PositionDto> {

    private Long id;
    private String name;
    private String state;
    private Long version;
    private List<UserDto> users;
    private List<SkillDto> skills;

    @Override
    public PositionDto convertFromGeneratedToDTO(cr.ac.una.controller.PositionDto generated, PositionDto dto) {
        dto.setUsers(DtoMapper.fromGeneratedList(generated.getUsers(), UserDto.class).getList());
        dto.setSkills(DtoMapper.fromGeneratedList(generated.getSkills(), SkillDto.class).getList());
        return dto;
    }

    @Override
    public cr.ac.una.controller.PositionDto convertFromDTOToGenerated(PositionDto dto,
            cr.ac.una.controller.PositionDto generated) {
        generated.getUsers()
                .addAll(DtoMapper.fromDtoList(dto.getUsers(), cr.ac.una.controller.UserDto.class).getList());
        generated.getSkills()
                .addAll(DtoMapper.fromDtoList(dto.getSkills(), cr.ac.una.controller.SkillDto.class).getList());
        return generated;
    }

    public PositionDto() {
    }

    public PositionDto(String name, String state, Long id) {
        this.name = name;
        this.state = state;
        this.id = id;
    }

    public PositionDto(cr.ac.una.controller.PositionDto positionDto) {
        this.id = positionDto.getId();
        this.name = positionDto.getName();
        this.state = positionDto.getState();
        this.version = positionDto.getVersion();
        this.users = new ArrayList<>();
        this.skills = new ArrayList<>();
    }

    public cr.ac.una.controller.PositionDto getDto() {
        cr.ac.una.controller.PositionDto dto = new cr.ac.una.controller.PositionDto();
        dto.setName(this.name);
        dto.setState(this.state);
        dto.setId(this.id);
        return dto;
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

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Long getVersion() {
        return this.version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public List<UserDto> getUsers() {
        return this.users;
    }

    public void setUsers(List<UserDto> users) {
        this.users = users;
    }

    public List<SkillDto> getSkills() {
        return this.skills;
    }

    public void setSkills(List<SkillDto> skills) {
        this.skills = skills;
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", name='" + getName() + "'" +
                ", state='" + getState() + "'" +
                ", version='" + getVersion() + "'" +
                ", users='" + getUsers() + "'" +
                ", skills='" + getSkills() + "'" +
                "}";
    }

}
