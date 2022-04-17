package baseball.game;

import baseball.game.util.Random;

import static baseball.game.GameConfig.*;

class GameState {
    private final NumberToIndex computersDigits = new NumberToIndex();

    GameState() {
        computersDigits.putAll(Random.randomNumbers(NUM_DIGITS, DIGIT_START, DIGIT_END));
    }

    NumberToIndex getComputersDigits() {
        return computersDigits;
    }
}
