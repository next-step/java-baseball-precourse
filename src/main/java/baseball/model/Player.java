package baseball.model;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private final List<Integer> numbers;

    public Player(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static Player from(String numbers) {
        String[] strings = numbers.split("");
        return new Player(stringArrayToIntList(strings));
    }

    private static List<Integer> stringArrayToIntList(String[] numbers) {
        List<Integer> result = new ArrayList<>();
        for (String number : numbers) {
            result.add(Integer.parseInt(number));
        }
        return result;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 3) {
            throw new IllegalArgumentException("숫자는 3개를 입력해야 합니다.");
        }
    }

    public List<Integer> numbers() {
        return numbers;
    }
}
