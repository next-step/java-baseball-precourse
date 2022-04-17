package baseball.game;

import baseball.game.util.Random;

import static baseball.game.GameConfig.*;

public class GameState {
    private final NumberToIndex computersDigits = new NumberToIndex();

    public GameState() {
        computersDigits.putAll(Random.randomNumbers(NUM_DIGITS, DIGIT_START, DIGIT_END));
    }

    public NumberToIndex getComputersDigits() {
        return computersDigits;
    }
}
