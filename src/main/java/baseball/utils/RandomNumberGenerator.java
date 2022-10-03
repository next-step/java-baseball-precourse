package baseball.utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class RandomNumberGenerator {

    private static final int MAX_LENGTH = 3;
    private static final int MIN = 1;
    private static final int MAX = 9;

    public static List<Integer> generate() {
        Set<Integer> randomNumber = new HashSet<>();
        while (randomNumber.size() < MAX_LENGTH) {
            randomNumber.add(Randoms.pickNumberInRange(MIN, MAX));
        }
        return new LinkedList<>(randomNumber);
    }
}
