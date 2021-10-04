package baseball.error;

public enum ErrorCode {

    VALIDATE_EXCEPTION_IS_NOT_NUMBER_OR_CONTAIN_ZERO("400", "문자열이 포함되어 있거나 0이 포함되어 있습니다"),
    VALIDATE_EXCEPTION_IS_NOT_THREE_DIGITS("400", "3자리 수가 아닙니다."),
    VALIDATE_EXCEPTION_IS_DUPLICATE("400", "중복되는 값이 존재합니다.");

    private ErrorCode() {
    }

    private String code;
    private String message;

    ErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}