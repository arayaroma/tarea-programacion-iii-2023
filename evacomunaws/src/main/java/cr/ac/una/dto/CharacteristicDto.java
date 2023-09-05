package cr.ac.una.dto;

import java.util.List;
import java.util.stream.Collectors;

import cr.ac.una.entities.Characteristic;
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
public class CharacteristicDto {
    private Long id;
    private String name;
    private Long version;
    List<SkillDto> skills;

    /**
     * @param skill constructor from entity to dto
     */
    public CharacteristicDto(Characteristic characteristic) {
        this.id = characteristic.getId();
        this.name = characteristic.getName();
        this.skills = characteristic.getSkills() != null
                ? characteristic.getSkills()
                        .stream()
                        .map(skill -> new SkillDto(skill))
                        .collect(Collectors.toList())
                : null;
        this.version = characteristic.getVersion();
    }
}
