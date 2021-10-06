package baseball.enums;

public enum GameMessage {

    BALL("볼"),
    STRIKE("스트라이크"),
    PLAYER_INPUT_MESSAGE("숫자를 입력해주세요 : "),
    ALL_STRIKE("3개의 숫자를 모두 맞히셨습니다! 게임 끝"),
    RESTART_NY("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요"),
    ERROR_INT("[ERROR] 숫자만 입력 가능 합니다"),
    ERROR_SIZE("[ERROR] 3자리 까지만 입력 가능합니다"),
    ERROR_DUPLICATION("[ERROR] 중복은 불가합니다."),
    SUCCESS_RESPONSE("성공");


    private String message;

    GameMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
