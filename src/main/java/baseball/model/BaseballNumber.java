package baseball.model;

import static baseball.constants.BaseballConstants.*;

import java.util.Objects;

public class BaseballNumber {

    private final int number;

    public BaseballNumber(int number) {
        validate(number);
        this.number = number;
    }

    private void validate(final int number) {
        if (number < MIN_BALL_NUMBER || number > MAX_BALL_NUMBER) {
            throw new IllegalArgumentException("숫자는 1에서 9까지 숫자만 입력 가능 합니다.");
        }
    }

    public int getNumber() {
        return number;
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

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
