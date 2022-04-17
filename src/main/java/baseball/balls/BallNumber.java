package baseball.balls;

import baseball.utils.ValidationUtils;

import java.util.Objects;

public class BallNumber {

    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 9;
    public static final String INVALID_INPUT_RANGE_MESSAGE = "%d~%d 범위의 숫자만 입력 가능합니다.";
    private final int number;

    public BallNumber(int number) {
        if (!ValidationUtils.validateNumberRange(number, MIN_NUMBER, MAX_NUMBER)) {
            throw new IllegalArgumentException(String.format(INVALID_INPUT_RANGE_MESSAGE, MIN_NUMBER, MAX_NUMBER));
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
