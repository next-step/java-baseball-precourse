package baseball.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameNumberGeneratorService {
    private final Random random;

    public GameNumberGeneratorService(Random random) {
        this.random = random;
    }

    public List<Integer> process() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            numbers.add(create(numbers));
        }
        return numbers;
    }

    private Integer create(List<Integer> numbers) {
        Integer createdNumber = random.nextInt(9) + 1;
        if (numbers.contains(createdNumber)) {
            return create(numbers);
        }
        return createdNumber;
    }
}
