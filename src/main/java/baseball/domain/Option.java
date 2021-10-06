package baseball.domain;

/**
 * @author theco2de
 * @version 1.0
 * @since 1.0
 */
public enum Option {

    RESTART("1", false),
    EXIT("2", true);

    private final String code;
    private final boolean value;

    Option(String code, boolean value) {
        this.code = code;
        this.value = value;
    }

    public String getCode() {
        return code;
    }

    public boolean isValue() {
        return value;
    }
}
