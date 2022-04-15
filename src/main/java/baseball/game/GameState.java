package baseball.game;

import java.util.List;

import static baseball.game.GameConfig.*;

public class GameState {
    private final NumberToIndex computerDigits = new NumberToIndex();

    public GameState() {
        computerDigits.putAll(GameUtil.randomNumbers(NUM_DIGITS, DIGIT_START, DIGIT_END));
    }

    public GameState(List<Integer> digits) {
        computerDigits.putAll(digits);
    }

    public NumberToIndex getComputerDigits() {
        return computerDigits;
    }
}
