package baseball.domain;

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
