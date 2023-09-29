package cr.ac.una.evacomuna.dto;

import java.util.ArrayList;
import java.util.List;
import cr.ac.una.evacomuna.util.DtoMapper;
import javafx.scene.layout.Pane;

/**
 *
 * @author estebannajera
 * @author arayaroma
 */
public class SkillDto extends Pane implements DtoMapper<cr.ac.una.evacomunaws.controller.SkillDto, SkillDto> {

    private Long id;
    private String name;
    private String state;
    private Long version;
    private List<PositionDto> positions;
    private List<CalificationDto> califications;
    private List<FinalCalificationDto> finalCalifications;
    private List<CharacteristicDto> characteristics;

    @Override
    public SkillDto convertFromGeneratedToDTO(cr.ac.una.evacomunaws.controller.SkillDto generated, SkillDto dto) {
        dto.setCalifications(
                DtoMapper.fromGeneratedList(generated.getCalifications(), CalificationDto.class).getList());
        dto.setFinalCalifications(
                DtoMapper.fromGeneratedList(generated.getFinalCalifications(), FinalCalificationDto.class).getList());
        return dto;
    }

    @Override
    public cr.ac.una.evacomunaws.controller.SkillDto convertFromDTOToGenerated(SkillDto dto,
            cr.ac.una.evacomunaws.controller.SkillDto generated) {
        generated.getCalifications().addAll(
                DtoMapper.fromDtoList(dto.getCalifications(), cr.ac.una.evacomunaws.controller.CalificationDto.class)
                        .getList());
        generated.getFinalCalifications().addAll(
                DtoMapper.fromDtoList(dto.getFinalCalifications(),
                        cr.ac.una.evacomunaws.controller.FinalCalificationDto.class).getList());
        return generated;
    }

    public SkillDto() {
    }

    public SkillDto(String name, String state, Long id) {
        this.name = name;
        this.state = state;
        this.id = id;
    }

    public SkillDto(String name) {
        this.name = name;
    }

    public SkillDto(SkillDto skillDto) {
        this.id = skillDto.getID();
        this.name = skillDto.getName();
        this.state = skillDto.getState();
        this.version = skillDto.getVersion();
        this.positions = new ArrayList<>();
        this.califications = new ArrayList<>();
        this.finalCalifications = new ArrayList<>();
        this.characteristics = new ArrayList<>();
        this.characteristics = skillDto.getCharacteristics();
    }

    public SkillDto(cr.ac.una.evacomunaws.controller.SkillDto skillDto) {
        this.id = skillDto.getId();
        this.name = skillDto.getName();
        this.state = skillDto.getState();
        this.version = skillDto.getVersion();
        this.positions = new ArrayList<>();
        this.califications = new ArrayList<>();
        this.finalCalifications = new ArrayList<>();
        this.characteristics = new ArrayList<>();
        this.characteristics = DtoMapper.fromGeneratedList(skillDto.getCharacteristics(), CharacteristicDto.class)
                .getList();
    }

    public cr.ac.una.evacomunaws.controller.SkillDto getDto() {
        cr.ac.una.evacomunaws.controller.SkillDto dto = new cr.ac.una.evacomunaws.controller.SkillDto();
        dto.setName(this.name);
        dto.setState(this.state);
        dto.setId(this.id);
        dto.setVersion(this.version);
        return dto;
    }

    public String getState() {
        return state;
    }

    public String getName() {
        return name;
    }

    public Long getID() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Long getVersion() {
        return this.version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public List<PositionDto> getPositions() {
        return this.positions;
    }

    public void setPositions(List<PositionDto> positions) {
        this.positions = positions;
    }

    public List<CalificationDto> getCalifications() {
        return this.califications;
    }

    public void setCalifications(List<CalificationDto> califications) {
        this.califications = califications;
    }

    public List<FinalCalificationDto> getFinalCalifications() {
        return this.finalCalifications;
    }

    public void setFinalCalifications(List<FinalCalificationDto> finalCalifications) {
        this.finalCalifications = finalCalifications;
    }

    public List<CharacteristicDto> getCharacteristics() {
        return this.characteristics;
    }

    public void setCharacteristics(List<CharacteristicDto> characteristics) {
        this.characteristics = characteristics;
    }

    @Override
    public String toString() {
        return "{"
                + " id='" + getId() + "'"
                + ", name='" + getName() + "'"
                + ", state='" + getState() + "'"
                + ", version='" + getVersion() + "'"
                + ", positions='" + getPositions() + "'"
                + ", califications='" + getCalifications() + "'"
                + ", finalCalifications='" + getFinalCalifications() + "'"
                + ", characteristics='" + getCharacteristics() + "'"
                + "}";
    }

}
