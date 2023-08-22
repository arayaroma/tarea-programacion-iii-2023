package cr.ac.una.util;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseWrapper implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer status;
    private ResponseCode code;
    private String message;
    private Object data;
}
