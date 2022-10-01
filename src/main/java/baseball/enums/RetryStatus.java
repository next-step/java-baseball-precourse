package baseball.enums;

public enum RetryStatus {
    RETRY("1"),
    EXIT("2");

    private String code;

    RetryStatus(String code) {
        this.code = code;
    }

    public static RetryStatus fromCode(String code) {
        if ("1".equals(code))
            return RETRY;
        if ("2".equals(code))
            return EXIT;
        throw new IllegalArgumentException();
    }
}
