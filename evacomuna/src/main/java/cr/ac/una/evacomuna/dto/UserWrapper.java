/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cr.ac.una.evacomuna.dto;

import cr.ac.una.controller.EvaluatedDto;
import cr.ac.una.controller.EvaluatorDto;
import cr.ac.una.controller.PositionDto;
import cr.ac.una.controller.UserDto;
import java.util.List;

/**
 *
 * @author estebannajera
 */
public class UserWrapper {
// private String activationCode;
// private String username;
// private String password;
// private String email;
// private String activationCode;

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

    public UserWrapper(UserDto userDto) {
        this.activationCode = userDto.getActivationCode();
        this.isActive = userDto.getIsActive();
        this.isAdmin = userDto.getIsAdmin();
        this.email = userDto.getEmail();
        this.name = userDto.getName();
        this.lastname = userDto.getLastname();
        this.secondLastname = userDto.getSecondLastname();
        this.landlineNumber = userDto.getLandlineNumber();
        this.phoneNumber = userDto.getPhoneNumber();
        this.email = userDto.getEmail();
        this.id = userDto.getId();
        this.version = userDto.getVersion();
        this.password = userDto.getPassword();
        this.passwordChanged = userDto.getPasswordChanged();
        this.username = userDto.getUsername();
        this.version = userDto.getVersion();

    }

    public UserDto getDto() {
        UserDto userDto = new UserDto();
        userDto.setActivationCode(activationCode);
        userDto.setEmail(email);
        userDto.setName(name);
        userDto.setId(id);
        userDto.setUsername(username);
        userDto.setLandlineNumber(landlineNumber);
        userDto.setPhoneNumber(phoneNumber);
        userDto.setIdentification(identification);
        userDto.setVersion(version);
        userDto.setSecondLastname(secondLastname);
        userDto.setIsActive(isActive);
        userDto.setIsAdmin(isAdmin);
        userDto.setProfilePhoto(profilePhoto);
        userDto.setPassword(password);
        userDto.setPasswordChanged(passwordChanged);
        return userDto;
    }
}
