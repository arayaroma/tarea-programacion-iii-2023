package cr.ac.una.entities;

import jakarta.validation.constraints.NotNull;
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
import static cr.ac.una.util.DatabaseSequences.SEQ_FINAL_CALIFICATION;
import java.io.Serializable;
import cr.ac.una.dto.FinalCalificationDto;

/**
 * 
 * @author arayaroma
 */
@Entity
@Table(name = "TBL_FINAL_CALIFICATION", schema = SCHEMA)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FinalCalification implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @NotNull
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
     * @param entity constructor from a entity to dto
     */
    public FinalCalification(FinalCalificationDto finalCalificationDto) {
        this.id = finalCalificationDto.getId();
        updateFinalCalification(finalCalificationDto);
    }

    /**
     * @param evaluatedDto update the entity with the dto
     */

    public void updateFinalCalification(FinalCalificationDto finalCalificationDto) {
        this.finalNote = finalCalificationDto.getFinalNote();
        this.average = finalCalificationDto.getAverage();
        this.version = finalCalificationDto.getVersion();
    }
}