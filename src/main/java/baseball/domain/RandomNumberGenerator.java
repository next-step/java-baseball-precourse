package baseball.domain;

import java.util.ArrayList;
import java.util.List;
import nextstep.utils.Randoms;

public class RandomNumberGenerator {

    public static Number generate() {
        final List<String> numbers = new ArrayList<>();
        addUniqueNumbers(numbers);
        return toNumber(numbers);
    }

    private static void addUniqueNumbers(final List<String> numbers) {
        while (numbers.size() != 3) {
            addUniqueNumber(numbers);
        }
    }

    private static void addUniqueNumber(final List<String> numbers) {
        final String randomNumber = createUniqueNumber();
        if (!numbers.contains(randomNumber)) {
            numbers.add(randomNumber);
        }
    }

    private static String createUniqueNumber() {
        final int randomNumber = Randoms.pickNumberInRange(1, 9);
        return String.valueOf(randomNumber);
    }

    private static Number toNumber(final List<String> numbers) {
        final String number = String.join("", numbers);
        return new Number(number);
    }
}
