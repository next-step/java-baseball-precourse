package baseball.exception;

public enum ErrorMessage {
    ESCAPE_NUMBER_EXCEPTION("1에서 9까지의 숫자만 입력할 수 있습니다."),
    THREE_NUMBER_EXCEPTION("세 자리의 숫자만 입력할 수 있습니다."),
    DUPLICATE_NUMBER_EXCEPTION("중복되지 않은 숫자만 입력할 수 있습니다."),
    ERROR ("[ERROR] ");

    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getErrorMessage() {
        return ERROR.getMessage() + message;
    }
}
