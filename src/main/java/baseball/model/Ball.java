package baseball.model;

import baseball.model.enums.BallStatus;

public class Ball {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    private final int position;
    private final int number;

    public Ball(int position, int number) {
        validateNumberRange(number);
        this.position = position;
        this.number = number;
    }

    private void validateNumberRange(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException("공의 숫자는 1 이상 9 이하여야 합니다.");
        }
    }

    public BallStatus compareTo(Ball other) {
        if (this.equals(other)) {
            return BallStatus.STRIKE;
        }

        if (isSameNumber(other)) {
            return BallStatus.BALL;
        }

        return BallStatus.NONE;
    }

    private boolean equals(Ball other) {
        return isSamePosition(other) && isSameNumber(other);
    }

    private boolean isSamePosition(Ball other) {
        return position == other.position;
    }

    private boolean isSameNumber(Ball other) {
        return number == other.number;
    }
}
