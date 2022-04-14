package baseball.balls;

import baseball.utils.ValidationUtils;

import java.util.Objects;

public class BallNumber {

    private final int number;

    public BallNumber(int number) {
        if (!ValidationUtils.validateNumberRange(number, ValidationUtils.MIN_NUMBER, ValidationUtils.MAX_NUMBER)) {
            throw new IllegalArgumentException(String.format(ValidationUtils.INVALID_INPUT_RANGE_MESSAGE, ValidationUtils.MIN_NUMBER, ValidationUtils.MAX_NUMBER));
        }
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BallNumber that = (BallNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
