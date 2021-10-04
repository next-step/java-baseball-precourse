package baseball.common;

public enum GameErrorMessage {
    INCORRECT_VALUE("[ERROR] 잘못된 값을 입력하였습니다.");

    private final String message;

    GameErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
