package baseball;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;


public class Computer {

    List<Integer> computerNumberList = new ArrayList<>();

    public void generateThreeNumbers() {

        int NUMBER_SIZE = 3;

        while (computerNumberList.size() < NUMBER_SIZE) {
            int number = getRandomNumbers();
            generateNumber(number);
        }
    }

    public int getRandomNumbers() {

        int MIN_NUMBER = 1;
        int MAX_NUMBER = 9;

        return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
    }

    private void generateNumber(int number) {
        if (!checkDuplicateNumber(number)) {
            computerNumberList.add(number);
        }
    }

    public boolean checkDuplicateNumber(Integer number) {
        return computerNumberList.contains(number);
    }

}
