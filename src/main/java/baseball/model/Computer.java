package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer extends Player {
    private final int START_INCLUSIVE_NUMBER = 1;
    private final int END_INCLUSIVE_NUMBER = 9;
    private final int SIZE = 3;

    public Computer() {
        super.setNumbers(createComputerNumbers());
    }


    private String createComputerNumbers() {
        String numStr = "";
        List<Integer> numbers = new ArrayList<>();

        while (numStr.length() < SIZE) {
            int temp = getNumber(numbers);
            numStr += String.valueOf(temp);
            numbers.add(temp);
        }

        return numStr;
    }

    public int getNumber(List<Integer> numbers) {
        int num = Randoms.pickNumberInRange(START_INCLUSIVE_NUMBER, END_INCLUSIVE_NUMBER);
        while (isDuplicated(numbers, Integer.valueOf(num))) {
            num = Randoms.pickNumberInRange(START_INCLUSIVE_NUMBER, END_INCLUSIVE_NUMBER);
        }
        return num;
    }

    public boolean isDuplicated(List<Integer> numbers, int num) {
        if (numbers != null && numbers.contains(num)) {
            return true;
        }
        return false;
    }
}
