package baseball.model;

import java.util.List;

public abstract class Player {

    private final BaseballNumbers baseballNumbers;

    public Player(List<Integer> numbers) {
        this.baseballNumbers = new BaseballNumbers(numbers);
    }

    public BaseballNumbers getBaseballNumbers() {
        return this.baseballNumbers;
    }
}
