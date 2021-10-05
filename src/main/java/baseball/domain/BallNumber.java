package baseball.domain;

import java.util.Objects;

public class BallNumber {

    public static final int NUMBER_MIN_INT = 1;
    public static final int NUMBER_MAX_INT = 9;

    private final int ballNumber;

    public BallNumber(final int ballNumber) {
        if(rangeCheck(ballNumber)) {
            throw new IllegalArgumentException("1~9까지만 허용"); // todo custom class로 변경
        }
        this.ballNumber = ballNumber;
    }

    private boolean rangeCheck(int ballNumber) {
        return ballNumber < NUMBER_MIN_INT || ballNumber > NUMBER_MAX_INT;
    }

    public boolean isEqualsNumber(BallNumber ballNumber) {
        return this.equals(ballNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BallNumber that = (BallNumber) o;
        return ballNumber == that.ballNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ballNumber);
    }

    @Override
    public String toString() {
        return "BallNumber{" +
                "ballNumber=" + ballNumber +
                '}';
    }
}
