package baseball.domain;

public enum GameState {
    START, STOP;

    public static GameState getGameState(int num) {
        if (num == 1) {
            return START;
        }

        if (num == 2) {
            return STOP;
        }

        return null;
    }
}
