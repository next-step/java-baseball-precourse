package baseball;

public class BallState {
    int strike;
    int ball;

    public void setStrike(int strike) {
        this.strike = strike;
    }

    public int getStrike() {
        return strike;
    }

    public void setBall(int ball) {
        this.ball = ball;
    }

    public int getBall() {
        return ball;
    }

    public boolean isNothing() {
        if (strike == 0 && ball == 0) {
            return true;
        }
        return false;
    }

    public boolean isOut() {
        if (strike == 3) {
            return true;
        }
        return false;
    }
}
