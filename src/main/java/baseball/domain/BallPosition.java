package baseball.domain;

import java.util.Objects;

public class BallPosition {

    public static final int MIN_INT = 0;
    public static final int MAX_INT = 2;

    private final int ballPosition;

    public BallPosition(int ballPosition) {
        if(ballPosition < MIN_INT || ballPosition > MAX_INT) {
            throw new IllegalArgumentException("3자리 까지만 가능"); // todo custom class로 변경
        }
        this.ballPosition = ballPosition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BallPosition that = (BallPosition) o;
        return ballPosition == that.ballPosition;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ballPosition);
    }

    @Override
    public String toString() {
        return "BallPosition{" +
                "ballPosition=" + ballPosition +
                '}';
    }
}
