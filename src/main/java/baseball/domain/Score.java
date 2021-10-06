package baseball.domain;

public class Score {

    private static final int ZERO = 0;

    private Rule strike;
    private Rule ball;
    private Rule nothing;

    public Score(Rule strike, Rule ball, Rule nothing) {
        this.strike = strike;
        this.ball = ball;
        this.nothing = nothing;
    }

    public String getText(int strikeCount, int ballCount) {
        if (strikeCount == ZERO && ballCount == ZERO) {
            return nothing.getName();
        }
        if (ballCount == ZERO) {
            return strike.getText(strikeCount);
        }
        if (strikeCount == ZERO) {
            return ball.getText(ballCount);
        }
        return strike.getText(strikeCount) + " " + ball.getText(ballCount);
    }
}
