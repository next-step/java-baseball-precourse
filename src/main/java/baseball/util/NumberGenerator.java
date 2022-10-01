package baseball.util;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class NumberGenerator {
    public static final int MIN = 1;
    public static final int MAX = 9;

    public static String create(int length) {
        String result = "";

        while (result.length() < length) {
            result = concatIfUnique(String.valueOf(pickNumberInRange(MIN, MAX)), result);
        }

        return result;
    }

    private static String concatIfUnique(String value, String result) {
        if (result.contains(value)) {
            return result;
        }

        return result + value;
    }
}
