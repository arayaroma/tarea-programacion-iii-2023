package cr.ac.una.evacomuna.dto;

import java.util.ArrayList;
import java.util.List;

import cr.ac.una.evacomuna.util.DtoMapper;

/**
 *
 * @author estebannajera
 * @author arayaroma
 */
public class PositionDto implements DtoMapper<cr.ac.una.evacomunaws.controller.PositionDto, PositionDto> {

    private Long id;
    private String name;
    private String state;
    private Long version;
    private List<UserDto> users;
    private List<SkillDto> skills;

    @Override
    public PositionDto convertFromGeneratedToDTO(cr.ac.una.evacomunaws.controller.PositionDto generated,
            PositionDto dto) {
        dto.setUsers(DtoMapper.fromDtoList(generated.getUsers(), UserDto.class).getList());
        dto.setSkills(DtoMapper.fromDtoList(generated.getSkills(), SkillDto.class).getList());
        if (dto.getSkills() == null) {
            dto.setSkills(new ArrayList<SkillDto>());
        }
        if (dto.getUsers() == null) {
            dto.setUsers(new ArrayList<UserDto>());
        }
        return dto;
    }

    @Override
    public cr.ac.una.evacomunaws.controller.PositionDto convertFromDTOToGenerated(PositionDto dto,
            cr.ac.una.evacomunaws.controller.PositionDto generated) {
        dto.getSkills().forEach(t -> generated.getSkills().add(createDtoSkill(t)));
        return generated;
    }

    public PositionDto() {
    }

    // public cr.ac.una.evacomunaws.controller.UserDto createDtoUser(UserDto
    // userDto) {
    // cr.ac.una.evacomunaws.controller.UserDto user = new
    // cr.ac.una.evacomunaws.controller.UserDto();
    // user.setActivationCode(userDto.getActivationCode());
    // user.setEmail(userDto.getEmail());
    // user.setId(userDto.getId());
    // user.setVersion(userDto.getVersion());
    // return user;
    // }

    public cr.ac.una.evacomunaws.controller.SkillDto createDtoSkill(SkillDto skillDto) {
        cr.ac.una.evacomunaws.controller.SkillDto skill = new cr.ac.una.evacomunaws.controller.SkillDto();
        skill.setId(skillDto.getID());
        skill.setVersion(skillDto.getVersion());
        skill.setName(skillDto.getName());
        return skill;
    }

    public PositionDto(String name, String state, Long id) {
        this.name = name;
        this.state = state;
        this.id = id;
    }

    public PositionDto(cr.ac.una.evacomunaws.controller.PositionDto positionDto) {
        this.id = positionDto.getId();
        this.name = positionDto.getName();
        this.state = positionDto.getState();
        this.version = positionDto.getVersion();
        this.users = new ArrayList<>();
        this.skills = new ArrayList<>();
    }

    public cr.ac.una.evacomunaws.controller.PositionDto getDto() {
        try {
            cr.ac.una.evacomunaws.controller.PositionDto dto = new cr.ac.una.evacomunaws.controller.PositionDto();
            dto.setName(this.name);
            dto.setState(this.state);
            dto.setId(this.id);
            dto.setVersion(this.version);
            // dto.getSkills();
            // skills.forEach(t->dto.getSkills().add(DtoMapper.convertToGenerated(t,
            // cr.ac.una.evacomunaws.controller.SkillDto.class)));
            // dto.getSkills().addAll(DtoMapper.fromDtoList(this.skills,
            // SkillDto.class).getList());
            return dto;
        } catch (Exception e) {
            System.out.println(e.toString());
            return null;
        }
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
        return "{"
                + " id='" + getId() + "'"
                + ", name='" + getName() + "'"
                + ", state='" + getState() + "'"
                + ", version='" + getVersion() + "'"
                + ", users='" + getUsers() + "'"
                + ", skills='" + getSkills() + "'"
                + "}";
    }

}
