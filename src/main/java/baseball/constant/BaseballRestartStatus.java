package baseball.constant;

public enum BaseballRestartStatus {
    Y("1"),
    N("2");

    private final String value;

    BaseballRestartStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static boolean isRestart(String value) {
        return Y.value.equals(value);
    }

    public static boolean isWrong(String value) {
        return !Y.value.equals(value) && !(N.value.equals(value));
    }
}
