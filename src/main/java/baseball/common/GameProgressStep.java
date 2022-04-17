package baseball.common;

public enum GameProgressStep {
    NEW_GAME,
    END_OF_GAME;

    public static GameProgressStep findProgressStep(int selectedProgressStep) {
        return GameProgressStep.values()[selectedProgressStep - 1];
    }
}
