package baseball.domain.decision;

import baseball.domain.BaseballNumber;
import baseball.domain.BaseballResult;

public interface ResultDecision {
    BaseballResult decide(BaseballNumber computerNumber, BaseballNumber userNumber);
}
