package baseball.etc;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RandomBallNumberGenerator {
    public static List<Integer> generate() {
        Set<Integer> set = new HashSet<>();
        while (set.size() < GameManager.BALLS_SIZE) {
            set.add(Randoms.pickNumberInRange(0, 9));
        }
        return new ArrayList<>(set);
    }
}
