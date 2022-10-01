package baseball.domain;

import baseball.domain.exceptions.BaseballIllegalArgumentException;

import java.util.Objects;

import static baseball.domain.ConsoleMessage.EXCEPTION_OUT_OF_BOUNDS_BASEBALL_NUMBER;

public class BaseballNumber {
    private final int value;
    public static final int MIN_VALUE = 1;
    public static final int MAX_VALUE = 9;

    public BaseballNumber(final int value) {
        verifyValue(value);
        this.value = value;
    }

    private void verifyValue(final int value) {
        if (isValidRange(value)) {
            throw new BaseballIllegalArgumentException(
                    EXCEPTION_OUT_OF_BOUNDS_BASEBALL_NUMBER, value, MIN_VALUE, MAX_VALUE);
        }
    }

    private boolean isValidRange(final int value) {
        return value < MIN_VALUE || value > MAX_VALUE;
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseballNumber that = (BaseballNumber) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
