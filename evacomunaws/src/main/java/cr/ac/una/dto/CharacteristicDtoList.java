package cr.ac.una.dto;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@XmlRootElement(name = "CharacteristicDtoList")
@XmlAccessorType(XmlAccessType.FIELD)
public class CharacteristicDtoList {

    @XmlElement(name = "CharacteristicDto")
    private List<CharacteristicDto> characteristicDtoList;

    public List<CharacteristicDto> getCharacteristicDtoList() {
        return characteristicDtoList;
    }

    public void setUserDtoList(List<CharacteristicDto> characteristicDtoList) {
        this.characteristicDtoList = characteristicDtoList;
    }
}
