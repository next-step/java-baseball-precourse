package baseball.domain.number;

import baseball.contant.BaseballConstant;
import baseball.contant.ExceptionMessage;
import java.util.List;

public class BaseballNumbers {
    private final List<BaseballNumber> values;

    private BaseballNumbers(List<BaseballNumber> values) {
        this.values = values;
    }

    public static BaseballNumbers from(List<BaseballNumber> values) {
        validateNumbers(values);
        return new BaseballNumbers(values);
    }

    private static void validateNumbers(List<BaseballNumber> values) {
        if (values.size() != BaseballConstant.BASEBALL_NUMBERS_SIZE) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_BASEBALL_NUMBERS_SIZE);
        }
    }

    public int size() {
        return this.values.size();
    }

    public BaseballNumber getBaseBallNumberByIndex(int index) {
        return this.values.get(index);
    }

    public boolean contains(BaseballNumber baseballNumber) {
        return this.values.contains(baseballNumber);
    }
}
