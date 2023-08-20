package cr.ac.una.dto;

import cr.ac.una.services.impl.User;
import cr.ac.una.services.impl.Position;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PositionDto {
    protected Long id;
    protected String name;
    protected String state;
    protected List<User> users;

    public Position toPosition() {
        Position position = new Position();
        position.setId(id);
        position.setName(name);
        position.setState(state);
        return position;
    }
}
