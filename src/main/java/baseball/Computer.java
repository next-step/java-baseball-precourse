package baseball;

import nextstep.utils.Randoms;

import java.util.*;

public class Computer implements Player {
    private static final int MAX_DIGIT_LENGTH = 3;

    @Override
    public Number pick() {
        List<Integer> digits = makeUniqueDigits();
        Collections.shuffle(digits);
        return new Number(digits);
    }

    private List<Integer> makeUniqueDigits() {
        Set<Integer> result = new HashSet<>();
        while (result.size() < MAX_DIGIT_LENGTH) {
            result.add(Randoms.pickNumberInRange(1, 9));
        }
        return new ArrayList<>(result);
    }
}
