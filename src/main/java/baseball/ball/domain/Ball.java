package baseball.ball.domain;

public class Ball {

    private final BallNumber ballNumber;
    private final BallLocation ballLocation;

    public Ball(BallNumber ballNumber, BallLocation ballLocation) {
        this.ballNumber = ballNumber;
        this.ballLocation = ballLocation;
    }

    public BallNumber ballNumber() {
        return this.ballNumber;
    }

    public BallLocation ballLocation() {
        return this.ballLocation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball that = (Ball) o;
        return ballLocation.equals(that.ballLocation) && ballNumber.equals(that.ballNumber);
    }

}
