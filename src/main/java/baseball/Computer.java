package baseball;

import nextstep.utils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    private final List<Integer> randomNums;

    Computer() {
        randomNums = new ArrayList<>();
        while (randomNums.size() < GameRule.MAX_LENGTH) {
            appendRandomNumber();
        }
    }

    public List<Integer> getRandomNums() {
        return randomNums;
    }

    private void appendRandomNumber() {
        int num = Randoms.pickNumberInRange(GameRule.MIN_VALUE,GameRule.MAX_VALUE);
        if (checkNumberValidation(num)) {
            randomNums.add(num);
        }
    }

    private Boolean checkNumberValidation(int num) {
        return !randomNums.contains(num);
    }

}