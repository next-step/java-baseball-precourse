package baseball.type;

public enum GameMessageType {
    INPUT_NUMBER("숫자를 입력해주세요 : "),
    FINISH("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    RESTART_OR_FINISH("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
    STRIKE("스트라이크"),
    BALL("볼"),
    NOTHING("낫싱");

    private final String message;

    GameMessageType(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
