package baseball.utils;

import baseball.common.Constants;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class RandomNumberGenerator {
    List<Integer> numbers;

    public RandomNumberGenerator() {
        numbers = generateUniqueRandomNumbers(Constants.RANGE_START, Constants.RANGE_END, Constants.NUMBER_SIZE);
    }

    public static List<Integer> generateUniqueRandomNumbers(
            final int startInclusive,
            final int endInclusive,
            final int count
    ) {
        Set<Integer> set = new LinkedHashSet<>();
        while (set.size() != count) {
            set.add(Randoms.pickNumberInRange(startInclusive, endInclusive));
        }
        return new ArrayList<>(set);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
