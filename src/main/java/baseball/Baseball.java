package baseball;

import java.util.ArrayList;
import java.util.List;

import nextstep.utils.Randoms;

public class Baseball {
    public List<Integer> setRandomNums(int numCnt) {
        int startInclusive = 1, endInclusive = 9, randdomNum = 0;
        List<Integer> randomNums = new ArrayList<>();

        while (true) {
            if (randomNums.size() == numCnt) {
                break;
            }
            randdomNum = Randoms.pickNumberInRange(startInclusive, endInclusive);
            if (randomNums.contains(randdomNum)) {
                continue;
            }
            randomNums.add(randdomNum);
        }
        return randomNums;
    }
}
