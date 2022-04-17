package baseball.game;

import static baseball.game.GameConfig.*;

class GameState {
    private final NumberToIndex computersDigits = new NumberToIndex();

    GameState() {
        computersDigits.putAll(GameUtil.randomNumbers(NUM_DIGITS, DIGIT_START, DIGIT_END));
    }

    NumberToIndex getComputersDigits() {
        return computersDigits;
    }
}
