package baseball.domain;

public enum GameMessage {
    STRIKE("스트라이크"),
    BALL("볼"),
    NOTHING("낫싱"),
    GAME_OVER("게임 끝"),
    GAME_CLEAR("3개의 숫자를 모두 맞히셨습니다! 게임 끝"),
    GAME_STATUS_CHOICE("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
    INPUT_PICK_NUMBER("숫자를 입력해주세요 : "),
    NEW_GAME("==========[ New Game ]=========="),
    ;

    private String msg;

    GameMessage(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
