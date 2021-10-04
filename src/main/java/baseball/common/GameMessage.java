package baseball.common;

public enum GameMessage {
    ASK_CONTINUE("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

    private final String message;

    GameMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
