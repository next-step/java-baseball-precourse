package baseball;

public enum COMMAND {
    CONTINUE("1"),
    END("2");
    public final String code;
    COMMAND(String code) {
        this.code = code;
    }
}
