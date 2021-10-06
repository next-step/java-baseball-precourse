package baseball.domain.ball;

import baseball.domain.Score;
import baseball.exception.BaseballException.InvalidRangeException;

import java.util.Objects;

import static baseball.constant.ErrorMessage.INVALID_RANGE;
import static baseball.constant.Rule.*;
import static baseball.domain.Score.*;

public class Ball {

    private final int number;
    private final int position;

    public Ball(int number, int position) {
        validate(number, position);
        this.number = number;
        this.position = position;
    }

    public int getNumber() {
        return number;
    }

    public int getPosition() {
        return position;
    }

    private void validate(int number, int position) {
        validateNumber(number);
        validatePosition(position);
    }

    private void validateNumber(int number) {
        if (number > MAX_BALL_NUMBER || number < MIN_BALL_NUMBER) {
            throw new InvalidRangeException(String.format(INVALID_RANGE + " %d이상 %d이하로 입력해주세요.", MIN_BALL_NUMBER, MAX_BALL_NUMBER) );
        }
    }

    private void validatePosition(int position) {
        if (position > MAX_POSITION_NUMBER || position < MIN_POSITION_NUMBER) {
            throw new InvalidRangeException(String.format(INVALID_RANGE + " %d이상 %d이하로 입력해주세요.", MIN_POSITION_NUMBER, MAX_POSITION_NUMBER) );
        }
    }

    public Score compare(Ball targetBall) {
        if (this.isStrike(targetBall)) {
            return STRIKE;
        }
        if (this.isBall(targetBall)) {
            return BALL;
        }
        return NOTHING;
    }

    private boolean isStrike(Ball targetBall) {
        if (this.equals(targetBall)) {
            return true;
        }
        return false;
    }

    private boolean isBall(Ball targetBall) {
        if (this.getNumber() == targetBall.getNumber() && this.position != targetBall.getPosition()) {
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return number == ball.number && position == ball.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, position);
    }
}
