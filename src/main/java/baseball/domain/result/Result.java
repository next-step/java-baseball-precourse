package baseball.domain.result;

public abstract class Result {

    public static final String COMPLETE_RESULT = "3스트라이크";
    private int strike;
    private int ball;
    private State state = State.NOTHING;

    public abstract String result();

    protected boolean isNothing(String result) {
        return state.isNothing() || State.NOTHING.getDescription().equals(result);
    }

    public boolean isComplete() {
        return result().equals(COMPLETE_RESULT);
    }

    protected String getDescription() {
        return state.getDescription();
    }

    protected int getStrike() {
        return strike;
    }

    public void setStrike(int strike) {
        this.strike = strike;
    }

    protected int getBall() {
        return ball;
    }

    public void setBall(int ball) {
        this.ball = ball;
    }

    protected void setState(State state) {
        this.state = state;
    }
}
