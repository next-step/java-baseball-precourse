package baseball.domain;

import java.util.List;

public class BaseballNumber {
    private final BaseballNumberValidator validator;

    private List<Integer> numbers;

    public BaseballNumber(BaseballNumberValidator validator) {
        this.validator = validator;
    }

    public void setNumbers(List<Integer> numbers) {
        validator.validate(numbers);

        this.numbers = numbers;
    }

    public Integer get(int index) {
        return numbers.get(index);
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    public int size() {
        return numbers.size();
    }
}
