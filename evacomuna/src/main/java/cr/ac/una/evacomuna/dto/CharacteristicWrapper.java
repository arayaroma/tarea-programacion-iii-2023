package cr.ac.una.evacomuna.dto;

import cr.ac.una.controller.CharacteristicDto;
import cr.ac.una.controller.SkillDto;

/**
 *
 * @author estebannajera
 */
public class CharacteristicWrapper {

    private String name;
    private Long id;
    private SkillDto skillDto;

    public CharacteristicWrapper(String name, Long id, SkillDto skillDto) {
        this.name = name;
        this.id = id;
        this.skillDto = skillDto;
    }

    public CharacteristicWrapper() {
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SkillDto getSkillDto() {
        return skillDto;
    }

    public void setSkillDto(SkillDto skillDto) {
        this.skillDto = skillDto;
    }

    public CharacteristicDto getDto() {
        CharacteristicDto characteristicDto = new CharacteristicDto();
        characteristicDto.setId(this.id);
        characteristicDto.setName(this.name);
        characteristicDto.setSkill(this.skillDto);
        return characteristicDto;
    }

}
