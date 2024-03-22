package model;

import java.util.List;

public class GameModel {
    private static final int NUM_OF_DIGIT = 3;

    private final List<Integer> answer;

    public GameModel(final RandomGenerator randomGenerator) {
        answer = randomGenerator.generateRandomNumber(NUM_OF_DIGIT);
    }

    public boolean isGameEnd(final GameInput gameInput) {
        return gameInput.hasSameValue(answer);
    }

    public GameResult calculateGameResult(final GameInput gameInput) {
		return new GameResult(gameInput.getValues(), answer);
    }
}
