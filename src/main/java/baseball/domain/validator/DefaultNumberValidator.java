package baseball.domain.validator;

import baseball.constant.BaseballMessages;
import baseball.domain.BaseballNumberConfig;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DefaultNumberValidator implements NumberValidator {
    private final int startRandomNumber;
    private final int endRandomNumber;
    private final int numberCount;

    public DefaultNumberValidator(BaseballNumberConfig numberConfig) {
        this.startRandomNumber = numberConfig.getStartRandomNumber();
        this.endRandomNumber = numberConfig.getEndRandomNumber();
        this.numberCount = numberConfig.getNumberCount();
    }

    @Override
    public void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateRange(numbers);
        validateUnique(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != numberCount) {
            throw new IllegalArgumentException(String.format(BaseballMessages.ERROR_NUMBER_COUNT, numberCount));
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            validateRange(number);
        }
    }

    private void validateRange(Integer number) {
        if (number < startRandomNumber || number > endRandomNumber) {
            throw new IllegalArgumentException(
                    String.format(BaseballMessages.ERROR_NUMBER_RANGE, startRandomNumber, endRandomNumber));
        }
    }

    private void validateUnique(List<Integer> numbers) {
        Set<Integer> numberSet = new HashSet<>(numbers);
        if (numberSet.size() != numberCount) {
            throw new IllegalArgumentException(BaseballMessages.ERROR_NUMBER_DUPLICATE);
        }
    }
}
