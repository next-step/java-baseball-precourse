package baseball.domain;

public enum GameStatus {
    START(1),
    END(2),
    ;

    private int gameStatus;

    GameStatus(int gameStatus) {
        this.gameStatus = gameStatus;
    }

    public int getGameStatus() {
        return gameStatus;
    }
}
