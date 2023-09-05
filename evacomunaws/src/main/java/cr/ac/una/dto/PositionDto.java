package cr.ac.una.dto;

import java.util.List;
import java.util.stream.Collectors;

import cr.ac.una.entities.Position;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author arayaroma
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PositionDto {
    private Long id;
    private String name;
    private String state;
    private Long version;
    private List<UserDto> usersList;

    /**
     * @param position constructor from entity to dto
     */
    public PositionDto(Position position) {
        this.id = position.getId();
        this.name = position.getName();
        this.state = position.getState();
        this.version = position.getVersion();
        this.usersList = position.getUsersList() != null
                ? position.getUsersList()
                        .stream()
                        .map(UserDto::new)
                        .collect(Collectors.toList())
                : null;
    }
}