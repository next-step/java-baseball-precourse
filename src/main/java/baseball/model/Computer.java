package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Computer {

    private final List<Integer> numbers;

    public Computer() {
        numbers = new ArrayList<>();
        generateNumbers();
    }

    private void generateNumbers() {
        Set<Integer> numberBox = generateNumberBox();
        for (int count = 0; count < 3; count++) {
            numbers.add(pickNumber(numberBox));
        }
    }

    private Set<Integer> generateNumberBox() {
        Set<Integer> numberBox = new HashSet<>();
        for (int num = 1; num <= 9; num++) {
            numberBox.add(num);
        }
        return numberBox;
    }

    private int pickNumber(Set<Integer> pickBox) {
        boolean allowPick = true;
        int number = 0;
        while (allowPick) {
            number = Randoms.pickNumberInRange(1, 9);
            allowPick = !pickBox.contains(number);
        }
        pickBox.remove(number);
        return number;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
