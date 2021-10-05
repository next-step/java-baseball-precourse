package baseball.domain;

public class PickNumberMatchResultView {

    private int strike;
    private int ball;

    public PickNumberMatchResultView() {
        this.strike = 0;
        this.ball = 0;
    }

    public void addStrikeCount() {
        this.strike += 1;
    }

    public void addBallCount() {
        this.ball += 1;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    @Override
    public String toString() {
        StringBuilder matchResult = new StringBuilder();

        if (strike > 0) {
            matchResult.append(strike + GameMessage.STRIKE.getMsg());
        }

        if (strike > 0 && ball > 0) {
            matchResult.append(" ");
        }

        if (ball > 0) {
            matchResult.append(ball + GameMessage.BALL.getMsg());
        }

        if (strike == 0 && ball == 0) {
            matchResult.append(GameMessage.NOTHING.getMsg());
        }

        return matchResult.toString();
    }
}
