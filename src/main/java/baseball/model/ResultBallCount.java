package baseball.model;

public class ResultBallCount {
    private int strike;
    private int ball;

    private static final int MAX_COUNT = 3;

    public ResultBallCount() {
        this.strike = 0;
        this.ball = 0;
    }

    public boolean isOut(){
        return strike == MAX_COUNT;
    }

    public void setResultBallCount(ResultType resultType) {
        if (resultType.equals(ResultType.STRIKE)) {
            strike++;
        }
        if (resultType.equals(ResultType.BALL)) {
            ball++;
        }
    }

    @Override
    public String toString() {
        if (strike + ball <= 0) {
            return ResultType.NOTHING.getName();
        }
        String message = "";
        if (strike > 0) {
            message += strike + ResultType.STRIKE.getName();
        }
        if (ball > 0) {
            message += ball + ResultType.BALL.getName();
        }
        return message;
    }
}
