package baseball.domain.number;

import baseball.contant.BaseballConstant;
import baseball.contant.ExceptionMessage;
import java.util.Objects;

public class BaseballNumber {
    private final int number;

    private BaseballNumber(int number) {
        this.number = number;
    }

    public static BaseballNumber from(int number) {
        validateNumber(number);
        return new BaseballNumber(number);
    }

    private static void validateNumber(int number) {
        if (number < BaseballConstant.BASEBALL_NUMBER_MIN || number > BaseballConstant.BASEBALL_NUMBER_MAX) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_BASEBALL_NUMBER);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BaseballNumber that = (BaseballNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    public int number() {
        return this.number;
    }
}
