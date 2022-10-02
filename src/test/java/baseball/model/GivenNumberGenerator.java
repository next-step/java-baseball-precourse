package baseball.model;

import java.util.List;

public class GivenNumberGenerator implements NumberGenerator {

    private final List<Integer> numbers;

    public GivenNumberGenerator(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public List<Integer> generate() {
        return numbers;
    }
}
