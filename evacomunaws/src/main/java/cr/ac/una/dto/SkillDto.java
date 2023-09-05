package cr.ac.una.dto;

import java.util.List;
import java.util.stream.Collectors;
import cr.ac.una.entities.Skill;
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
    private String description;
    private String state;
    private Long version;
    private List<PositionDto> positions;

    /**
     * @param skill constructor from entity to dto
     */
    public SkillDto(Skill skill) {
        this.id = skill.getId();
        this.name = skill.getName();
        this.description = skill.getDescription();
        this.state = skill.getState();
        this.version = skill.getVersion();
        this.positions = skill.getPositions() != null
                ? skill.getPositions()
                        .stream()
                        .map(position -> new PositionDto(position))
                        .collect(Collectors.toList())
                : null;
    }
}
