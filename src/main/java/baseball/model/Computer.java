package baseball.model;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;


public class Computer {

    public List<Integer> computerNumberList = new ArrayList<>();

    public List<Integer> generateThreeNumbers() {
        int NUMBER_SIZE = 3;
        while (computerNumberList.size() < NUMBER_SIZE) {
            int number = getRandomNumbers();
            addNumber(number);
        }
        return computerNumberList;
    }

    public int getRandomNumbers() {
        int MIN_NUMBER = 1;
        int MAX_NUMBER = 9;
        return Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
    }

    public void addNumber(int number) {
        if (!checkDuplicateNumber(number)) {
            computerNumberList.add(number);
        }
    }

    public boolean checkDuplicateNumber(Integer number) {
        return computerNumberList.contains(number);
    }

}
