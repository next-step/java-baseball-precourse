package baseball.domain.generator;

import baseball.domain.BaseballNumberConfig;
import baseball.util.NumberUtil;

import java.util.List;

public class RandomNumberGenerator implements NumberGenerator {
    private final BaseballNumberConfig numberConfig;

    public RandomNumberGenerator(BaseballNumberConfig numberConfig) {
        this.numberConfig = numberConfig;
    }

    @Override
    public List<Integer> generateNumbers() {
        int startRandomNumber = numberConfig.getStartRandomNumber();
        int endRandomNumber = numberConfig.getEndRandomNumber();
        int numberCount = numberConfig.getNumberCount();

        return NumberUtil.pickUniqueNumbers(startRandomNumber, endRandomNumber, numberCount);
    }
}
