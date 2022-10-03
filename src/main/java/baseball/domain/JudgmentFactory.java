package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class JudgmentFactory {
        
    public static List<Judgment> newJudgments(BaseballNumbers computerNumbers, BaseballNumbers playerNumbers) {
        List<Judgment> result = new ArrayList<>();
        
        result.add(new BallJudgment(computerNumbers, playerNumbers));
        result.add(new StrikeJudgment(computerNumbers, playerNumbers));
        result.add(new NothingJudgment(computerNumbers, playerNumbers));
        
        return result;
    }
}
