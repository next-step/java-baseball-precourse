package baseball.util;

public enum Message {
    INPUT("숫자를 입력해주세요 : "),
    CHOICE("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
    BALL("%d볼 "),
    STRIKE("%d스트라이크"),
    NOTHING("낫싱"),
    FINISH("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    ERROR_INPUT("잘못된 입력입니다. 프로그램을 종료합니다.");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
