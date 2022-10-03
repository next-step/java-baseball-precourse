package baseball.controller;

public enum ErrorMessage {

    GAME_ALREADY_IN_PROGRESS_ERROR("이미 게임이 진행중입니다."),
    INVALID_CONTINUE_KEY_INPUT_ERROR("키는 시작(%s) 또는 종료(%s)만 입력할 수 있습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    } 

    public String getMessage() {
        return message;
    }

    public String getMessage(Object... values) {
        return String.format(message, values);
    }
}
