package cr.ac.una.dto;

import java.util.ArrayList;
import java.util.List;
import cr.ac.una.entities.Skill;
import cr.ac.una.util.EntityMapper;
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
public class SkillDto implements EntityMapper<Skill, SkillDto> {

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
        this.characteristics = EntityUtil.fromEntityList(skill.getCharacteristics(), CharacteristicDto.class).getList();
    }
}
