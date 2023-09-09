package cr.ac.una.dto;

import java.util.List;
import cr.ac.una.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author arayaroma
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
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
        this.position = new PositionDto(user.getPosition());
        this.isActive = user.getIsActive();
        this.isAdmin = user.getIsAdmin();
        this.passwordChanged = user.getPasswordChanged();
        this.activationCode = user.getActivationCode();
        this.version = user.getVersion();
    }
}
