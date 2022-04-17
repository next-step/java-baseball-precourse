package baseball.game.util;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public final class Random {

    public static List<Integer> randomNumbers(int numNumbers, int start, int end) {
        Set<Integer> result = new LinkedHashSet<>();

        while (result.size() < numNumbers) {
            int picked = pickNumberInRange(start, end);
            result.add(picked);
        }
        return new ArrayList<>(result);
    }
}
