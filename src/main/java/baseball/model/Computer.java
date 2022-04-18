package baseball.model;

import baseball.model.Player;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer extends Player {
    private static final int START_INCLUSIVE_NUMBER = 1;
    private static final int END_INCLUSIVE_NUMBER = 9;

    public Computer() {
    }
    public Computer(int size) {
        super.setSize(size);
        super.setNumbers(createComputerNumbers());
    }

    private List<Integer> createComputerNumbers() {
        List<Integer> numbers = new ArrayList<>();

        while (numbers.size() < super.getSize()) {
            numbers.add(getNumber(numbers));
        }

        return numbers;
    }

    private int getNumber(List<Integer> numbers) {
        int num = Randoms.pickNumberInRange(START_INCLUSIVE_NUMBER, END_INCLUSIVE_NUMBER);
        while (isDuplicated(numbers, num)) {
            num = Randoms.pickNumberInRange(START_INCLUSIVE_NUMBER, END_INCLUSIVE_NUMBER);
        }
        return num;
    }

    private boolean isDuplicated(List<Integer> numbers, int num) {
        if (numbers != null && numbers.contains(num)) {
            return true;
        }
        return false;
    }
}
