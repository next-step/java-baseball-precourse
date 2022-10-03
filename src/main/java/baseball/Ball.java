package baseball;

import java.util.Objects;

public class Ball {
    private int position;
    private int number;

    public Ball(int position, int number) {
        this.position = position;
        this.number = number;
    }

    public BallStatus compare(Ball ball) {
        if (this.equals(ball)) {
            return BallStatus.STRIKE;
        }
        if (this.number == ball.number) {
            return BallStatus.BALL;
        }
        return BallStatus.NOTHING;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || this.getClass() != obj.getClass()) return false;
        Ball ball = (Ball) obj;
        return this.position == ball.position
                && this.number == ball.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, number);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
