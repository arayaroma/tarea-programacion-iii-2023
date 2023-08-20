package cr.ac.una.dto;

import java.util.ArrayList;
import java.util.List;

import cr.ac.una.entities.Position;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PositionDto {
    private Long id;
    private String name;
    private String state;
    private List<UserDto> users = new ArrayList<>();

    public PositionDto(Position position) {
        this.id = position.getId();
        this.name = position.getName();
        this.state = position.getState();
        position.getUsers().forEach(user -> {
            this.users.add(new UserDto(user));
        });
    }
}
