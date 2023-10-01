package cr.ac.una.evacomuna.util;

/**
 *
 * @author estebannajera
 * @author arayaroma
 */
public enum CalificationCode {
    EXCEPTIONAL(Long.valueOf(4)),
    ABOVE_EXPECTATIONS(Long.valueOf(3)),
    MEETS_EXPECTATIONS(Long.valueOf(2)),
    UNDER_EXPECTATIONS(Long.valueOf(1));

    private Long code;

    private CalificationCode(Long code) {
        this.code = code;
    }

    public Long getCode() {
        return code;
    }

    public static Long parseStringToCode(String code) {
        if (code == "Exceptional") {
            return CalificationCode.EXCEPTIONAL.getCode();
        }
        if (code == "Meets Expectations") {
            return CalificationCode.MEETS_EXPECTATIONS.getCode();
        }
        if (code == "Under Expectations") {
            return CalificationCode.UNDER_EXPECTATIONS.getCode();
        }
        if (code == "Above Expectations") {
            return CalificationCode.ABOVE_EXPECTATIONS.getCode();
        }
        return Long.valueOf(-1);
    }

    public static String parseCodeToString(Long code) {
        if (code == CalificationCode.ABOVE_EXPECTATIONS.getCode()) {
            return "Above Expectations";
        } else if (code == CalificationCode.UNDER_EXPECTATIONS.getCode()) {
            return "Under Expectations";
        } else if (code == CalificationCode.MEETS_EXPECTATIONS.getCode()) {
            return "Meets Expectations";
        }
        if (code == CalificationCode.EXCEPTIONAL.getCode()) {
            return "Exceptional";
        }
        return "";
    }

}
