package cr.ac.una.util;

import java.io.Serializable;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlSeeAlso({ ListWrapper.class })
public class ResponseWrapper implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer status;
    private ResponseCode code;
    private String message;
    private Object data;
}
