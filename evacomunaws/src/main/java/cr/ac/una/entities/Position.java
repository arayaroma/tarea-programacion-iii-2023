package cr.ac.una.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import cr.ac.una.dto.PositionDto;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TBL_POSITION", schema = "EvaComUNA")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Position implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name = "SEQ_POSITION", sequenceName = "EvaComUNA.SEQ_POSITION", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_POSITION")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Long id;

    private String name;
    private String state;

    @OneToMany(mappedBy = "position")
    private List<User> users = new ArrayList<>();

    public Position(PositionDto position) {
        this.id = position.getId();
        updatePosition(position);
    }

    public void updatePosition(PositionDto position) {
        this.name = position.getName();
        this.state = position.getState();
        position.getUsers().forEach(user -> {
            this.users.add(new User(user));
        });
    }
}
