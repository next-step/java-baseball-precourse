package baseball.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.Set;

public class Generator {

    private static int START = 1;

    private static int END = 9;

    private static int SIZE = 3;

    public static String generate() {
        Set<Integer> set = new HashSet<>();

        while (set.size() != SIZE) {
            set.add(Randoms.pickNumberInRange(START, END));
        }

        return set.toString().replaceAll("[^0-9]", "");
    }
}
