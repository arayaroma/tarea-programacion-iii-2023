package cr.ac.una.dto;

import java.util.List;
import cr.ac.una.entities.User;
import cr.ac.una.util.EntityUtil;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author arayaroma
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "UserDto")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserDto {
    private Long id;
    private String username;
    private String password;
    private String name;
    private String lastname;
    private String secondLastname;
    private String identification;
    private String email;
    private String landlineNumber;
    private String phoneNumber;
    private byte[] profilePhoto;
    private String isActive;
    private String isAdmin;
    private String passwordChanged;
    private String activationCode;
    private PositionDto position;
    private List<EvaluatedDto> evaluated;
    private List<EvaluatorDto> evaluators;
    private Long version;

    /**
     * @param user constructor from entity to dto
     */
    public UserDto(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.name = user.getName();
        this.lastname = user.getLastname();
        this.secondLastname = user.getSecondLastname();
        this.identification = user.getIdentification();
        this.email = user.getEmail();
        this.landlineNumber = user.getLandlineNumber();
        this.phoneNumber = user.getPhoneNumber();
        this.profilePhoto = user.getProfilePhoto();
        this.isActive = user.getIsActive();
        this.isAdmin = user.getIsAdmin();
        this.passwordChanged = user.getPasswordChanged();
        this.activationCode = user.getActivationCode();
        this.evaluated = EntityUtil.fromEntityList(user.getEvaluated(), EvaluatedDto.class).getList();
        this.evaluators = EntityUtil.fromEntityList(user.getEvaluators(), EvaluatorDto.class).getList();
        this.version = user.getVersion();
    }

}
