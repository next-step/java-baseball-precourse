package baseball.domain;

import baseball.exception.BaseBallException.InvalidBallFormatException;
import baseball.exception.BaseBallException.InvalidBallRangeException;

import java.util.Objects;

import static baseball.rule.Rule.MAX_NUMBER_OF_BALL;
import static baseball.rule.Rule.MIN_NUMBER_OF_BALL;

public class Ball {

    private int value;

    public Ball(int value) {
        setValue(value);
    }

    public Ball(String value) {
        try {
            setValue(Integer.parseInt(value));
        } catch (NumberFormatException e) {
            throw new InvalidBallFormatException();
        }
    }

    private void validate(int value) {
        if (value > MAX_NUMBER_OF_BALL || value < MIN_NUMBER_OF_BALL) {
            throw new InvalidBallRangeException();
        }
    }

    public int getValue() {
        return value;
    }

    private void setValue(int value) {
        validate(value);
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball that = (Ball) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
