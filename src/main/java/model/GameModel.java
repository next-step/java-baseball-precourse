package model;

import java.util.List;

public class GameModel {
    private static final int NUM_OF_DIGIT = 3;

    private final List<Integer> answer;

    public GameModel(final RandomGenerator randomGenerator) {
        answer = randomGenerator.generateRandomNumber(NUM_OF_DIGIT);
    }

    public boolean isGameEnd(final String number) {
        return Integer.parseInt(number) == answer.get(0) * 100 + answer.get(1) * 10 + answer.get(2);
    }

    public GameResult calculateGameResult(final String number) {
		return new GameResult(number, answer);
    }
}
