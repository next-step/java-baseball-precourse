package baseball.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomUtils {

    private RandomUtils() {}

    public static List<Integer> generateNonRepeatRandomNumber(final int numberOfDigits) {
        final List<Integer> number = new ArrayList<>();

        while (number.size() < numberOfDigits) {
            addNumber(number);
        }

        return number;
    }

    private static void addNumber(final List<Integer> number) {
        final int randomNumber = Randoms.pickNumberInRange(1, 9);

        if (!number.contains(randomNumber)) {
            number.add(randomNumber);
        }
    }
}
