package cr.ac.una.entities;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
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
@NamedQueries({
        @NamedQuery(name = "Skill.findAll", query = "SELECT s FROM Skill s"),
        @NamedQuery(name = "Skill.findById", query = "SELECT s FROM Skill s WHERE s.id = :id"),
        @NamedQuery(name = "Skill.findByName", query = "SELECT s FROM Skill s WHERE s.name = :name"),
        @NamedQuery(name = "Skill.deleteAll", query = "DELETE FROM Skill s"),
        @NamedQuery(name = "Skill.getCharacteristicsBySkillId", query = "SELECT c FROM Characteristic c JOIN c.skills s WHERE s.id = :id"),
        @NamedQuery(name = "Skill.getCalificationsBySkillId", query = "SELECT c FROM Calification c WHERE c.skill.id = :id"),
        @NamedQuery(name = "Skill.getFinalCalificationsBySkillId", query = "SELECT f FROM FinalCalification f WHERE f.skill.id = :id")
})
public class Skill implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
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

    @OneToMany(mappedBy = "skill")
    private List<Calification> califications;

    @OneToMany(mappedBy = "skill")
    private List<FinalCalification> finalCalifications;

    @OneToMany(mappedBy = "skill", cascade = CascadeType.ALL)
    private List<Characteristic> characteristics;

    @Version
    @Column(name = "VERSION")
    private Long version;

    /**
     * @param skillDto constructor from dto to entity
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
        this.version = skillDto.getVersion();
    }
}
