package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.LinkedHashSet;
import java.util.Set;

public class Computer {
    private static final int START_RANGE = 1;
    private static final int END_RANGE = 9;
    private static final int NUMBER_SIZE = 3;
    Set<Integer> number = new LinkedHashSet<>();

    public Computer() {
        generateRandomNumber();
    }

    public void generateRandomNumber() {
        while (number.size() < NUMBER_SIZE) {
            number.add(Randoms.pickNumberInRange(START_RANGE, END_RANGE));
        }
    }

    public Set<Integer> getNumber() {
        return number;
    }
}
