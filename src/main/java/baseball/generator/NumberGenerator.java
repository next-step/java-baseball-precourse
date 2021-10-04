package baseball.generator;

import nextstep.utils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberGenerator {

    private NumberGenerator() {
    }

    public static List<Integer> makeThreeDigits() {
        Set<Integer> set = new HashSet<>();
        while (set.size() != 3) {
            set.add(Randoms.pickNumberInRange(1, 9));
        }
        return new ArrayList<>(set);
    }
}