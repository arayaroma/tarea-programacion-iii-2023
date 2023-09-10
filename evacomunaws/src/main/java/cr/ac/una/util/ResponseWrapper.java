package cr.ac.una.util;

import java.io.Serializable;

import cr.ac.una.dto.UserDto;
import cr.ac.una.dto.UserDtoList;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlSeeAlso({UserDtoList.class, UserDto.class})
public class ResponseWrapper implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer status;
    private ResponseCode code;
    private String message;
    private Object data;
}
