package baseball.domain.decision;

import baseball.domain.BaseballNumber;
import baseball.domain.BaseballResult;

public class DefaultResultDecision implements ResultDecision {
    @Override
    public BaseballResult decide(BaseballNumber computerNumber, BaseballNumber userNumber) {
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < userNumber.size(); i++) {
            int userNo = userNumber.get(i);

            strike += increaseStrike(computerNumber.get(i), userNo);
            ball += increaseBall(computerNumber, i, userNo);
        }

        return new BaseballResult(strike, ball);
    }

    private int increaseStrike(int computerNo, int userNo) {
        if (computerNo == userNo) {
            return 1;
        }
        return 0;
    }

    private int increaseBall(BaseballNumber computerNumber, int index, int userNo) {
        if (computerNumber.get(index) != userNo && computerNumber.contains(userNo)) {
            return 1;
        }
        return 0;
    }
}
