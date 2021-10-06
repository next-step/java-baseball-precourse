package baseball.domain.ball;

import baseball.exception.BaseBallException.InvalidBallRangeException;

import java.util.Objects;

import static baseball.constant.Rule.MAX_BALL_NUMBER;
import static baseball.constant.Rule.MIN_BALL_NUMBER;

public class Ball {

    private int number;

    public Ball(int number) {
        setNumber(number);
    }

    public int getNumber() {
        return number;
    }

    private void setNumber(int number) {
        validateNumber(number);
        this.number = number;
    }

    private void validateNumber(int number) {
        if (number > MAX_BALL_NUMBER || number < MIN_BALL_NUMBER) {
            throw new InvalidBallRangeException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball that = (Ball) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
