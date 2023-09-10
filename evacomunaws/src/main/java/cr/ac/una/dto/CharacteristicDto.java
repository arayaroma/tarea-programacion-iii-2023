package cr.ac.una.dto;

import java.util.List;
import cr.ac.una.entities.Characteristic;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
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

    public static CharacteristicDtoList fromEntityList(List<Characteristic> characteristic) {
        CharacteristicDtoList characteristicDtoList = new CharacteristicDtoList();
        if (characteristic == null || characteristic.isEmpty()) {
            return characteristicDtoList;
        }

        List<CharacteristicDto> characteristicDto = new ArrayList<>();
        for (Characteristic i : characteristic) {
            characteristicDto.add(new CharacteristicDto(i));
        }

        characteristicDtoList.setUserDtoList(characteristicDto);
        return characteristicDtoList;
    }
}
