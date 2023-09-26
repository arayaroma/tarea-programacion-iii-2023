package cr.ac.una.evacomuna.dto;

/**
 * FIXME: Equals and Hash
 * 
 * @author estebannajera
 * @author arayaroma
 */
public class CharacteristicDto {

    private Long id;
    private String name;
    private Long version;
    private SkillDto skill;

    public CharacteristicDto() {
    }

    public CharacteristicDto(String name, Long id, SkillDto skillDto) {
        this.name = name;
        this.id = id;
        this.skill = skillDto;
    }

    public CharacteristicDto(cr.ac.una.controller.CharacteristicDto characteristicDto) {
        this.id = characteristicDto.getId();
        this.name = characteristicDto.getName();
        this.version = characteristicDto.getVersion();
        this.skill = new SkillDto();
    }

    public cr.ac.una.controller.CharacteristicDto getDto() {
        cr.ac.una.controller.CharacteristicDto characteristicDto = new cr.ac.una.controller.CharacteristicDto();
        characteristicDto.setId(this.id);
        characteristicDto.setName(this.name);
        characteristicDto.setSkill(this.skill.getDto());
        return characteristicDto;
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

    public Long getVersion() {
        return this.version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public SkillDto getSkill() {
        return this.skill;
    }

    public void setSkill(SkillDto skill) {
        this.skill = skill;
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", name='" + getName() + "'" +
                ", version='" + getVersion() + "'" +
                ", skill='" + getSkill() + "'" +
                "}";
    }

}
