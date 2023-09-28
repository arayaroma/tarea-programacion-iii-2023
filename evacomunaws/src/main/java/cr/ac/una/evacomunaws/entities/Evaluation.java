package cr.ac.una.evacomunaws.entities;

import java.io.Serializable;
import java.time.LocalDate;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import static cr.ac.una.evacomunaws.util.Constants.SCHEMA;
import static cr.ac.una.evacomunaws.util.DatabaseSequences.SEQ_EVALUATION;
import java.util.List;
import cr.ac.una.evacomunaws.dto.EvaluationDto;

/**
 *
 * @author arayaroma
 */
@Entity
@Table(name = "TBL_EVALUATION", schema = SCHEMA)
@Data
@NoArgsConstructor
@AllArgsConstructor
@NamedQueries({
    @NamedQuery(name = "Evaluation.findAll", query = "SELECT e FROM Evaluation e", hints = @QueryHint(name = "eclipselink.refresh", value = "true")),
    @NamedQuery(name = "Evaluation.findByName", query = "SELECT e FROM Evaluation e WHERE e.name = :name", hints = {
        @QueryHint(name = "eclipselink.refresh", value = "true")})
})

public class Evaluation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name = SEQ_EVALUATION, sequenceName = SCHEMA + "." + SEQ_EVALUATION, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_EVALUATION)
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
    LocalDate applicationDate;

    @NotNull
    @Basic(optional = false)
    LocalDate InitialPeriod;

    @NotNull
    @Basic(optional = false)
    LocalDate finalPeriod;

    @NotNull
    @Basic(optional = false)
    @Size(min = 1, max = 24)
    @Column(name = "STATE")
    private String state;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "evaluation")
    private List<Evaluated> evaluated;

    @Version
    @Column(name = "VERSION")
    private Long version;

    /**
     * @param evaluationDto constructor from a dto to entity
     */
    public Evaluation(EvaluationDto evaluationDto) {
        this.id = evaluationDto.getId();
        updateEvaluation(evaluationDto);
    }

    /**
     * @param evaluationDto update the entity with the dto
     */
    public void updateEvaluation(EvaluationDto evaluationDto) {
        this.name = evaluationDto.getName();

        this.applicationDate = LocalDate.parse(evaluationDto.getApplicationDate());
        this.InitialPeriod = LocalDate.parse(evaluationDto.getInitialPeriod());
        this.finalPeriod = LocalDate.parse(evaluationDto.getFinalPeriod());
        this.state = evaluationDto.getState();
        this.version = evaluationDto.getVersion();
    }
}
