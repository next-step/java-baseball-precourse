package baseball.code;

public enum GameStatus {
    RESTART_GAME("1"),
    END_GAME("2"),
    CONTINUE_GAME("3");

    private final String gameStatus;

    GameStatus(String gameStatus) {
        this.gameStatus = gameStatus;
    }

    public String getGameStatus() {
        return this.gameStatus;
    }
}
