package cr.ac.una.dto;

import java.util.List;
import cr.ac.una.entities.Skill;
import cr.ac.una.util.EntityUtil;
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
public class SkillDto {

    private Long id;
    private String name;
    private String state;
    private Long version;
    private List<PositionDto> positions;
    private List<CalificationDto> califications;
    private List<FinalCalificationDto> finalCalifications;
    private List<CharacteristicDto> characteristics;

    /**
     * @param skill constructor from entity to dto
     */
    public SkillDto(Skill skill) {
        this.id = skill.getId();
        this.name = skill.getName();
        this.state = skill.getState();
        this.version = skill.getVersion();
        this.characteristics = EntityUtil.fromEntityList(skill.getCharacteristics(), CharacteristicDto.class).getList();
    }
}
