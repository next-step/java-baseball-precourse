package baseball;


import java.util.Objects;

public class BallCount {
    private int strike;
    private int ball;

    public BallCount() {
        this(0, 0);
    }

    public BallCount(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public void increaseStrike() {
        strike++;
    }

    public void increaseBall() {
        ball++;
    }

    public boolean isThreeStrike() {
        return strike == 3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BallCount ballCount = (BallCount) o;
        return strike == ballCount.strike && ball == ballCount.ball;
    }

    @Override
    public int hashCode() {
        return Objects.hash(strike, ball);
    }

    @Override
    public String toString() {
        if (strike == 0 && ball == 0) {
            return "낫싱";
        }
        StringBuilder sb = new StringBuilder();
        if (strike > 0) {
            sb.append(strike).append("스트라이크 ");
        }
        if (ball > 0) {
            sb.append(ball).append("볼");
        }
        return sb.toString();
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }
}
