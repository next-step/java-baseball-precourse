package baseball.domain;

import baseball.strategy.RandomNumberStrategy;
import lombok.Builder;

import java.util.List;

public class Computer {

    private RandomNumberStrategy strategy;

    // default
    private int numberRangeStart = 1;
    private int numberRangeEnd = 9;
    private int numberCount = 3;

    @Builder
    public Computer(RandomNumberStrategy strategy) {
        this.strategy = strategy;
    }

    public List<Integer> getChoiceNumbers() {
        return strategy.getRandomNumberList(numberRangeStart, numberRangeEnd, numberCount);
    }

    public void changeNumberRange(final int numberRangeStart, final int numberRangeEnd) {
        this.numberRangeStart = numberRangeStart;
        this.numberRangeEnd = numberRangeEnd;
    }
    public void changeNumberCount(final int numberCount) {
        this.numberCount = numberCount;
    }

}
