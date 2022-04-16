package baseball.domain;

import java.util.Objects;

public class Ball {
    private final int number;

    public Ball(int number) {
        validate(number);
        this.number = number;
    }

    private void validate(int number) {
        if (number < BaseBall.MIN_BALL_NUMBER || number > BaseBall.MAX_BALL_NUMBER) {
            throw new IllegalArgumentException(
                String.format("볼의 숫자는 %d ~ %d 값을 가질 수 있습니다.", BaseBall.MIN_BALL_NUMBER, BaseBall.MAX_BALL_NUMBER)
            );
        }
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return number == ball.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return "Ball{" +
                "number=" + number +
                '}';
    }
}
