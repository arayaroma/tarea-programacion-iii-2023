package cr.ac.una.dto;

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

    public PositionDto(Position position) {
        this.id = position.getId();
        this.name = position.getName();
        this.state = position.getState();
    }
}