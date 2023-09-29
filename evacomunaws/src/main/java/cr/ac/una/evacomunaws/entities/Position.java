package cr.ac.una.evacomunaws.entities;

import java.io.Serializable;
import java.util.List;
import static cr.ac.una.evacomunaws.util.Constants.SCHEMA;
import static cr.ac.una.evacomunaws.util.DatabaseSequences.SEQ_POSITION;
import cr.ac.una.evacomunaws.dto.PositionDto;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.QueryHint;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author arayaroma
 */
@Entity
@Table(name = "TBL_POSITION", schema = SCHEMA)
@Data
@NoArgsConstructor
@AllArgsConstructor
@NamedQueries({
                @NamedQuery(name = "Position.findAll", query = "SELECT p FROM Position p", hints = {
                                @QueryHint(name = "eclipselink.refresh", value = "true") }),
                @NamedQuery(name = "Position.findById", query = "SELECT p FROM Position p WHERE p.id = :id", hints = {
                                @QueryHint(name = "eclipselink.refresh", value = "true") }),
                @NamedQuery(name = "Position.findByName", query = "SELECT p FROM Position p WHERE p.name = :name", hints = {
                                @QueryHint(name = "eclipselink.refresh", value = "true") }),
                @NamedQuery(name = "Position.findByState", query = "SELECT p FROM Position p WHERE p.state = :state", hints = {
                                @QueryHint(name = "eclipselink.refresh", value = "true") }),
                @NamedQuery(name = "Position.deleteAll", query = "DELETE FROM Position p"),
                @NamedQuery(name = "Position.getUsersByPositionId", query = "SELECT u FROM User u WHERE u.position.id = :id", hints = @QueryHint(name = "eclipselink.refresh", value = "true")),
})
public class Position implements Serializable {

        private static final long serialVersionUID = 1L;

        @Id
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

        @OneToMany(mappedBy = "position", fetch = FetchType.LAZY)
        private List<User> users;

        @ManyToMany(fetch = FetchType.LAZY)
        @JoinTable(name = "TBL_POSITION_SKILL", joinColumns = @JoinColumn(name = "POSITIONID", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "SKILLID", referencedColumnName = "ID"))
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
        }
}
