package baseball.model;

import java.util.List;

public class Result {
    private Strike strike;
    private Ball ball;

    public Result() {
        this.strike = new Strike();
        this.ball = new Ball();
    }

    public void createResult(User user, List<Integer> computer) {
        countStrike(user, computer);

        if (this.strike.getCount() == 3) {
            return;
        }

        countBall(user, computer);
    }

    private void countBall(User user, List<Integer> computer) {
        ball.computeCount(user, computer);
    }

    private void countStrike(User user, List<Integer> computer) {
        for (int i = 0; i < user.getNumbers().size(); i++) {
            if (this.strike.computeCount(user.getNumbers().get(i), computer.get(i))) {
                user.checkNumber(user.getNumbers().get(i));
            }
        }
    }

    public Strike getStrike() {
        return this.strike;
    }

    public Ball getBall() {
        return this.ball;
    }

    public Boolean isNothing() {
        if (!this.strike.isStrikeExisted() && !this.ball.isBallExisted()) {
            return Boolean.TRUE;
        }

        return Boolean.FALSE;
    }

    public Boolean is3Strikes() {
        if (this.strike.getCount() == 3 && this.ball.getCount() == 0) {
            return Boolean.TRUE;
        }

        return Boolean.FALSE;
    }
}
