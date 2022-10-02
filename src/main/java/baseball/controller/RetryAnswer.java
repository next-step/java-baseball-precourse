package baseball.controller;

public enum RetryAnswer {
    PLAY_NEW_GAME,
    END_GAME;

    public static RetryAnswer from(String answer) {
        if ("1".equals(answer)) {
            return PLAY_NEW_GAME;
        }
        return END_GAME;
    }

    public boolean isEndGame() {
        return this == END_GAME;
    }
}
