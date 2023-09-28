package cr.ac.una.evacomunaws.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import static cr.ac.una.evacomunaws.util.Constants.SCHEMA;
import static cr.ac.una.evacomunaws.util.DatabaseSequences.SEQ_EVALUATED;
import java.io.Serializable;
import java.util.List;
import cr.ac.una.evacomunaws.dto.EvaluatedDto;

/**
 *
 * @author arayaroma
 */
@Entity
@Table(name = "TBL_EVALUATED", schema = SCHEMA)
@Data
@NoArgsConstructor
@AllArgsConstructor
@NamedQueries({
        @NamedQuery(name = "Evaluated.findAll", query = "SELECT e FROM Evaluated e", hints = @QueryHint(name = "eclipselink.refresh", value = "true")),
        @NamedQuery(name = "Evaluated.findById", query = "SELECT e FROM Evaluated e WHERE e.id = :id", hints = @QueryHint(name = "eclipselink.refresh", value = "true")),
        @NamedQuery(name = "Evaluated.findByFinalNote", query = "SELECT e FROM Evaluated e WHERE e.finalNote = :finalNote", hints = @QueryHint(name = "eclipselink.refresh", value = "true")),
})
public class Evaluated implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name = SEQ_EVALUATED, sequenceName = SCHEMA + "." + SEQ_EVALUATED, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_EVALUATED)
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "EVALUATEDID")
    private User evaluated;

    @Basic(optional = false)
    @Column(name = "FINALNOTE")
    private String finalNote;

    @ManyToOne
    @JoinColumn(name = "EVALUATIONID", referencedColumnName = "ID")
    private Evaluation evaluation;

    @OneToMany(mappedBy = "evaluated", fetch = FetchType.LAZY)
    private List<Evaluator> evaluators;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "evaluated")
    private List<FinalCalification> finalCalifications;

    @Version
    @Column(name = "VERSION")
    private Long version;

    /**
     * @param evaluatedDto constructor from a dto to entity
     */
    public Evaluated(EvaluatedDto evaluatedDto) {
        this.id = evaluatedDto.getId();
        updateEvaluated(evaluatedDto);
    }

    /**
     * @param evaluatedDto update the entity with the dto
     */
    public void updateEvaluated(EvaluatedDto evaluatedDto) {
        this.finalNote = evaluatedDto.getFinalNote();
        this.version = evaluatedDto.getVersion();
    }

}
