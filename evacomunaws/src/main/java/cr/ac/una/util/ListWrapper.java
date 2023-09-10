
package cr.ac.una.util;

import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
import cr.ac.una.dto.UserDto;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "list")
@XmlSeeAlso(UserDto.class)
public class ListWrapper<D> {
    private List<D> list;
}
