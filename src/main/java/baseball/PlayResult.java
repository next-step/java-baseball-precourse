package baseball;

public class PlayResult {
    private int strike;
    private int ball;

    public void score(BallStatus status) {
        if (status.isStrike()) {
            strike += 1;
        }
        if (status.isBall()) {
            ball += 1;
        }
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }
}
