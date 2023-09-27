package cr.ac.una.evacomunaws.dto;

import java.util.ArrayList;
import java.util.List;

import cr.ac.una.evacomunaws.entities.Position;
import cr.ac.una.evacomunaws.entities.Skill;
import cr.ac.una.evacomunaws.entities.User;
import cr.ac.una.evacomunaws.util.DtoMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author arayaroma
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PositionDto implements DtoMapper<Position, PositionDto> {

    private Long id;
    private String name;
    private String state;
    private Long version;
    private List<UserDto> users;
    private List<SkillDto> skills;

    /**
     * @param entity entity to be converted
     * @param dto    dto to be updated
     * @return dto with the updated information
     */
    @Override
    public PositionDto convertFromEntityToDTO(Position entity, PositionDto dto) {
        dto.setUsers(DtoMapper.fromEntityList(entity.getUsers(),
                UserDto.class).getList());

        dto.setSkills(
                DtoMapper.fromEntityList(entity.getSkills(),
                        SkillDto.class).getList());
        return dto;
    }

    /**
     * @param entity entity to be converted
     * @param dto    dto to be updated
     * @return dto with the updated information
     */
    @Override
    public Position convertFromDTOToEntity(PositionDto dto, Position entity) {
        entity.setUsers(DtoMapper.fromDtoList(dto.getUsers(),
                User.class).getList());

        entity.setSkills(DtoMapper.fromDtoList(dto.getSkills(),
                Skill.class).getList());
        return entity;
    }

    /**
     * @param position constructor from entity to dto
     */
    public PositionDto(Position position) {
        this.id = position.getId();
        this.name = position.getName();
        this.state = position.getState();
        this.version = position.getVersion();
        this.users = new ArrayList<>();
        this.skills = new ArrayList<>();
    }
}
