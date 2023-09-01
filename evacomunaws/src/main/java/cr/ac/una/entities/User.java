package cr.ac.una.entities;

import java.io.Serializable;
import cr.ac.una.dto.UserDto;
import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.GenerationType;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;

@Entity
@Table(name = "TBL_USER", schema = "EvaComUNA")
@Data
@NoArgsConstructor
@AllArgsConstructor
@NamedQueries({
        @NamedQuery(name = "user.findAll", query = "SELECT u FROM User u") })
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name = "SEQ_USER", sequenceName = "EvaComUNA.SEQ_USER", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_USER")
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Long id;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "USERNAME", unique = true)
    private String username;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "PASSWORD")
    private String password;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "NAME")
    private String name;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "LASTNAME")
    private String lastname;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "SECONDLASTNAME")
    private String secondLastname;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "IDENTIFICATION", unique = true)
    private String identification;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "EMAIL")
    private String email;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "LANDLINENUMBER")
    private String landlineNumber;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "PHONENUMBER")
    private String phoneNumber;

    @Lob()
    @Column(name = "PROFILEPHOTO")
    private byte[] profilePhoto;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "ISACTIVE")
    private String isActive;

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "ISADMIN")
    private String isAdmin;

    @Column(name = "USERPOSITIONID")
    private Long userPositionId;

    @Column(name = "EVALUATORID")
    @NotNull
    private Long evaluatedId;

    @Column(name = "EVALUATEDID")
    @NotNull
    private Long evaluatorId;

    @Column(name = "ACTIVATIONCODE")
    private String activationCode;

    public User(UserDto userDto) {
        this.id = userDto.getId();
        updateUser(userDto);
    }

    public void updateUser(UserDto userDto) {
        this.username = userDto.getUsername();
        this.password = userDto.getPassword();
        this.name = userDto.getName();
        this.lastname = userDto.getLastname();
        this.secondLastname = userDto.getSecondLastname();
        this.identification = userDto.getIdentification();
        this.email = userDto.getEmail();
        this.landlineNumber = userDto.getLandlineNumber();
        this.phoneNumber = userDto.getPhoneNumber();
        this.profilePhoto = userDto.getProfilePhoto();
        this.isActive = userDto.getIsActive();
        this.isAdmin = userDto.getIsAdmin();
        this.userPositionId = userDto.getUserPositionId();
        this.evaluatedId = userDto.getEvaluatedId();
        this.evaluatorId = userDto.getEvaluatorId();
        this.activationCode = userDto.getActivationCode();

    }
}