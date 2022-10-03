package baseball.ball.domain;

import java.math.BigDecimal;
import java.util.Objects;

public class BallNumber {
    public static final BigDecimal MAX_PITCHING_NUMBER = BigDecimal.valueOf(9);
    public static final BigDecimal MIN_PITCHING_NUMBER = BigDecimal.valueOf(1);

    private final BigDecimal number;

    public BallNumber(BigDecimal number) {
        validate(number);
        this.number = number;
    }

    private void validate(BigDecimal number) {
        validateMaxBallNumber(number);
        validateMinBallNumber(number);
    }

    private static void validateMaxBallNumber(BigDecimal number) {
        if (number.compareTo(MAX_PITCHING_NUMBER) > 0) {
            throw new IllegalArgumentException(MAX_PITCHING_NUMBER + "보다 클 수 없습니다.");
        }
    }

    private void validateMinBallNumber(BigDecimal number) {
        if (number.compareTo(MIN_PITCHING_NUMBER) < 0) {
            throw new IllegalArgumentException(MIN_PITCHING_NUMBER + "보다 작을 수 없습니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BallNumber that = (BallNumber) o;
        return number.equals(that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

}
