package baseball.game;

import java.util.List;

import static baseball.game.GameConfig.NUM_NUMBERS;

public class GameState {
    private final NumberToIndex computerNumbers = new NumberToIndex();

    public GameState() {
        computerNumbers.putAll(GameUtil.randomNumbers(NUM_NUMBERS, 1, 9));
    }

    public GameState(List<Integer> numbers) {
        computerNumbers.putAll(numbers);
    }

    public NumberToIndex getComputerNumbers() {
        return computerNumbers;
    }
}
