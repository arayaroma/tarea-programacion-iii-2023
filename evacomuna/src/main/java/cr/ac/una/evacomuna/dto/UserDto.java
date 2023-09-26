package cr.ac.una.evacomuna.dto;

import java.util.ArrayList;
import java.util.List;
import cr.ac.una.evacomuna.util.DtoMapper;

/**
 * FIXME: Add Equals and Hash
 * API WORKING, REPLICATE OVER ALL DTOS AND SERVICES
 * 
 * @author estebannajera
 * @author arayaroma
 */
public class UserDto implements DtoMapper<cr.ac.una.controller.UserDto, UserDto> {

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

    @Override
    public UserDto convertFromGeneratedToDTO(cr.ac.una.controller.UserDto generated, UserDto dto) {
        dto.setPosition(new PositionDto(generated.getPosition()));
        dto.getPosition().setUsers(
                DtoMapper.fromGeneratedList(generated.getPosition().getUsers(), UserDto.class).getList());

        dto.getPosition().setSkills(
                DtoMapper.fromGeneratedList(
                        generated.getPosition().getSkills(), SkillDto.class).getList());
        return dto;
    }

    @Override
    public cr.ac.una.controller.UserDto convertFromDTOToGenerated(UserDto dto, cr.ac.una.controller.UserDto generated) {
        generated.setPosition(dto.getPosition().getDto());
        generated.getPosition().getUsers().addAll(
                DtoMapper.fromDtoList(dto.getPosition().getUsers(), cr.ac.una.controller.UserDto.class).getList());

        generated.getPosition().getSkills().addAll(
                DtoMapper.fromDtoList(dto.getPosition().getSkills(), cr.ac.una.controller.SkillDto.class).getList());

        return generated;
    }

    public UserDto() {
    }

    public UserDto(cr.ac.una.controller.UserDto userDto) {
        this.id = userDto.getId();
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
        this.passwordChanged = userDto.getPasswordChanged();
        this.activationCode = userDto.getActivationCode();
        this.version = userDto.getVersion();
        this.position = new PositionDto();
        this.evaluated = new ArrayList<>();
        this.evaluators = new ArrayList<>();
    }

    public cr.ac.una.controller.UserDto getDto() {
        cr.ac.una.controller.UserDto userDto = new cr.ac.una.controller.UserDto();
        userDto.setId(id);
        userDto.setUsername(username);
        userDto.setPassword(password);
        userDto.setName(name);
        userDto.setLastname(lastname);
        userDto.setSecondLastname(secondLastname);
        userDto.setIdentification(identification);
        userDto.setEmail(email);
        userDto.setLandlineNumber(landlineNumber);
        userDto.setPhoneNumber(phoneNumber);
        userDto.setProfilePhoto(profilePhoto);
        userDto.setIsActive(isActive);
        userDto.setIsAdmin(isAdmin);
        userDto.setPasswordChanged(passwordChanged);
        userDto.setActivationCode(activationCode);
        userDto.setVersion(version);
        userDto.setPosition(position.getDto());
        return userDto;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return this.lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getSecondLastname() {
        return this.secondLastname;
    }

    public void setSecondLastname(String secondLastname) {
        this.secondLastname = secondLastname;
    }

    public String getIdentification() {
        return this.identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLandlineNumber() {
        return this.landlineNumber;
    }

    public void setLandlineNumber(String landlineNumber) {
        this.landlineNumber = landlineNumber;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public byte[] getProfilePhoto() {
        return this.profilePhoto;
    }

    public void setProfilePhoto(byte[] profilePhoto) {
        this.profilePhoto = profilePhoto;
    }

    public String getIsActive() {
        return this.isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    public String getIsAdmin() {
        return this.isAdmin;
    }

    public void setIsAdmin(String isAdmin) {
        this.isAdmin = isAdmin;
    }

    public String getPasswordChanged() {
        return this.passwordChanged;
    }

    public void setPasswordChanged(String passwordChanged) {
        this.passwordChanged = passwordChanged;
    }

    public String getActivationCode() {
        return this.activationCode;
    }

    public void setActivationCode(String activationCode) {
        this.activationCode = activationCode;
    }

    public PositionDto getPosition() {
        return this.position;
    }

    public void setPosition(PositionDto position) {
        this.position = position;
    }

    public List<EvaluatedDto> getEvaluated() {
        return this.evaluated;
    }

    public void setEvaluated(List<EvaluatedDto> evaluated) {
        this.evaluated = evaluated;
    }

    public List<EvaluatorDto> getEvaluators() {
        return this.evaluators;
    }

    public void setEvaluators(List<EvaluatorDto> evaluators) {
        this.evaluators = evaluators;
    }

    public Long getVersion() {
        return this.version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", username='" + getUsername() + "'" +
                ", password='" + getPassword() + "'" +
                ", name='" + getName() + "'" +
                ", lastname='" + getLastname() + "'" +
                ", secondLastname='" + getSecondLastname() + "'" +
                ", identification='" + getIdentification() + "'" +
                ", email='" + getEmail() + "'" +
                ", landlineNumber='" + getLandlineNumber() + "'" +
                ", phoneNumber='" + getPhoneNumber() + "'" +
                ", profilePhoto='" + getProfilePhoto() + "'" +
                ", isActive='" + getIsActive() + "'" +
                ", isAdmin='" + getIsAdmin() + "'" +
                ", passwordChanged='" + getPasswordChanged() + "'" +
                ", activationCode='" + getActivationCode() + "'" +
                ", position='" + getPosition() + "'" +
                ", evaluated='" + getEvaluated() + "'" +
                ", evaluators='" + getEvaluators() + "'" +
                ", version='" + getVersion() + "'" +
                "}";
    }

}
