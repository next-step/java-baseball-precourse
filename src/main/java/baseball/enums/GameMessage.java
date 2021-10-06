package baseball.enums;

public enum GameMessage {

    PLAYER_INPUT_MESSAGE("숫자를 입력해주세요 : "),
    ALL_STRIKE("3개의 숫자를 모두 맞히셨습니다! 게임 끝"),
    RESTART_NY("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요"),
    STRIKE("스트라이크"),
    BALL("볼");

    private String message;

    GameMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
