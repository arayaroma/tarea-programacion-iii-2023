package cr.ac.una.evacomunaws.dto;

import java.util.ArrayList;
import java.util.List;
import cr.ac.una.evacomunaws.entities.Skill;
import cr.ac.una.evacomunaws.util.DtoMapper;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

/**
 *
 * @author arayaroma
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SkillDto implements DtoMapper<Skill, SkillDto> {

    private Long id;
    private String name;
    private String state;
    private Long version;
    private List<PositionDto> positions;
    private List<CalificationDto> califications;
    private List<FinalCalificationDto> finalCalifications;
    private List<CharacteristicDto> characteristics;

    /**
     * @param entity Entity to be converted
     * @param dto    DTO to be updated
     * @return DTO with the updated information
     */
    @Override
    public SkillDto convertFromEntityToDTO(Skill entity, SkillDto dto) {
        /**
         * TODO: Califications and FinalCalifications lists
         */
        dto.setCalifications(DtoMapper.fromEntityList(entity.getCalifications(), CalificationDto.class).getList());
        dto.setFinalCalifications(
                DtoMapper.fromEntityList(entity.getFinalCalifications(), FinalCalificationDto.class).getList());
        return dto;
    }

    /**
     * @param dto    DTO to be converted
     * @param entity Entity to be updated
     * @return Entity with the updated information
     */
    @Override
    public Skill convertFromDTOToEntity(SkillDto dto, Skill entity) {
        /**
         * TODO: Califications and FinalCalifications lists
         */
        // entity.setCalifications(califications);
        return entity;
    }

    /**
     * @param skill constructor from entity to dto
     */
    public SkillDto(Skill skill) {
        this.id = skill.getId();
        this.name = skill.getName();
        this.state = skill.getState();
        this.version = skill.getVersion();
        this.positions = new ArrayList<>();
        this.califications = new ArrayList<>();
        this.finalCalifications = new ArrayList<>();
        this.characteristics = DtoMapper.fromEntityList(skill.getCharacteristics(), CharacteristicDto.class)
                .getList();
    }
}
