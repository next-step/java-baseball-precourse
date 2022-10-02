package baseball.score;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.List;

public class RandomScoreGenerator implements ScoreGenerator {
    
    private static final int RANGE_START = 1;
    private static final int RANGE_END = 9;
    
    @Override
    public ScoreBoard generate() {
        List<Integer> initList = Arrays.asList(
                Randoms.pickNumberInRange(RANGE_START, RANGE_END),
                Randoms.pickNumberInRange(RANGE_START, RANGE_END),
                Randoms.pickNumberInRange(RANGE_START, RANGE_END)
        );
        return new ScoreBoard(initList);
    }
}
