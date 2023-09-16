package cr.ac.una.dto;

import java.util.ArrayList;
import java.util.List;
import cr.ac.una.entities.Position;
import cr.ac.una.entities.Skill;
import cr.ac.una.entities.User;
import cr.ac.una.util.EntityMapper;
import cr.ac.una.util.EntityUtil;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author arayaroma
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "PositionDto")
@XmlAccessorType(XmlAccessType.FIELD)
public class PositionDto implements EntityMapper<Position, PositionDto> {

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
        dto.setUsers(EntityUtil.fromEntityList(entity.getUsers(),
                UserDto.class).getList());

        dto.setSkills(
                EntityUtil.fromEntityList(entity.getSkills(),
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
        entity.setUsers(EntityUtil.fromDtoList(dto.getUsers(),
                User.class).getList());

        entity.setSkills(EntityUtil.fromDtoList(dto.getSkills(),
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
