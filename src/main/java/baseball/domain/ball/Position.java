package baseball.domain.ball;

import baseball.exception.BaseballException;

import java.util.Objects;

import static baseball.constant.ErrorMessage.INVALID_RANGE;
import static baseball.constant.Rule.MAX_POSITION_NUMBER;
import static baseball.constant.Rule.MIN_POSITION_NUMBER;

public class Position {
    int position;

    public Position(int position) {
        validatePosition(position);
        this.position = position;
    }

    private void validatePosition(int position) {
        if (position > MAX_POSITION_NUMBER || position < MIN_POSITION_NUMBER) {
            throw new BaseballException.InvalidRangeException(String.format(INVALID_RANGE + " %d이상 %d이하로 입력해주세요.", MIN_POSITION_NUMBER, MAX_POSITION_NUMBER));
        }
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position1 = (Position) o;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
