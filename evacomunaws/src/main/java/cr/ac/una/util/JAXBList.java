
package cr.ac.una.util;

import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.util.List;
import cr.ac.una.dto.UserDto;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@XmlRootElement(name = "list")
@XmlSeeAlso(UserDto.class)
public class JAXBList<T> {
    private List<T> list;
}
