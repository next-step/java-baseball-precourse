package baseball.game;

import java.util.List;

import static baseball.game.GameConfig.*;

public class GameState {
    private final NumberToIndex computersDigits = new NumberToIndex();

    public GameState() {
        computersDigits.putAll(GameUtil.randomNumbers(NUM_DIGITS, DIGIT_START, DIGIT_END));
    }

    public GameState(List<Integer> digits) {
        computersDigits.putAll(digits);
    }

    public NumberToIndex getComputersDigits() {
        return computersDigits;
    }
}
