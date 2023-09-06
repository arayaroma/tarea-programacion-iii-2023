package cr.ac.una.entities;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import static cr.ac.una.util.Constants.SCHEMA;
import static cr.ac.una.util.DatabaseSequences.SEQ_SKILL;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;
import cr.ac.una.dto.SkillDto;

/**
 * 
 * @author arayaroma
 */
@Entity
@Table(name = "TBL_SKILL", schema = SCHEMA)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Skill implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @NotNull
    @SequenceGenerator(name = SEQ_SKILL, sequenceName = SCHEMA + "." + SEQ_SKILL, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_SKILL)
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;

    @NotNull
    @Basic(optional = false)
    @Size(min = 1, max = 24)
    @Column(name = "NAME")
    private String name;

    @NotNull
    @Basic(optional = false)
    @Size(min = 1, max = 100)
    private String description;

    @NotNull
    @Basic(optional = false)
    @Size(min = 1, max = 8)
    private String state;

    @ManyToMany(mappedBy = "skills")
    private List<Position> positions;

    @OneToMany(mappedBy = "skillId")
    private List<Calification> califications;

    @OneToMany(mappedBy = "skillId")
    private List<FinalCalification> finalCalifications;

    @ManyToMany(mappedBy = "skills")
    @JoinTable(name = "TBL_SKILL_CHARACTERISTIC", joinColumns = @JoinColumn(name = "SKILLID"), inverseJoinColumns = @JoinColumn(name = "CHARACTERISTICID"))
    private List<Characteristic> characteristics;

    @Version
    @Column(name = "VERSION")
    private Long version;

    /**
     * @param skill constructor from dto to entity
     */
    public Skill(SkillDto skillDto) {
        this.id = skillDto.getId();
        updateSkill(skillDto);
    }

    /**
     * @param skillDto update entity from dto
     */
    public void updateSkill(SkillDto skillDto) {
        this.name = skillDto.getName();
        this.description = skillDto.getDescription();
        this.state = skillDto.getState();
        this.califications = skillDto.getCalifications() != null
                ? skillDto.getCalifications()
                        .stream()
                        .map(calificationDto -> new Calification(calificationDto))
                        .collect(Collectors.toList())
                : null;
        this.finalCalifications = skillDto.getFinalCalifications() != null
                ? skillDto.getFinalCalifications()
                        .stream()
                        .map(finalCalificationDto -> new FinalCalification(finalCalificationDto))
                        .collect(Collectors.toList())
                : null;
        this.positions = skillDto.getPositions() != null
                ? skillDto.getPositions()
                        .stream()
                        .map(positionDto -> new Position(positionDto))
                        .collect(Collectors.toList())
                : null;
        this.characteristics = skillDto.getCharacteristics() != null
                ? skillDto.getCharacteristics()
                        .stream()
                        .map(characteristicDto -> new Characteristic(characteristicDto))
                        .collect(Collectors.toList())
                : null;
        this.version = skillDto.getVersion();
    }
}