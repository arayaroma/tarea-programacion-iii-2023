package cr.ac.una.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private PositionDto position;
}
