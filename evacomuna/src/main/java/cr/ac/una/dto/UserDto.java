package cr.ac.una.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import cr.ac.una.services.impl.User;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    protected String email;
    protected Long id;
    protected String identification;
    protected String isActive;
    protected String isAdmin;
    protected String landlineNumber;
    protected String lastname;
    protected String name;
    protected String password;
    protected String phoneNumber;
    protected PositionDto position;
    protected byte[] profilePhoto;
    protected String secondLastname;
    protected String username;;

    public User toUser(UserDto userDto) {
        User user = new User();
        user.setEmail(userDto.getEmail());
        user.setId(userDto.getId());
        user.setIdentification(userDto.getIdentification());
        user.setIsActive(userDto.getIsActive());
        user.setIsAdmin(userDto.getIsAdmin());
        user.setLandlineNumber(userDto.getLandlineNumber());
        user.setLastname(userDto.getLastname());
        user.setName(userDto.getName());
        user.setPassword(userDto.getPassword());
        if (userDto.getPosition() != null) {
            user.setPosition(userDto.getPosition().toPosition());
        }
        user.setProfilePhoto(userDto.getProfilePhoto());
        user.setSecondLastname(userDto.getSecondLastname());
        user.setUsername(userDto.getUsername());
        return user;
    }
}
