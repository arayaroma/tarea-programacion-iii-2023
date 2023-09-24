package cr.ac.una.dto;

import java.util.ArrayList;
import java.util.List;

import cr.ac.una.entities.Position;
import cr.ac.una.entities.Skill;
import cr.ac.una.entities.User;
import cr.ac.una.util.EntityMapper;
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
public class UserDto implements EntityMapper<User, UserDto> {

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
     * @param entity Entity to be converted
     * @param dto DTO to be updated
     * @return DTO with the updated information
     */
    @Override
    public UserDto convertFromEntityToDTO(User entity, UserDto dto) {
        dto.setPosition(new PositionDto(entity.getPosition()));
        dto.getPosition().setUsers(
                EntityUtil.fromEntityList(entity.getPosition().getUsers(), UserDto.class)
                        .getList());
        dto.getPosition().setSkills(
                EntityUtil.fromEntityList(entity.getPosition().getSkills(), SkillDto.class)
                        .getList());
//        dto.setEvaluators(EntityUtil.fromEntityList(entity.getEvaluators(), EvaluatorDto.class).getList());
//        dto.setEvaluated(EntityUtil.fromEntityList(entity.getEvaluated(), EvaluatedDto.class).getList());
        return dto;
    }

    /**
     * @param dto DTO to be converted
     * @param entity Entity to be updated
     * @return Entity with the updated information
     */
    @Override
    public User convertFromDTOToEntity(UserDto dto, User entity) {
        entity.setPosition(new Position(dto.getPosition()));
        entity.getPosition().setUsers(
                EntityUtil.fromDtoList(dto.getPosition().getUsers(), User.class)
                        .getList());
        entity.getPosition().setSkills(
                EntityUtil.fromDtoList(dto.getPosition().getSkills(), Skill.class)
                        .getList());
        return entity;
    }

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
        this.version = user.getVersion();
        this.position = new PositionDto();
        this.evaluated = new ArrayList<>();
        this.evaluators = new ArrayList<>();

    }
}
