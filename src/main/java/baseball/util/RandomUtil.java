package baseball.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RandomUtil {
    private static final int NUMBER_START = 1;
    private static final int NUMBER_END = 9;
    private static final int ANSWER_LENGTH = 3;
    public static List<Integer> create() {
        Set<Integer> numberSet = new HashSet<>();
        while(numberSet.size() < ANSWER_LENGTH) {
            numberSet.add(Randoms.pickNumberInRange(NUMBER_START, NUMBER_END));
        }
        return new ArrayList<>(numberSet);
    }

}
