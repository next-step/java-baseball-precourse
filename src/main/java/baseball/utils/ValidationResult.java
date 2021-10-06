package baseball.utils;

/**
 * @author KingCjy
 */
public enum ValidationResult {
    SUCCESS(""),
    BALL_INVALID_LENGTH("[ERROR] 3자리 숫자로 입력해주세요."),
    BALL_IS_NOT_NUMBER("[ERROR] 1~9까지의 숫자를 입력해주세요."),
    BALL_DUPLICATED_NUMBER("[ERROR] 중복된 숫자를 허용하지 않습니다."),

    RESTART_INVALID("[ERROR] 게임 재시작은 1, 종료는 2만 입력 가능합니다.");

    private final String message;

    ValidationResult(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void printMessage() {
        if ("".equals(this.message)) {
            return;
        }

        System.out.println(this.message);
    }
}
