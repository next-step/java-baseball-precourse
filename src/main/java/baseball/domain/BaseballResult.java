package baseball.domain;

public class BaseballResult {
    private final int strike;
    private final int ball;

    public BaseballResult(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public String getMessage() {
        if (strike != 0 && ball != 0) {
            return String.format("%d볼 %d스트라이크", ball, strike);
        }
        if (strike != 0) {
            return String.format("%d스트라이크", strike);
        }
        if (ball != 0) {
            return String.format("%d볼", ball);
        }

        return "낫싱";
    }

    public boolean isPassed(int numberCount) {
        return strike == numberCount;
    }
}
