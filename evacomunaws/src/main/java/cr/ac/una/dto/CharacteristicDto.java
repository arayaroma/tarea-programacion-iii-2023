package cr.ac.una.dto;

import java.util.List;
import cr.ac.una.entities.Characteristic;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
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
@XmlRootElement(name = "CharacteristicDto")
@XmlAccessorType(XmlAccessType.FIELD)
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
        this.version = characteristic.getVersion();
    }
}
