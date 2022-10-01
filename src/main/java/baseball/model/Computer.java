package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    private static final int NUMBER_LENGTH = 3;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    private List<Integer> numbers;

    public Computer() {
        generateNumbers();
    }

    private void generateNumbers() {
        numbers = new ArrayList<>();
        do {
            int number = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            addNonDuplicateNumbers(number);
        } while (numbers.size() < NUMBER_LENGTH);
    }

    private void addNonDuplicateNumbers(int number) {
        if (!numbers.contains(number)) {
            numbers.add(number);
        }
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }
}
