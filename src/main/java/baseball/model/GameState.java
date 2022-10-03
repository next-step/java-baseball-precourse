package baseball.model;

public enum GameState {
    PLAY,
    VICTORY,
    DEFEAT,
    END;

    public static boolean isVictoryGame(GameState gameState) {
        return gameState.equals(VICTORY);
    }

    public static boolean isPlayGame(GameState gameState) {
        return gameState.equals(PLAY);
    }

    public static boolean isDefeatGame(GameState gameState) {
        return gameState.equals(DEFEAT);
    }
}
