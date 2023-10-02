package cr.ac.una.evacomunaws.entities;

import jakarta.validation.constraints.NotNull;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import static cr.ac.una.evacomunaws.util.Constants.SCHEMA;
import static cr.ac.una.evacomunaws.util.DatabaseSequences.SEQ_CALIFICATION;
import java.io.Serializable;
import cr.ac.una.evacomunaws.dto.CalificationDto;

/**
 *
 * @author arayaroma
 */
@Entity
@Table(name = "TBL_CALIFICATION", schema = SCHEMA)
@Data
@NoArgsConstructor
@AllArgsConstructor
@NamedQueries({
        @NamedQuery(name = "Calification.findAll", query = "SELECT c FROM Calification c", hints = @jakarta.persistence.QueryHint(name = "eclipselink.refresh", value = "true")),
        @NamedQuery(name = "Calification.findById", query = "SELECT c FROM Calification c WHERE c.id = :id", hints = {
                @jakarta.persistence.QueryHint(name = "eclipselink.refresh", value = "true") }),
        @NamedQuery(name = "Calification.findByCalification", query = "SELECT c FROM Calification c WHERE c.calification = :calification", hints = {
                @jakarta.persistence.QueryHint(name = "eclipselink.refresh", value = "true") })
})
public class Calification implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = SEQ_CALIFICATION, sequenceName = SCHEMA + "." + SEQ_CALIFICATION, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_CALIFICATION)
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;

    @NotNull
    @Basic(optional = false)
    @Column(name = "CALIFICATION")
    private Long calification;

    @ManyToOne
    @JoinColumn(name = "SKILLID")
    private Skill skill;

    @ManyToOne
    @JoinColumn(name = "EVALUATORID")
    private Evaluator evaluator;

    @Version
    @Column(name = "VERSION")
    private Long version;

    /**
     * @param calificationDto constructor from entity to dto
     */
    public Calification(CalificationDto calificationDto) {
        this.id = calificationDto.getId();
        updateCalification(calificationDto);
    }

    /**
     * @param calificationDto update entity from dto
     */
    public void updateCalification(CalificationDto calificationDto) {
        this.calification = calificationDto.getCalification();
        this.version = calificationDto.getVersion();
    }
}
