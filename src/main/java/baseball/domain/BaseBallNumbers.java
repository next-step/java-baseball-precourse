package baseball.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BaseBallNumbers {
    private final List<Integer> numbers;

    public BaseBallNumbers(Collection<Integer> generatedNumbers) {
        this.numbers = new ArrayList<>(generatedNumbers);
    }

    public List<Integer> getThreeDigits() {
        return numbers;
    }
}
