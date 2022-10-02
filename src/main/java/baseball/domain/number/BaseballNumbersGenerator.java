package baseball.domain.number;

import java.util.List;

public class BaseballNumbersGenerator {
    private NumberGenerateStrategy strategy;

    public BaseballNumbersGenerator(NumberGenerateStrategy strategy) {
        this.strategy = strategy;
    }

    public List<BaseballNumber> generate() {
        return strategy.generate();
    }
}
