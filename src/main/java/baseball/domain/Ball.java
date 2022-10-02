package baseball.domain;

import java.util.Objects;

public class Ball {
    private final BallNumber ballNumber;

    public Ball(final int number) {
        this.ballNumber = new BallNumber(number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Ball ball = (Ball) o;
        return Objects.equals(ballNumber, ball.ballNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ballNumber);
    }
}
