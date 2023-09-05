package cr.ac.una.entities;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import cr.ac.una.dto.PositionDto;
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
import static cr.ac.una.util.DatabaseSequences.SEQ_POSITION;

/**
 * 
 * @author arayaroma
 */
@Entity
@Table(name = "TBL_POSITION", schema = SCHEMA)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Position implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @NotNull
    @SequenceGenerator(name = SEQ_POSITION, sequenceName = SCHEMA + "." + SEQ_POSITION, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_POSITION)
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
    @Size(min = 1, max = 20)
    @Column(name = "STATE")
    private String state;

    @OneToMany(mappedBy = "userPositionId")
    private List<User> users;

    @ManyToMany
    @JoinTable(name = "TBL_POSITION_SKILL", joinColumns = @JoinColumn(name = "POSITION_ID"), inverseJoinColumns = @JoinColumn(name = "SKILL_ID"))
    private List<Skill> skills;

    @Version
    @Column(name = "VERSION")
    private Long version;

    /**
     * @param positionDto constructor from dto to entity
     */
    public Position(PositionDto positionDto) {
        this.id = positionDto.getId();
        updatePosition(positionDto);
    }

    /**
     * @param positionDto update entity from dto
     */
    public void updatePosition(PositionDto positionDto) {
        this.name = positionDto.getName();
        this.state = positionDto.getState();
        this.version = positionDto.getVersion();
        this.users = positionDto.getUsers() != null
                ? positionDto.getUsers()
                        .stream()
                        .map(User::new)
                        .collect(Collectors.toList())
                : null;
        this.skills = positionDto.getSkills() != null
                ? positionDto.getSkills()
                        .stream()
                        .map(Skill::new)
                        .collect(Collectors.toList())
                : null;
    }
}