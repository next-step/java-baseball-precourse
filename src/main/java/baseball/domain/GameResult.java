package baseball.domain;

public class GameResult {

    private static int strike;
    private static int ball;

    public GameResult() {
        strike = 0;
        ball = 0;
    }

    public void addStrike() {
        strike++;
    }

    public void addBall() {
        ball++;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }
}
