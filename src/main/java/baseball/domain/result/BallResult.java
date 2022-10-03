package baseball.domain.result;

public class BallResult extends Result {

    private Result result;

    public BallResult(Result result) {
        this.result = result;
        setState(State.BALL);
    }

    @Override
    public String result() {
        String ballResult = result.result();
        if (result.isNothing(ballResult)) {
            return nothingBallResult(ballResult);
        }
        return notNothingBallResult(ballResult);
    }

    @Override
    protected int getBall() {
        return result.getBall();
    }

    @Override
    public void setBall(int ball) {
        result.setBall(ball);
    }

    @Override
    protected int getStrike() {
        return result.getStrike();
    }

    @Override
    public void setStrike(int strike) {
        result.setStrike(strike);
    }

    private String notNothingBallResult(String ballResult) {
        if (getBall() != 0) {
            return getBall() + getDescription() + " " + ballResult;
        }
        return ballResult;
    }

    private String nothingBallResult(String ballResult) {
        if (getBall() != 0) {
            return getBall() + getDescription();
        }
        return ballResult;
    }
}
