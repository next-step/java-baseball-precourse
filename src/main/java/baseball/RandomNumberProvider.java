package baseball;

import nextstep.utils.Randoms;

import java.util.LinkedHashSet;
import java.util.Set;

public class RandomNumberProvider {
    private static final int MAX_DIGIT_LENGTH = 3;

    public static String generate() {
        Set<Integer> uniqueNumbers = getUniqueNumbers();
        return concatenate(uniqueNumbers);
    }

    private static Set<Integer> getUniqueNumbers() {
        Set<Integer> uniqueNumbers = new LinkedHashSet<>();
        while (uniqueNumbers.size() < MAX_DIGIT_LENGTH) {
            uniqueNumbers.add(Randoms.pickNumberInRange(1, 9));
        }
        return uniqueNumbers;
    }

    private static String concatenate(Set<Integer> numbers) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Integer number : numbers) {
            stringBuilder.append(number);
        }
        return stringBuilder.toString();
    }
}
