package cr.ac.una.util;

public enum ResponseCode {
    OK(200),
    NO_CONTENT(204),
    MOVED_PERMANENTLY(301),
    FOUND(302),
    BAD_REQUEST(400),
    UNATHORIZED(401),
    FORBIDDEN(403),
    NOT_FOUND(404),
    METHOD_NOT_ALLOWED(405),
    PROXY_AUTHENTICATION_REQUIRED(407),
    REQUEST_TIMEOUT(408),
    IM_A_TEAPOT(418),
    TOO_MANY_REQUESTS(429),
    INTERNAL_SERVER_ERROR(500),
    NOT_IMPLEMENTED(501),
    BAD_GATEWAY(502),
    SERVICE_UNAVAILABLE(503);

    private Integer code;

    private ResponseCode(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
