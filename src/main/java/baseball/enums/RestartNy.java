package baseball.enums;

public enum RestartNy {
    YES("1"), 
    NO("2");

    private String code;

    RestartNy(String code) { this.code = code; }

    public String getCode() { return code; }

    public static boolean restart(String response) {
        return response.equals(YES.code);
    }
}
