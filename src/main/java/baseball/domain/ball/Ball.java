package baseball.domain.ball;

import baseball.domain.score.ScoreType;
import baseball.exception.BaseballException.InvalidRangeException;

import java.util.Objects;

import static baseball.constant.ErrorMessage.INVALID_RANGE;
import static baseball.constant.Rule.*;
import static baseball.domain.score.ScoreType.*;

public class Ball {

    private final int number;
    private final Position position;

    public Ball(int number, int position) {
        validateNumber(number);
        this.number = number;
        this.position = new Position(position);
    }

    public int getNumber() {
        return number;
    }

    public Position getPosition() {
        return position;
    }

    private void validateNumber(int number) {
        if (number > MAX_BALL_NUMBER || number < MIN_BALL_NUMBER) {
            throw new InvalidRangeException(String.format(INVALID_RANGE + " %d이상 %d이하로 입력해주세요.", MIN_BALL_NUMBER, MAX_BALL_NUMBER));
        }
    }

    public ScoreType compare(Ball targetBall) {
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
        if (this.getNumber() == targetBall.getNumber() && !this.position.equals(targetBall.getPosition())) {
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return number == ball.number && Objects.equals(position, ball.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, position);
    }
}
