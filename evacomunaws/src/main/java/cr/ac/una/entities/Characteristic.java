package cr.ac.una.entities;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import static cr.ac.una.util.Constants.SCHEMA;
import static cr.ac.una.util.DatabaseSequences.SEQ_CHARACTERISTIC;
import java.io.Serializable;
import java.util.List;
import cr.ac.una.dto.CharacteristicDto;

/**
 * 
 * @author arayaroma
 */
@Entity
@Table(name = "TBL_CHARACTERISTIC", schema = SCHEMA)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Characteristic implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @NotNull
    @SequenceGenerator(name = SEQ_CHARACTERISTIC, sequenceName = SCHEMA + "." + SEQ_CHARACTERISTIC, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_CHARACTERISTIC)
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;

    @NotNull
    @Basic(optional = false)
    @Size(min = 1, max = 100)
    @Column(name = "NAME")
    private String name;

    @Version
    @Column(name = "VERSION")
    private Long version;

    @ManyToMany(mappedBy = "characteristics")
    List<Skill> skills;

    /**
     * @param skill constructor from entity to dto
     */
    public Characteristic(CharacteristicDto characteristicDto) {
        this.id = characteristicDto.getId();
        updateCharacteristic(characteristicDto);
    }

    /**
     * @param characteristicDto update entity from dto
     */
    public void updateCharacteristic(CharacteristicDto characteristicDto) {
        this.name = characteristicDto.getName();
        this.version = characteristicDto.getVersion();
    }

}
