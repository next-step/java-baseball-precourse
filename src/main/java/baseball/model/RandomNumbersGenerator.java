package baseball.model;

import baseball.domain.GameRule;
import java.util.ArrayList;
import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumbersGenerator {
    private final ArrayList<Integer> randomNumbers;

    public RandomNumbersGenerator() {
        randomNumbers = new ArrayList<>();
        while(randomNumbers.size() < GameRule.MAX_LENGTH) {
            addRandomNumber();
        }
    }

    public ArrayList<Integer> getRandomNumbers() {
        return randomNumbers;
    }

    private void addRandomNumber() {
        int pickNumber = Randoms.pickNumberInRange(GameRule.MIN_VALUE, GameRule.MAX_VALUE);
        if (validateNumber(pickNumber)) {
            randomNumbers.add(pickNumber);
        }
    }

    private Boolean validateNumber(int number) {
        return !randomNumbers.contains(number);
    }
}
