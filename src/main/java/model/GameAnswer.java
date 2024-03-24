package model;

import java.util.List;

public class GameAnswer {
    private static final int NUM_OF_DIGIT = 3;

    private final List<Integer> answers;

    public GameAnswer(final RandomGenerator randomGenerator) {
        answers = randomGenerator.generateRandomNumber(NUM_OF_DIGIT);
    }

    public GameResult calculateGameResult(final GameInput gameInput) {
		return new GameResult(gameInput.getValues(), answers);
    }
}
