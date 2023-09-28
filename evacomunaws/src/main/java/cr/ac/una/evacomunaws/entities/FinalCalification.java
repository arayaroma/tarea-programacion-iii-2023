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
import jakarta.persistence.QueryHint;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import static cr.ac.una.evacomunaws.util.Constants.SCHEMA;
import static cr.ac.una.evacomunaws.util.DatabaseSequences.SEQ_FINAL_CALIFICATION;
import java.io.Serializable;
import cr.ac.una.evacomunaws.dto.FinalCalificationDto;

/**
 * 
 * @author arayaroma
 */
@Entity
@Table(name = "TBL_FINAL_CALIFICATION", schema = SCHEMA)
@Data
@NoArgsConstructor
@AllArgsConstructor
@NamedQueries({
        @NamedQuery(name = "FinalCalification.findAll", query = "SELECT c FROM FinalCalification c", hints = @QueryHint(name = "eclipselink.refresh", value = "true")),
        @NamedQuery(name = "FinalCalification.findById", query = "SELECT c FROM FinalCalification c WHERE c.id = :id", hints = {
                @QueryHint(name = "eclipselink.refresh", value = "true") }),
        @NamedQuery(name = "FinalCalification.findByFinalNote", query = "SELECT c FROM FinalCalification c WHERE c.finalNote = :finalNote", hints = {
                @QueryHint(name = "eclipselink.refresh", value = "true") }),
        @NamedQuery(name = "FinalCalification.findByAverage", query = "SELECT c FROM FinalCalification c WHERE c.average = :average", hints = {
                @QueryHint(name = "eclipselink.refresh", value = "true") })
})
public class FinalCalification implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name = SEQ_FINAL_CALIFICATION, sequenceName = SCHEMA + "."
            + SEQ_FINAL_CALIFICATION, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_FINAL_CALIFICATION)
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;

    @NotNull
    @Basic(optional = false)
    @Column(name = "FINALNOTE")
    private Long finalNote;

    @NotNull
    @Basic(optional = false)
    @Column(name = "AVERAGE")
    private Long average;

    @ManyToOne
    @JoinColumn(name = "EVALUATEDID")
    private Evaluated evaluated;

    @ManyToOne
    @JoinColumn(name = "SKILLID")
    private Skill skill;

    @Version
    @Column(name = "VERSION")
    private Long version;

    /**
     * Constructor from a dto to entity
     * 
     * @param finalCalificationDto dto to copy from
     */
    public FinalCalification(FinalCalificationDto finalCalificationDto) {
        this.id = finalCalificationDto.getId();
        updateFinalCalification(finalCalificationDto);
    }

    /**
     * @param finalCalificationDto update the entity with the dto
     */

    public void updateFinalCalification(FinalCalificationDto finalCalificationDto) {
        this.finalNote = finalCalificationDto.getFinalNote();
        this.average = finalCalificationDto.getAverage();
        this.version = finalCalificationDto.getVersion();
    }
}