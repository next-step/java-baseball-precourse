package baseball.domain;

public enum GameMessage {
    STRIKE("스트라이크"),
    BALL("볼"),
    NOTHING("낫싱"),
    GAME_OVER("게임 끝"),
    ;

    private String msg;

    GameMessage(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
