package baseball.model;

import static baseball.constants.BaseballConstants.MAX_BALL_COUNT;

import java.util.ArrayList;
import java.util.List;

public class BaseballNumbers {

    private final List<BaseballNumber> numbers= new ArrayList<>();

    public BaseballNumbers(List<Integer> numbers) {
        validateSize(numbers);

        for (Integer i : numbers) {
            BaseballNumber baseballNumber = new BaseballNumber(i);
            validateDuplicateNumber(baseballNumber);
            this.numbers.add(baseballNumber);
        }
    }

    private void validateSize(final List<Integer> numbers) {
        if (numbers.size() > MAX_BALL_COUNT) {
            throw new IllegalArgumentException(String.format("야구 게임 숫자는 %s자리를 초과 할 수 없습니다.", MAX_BALL_COUNT));
        }
    }

    private void validateDuplicateNumber(final BaseballNumber baseballNumber) {
        if (numbers.contains(baseballNumber)) {
            throw new IllegalArgumentException("중복 된 숫자는 들어올 수 없습니다.");
        }
    }

    public List<BaseballNumber> getNumbers() {
        return numbers;
    }
}
