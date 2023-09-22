package cr.ac.una.entities;

import jakarta.persistence.*;

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
//@SecondaryTable(name = "TBL_USER", schema = SCHEMA)
@Data
@NoArgsConstructor
@AllArgsConstructor
@NamedQueries({
    @NamedQuery(name = "Evaluator.findAll", query = "SELECT e FROM Evaluator e"),})
public class Evaluator implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = SEQ_EVALUATOR, sequenceName = SCHEMA + "." + SEQ_EVALUATOR, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_EVALUATOR)
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;


    @NotNull
    @Basic(optional = false)
    @Size(min = 1, max = 24)
    @Column(name = "ROLE")
    private String role;

    //@NotNull
    @Basic(optional = false)
    @Size(min = 1, max = 100)
    @Column(name = "FEEDBACK")
    private String feedback;

    @JoinColumn(name = "EVALUATEDID", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Evaluated evaluated;
//    @JoinColumn(name = "EVALUATOR", referencedColumnName = "ID")
//    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private User evaluator;

    @OneToMany(mappedBy = "EVALUATOR")
    private List<Calification> califications;

    @Version
    @Column(name = "VERSION")
    private Long version;

    /**
     * @param evaluatorDto constructor from a dto to entity
     */
    public Evaluator(EvaluatorDto evaluatorDto) {
        this.id = evaluatorDto.getId();
        updateEvaluator(evaluatorDto);
    }

    /**
     * @param evaluatorDto update the entity with the dto
     */
    public void updateEvaluator(EvaluatorDto evaluatorDto) {
        this.role = evaluatorDto.getRole();
        this.feedback = evaluatorDto.getFeedback();
        this.version = evaluatorDto.getVersion();
    }
}
