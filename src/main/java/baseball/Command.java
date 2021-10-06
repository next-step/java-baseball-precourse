package baseball;

public enum Command {
    RESTART("1"), EXIT("2");
    private final String value;

    Command(String value) {
        this.value = value;
    }

    public static Command of(String value) {
        switch (value) {
            case "1":
                return RESTART;
            case "2":
                return EXIT;
            default:
                throw new IllegalArgumentException("[ERROR] 종료 커맨드가 올바르지 않습니다");
        }
    }
}
