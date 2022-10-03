package baseball.domain;

import java.util.Objects;

public class Ball {
    private final Integer position;
    private final Integer ballNumber;

    public Ball(Integer position, Integer ballNumber) {
        this.position = position;
        this.ballNumber = ballNumber;
    }

    public BallStatus play(Ball ball) {
        if (this.equals(ball)) {
            return BallStatus.STRIKE;
        }
        if (ball.matchBallNumber(ballNumber)) {
            return BallStatus.BALL;
        }
        return BallStatus.NOTHING;
    }

    private boolean matchBallNumber(Integer ballNumber) {
        return Objects.equals(ballNumber, this.ballNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return Objects.equals(position, ball.position) && Objects.equals(ballNumber, ball.ballNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, ballNumber);
    }
}
