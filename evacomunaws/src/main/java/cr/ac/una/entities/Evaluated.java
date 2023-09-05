package cr.ac.una.entities;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import static cr.ac.una.util.Constants.SCHEMA;
import static cr.ac.una.util.DatabaseSequences.SEQ_EVALUATED;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import cr.ac.una.dto.EvaluatedDto;

/**
 * 
 * @author arayaroma
 */
@Entity
@Table(name = "TBL_EVALUATED", schema = SCHEMA)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Evaluated implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @NotNull
    @SequenceGenerator(name = SEQ_EVALUATED, sequenceName = SCHEMA + "." + SEQ_EVALUATED, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_EVALUATED)
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;

    @NotNull
    @ManyToOne
    @Basic(optional = false)
    @JoinColumn(name = "EVALUATEDID")
    private User evaluatedId;

    @NotNull
    @Basic(optional = false)
    @Column(name = "FINALNOTE")
    private String finalNote;

    @NotNull
    @ManyToOne
    @Basic(optional = false)
    @Column(name = "EVALUATIONID")
    @JoinColumn(name = "EVALUATIONID")
    private Evaluation evaluationId;

    @NotNull
    @OneToMany(mappedBy = "evaluatedId")
    private List<Evaluator> evaluators;

    @NotNull
    @OneToMany(mappedBy = "evaluatedId")
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
        this.evaluatedId = new User(evaluatedDto.getEvaluatedId());
        this.finalNote = evaluatedDto.getFinalNote();
        this.evaluationId = new Evaluation(evaluatedDto.getEvaluationId());
        this.finalCalifications = evaluatedDto.getFinalCalifications()
                .stream()
                .map(finalCalificationDto -> new FinalCalification(finalCalificationDto))
                .collect(Collectors.toList());
        this.evaluators = evaluatedDto.getEvaluators()
                .stream()
                .map(evaluatorDto -> new Evaluator(evaluatorDto))
                .collect(Collectors.toList());
        this.version = evaluatedDto.getVersion();
    }
}