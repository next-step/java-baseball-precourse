package baseball.domain;

public class AtBatResult {
    private final Integer strike;
    private final Integer ball;

    private AtBatResult(Integer strike, Integer ball) {
        validate(strike, ball);
        this.strike = strike;
        this.ball = ball;
    }

    public static AtBatResult of(Integer strike, Integer ball) {
        return new AtBatResult(strike, ball);
    }

    public boolean isSuccess() {
        return strike == 3;
    }

    private void validate(Integer strike, Integer ball) {
        if (strike < 0 || strike > 3) {
            throw new IllegalArgumentException("스트라이크의 범위가 올바르지 않습니다.");
        }
        if (ball < 0 || ball > 3) {
            throw new IllegalArgumentException("볼의 범위가 올바르지 않습니다.");
        }
    }

    @Override
    public String toString() {
        if (strike == 0 && ball == 0) {
            return "낫싱";
        }
        if (strike == 0) {
            return ball + "볼";
        }
        if (ball == 0) {
            return strike + "스트라이크";
        }
        return strike + "스트라이크 " + ball + "볼";
    }
}
