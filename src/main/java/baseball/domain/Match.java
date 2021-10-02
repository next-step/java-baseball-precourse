package baseball.domain;

import java.util.List;

public class Match {

    private int strike;
    private int ball;

    public void of(List<Ball> randomBalls, List<Ball> inputBalls) {
        this.strike = 0;
        this.ball = 0;
        for (int i = 0; i < inputBalls.size(); i++) {
            this.strike += checkStrike(inputBalls.get(i), randomBalls.get(i));
            this.ball += checkBall(inputBalls.get(i), randomBalls);
        }
    }

    private int checkStrike(Ball inputBall, Ball randomBall) {
        if (inputBall.equals(randomBall)) {
            return 1;
        }
        return 0;
    }
    private int checkBall(Ball inputBall, List<Ball> randomBalls) {
        int ball = 0;
        for (Ball randomBall : randomBalls) {
            ball += !inputBall.equals(randomBall)
                    && inputBall.getNumber() == randomBall.getNumber() ? 1 : 0;
        }
        return ball;
    }

    public boolean isThreeStrike() {
        return this.strike == 3 ? true : false;
    }

    public int getStrike() {
        return this.strike;
    }

    public int getBall() {
        return ball;
    }
}
