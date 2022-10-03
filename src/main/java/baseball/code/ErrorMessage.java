package baseball.code;

public enum ErrorMessage {
    INVALID_BALL_LIST_SIZE("Invalid ball list size"),
    INVALID_BALL_VALUE_TYPE("Invalid ball value type"),
    INVALID_BALL_DUPLICATE("Invalid ball duplicate"),
    INVALID_DECIDE_RESTART_STRING("Invalid decide restart string");

    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return "[ERROR] " + this.errorMessage;
    }

}
