package baseball.domain.ball;

import java.util.Objects;

public class Ball {

    private final int number;

    public Ball(int number) {
        validateRange(number);
        this.number = number;
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
        return number == ball.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    private static void validateRange(int number) {
        if (number < 1 || number > 9) {
            throw new IllegalArgumentException("볼은 1 ~ 9 사이여야 합니다.");
        }
    }
}