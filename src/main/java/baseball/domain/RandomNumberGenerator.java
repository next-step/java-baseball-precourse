package baseball.domain;

import nextstep.utils.Randoms;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RandomNumberGenerator implements RandomGenerator{

    private static final int MIN_THRESHOLD = 2;
    private static final int MAX_THRESHOLD = 8;
    private static final int MAX_VALUE = 9;
    private static final int MIN_VALUE = 1;
    private static final int OFFSET = 1;

    @Override
    public String getValue() {
        int first = Randoms.pickNumberInRange(MIN_THRESHOLD, MAX_THRESHOLD);
        int second = Randoms.pickNumberInRange(first + OFFSET, MAX_VALUE);
        int third = Randoms.pickNumberInRange(MIN_VALUE, first - OFFSET);
        List<Integer> list = Arrays.asList(first, second, third);
        Collections.shuffle(list);
        StringBuffer buffer = new StringBuffer();
        for (Integer number : list) {
            buffer.append(number);
        }
        return buffer.toString();
    }
}
