package baseball.controller;

import baseball.model.BaseballCount;
import baseball.model.ResultBallCount;
import baseball.model.ResultType;

public class BaseballReferee {

    public ResultBallCount getResultBallCount(String answerNumber, BaseballCount baseballCount) {
        ResultBallCount resultBallCount = new ResultBallCount();
        for (int i = 0; i < answerNumber.length(); i++) {
            char num = baseballCount.getBallCount().charAt(i);
            resultBallCount.setResultBallCount(getResultBallCountByString(answerNumber, num, i));
        }
        return resultBallCount;
    }

    private ResultType getResultBallCountByString(String answerNumber, char num, int index) {
        if (answerNumber.charAt(index) == num) {
            return ResultType.STRIKE;
        }
        if (answerNumber.contains(String.valueOf(num))) {
            return ResultType.BALL;
        }
        return ResultType.NOTHING;
    }
}
