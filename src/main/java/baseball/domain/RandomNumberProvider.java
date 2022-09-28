package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomNumberProvider {

    private static final int RANDOM_NUMBER_SIZE = 3;
    private static final int START_RANGE = 1;
    private static final int END_RANGE = 9;

    private RandomNumberProvider() {
    }

    public static List<Integer> randomNumberCreate() {
        List<Integer> randomNumbers = new ArrayList<>();
        while (randomNumbers.size() < RANDOM_NUMBER_SIZE) {
            randomNumberAdd(randomNumbers, Randoms.pickNumberInRange(START_RANGE, END_RANGE));
        }
        return randomNumbers;
    }

    private static void randomNumberAdd(List<Integer> randomNumbers, int randomNumber) {
        if (validateAdd(randomNumbers, randomNumber)) {
            randomNumbers.add(randomNumber);
        }
    }

    private static boolean validateAdd(List<Integer> randomNumbers, int randomNumber) {
        return !randomNumbers.contains(randomNumber);
    }

}
