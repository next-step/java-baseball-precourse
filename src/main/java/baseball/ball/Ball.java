package baseball.ball;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author KingCjy
 */
public class Ball {
    private final List<BallNumber> numbers = new ArrayList<>();

    public Ball(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            this.numbers.add(new BallNumber(numbers[i], i));
        }
    }

    public List<BallNumber> getNumbers() {
        return numbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return Objects.equals(numbers, ball.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

    @Override
    public String toString() {
        return "Ball{" +
                "numbers=" + numbers +
                '}';
    }
}
