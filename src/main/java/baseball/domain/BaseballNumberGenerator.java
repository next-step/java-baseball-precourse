package baseball.domain;

import baseball.common.Const;
import nextstep.utils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballNumberGenerator {
    public static List<Integer> generateBaseballNumbers() {
        List<Integer> baseballNumbers = new ArrayList<>();
        while(baseballNumbers.size() < Const.BALL_COUNT) {
            addBaseballNumber(baseballNumbers);
        }
        return baseballNumbers;
    }

    private static void addBaseballNumber(List<Integer> baseballNumbers) {
        int randomNumber = Randoms.pickNumberInRange(1, 9);
        if (!baseballNumbers.contains(randomNumber)) {
            baseballNumbers.add(randomNumber);
        }
    }
}
