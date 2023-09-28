package cr.ac.una.evacomunaws.entities;

import java.io.Serializable;
import java.util.List;
import static cr.ac.una.evacomunaws.util.Constants.SCHEMA;
import static cr.ac.una.evacomunaws.util.DatabaseSequences.SEQ_USER;
import cr.ac.una.evacomunaws.dto.UserDto;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Version;
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
import jakarta.persistence.OneToMany;
import jakarta.persistence.QueryHint;
import jakarta.persistence.FetchType;

/**
 * 
 * @author arayaroma
 */
@Entity
@Table(name = "TBL_USER", schema = SCHEMA)
@Data
@NoArgsConstructor
@AllArgsConstructor
@NamedQueries({
        @NamedQuery(name = "user.findAll", query = "SELECT u FROM User u", hints = @QueryHint(name = "eclipselink.refresh", value = "true")),
        @NamedQuery(name = "user.findById", query = "SELECT u FROM User u WHERE u.id = :id", hints = @QueryHint(name = "eclipselink.refresh", value = "true")),
        @NamedQuery(name = "user.findByIdentification", query = "SELECT u FROM User u WHERE u.identification = :identification", hints = @QueryHint(name = "eclipselink.refresh", value = "true")),
        @NamedQuery(name = "user.findByUsername", query = "SELECT u FROM User u WHERE u.username = :username", hints = @QueryHint(name = "eclipselink.refresh", value = "true")),
        @NamedQuery(name = "user.findByUsernameAndPassword", query = "SELECT u FROM User u WHERE u.username = :username AND u.password = :password", hints = @QueryHint(name = "eclipselink.refresh", value = "true")),
        @NamedQuery(name = "user.findByName", query = "SELECT u FROM User u WHERE LOWER(u.name) LIKE LOWER(:name)", hints = @QueryHint(name = "eclipselink.refresh", value = "true")),
        @NamedQuery(name = "user.findByPosition", query = "SELECT u FROM User u WHERE LOWER(u.position.name) = LOWER(:position)", hints = @QueryHint(name = "eclipselink.refresh", value = "true")),
        @NamedQuery(name = "user.findByActivationCode", query = "SELECT u FROM User u WHERE u.activationCode = :activationCode", hints = @QueryHint(name = "eclipselink.refresh", value = "true")),
        @NamedQuery(name = "user.findByEmail", query = "SELECT u FROM User u WHERE u.email = :email", hints = @QueryHint(name = "eclipselink.refresh", value = "true")),
})
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = SEQ_USER, sequenceName = SCHEMA + "." + SEQ_USER, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_USER)
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;

    @NotNull
    @Basic(optional = false)
    @Size(min = 1, max = 20)
    @Column(name = "USERNAME", unique = true)
    private String username;

    @NotNull
    @Basic(optional = false)
    @Size(min = 1, max = 16)
    @Column(name = "PASSWORD")
    private String password;

    @NotNull
    @Basic(optional = false)
    @Size(min = 1, max = 16)
    @Column(name = "NAME")
    private String name;

    @NotNull
    @Basic(optional = false)
    @Size(min = 1, max = 16)
    @Column(name = "LASTNAME")
    private String lastname;

    @NotNull
    @Basic(optional = false)
    @Size(min = 1, max = 16)
    @Column(name = "SECONDLASTNAME")
    private String secondLastname;

    @NotNull
    @Basic(optional = false)
    @Size(min = 1, max = 9)
    @Column(name = "IDENTIFICATION", unique = true)
    private String identification;

    @NotNull
    @Basic(optional = false)
    @Size(min = 1, max = 64)
    @Column(name = "EMAIL")
    private String email;

    @NotNull
    @Basic(optional = false)
    @Size(min = 1, max = 8)
    @Column(name = "LANDLINENUMBER")
    private String landlineNumber;

    @NotNull
    @Basic(optional = false)
    @Size(min = 1, max = 8)
    @Column(name = "PHONENUMBER")
    private String phoneNumber;

    @NotNull
    @Basic(optional = false)
    @Size(min = 1, max = 1)
    @Column(name = "ISACTIVE")
    private String isActive;

    @NotNull
    @Basic(optional = false)
    @Size(min = 1, max = 1)
    @Column(name = "ISADMIN")
    private String isAdmin;

    @NotNull
    @Basic(optional = false)
    @Size(min = 1, max = 1)
    @Column(name = "PASSWORDCHANGED")
    private String passwordChanged;

    @Basic(optional = false)
    @Size(min = 1, max = 100)
    @Column(name = "ACTIVATIONCODE")
    private String activationCode;

    @Lob
    @Column(name = "PROFILEPHOTO")
    private byte[] profilePhoto;

    @ManyToOne
    @JoinColumn(name = "USERPOSITIONID")
    private Position position;

    @OneToMany(mappedBy = "evaluated", fetch = FetchType.LAZY)
    private List<Evaluated> evaluated;

    @OneToMany(mappedBy = "evaluator", fetch = FetchType.LAZY)
    private List<Evaluator> evaluators;

    @Version
    @Column(name = "VERSION")
    private Long version;

    /**
     * @param userDto constructor from dto to entity
     */
    public User(UserDto userDto) {
        this.id = userDto.getId();
        updateUser(userDto);
    }

    /**
     * @param userDto updates the userDto
     */
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
        this.isActive = userDto.getIsActive();
        this.isAdmin = userDto.getIsAdmin();
        this.passwordChanged = userDto.getPasswordChanged();
        this.activationCode = userDto.getActivationCode();
        this.profilePhoto = userDto.getProfilePhoto();
        this.version = userDto.getVersion();
    }
}