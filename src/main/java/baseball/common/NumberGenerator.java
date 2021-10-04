package baseball.common;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static nextstep.utils.Randoms.pickNumberInRange;

public class NumberGenerator {

    public static List<Integer> numberGenerate() {
        HashSet<Integer> set = new HashSet<Integer>();

        while (set.size() < Constants.BALLS_SIZE) {
            set.add(pickNumberInRange(Constants.BALL_MIN, Constants.BALL_MAX));
        }
        return new ArrayList<>(set);
    }
}

