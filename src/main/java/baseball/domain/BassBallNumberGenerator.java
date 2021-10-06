package baseball.domain;

import nextstep.utils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BassBallNumberGenerator {
    private static final int NUMBER_SIZE = 3;
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 9;

    public static List<Integer> createRandomNumbers() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < NUMBER_SIZE) {
            addNumber(numbers);
        }
        return numbers;
    }

    private static void addNumber(List<Integer> numbers) {
        int number = Randoms.pickNumberInRange(START_NUMBER, END_NUMBER);
        if (!numbers.contains(number)) {
            numbers.add(number);
        }
    }
}
