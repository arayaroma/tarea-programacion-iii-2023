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
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import static cr.ac.una.util.Constants.SCHEMA;
import static cr.ac.una.util.DatabaseSequences.SEQ_EVALUATOR;
import java.io.Serializable;
import java.util.List;

import cr.ac.una.dto.EvaluatorDto;

/**
 * 
 * @author arayaroma
 */
@Entity
@Table(name = "TBL_EVALUATOR", schema = SCHEMA)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Evaluator implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @NotNull
    @SequenceGenerator(name = SEQ_EVALUATOR, sequenceName = SCHEMA + "." + SEQ_EVALUATOR, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_EVALUATOR)
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;

    @NotNull
    @ManyToOne
    @Basic(optional = false)
    @JoinColumn(name = "EVALUATORID")
    private User evaluator;

    @NotNull
    @Basic(optional = false)
    @Size(min = 1, max = 24)
    @Column(name = "ROLE")
    private String role;

    @NotNull
    @Basic(optional = false)
    @Size(min = 1, max = 100)
    @Column(name = "FEEDBACK")
    private String feedback;

    @NotNull
    @ManyToOne
    @Basic(optional = false)
    @JoinColumn(name = "EVALUATEDID")
    private Evaluated evaluated;

    @OneToMany(mappedBy = "evaluator")
    private List<Calification> califications;

    @Version
    @Column(name = "VERSION")
    private Long version;

    /**
     * @param dto constructor from a dto to entity
     */
    public Evaluator(EvaluatorDto evaluatorDto) {
        this.id = evaluatorDto.getId();
        updateEvaluator(evaluatorDto);
    }

    /**
     * @param entity update the entity with the dto
     */
    public void updateEvaluator(EvaluatorDto evaluatorDto) {
        this.role = evaluatorDto.getRole();
        this.feedback = evaluatorDto.getFeedback();
        this.version = evaluatorDto.getVersion();
    }
}
