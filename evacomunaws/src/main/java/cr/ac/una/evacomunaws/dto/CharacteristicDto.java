package cr.ac.una.evacomunaws.dto;

import cr.ac.una.evacomunaws.entities.Characteristic;
import cr.ac.una.evacomunaws.util.DtoMapper;
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
public class CharacteristicDto implements DtoMapper<Characteristic, CharacteristicDto> {

    private Long id;
    private String name;
    private Long version;
    SkillDto skill;

    /**
     * @param entity Entity to be converted
     * @param dto    DTO to be updated
     * @return DTO with the updated information
     */
    @Override
    public CharacteristicDto convertFromEntityToDTO(Characteristic entity,
            CharacteristicDto dto) {
        return dto;
    }

    /**
     * @param dto    DTO to be converted
     * @param entity Entity to be updated
     * @return Entity with the updated information
     */
    @Override
    public Characteristic convertFromDTOToEntity(CharacteristicDto dto,
            Characteristic entity) {
        return entity;
    }

    /**
     * @param characteristic constructor from entity to dto
     */
    public CharacteristicDto(Characteristic characteristic) {
        this.id = characteristic.getId();
        this.name = characteristic.getName();
        this.version = characteristic.getVersion();
    }
}
