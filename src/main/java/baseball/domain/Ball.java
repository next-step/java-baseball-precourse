package baseball.domain;

import java.util.Objects;

public class Ball {

    private BallPosition ballPosition;
    private BallNumber ballNumber;

    public Ball(BallPosition ballPosition, BallNumber ballNumber) {
        this.ballPosition = ballPosition;
        this.ballNumber = ballNumber;
    }

    public Ball(int ballPosition, int ballNumber) {
        this(new BallPosition(ballPosition), new BallNumber(ballNumber));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return Objects.equals(ballPosition, ball.ballPosition) && Objects.equals(ballNumber, ball.ballNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ballPosition, ballNumber);
    }
}
