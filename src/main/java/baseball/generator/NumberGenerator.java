package baseball.generator;

import nextstep.utils.Randoms;

import java.util.HashSet;
import java.util.Set;

public class NumberGenerator {

    private static final NumberGenerator numberGenerator = new NumberGenerator();

    private NumberGenerator() {
    }

    public static Set<Integer> makeThreeDigits() {
        Set<Integer> set = new HashSet<>();
        while (set.size() != 3) {
            set.add(Randoms.pickNumberInRange(1, 9));
        }
        return set;
    }
}