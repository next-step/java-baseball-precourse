package baseball.util;

import baseball.constant.BaseballMessages;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class RandomNumberUtil {
    private RandomNumberUtil() {
    }

    public static List<Integer> pickUniqueNumbers(int start, int end, int size) {
        if (end - start + 1 < size) {
            throw new IllegalArgumentException(BaseballMessages.ERROR_OVERFLOW_RANDOM_NUMBER_COUNT);
        }

        // 제약 사항 - Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용한다.
        // return Randoms.pickUniqueNumbersInRange(start, end, size);

        Set<Integer> numbers = new HashSet<>();

        while (numbers.size() < size) {
            int number = pickNumber(start, end);

            numbers.add(number);
        }

        return new ArrayList<>(numbers);
    }

    private static int pickNumber(int start, int end) {
        return Randoms.pickNumberInRange(start, end);
    }
}
