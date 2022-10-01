package baseball.util;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomUtil {

    public static int getNumber() {
        int startInclusive = 1;
        int endInclusive = 9;
        return getNumber(startInclusive, endInclusive);
    }

    private static int getNumber(int startInclusive, int endInclusive) {
        return Randoms.pickNumberInRange(startInclusive, endInclusive);
    }
}
