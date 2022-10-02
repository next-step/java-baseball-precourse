package baseball.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RandomNumberGenerator {
    private static final int START_INCLUSIVE = 1;
    private static final int END_INCLUSIVE = 9;
    private static final int FIXED_COUNT = 3;

    private RandomNumberGenerator() {

    }

    public static List<Integer> getThreeRandomNumbers() {
        Set<Integer> temporaryStorage = new HashSet<>();
        while (temporaryStorage.size() != FIXED_COUNT) {
            int randomNumber = Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
            temporaryStorage.add(randomNumber);
        }
        return new ArrayList<>(temporaryStorage);
    }
}
