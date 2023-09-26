package cr.ac.una.evacomuna.util;

/**
 *
 * @author estebannajera
 */
public enum CalificationCode {
    EXCEPTIONAL(Long.valueOf(4)),
    ABOVE_EXPECTATIONS(Long.valueOf(3)),
    EXPECTATIONS(Long.valueOf(2)),
    UNDER_EXPECTATIONS(Long.valueOf(1));
    private Long code;

    private CalificationCode(Long code) {
        this.code = code;
    }

    public Long getCode() {
        return code;
    }

}
