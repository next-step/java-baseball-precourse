package baseball.score;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomScoreGenerator implements ScoreGenerator {
    
    private static final int RANGE_START = 1;
    private static final int RANGE_END = 9;
    
    @Override
    public String generate() {
        return String.valueOf(Randoms.pickNumberInRange(RANGE_START, RANGE_END)) +
                Randoms.pickNumberInRange(RANGE_START, RANGE_END) +
                Randoms.pickNumberInRange(RANGE_START, RANGE_END);
    }
}
