package cr.ac.una.dto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import cr.ac.una.entities.User;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
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
    @XmlElement(name = "id")
    private Long id;
    @XmlElement(name = "username")
    private String username;
    @XmlElement(name = "password")
    private String password;
    @XmlElement(name = "name")
    private String name;
    @XmlElement(name = "lastname")
    private String lastname;
    @XmlElement(name = "secondLastname")
    private String secondLastname;
    @XmlElement(name = "identification")
    private String identification;
    @XmlElement(name = "email")
    private String email;
    @XmlElement(name = "landlineNumber")
    private String landlineNumber;
    @XmlElement(name = "phoneNumber")
    private String phoneNumber;
    @XmlElement(name = "profilePhoto")
    private byte[] profilePhoto;
    @XmlElement(name = "isActive")
    private String isActive;
    @XmlElement(name = "isAdmin")
    private String isAdmin;
    @XmlElement(name = "passwordChanged")
    private String passwordChanged;
    @XmlElement(name = "activationCode")
    private String activationCode;
    @XmlElement(name = "position")
    private PositionDto position;
    @XmlElement(name = "evaluated")
    private List<EvaluatedDto> evaluated;
    @XmlElement(name = "evaluators")
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

    /**
        * @param users list of users to be converted to dto
     **/
    //TODO: Analyze if this belongs in userDto
    public static UserDtoList fromEntityList(List<User> users) {
        UserDtoList userDtoList = new UserDtoList();
        if (users == null || users.isEmpty()) {
            return userDtoList;
        }

        List<UserDto> userDtos = new ArrayList<>();
        for (User user : users) {
            userDtos.add(new UserDto(user));
        }


        userDtoList.setUserDtoList(userDtos);
        return userDtoList;
    }
}
