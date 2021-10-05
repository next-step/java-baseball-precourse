package baseball.model;

public class CheckResult {

    private Integer strike;
    private Integer ball;

    public CheckResult(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public Integer getStrike() {
        return strike;
    }

    public Integer getBall() {
        return ball;
    }
}
