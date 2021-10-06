package baseball.domain;

import nextstep.utils.Randoms;

public class RandomNumberGenerator implements RandomGenerator{

    private static final int MIN_THRESHOLD = 2;
    private static final int MAX_THRESHOLD = 8;
    private static final int MAX_VALUE = 9;
    private static final int MIN_VALUE = 1;
    private static final int OFFSET = 1;

    @Override
    public String getValue() {
        StringBuffer buffer = new StringBuffer();
        int first = Randoms.pickNumberInRange(MIN_THRESHOLD, MAX_THRESHOLD);
        int second = Randoms.pickNumberInRange(first + OFFSET, MAX_VALUE);
        int third = Randoms.pickNumberInRange(MIN_VALUE, first - OFFSET);
        return buffer.append(first).append(second).append(third).toString();
    }
}
