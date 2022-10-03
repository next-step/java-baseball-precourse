package baseball.result;

import baseball.constants.Condition;
import baseball.constants.ResultMessage;
import baseball.result.bean.Result;

public class ResultView {

    private ResultMaker resultMaker;
    public ResultView() {
        this.resultMaker = new ResultMaker();
    }
    public boolean resultRestartGame(String restartCode) {
        if(!Condition.INPUT_RESTART.equals(restartCode) &&
                !Condition.INPUT_EXIT.equals(restartCode)) {
            throw new IllegalArgumentException();
        }
        if(Condition.INPUT_RESTART.equals(restartCode)) {
            return true;
        }
        return false;
    }

    public void printResult(Result result) {
        if(result.isNothing()) {
            System.out.println(ResultMessage.NOTHING);
        }
        if(result.getBallCount() > Condition.MIN_BALL_COUNT) {
            System.out.printf(ResultMessage.BALL, result.getBallCount());
        }
        if(result.getBallCount() == Condition.MAX_BALL_COUNT) {
            System.out.println();
        }
        if(result.getStrikeCount() > Condition.MIN_STRIKE_COUNT) {
            System.out.printf(ResultMessage.STRIKE, result.getStrikeCount());
        }
    }
}
