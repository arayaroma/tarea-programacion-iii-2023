package cr.ac.una.entities;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import static cr.ac.una.util.Constants.SCHEMA;
import static cr.ac.una.util.DatabaseSequences.SEQ_CHARACTERISTIC;
import java.io.Serializable;
import cr.ac.una.dto.CharacteristicDto;
import jakarta.persistence.FetchType;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;

/**
 *
 * @author arayaroma
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "TBL_CHARACTERISTIC", schema = SCHEMA)
@NamedQueries({
    @NamedQuery(name = "Characteristic.findAll", query = "SELECT c FROM Characteristic c"),
    @NamedQuery(name = "Characteristic.findByName", query = "SELECT c FROM Characteristic c WHERE c.name = :name"),
    @NamedQuery(name = "Characteristic.deleteAll", query = "DELETE FROM Characteristic c"),})
public class Characteristic implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
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
    
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SKILLID", referencedColumnName = "ID")
    Skill skill;

    /**
     * @param characteristicDto constructor from entity to dto
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
