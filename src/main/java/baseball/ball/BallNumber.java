package baseball.ball;

import java.util.Objects;

/**
 * @author KingCjy
 */
public class BallNumber {

    private final int number;
    private final int position;

    public BallNumber(int number, int position) {
        this.number = number;
        this.position = position;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BallNumber that = (BallNumber) o;
        return number == that.number && position == that.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, position);
    }

    @Override
    public String toString() {
        return "BallNumber{" +
                "number=" + number +
                ", position=" + position +
                '}';
    }
}
