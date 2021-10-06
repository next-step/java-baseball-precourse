package baseball.domain;

public class Score {

    private final Strike strike;
    private final Ball ball;
    private final Nothing nothing;

    public Score(Strike strike, Ball ball, Nothing nothing) {
        this.strike = strike;
        this.ball = ball;
        this.nothing = nothing;
    }

    public Score(Strike strike, Ball ball) {
        this(strike, ball, null);
    }

    public Score(Strike strike) {
        this(strike, null, null);
    }

    public Score(Ball ball) {
        this(null, ball, null);
    }

    public Score(Nothing nothing) {
        this(null, null, nothing);
    }

    public String getText() {
        if (strike.getCount() == 0 && ball.getCount() == 0) {
            return nothing.getText();
        }
        if (strike.getCount() == 0) {
            return ball.getText();
        }
        if (ball.getCount() == 0) {
            return strike.getText();
        }
        return strike.getText() + " " + ball.getText();
    }
}
