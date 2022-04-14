package baseball.domain;

import java.util.List;

public class BaseballNumber {
    private final List<Integer> numbers;

    public BaseballNumber(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public Integer get(int index) {
        return numbers.get(index);
    }

    public boolean contains(Integer number) {
        return numbers.contains(number);
    }

    public int size() {
        return numbers.size();
    }
}
