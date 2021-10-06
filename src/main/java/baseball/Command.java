package baseball;

public enum Command {
    RESTART, EXIT;

    public static Command of(String value) {
        if ("1".equals(value)) return RESTART;
        return EXIT;
    }
}
